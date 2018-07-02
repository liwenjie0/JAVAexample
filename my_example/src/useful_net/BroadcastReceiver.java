package useful_net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//自发自收的组播
public class BroadcastReceiver {

	public static void main(String[] args) {
		byte[] arb1=new byte[]{'h','e','l','l','o',',','P','2','P'};
		try{
			//创建多播嵌套字对象并将其绑定到特定端口，这里要与发送端口一致，端口设定为：7779
			MulticastSocket multicastSocket=new MulticastSocket(7777);
			
			//通过InetAddress的getByName方法，在给定主机名的情况下确定主机的IP地址，此IP地址设置为多播所用IP:230.0.0.1
			InetAddress inetAddress=InetAddress.getByName("230.0.0.1");
			//通过多播嵌套字的joinGroup方法，依据制定IP加入到多播组
			multicastSocket.joinGroup(inetAddress);
			//通过无线循环来接收来自发送端的消息
			System.out.println("开始发送");
			DatagramPacket datagramPacket1=new DatagramPacket(arb1, arb1.length,inetAddress,7777);
			new MulticastSocket().send(datagramPacket1);
			System.out.println("开始接受");
			while(true){
				byte[] arb=new byte[20];
				//根据缓冲区名和长度，来新建一个数据报
				DatagramPacket datagramPacket=new DatagramPacket(arb, arb.length);
				//调用多播嵌套字的receive方法来接收数据报
				multicastSocket.receive(datagramPacket);
				System.out.println(new String(arb));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
