package useful_net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/*
 * Sender�࣬IP�ಥ�ڷ��Ͷ˽�����Ϣ���͵ķ�������Ҫ������ʾһ�£�����������ν�һ����Ϣ��IP�ಥ�ķ�ʽ���͵������С�
 * IP�ಥ��ַ��224.0.0.0��239.255.255.255�ķ�Χ�ڣ���ַ224.0.0.0����
 * MulticastSocket��Ҳ�жಥ���ݱ�Ƕ�����࣬Ҳ��һ��UDP��DatagramSocket������Ҫ���ڷ��ͺͽ���IP�ಥ��
 */

public class Sender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			byte[] arb1=new byte[]{'h','e','l','l','o',',','P','2','P'};
			String s1=new String("幸��Ұ���");
			//byte[] arb1=s1.getBytes();
			//ͨ��InetAddress��getByName�������ڸ����������������ȷ��������IP��ַ����IP��ַ����Ϊ�ಥ����IP��230.0.0.1
			InetAddress inetAddress=InetAddress.getByName("230.0.0.1");
			
			//ͨ��DatagramPacket�࣬����װһ������Ҫ������Ϣ�����ݰ�����Ҫ����Ҫ������Ϣ�����ݣ���Ϣ�ĳ��ȡ��ಥIP���˿ڵȲ�����������˿�����Ϊ��7779	
			DatagramPacket datagramPacket=new DatagramPacket(arb1, arb1.length,inetAddress,7777);
			
			//ͨ��MulticastSocket�࣬�½�һ���ಥǶ���Ӷ���
			MulticastSocket multicastSocket=new MulticastSocket();
			
			//ֱ�ӵ���MulticastSocket��send��������װ�����ݱ����ͳ�ȥ
			multicastSocket.send(datagramPacket);
			System.out.println("���ͳɹ�");
			//multicastSocket.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}

}
