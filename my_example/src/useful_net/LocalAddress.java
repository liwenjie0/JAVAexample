package useful_net;

import java.net.InetAddress;

public class LocalAddress {

	public static void main(String[] args) {
		InetAddress ip;
		try{
			ip=InetAddress.getLocalHost();
			String localname=ip.getHostName();
			String localip=ip.getHostAddress();
			System.out.println("����������Ϊ��"+localname);
			System.out.println("����ip��ַΪ��"+localip);
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
