package useful_net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/*
 * Sender类，IP多播在发送端进行消息发送的方法，主要用来演示一下，在网络中如何将一条消息以IP多播的方式发送到网络中。
 * IP多播地址在224.0.0.0和239.255.255.255的范围内，地址224.0.0.0保留
 * MulticastSocket类也叫多播数据报嵌套字类，也是一种UDP（DatagramSocket），主要用于发送和接收IP多播包
 */

public class Sender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			byte[] arb1=new byte[]{'h','e','l','l','o',',','P','2','P'};
			String s1=new String("骞哥我爱你");
			//byte[] arb1=s1.getBytes();
			//通过InetAddress的getByName方法，在给定主机名的情况下确定主机的IP地址，此IP地址设置为多播所用IP：230.0.0.1
			InetAddress inetAddress=InetAddress.getByName("230.0.0.1");
			
			//通过DatagramPacket类，来封装一个包含要发送消息的数据包，需要传入要发送消息的内容，消息的长度、多播IP、端口等参数，本程序端口设置为：7779	
			DatagramPacket datagramPacket=new DatagramPacket(arb1, arb1.length,inetAddress,7777);
			
			//通过MulticastSocket类，新建一个多播嵌套子对象
			MulticastSocket multicastSocket=new MulticastSocket();
			
			//直接调用MulticastSocket的send方法将封装的数据报发送出去
			multicastSocket.send(datagramPacket);
			System.out.println("发送成功");
			//multicastSocket.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}

}
