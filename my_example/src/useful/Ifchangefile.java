package useful;

import java.io.File;
import java.io.IOException;

/*
 * �����ļ��ĸ��ַ�ʽ
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
	
	//�ڵ�ǰ�̷���Ŀ¼�´���һ���ļ�
	private static void createfile0(){
		file=new File("/test.txt");//�����������һ���ļ���·��
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//�ƶ�����·���������ھ���·���²�����PS:����·�������ļ�����·��
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
	//ʹ�� .. �����ϸ����ļ���·��
	private static void createfile2(){
		file=new File("../test.txt");//�����������һ���ļ���·��
		if(!file.exists()){
			try {
				//file.mkdir();
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//ֱ��ʹ���ļ������ڵ�ǰĿ��ĿĿ¼�²���
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
	//���ļ���·��������ʱ������·���µ��ļ���
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
	//�ڳ���·���д����ļ�;mkdirs()�������ڴ���һ�����ļ���,mkdirֻ�ܴ���һ���ļ���
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
