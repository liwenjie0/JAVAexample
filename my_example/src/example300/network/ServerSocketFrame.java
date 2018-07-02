package example300.network;

/*
 * 实例255 建立服务器套接字
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ServerSocketFrame extends JFrame{
	
	private volatile JTextArea text;
	private volatile ServerSocket server;
	private volatile Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketFrame frame = new ServerSocketFrame();
					frame.setVisible(true);
					frame.getServer();
					frame.get();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.
	 */
	public ServerSocketFrame() {
		super();
		setTitle("建立服务器嵌套子");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		final JScrollPane scrollPane=new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		text=new JTextArea();
		scrollPane.setViewportView(text);
	}
	
	public void getServer(){
		try{
			server=new ServerSocket(1978);
			text.append("服务器嵌套字意见创建成功!\n");
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
				text.append("等待客户机连接……\n");
				try {
					socket=server.accept();	//实例化socket，成功则代表客户机连接成功
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				if(socket!=null){
					text.append("连接成功!\n");
					break;
				}
				
			}
			
		}
	});
	

	public void get(){
		text.append("dfdsafsdfa");
	}
}
