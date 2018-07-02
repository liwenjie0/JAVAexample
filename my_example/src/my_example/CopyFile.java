package my_example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
	//对文件夹进行复制，输入两个参数，分别是原文件夹路径和目标文件夹路径。PS：目标路径不能被源路径之下
	public static void copyFolder(String oldPath,String newPath){
		File oldfile,newfile;
		FileInputStream input;
		FileOutputStream output;
		byte[] b;
		int len;
		if(!isContain(oldPath, newPath)){			
			try{
				newfile=new File(newPath);
				if(!newfile.exists()){	//如果文件夹不存在，则建立新文件夹
					newfile.mkdirs();
				}
				oldfile=new File(oldPath);
				String[] file=oldfile.list();	//获取抽象路径名表示的目录中的文件个目录
				File temp=null;
				for(int i=0;i<file.length;i++){		//循环遍历数组
					if(oldPath.endsWith(File.separator)){
						//如果要进行复制的文件夹是以系统默认的文件分隔符结尾
						temp=new File(oldPath+file[i]);		//实例化文件对象
					}else{
						temp=new File(oldPath+File.separator+file[i]);
					}
					if(temp.isFile()){	//如果temp对象是一个文件对象
						input=new FileInputStream(temp);
						output=new FileOutputStream(newPath+"/"+(temp.getName()).toString());
						b=new byte[1024*10];
						while((len=input.read(b))!=-1){
							output.write(b,0,len);//循环写入文件
						}
						output.flush();
						output.close();
						input.close();
					}else if(temp.isDirectory()){
						copyFolder(oldPath+"/"+file[i], newPath+"/"+file[i]);	//再次调用本方法
					}
				}
			}catch(Exception e){
				System.out.println("复制出错！");
				e.printStackTrace();
			}
		}else{
			System.out.println("文件夹路径有误！");
		}
	}
	//isContain方法用于判断源路径是否包含目标路径，源路径包含目标路径则返回true，否则返回false
	protected static boolean isContain(String oldpath,String newpath){
		String temp=newpath.substring(0, oldpath.length());
		return (temp.equals(oldpath)?true:false);		
	}
	
	public static void main(String[] args){
		System.out.println("ok");
		String sourcepath="E:\\javaproject\\";
		String targetpath="E:\\javaproject\\my_example\\test1\\";
		if(isContain(sourcepath, targetpath)){
			System.out.println("路径有误");
		}
		//copyFolder(sourcepath, targetpath);
		System.out.println(Hello.pi);
	}
}