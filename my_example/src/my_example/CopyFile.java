package my_example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
	//���ļ��н��и��ƣ����������������ֱ���ԭ�ļ���·����Ŀ���ļ���·����PS��Ŀ��·�����ܱ�Դ·��֮��
	public static void copyFolder(String oldPath,String newPath){
		File oldfile,newfile;
		FileInputStream input;
		FileOutputStream output;
		byte[] b;
		int len;
		if(!isContain(oldPath, newPath)){			
			try{
				newfile=new File(newPath);
				if(!newfile.exists()){	//����ļ��в����ڣ��������ļ���
					newfile.mkdirs();
				}
				oldfile=new File(oldPath);
				String[] file=oldfile.list();	//��ȡ����·������ʾ��Ŀ¼�е��ļ���Ŀ¼
				File temp=null;
				for(int i=0;i<file.length;i++){		//ѭ����������
					if(oldPath.endsWith(File.separator)){
						//���Ҫ���и��Ƶ��ļ�������ϵͳĬ�ϵ��ļ��ָ�����β
						temp=new File(oldPath+file[i]);		//ʵ�����ļ�����
					}else{
						temp=new File(oldPath+File.separator+file[i]);
					}
					if(temp.isFile()){	//���temp������һ���ļ�����
						input=new FileInputStream(temp);
						output=new FileOutputStream(newPath+"/"+(temp.getName()).toString());
						b=new byte[1024*10];
						while((len=input.read(b))!=-1){
							output.write(b,0,len);//ѭ��д���ļ�
						}
						output.flush();
						output.close();
						input.close();
					}else if(temp.isDirectory()){
						copyFolder(oldPath+"/"+file[i], newPath+"/"+file[i]);	//�ٴε��ñ�����
					}
				}
			}catch(Exception e){
				System.out.println("���Ƴ���");
				e.printStackTrace();
			}
		}else{
			System.out.println("�ļ���·������");
		}
	}
	//isContain���������ж�Դ·���Ƿ����Ŀ��·����Դ·������Ŀ��·���򷵻�true�����򷵻�false
	protected static boolean isContain(String oldpath,String newpath){
		String temp=newpath.substring(0, oldpath.length());
		return (temp.equals(oldpath)?true:false);		
	}
	
	public static void main(String[] args){
		System.out.println("ok");
		String sourcepath="E:\\javaproject\\";
		String targetpath="E:\\javaproject\\my_example\\test1\\";
		if(isContain(sourcepath, targetpath)){
			System.out.println("·������");
		}
		//copyFolder(sourcepath, targetpath);
		System.out.println(Hello.pi);
	}
}