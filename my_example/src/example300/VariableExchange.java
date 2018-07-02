package example300;

import java.util.Scanner;

/*
 * 实例018 实现两个变量互换（不借助第三个变量）
 */
public class VariableExchange {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入变量A：");
		int A=scanner.nextInt();
		System.out.println("请输入变量B：");
		int B=scanner.nextInt();
		System.out.println("A="+A+"\tB="+B);
		System.out.println("执行变量互换！");
		A=A^B;
		B=B^A;
		A=A^B;
		System.out.println("A="+A+"\tB="+B);

	}

}
