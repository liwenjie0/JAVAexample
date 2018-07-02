package useful_net;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/*
 * Receiver�࣬IP�ಥ�ڽ��ն˽�����Ϣ�ķ�������Ҫ������ʾ����������ν���һ���ಥ��Ϣ�Ĺ��̣�
 */

public class Receiver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//�����ಥǶ���ֶ��󲢽���󶨵��ض��˿ڣ�����Ҫ�뷢�Ͷ˿�һ�£��˿��趨Ϊ��7779
			MulticastSocket multicastSocket=new MulticastSocket(7777);
			
			//ͨ��InetAddress��getByName�������ڸ����������������ȷ��������IP��ַ����IP��ַ����Ϊ�ಥ����IP:230.0.0.1
			InetAddress inetAddress=InetAddress.getByName("230.0.0.1");
			//ͨ���ಥǶ���ֵ�joinGroup�����������ƶ�IP���뵽�ಥ��
			multicastSocket.joinGroup(inetAddress);
			//ͨ������ѭ�����������Է��Ͷ˵���Ϣ
			System.out.println("��ʼ����");
			while(true){
				byte[] arb=new byte[20];
				//���ݻ��������ͳ��ȣ����½�һ�����ݱ�
				DatagramPacket datagramPacket=new DatagramPacket(arb, arb.length);
				//���öಥǶ���ֵ�receive�������������ݱ�
				multicastSocket.receive(datagramPacket);
				System.out.println(new String(arb));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
