package example300.network;

/*
 * 实例259 接受和发送Socket信息
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ServerSocketFrame0 extends JFrame {

	private JPanel contentPane;
    private JTextArea text;// 声明文本域,用于显示连接信息和接收到的信息
    private BufferedReader reader; // 声明BufferedReader对象
    private ServerSocket server; // 声明ServerSocket对象
    private Socket socket; // 声明Socket对象socket
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketFrame0 frame = new ServerSocketFrame0();
					frame.setVisible(true);
					frame.getServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerSocketFrame0() {
		setTitle("服务器端程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		text=new JTextArea();
		scrollPane.setViewportView(text);
	}
	
	public void getServer(){
		try{
			server=new ServerSocket(1978);
			text.append("服务器套接字创建成功！\n");	
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
					socket=server.accept();				
					text.append("连接成功");
					reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					getClientInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	});
	
	private void getClientInfo(){
		try{
			text.append("接受客户机发送的信息：\n");
			while(true){
				text.append(reader.readLine()+"\n");
				
			}
		}catch(Exception e){
			text.append("客户机已退出");
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null){
					reader.close();
				if(socket!=null)
					socket.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
