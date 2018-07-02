package example300;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * 实例013 重定向输出流实现程序日志
 * 改变System.out 的输出方式，通过System.setOut（）方法来设置新的输出流。
 */
public class RedirectOutputStream {

	public static void main(String[] args) {
		try{
			PrintStream out=System.out;
			PrintStream ps=new PrintStream("log.txt");
			System.setOut(ps);
			int age=18;
			System.out.println("年龄变量设置成功，初始值为："+age);
			String sex="女";
			System.out.println("性别变量设置成功，初始值为"+sex);
			String info="这是个"+sex+"孩子，应该有"+age+"岁了。";
			System.out.println("整合变量为:"+info);
			System.setOut(out);
			System.out.println("程序输出完毕，请查看日志文件！");
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
