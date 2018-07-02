package myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOperation {
	//以下为初始化复制文件操作所需要的一些参数
	private File oldfile,newfile;
	private FileInputStream input;
	private FileOutputStream output;
	private byte[] b;	//构建字节数据用于转存数据
	private int len;
	
	//该函数执行复制操作。没有进行路径的判断！
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
	
	//对文件夹进行复制，输入两个参数，分别是原文件夹路径和目标文件夹路径。PS：目标路径不能被源路径之下
	private boolean copyFolder(String oldPath,String newPath){
		if(!isContain(oldPath, newPath)){	
			try{
				newfile=new File(newPath);
				if(!newfile.exists()){	//如果文件夹不存在，则建立新文件夹
					newfile.mkdirs();
				}
				oldfile=new File(oldPath);
				String[] file=oldfile.list();	//获取抽象路径名表示的目录中的文件个目录
				//System.out.println(file.length+"++"+file[0]);
				File temp=null;
				int i=0;
				do{		//循环遍历数组
					//补全路径，并以当前路径建立File对象
					if(oldPath.endsWith(File.separator)){
						//如果要进行复制的文件夹是以系统默认的文件分隔符结尾
						temp=new File(oldPath+file[i]);		//实例化文件对象
					}else{
						temp=new File(oldPath+File.separator+file[i]);
					}
					
					if(temp.isFile()){	//如果temp对象是一个文件对象
						File[] results=filterByFileName(oldfile, newfile);
						int loop=0;
						for(File f :results){
							input=new FileInputStream(f);
							output=new FileOutputStream(newPath+"\\"+(f.getName()).toString());
							b=new byte[1024*10];
							while((len=input.read(b))!=-1){
								output.write(b,0,len);//循环写入文件
							}
							output.flush();
							output.close();
							input.close();
							loop++;
						}
						System.out.println(results.length+"::"+loop);
					}else if(temp.isDirectory()){
						if(temp.list().length>0){
						copyFolder(oldPath+"\\"+file[i], newPath+"\\"+file[i]);	//再次调用本方法
						}
					}
					i++;
				}while((!temp.isFile())&&i<file.length);
			}catch(Exception e){
				System.out.println("复制出错！");
				e.printStackTrace();
				return false;
			}
			return true;
		}else{
			System.out.println("文件夹路径有误！");
		}
		return false;
	}
	
	//复制文件操作
	private boolean copyFile(String oldPath,String newPath){
		
		oldfile=new File(oldPath);	
		try{
			input=new FileInputStream(oldfile);
			output=new FileOutputStream(newPath+"/"+(oldfile.getName()).toString());
			b=new byte[1024*10];
			while((len=input.read(b))!=-1){
				output.write(b,0,len);//循环写入文件
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
	
	//isContain方法用于判断源路径是否包含目标路径，源路径包含目标路径则返回true，否则返回false
	public static boolean isContain(String oldpath,String newpath){
		//判断源路径长度是否大于目标路径长度
		if(oldpath.length()>newpath.length())	return false;
		
		String temp=newpath.substring(0, oldpath.length());
		return (temp.equals(oldpath)?true:false);		
	}
	
	//判断文件路径是否相同
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
	//此函数用于过滤重文件名的文件，并返回过滤后的文件数组
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
	
/*	//未使用此函数
	//对文件夹进行复制，输入两个参数，分别是原文件夹路径和目标文件夹路径。PS：目标路径不能被源路径之下
	public static void copyFolder1(String oldPath,String newPath){
		//一下为初始化的一些参数
		File oldfile,newfile;
		FileInputStream input;
		FileOutputStream output;
		byte[] b;	//构建字节数据用于转存数据
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
						copyFolder1(oldPath+"/"+file[i], newPath+"/"+file[i]);	//再次调用本方法
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
*/
}
