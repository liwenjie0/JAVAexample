package example300;

import java.util.Scanner;

/*
 * ʵ��015 ���ܿ��������򵥣�λ���㣩
 * ��ʵ���ù�λ�������������'^'���ַ�����һ��ָ��ֵ����������㣬�Ӷ��ı��ַ�����ÿ���ַ���ֵ���������Եõ����ܺ���ַ�����
 * �Ѽ��ܺ���ַ�����Ϊ����������ݣ���������Ѽ��ܺ���ַ���ԭΪԭ���ַ�����ֵ��
 */
public class Jiami {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������һ�������ַ�������ַ�");
		String password=scanner.nextLine();
		char[] array=password.toCharArray();		
		/*System.out.println("�ַ�����Ϊ��"+array.length);
		byte[] array1=password.getBytes();
		System.out.println("�ֽڳ���Ϊ��"+array1.length);*/
		
		for(int i=0;i<array.length;i++){
			array[i]=(char)(array[i]^20000);
		}
		System.out.println("���ܻ���ܽ������");
		System.out.println(new String(array));
	}

}
