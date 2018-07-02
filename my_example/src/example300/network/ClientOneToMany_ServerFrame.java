package example300.network;

/*
 * 实例269 客户端一对多通信
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ClientOneToMany_ServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea text;
	private ServerSocket server;
	private Socket socket;
	private volatile Vector<Socket> vector=new Vector<Socket>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOneToMany_ServerFrame frame = new ClientOneToMany_ServerFrame();
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
	public ClientOneToMany_ServerFrame() {
		setTitle("客户端一对多通信——服务器程序");
		setResizable(false);
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
	}
	
	public void createSocket(){
		try{
			server=new ServerSocket(1978);
			text.append("创建服务器连接成功");
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			try{
            while (true) {
                text.append("等待新客户连接......\n");
                socket = server.accept();// 创建套接字对象
                vector.add(socket);// 将套接字对象添加到向量对象中
                text.append("客户端连接成功。" + socket + "\n");
                new ServerThread(socket).start();// 创建并启动线程对象
            }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	});
	
	private class ServerThread extends Thread{
		Socket sockett;
		public ServerThread(Socket socket){
			super();
			this.sockett=socket;
		}
		@Override
		public void run() {
			PrintWriter out;
			try {
				BufferedReader in=new BufferedReader(new InputStreamReader(sockett.getInputStream()));
				while(true){
					String info=in.readLine();
					text.append(socket+":"+info+"\n");
					for(Socket s : vector){
						if(s!=sockett){
							try{
							out=new PrintWriter(s.getOutputStream(),true);
							out.println(info);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				}
			} catch (IOException e) {				
				text.append(sockett+"已退出！\n");
				vector.remove(sockett);
				e.printStackTrace();
			}
			
		}
	}

}
