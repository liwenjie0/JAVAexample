package useful;

import java.io.File;
import java.io.IOException;

/*
 * 创建文件的各种方式
 */
public class Ifchangefile {
	private static File file;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createfile5();
		System.out.println(file.toString());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		
	}
	
	//在当前盘符根目录下创建一个文件
	private static void createfile0(){
		file=new File("/test.txt");//两个点代表上一个文件夹路径
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//制定绝对路径，可以在绝对路径下操作，PS:绝对路劲包含文件名的路径
	private static void createfile1(){
		file=new File("E:\\test.txt");
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//使用 .. 代表上个层文件夹路径
	private static void createfile2(){
		file=new File("../test.txt");//两个点代表上一个文件夹路径
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//直接使用文件名则在当前目项目目录下操作
	private static void createfile3(){
		file=new File("test.txt");
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//当文件夹路径不存在时，创建路径下的文件夹
	private static void createfile4(){
		file=new File("test1\\test.txt");
		if(!file.exists()){
			try {
				file.mkdirs();
				System.out.println(file.toString().substring(0,file.toString().lastIndexOf("\\")));
				//file.createNewFile();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//在抽象路经中创建文件;mkdirs()方法用于创建一连串文件夹,mkdir只能创建一个文件夹
	private static void createfile5(){
		file=new File("E:\\test1\\aini\\test.txt");

		if(!file.exists()){
			try {
				File file0=new File(file.getParent());
				file0.mkdirs();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}catch(SecurityException e){
				e.printStackTrace();
			}
		}
	}
}
