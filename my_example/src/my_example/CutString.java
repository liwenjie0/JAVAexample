package my_example;

public class CutString {

	public static void main(String[] args) {
		String ip1="192.168.1.2";
		String ip2="192.168.1.254";
		
		String targetip="192.168.1.11";
		
		int temp0=targetip.lastIndexOf(".");
		System.out.println(temp0);
		String temp1=targetip.substring(0, temp0);
		if(ip1.contains(temp1)){
			System.out.println("°üº¬ÔÚÄÚ");
		}
		
	}

}
