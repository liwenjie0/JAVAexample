package example300;

import java.util.Scanner;

/*
 * 实例015 加密可以这样简单（位运算）
 * 本实例用过位运算的异或运算符'^'把字符串与一个指定值进行异或运算，从而改变字符串中每个字符的值，这样可以得到加密后的字符串。
 * 把加密后的字符串作为程序出入内容，异或运算会把加密后的字符还原为原有字符串的值。
 */
public class Jiami {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一串密码字符或解密字符");
		String password=scanner.nextLine();
		char[] array=password.toCharArray();		
		/*System.out.println("字符长度为："+array.length);
		byte[] array1=password.getBytes();
		System.out.println("字节长度为："+array1.length);*/
		
		for(int i=0;i<array.length;i++){
			array[i]=(char)(array[i]^20000);
		}
		System.out.println("加密或解密结果如下");
		System.out.println(new String(array));
	}

}
