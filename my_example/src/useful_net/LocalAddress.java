package useful_net;

import java.net.InetAddress;

public class LocalAddress {

	public static void main(String[] args) {
		InetAddress ip;
		try{
			ip=InetAddress.getLocalHost();
			String localname=ip.getHostName();
			String localip=ip.getHostAddress();
			System.out.println("您的主机名为："+localname);
			System.out.println("您的ip地址为："+localip);
			System.out.println();
			byte[] bs=ip.getAddress();
			for (byte b : bs) {
				System.out.print(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
