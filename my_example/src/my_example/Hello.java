package my_example;

public class Hello {
	public int p;
	public static int pi=4;
	public static void method1(){
		System.out.println(pi);
	}
	public static void swap(Hello a,Hello b){
		Hello temp=new Hello();
		temp.p=a.p;
		a.p=b.p;
		b.p=a.p;
	}
	
	public static void main(String[] args) {
		Hello h1=new Hello();
		Hello h2=new Hello();
		h1.p=1;
		h2.p=2;
		int a=1,b=2;
		swap(h1,h2);
		System.out.println(h1.p);
	}
	
}
