package example300.network;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ClientOneToOne_ServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea text;
	private ServerSocket server;
	private Socket socket;
	private volatile int counts=0;
	private volatile Hashtable<String, Socket> map=new Hashtable<String, Socket>();	// 用于存储连接到服务器的用户和客户端套接字对象

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOneToOne_ServerFrame frame = new ClientOneToOne_ServerFrame();
					frame.setVisible(true);
					frame.createSocket();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientOneToOne_ServerFrame() {
		setTitle("客户端一对一通信————服务端程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		text=new JTextArea();
		scrollPane.setViewportView(text);
		text.setEditable(false);
	}

	public void createSocket(){
		text.append("正在创建服务器套接字……");
		try{
			server=new ServerSocket(1978);
			text.append("创建服务成功！\n");
			t.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			try{
			while(true){
				text.append("等待客户里连接……\n");
				socket=server.accept();
				text.append("第"+(counts++)+"客户连接成功！"+socket+"\n");
				new ServerThread(socket,counts).start();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	});
	private class ServerThread extends Thread{
		Socket socket;
		String key=null;
		int num;
		public ServerThread(Socket s,int num){
			this.socket=s;
			this.num=num;
		}
		
		@Override
		public void run() {
			try{
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true){
					String info=in.readLine();
					
					if(info.startsWith("用户:")){	// 添加登录用户到客户端列表
						key=info.substring(3, info.length());	// 获得用户名并作为键使用
						map.put(key, socket);
						Set<String> set=map.keySet();	//获得集合中所有键的Set视图
						Iterator<String> keyIt=set.iterator();	//获得所有键的迭代器
						while(keyIt.hasNext()){
							String receiverKey=keyIt.next();
							Socket socket_temp=map.get(receiverKey);
							PrintWriter out=new PrintWriter(socket_temp.getOutputStream());
							Iterator<String> keyIt1=set.iterator();
							out.println("更新:"+set.size());
							while(keyIt1.hasNext()){
								String receiveKey1=keyIt1.next();
								out.println(receiveKey1);
																
							}	
							out.flush();
						}																
					}else{	//转发接受消息
						text.append(info+"\n");
						key=info.substring(info.indexOf("：发送给：")+5, info.indexOf("：的信息是："));
						System.out.println(key);
						String sendUser=info.substring(0, info.indexOf("：发送给："));
						System.out.println(sendUser);
						Set<String> set=map.keySet();
						Iterator<String> keyIt=set.iterator();
						while(keyIt.hasNext()){
							String receivekey=keyIt.next();
							if(key.equals(receivekey) && !sendUser.equals(receivekey)){
							Socket socket_temp=map.get(receivekey);
							PrintWriter out=new PrintWriter(socket_temp.getOutputStream());
							out.println("MSG:"+info);
							out.flush();
							}
							
						}
					}
				}
			}catch(Exception e	){
				text.append("第"+num+"个客户已退出！"+socket+"\n");
				map.remove(key);
			}
		}
	}
}
