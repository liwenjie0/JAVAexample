package example300;

import java.util.Scanner;

/*
 * ʵ��018 ʵ����������������������������������
 */
public class VariableExchange {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������A��");
		int A=scanner.nextInt();
		System.out.println("���������B��");
		int B=scanner.nextInt();
		System.out.println("A="+A+"\tB="+B);
		System.out.println("ִ�б���������");
		A=A^B;
		B=B^A;
		A=A^B;
		System.out.println("A="+A+"\tB="+B);

	}

}
