package example300;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * ʵ��013 �ض��������ʵ�ֳ�����־
 * �ı�System.out �������ʽ��ͨ��System.setOut���������������µ��������
 */
public class RedirectOutputStream {

	public static void main(String[] args) {
		try{
			PrintStream out=System.out;
			PrintStream ps=new PrintStream("log.txt");
			System.setOut(ps);
			int age=18;
			System.out.println("����������óɹ�����ʼֵΪ��"+age);
			String sex="Ů";
			System.out.println("�Ա�������óɹ�����ʼֵΪ"+sex);
			String info="���Ǹ�"+sex+"���ӣ�Ӧ����"+age+"���ˡ�";
			System.out.println("���ϱ���Ϊ:"+info);
			System.setOut(out);
			System.out.println("���������ϣ���鿴��־�ļ���");
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
