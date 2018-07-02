package useful_net;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/*
 * Receiver类，IP多播在接收端接收消息的方法，主要用来演示在网络中如何接收一条多播消息的过程，
 */

public class Receiver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//创建多播嵌套字对象并将其绑定到特定端口，这里要与发送端口一致，端口设定为：7779
			MulticastSocket multicastSocket=new MulticastSocket(7777);
			
			//通过InetAddress的getByName方法，在给定主机名的情况下确定主机的IP地址，此IP地址设置为多播所用IP:230.0.0.1
			InetAddress inetAddress=InetAddress.getByName("230.0.0.1");
			//通过多播嵌套字的joinGroup方法，依据制定IP加入到多播组
			multicastSocket.joinGroup(inetAddress);
			//通过无线循环来接收来自发送端的消息
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
