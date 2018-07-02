package myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOperation {
	//����Ϊ��ʼ�������ļ���������Ҫ��һЩ����
	private File oldfile,newfile;
	private FileInputStream input;
	private FileOutputStream output;
	private byte[] b;	//�����ֽ���������ת������
	private int len;
	
	//�ú���ִ�и��Ʋ�����û�н���·�����жϣ�
	public boolean Copy(String oldPath,String newPath){
		oldfile=new File(oldPath);
		if(oldfile.exists()&&oldfile.isDirectory()){
			if(copyFolder(oldPath,newPath)){
			return true;
			}else{
				return false;
			}
		}else if(oldfile.exists()&&oldfile.isFile()){
			if(copyFile(oldPath, newPath)){
				return true;
			}else{
				return false;
			}
		}		
		return false;
		
	}
	
	//���ļ��н��и��ƣ����������������ֱ���ԭ�ļ���·����Ŀ���ļ���·����PS��Ŀ��·�����ܱ�Դ·��֮��
	private boolean copyFolder(String oldPath,String newPath){
		if(!isContain(oldPath, newPath)){	
			try{
				newfile=new File(newPath);
				if(!newfile.exists()){	//����ļ��в����ڣ��������ļ���
					newfile.mkdirs();
				}
				oldfile=new File(oldPath);
				String[] file=oldfile.list();	//��ȡ����·������ʾ��Ŀ¼�е��ļ���Ŀ¼
				//System.out.println(file.length+"++"+file[0]);
				File temp=null;
				int i=0;
				do{		//ѭ����������
					//��ȫ·�������Ե�ǰ·������File����
					if(oldPath.endsWith(File.separator)){
						//���Ҫ���и��Ƶ��ļ�������ϵͳĬ�ϵ��ļ��ָ�����β
						temp=new File(oldPath+file[i]);		//ʵ�����ļ�����
					}else{
						temp=new File(oldPath+File.separator+file[i]);
					}
					
					if(temp.isFile()){	//���temp������һ���ļ�����
						File[] results=filterByFileName(oldfile, newfile);
						int loop=0;
						for(File f :results){
							input=new FileInputStream(f);
							output=new FileOutputStream(newPath+"\\"+(f.getName()).toString());
							b=new byte[1024*10];
							while((len=input.read(b))!=-1){
								output.write(b,0,len);//ѭ��д���ļ�
							}
							output.flush();
							output.close();
							input.close();
							loop++;
						}
						System.out.println(results.length+"::"+loop);
					}else if(temp.isDirectory()){
						if(temp.list().length>0){
						copyFolder(oldPath+"\\"+file[i], newPath+"\\"+file[i]);	//�ٴε��ñ�����
						}
					}
					i++;
				}while((!temp.isFile())&&i<file.length);
			}catch(Exception e){
				System.out.println("���Ƴ���");
				e.printStackTrace();
				return false;
			}
			return true;
		}else{
			System.out.println("�ļ���·������");
		}
		return false;
	}
	
	//�����ļ�����
	private boolean copyFile(String oldPath,String newPath){
		
		oldfile=new File(oldPath);	
		try{
			input=new FileInputStream(oldfile);
			output=new FileOutputStream(newPath+"/"+(oldfile.getName()).toString());
			b=new byte[1024*10];
			while((len=input.read(b))!=-1){
				output.write(b,0,len);//ѭ��д���ļ�
			}
			output.flush();
			output.close();
			input.close();
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//isContain���������ж�Դ·���Ƿ����Ŀ��·����Դ·������Ŀ��·���򷵻�true�����򷵻�false
	public static boolean isContain(String oldpath,String newpath){
		//�ж�Դ·�������Ƿ����Ŀ��·������
		if(oldpath.length()>newpath.length())	return false;
		
		String temp=newpath.substring(0, oldpath.length());
		return (temp.equals(oldpath)?true:false);		
	}
	
	//�ж��ļ�·���Ƿ���ͬ
	public static boolean isFileEquals(String oldpath,String newpath){
		int i=oldpath.lastIndexOf("\\");
		String temp=oldpath.substring(0, i);
		if(temp.equals(newpath)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isExist(){
		
		return false;
	}
	//�˺������ڹ������ļ������ļ��������ع��˺���ļ�����
	private static File[] filterByFileName(File oldfile , File newfile){
		List<File> oldlist=new ArrayList<File>(Arrays.asList(oldfile.listFiles()));
		List<File> newlist=new ArrayList<File>(Arrays.asList(newfile.listFiles()));
		for(int i=0;i<oldlist.size();i++){
			for(int i1=0;i1<newlist.size();i1++){
				if(oldlist.get(i).getName().equals(newlist.get(i1).getName())){
					System.out.println(oldlist.get(i).getName());
					oldlist.remove(i);
					newlist.remove(i1);
				}
			}
		}
		System.out.println(oldlist.size()+"::"+newlist.size());
		return oldlist.toArray(new File[oldlist.size()]);

	}
	
/*	//δʹ�ô˺���
	//���ļ��н��и��ƣ����������������ֱ���ԭ�ļ���·����Ŀ���ļ���·����PS��Ŀ��·�����ܱ�Դ·��֮��
	public static void copyFolder1(String oldPath,String newPath){
		//һ��Ϊ��ʼ����һЩ����
		File oldfile,newfile;
		FileInputStream input;
		FileOutputStream output;
		byte[] b;	//�����ֽ���������ת������
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
						copyFolder1(oldPath+"/"+file[i], newPath+"/"+file[i]);	//�ٴε��ñ�����
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
*/
}
