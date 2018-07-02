package example300;

import java.util.Scanner;

/*
 * 实例012 从控制台接受输入字符
 */
public class InputCode {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你的电话号码：");
		String instr=scanner.nextLine();
		System.out.println("你输入的号码是"+instr.length()+"位");

	}

}
