package example300.network;

/*
 * ʵ��255 �����������׽���
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
		setTitle("����������Ƕ����");
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
			text.append("������Ƕ������������ɹ�!\n");
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
				text.append("�ȴ��ͻ������ӡ���\n");
				try {
					socket=server.accept();	//ʵ����socket���ɹ������ͻ������ӳɹ�
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				if(socket!=null){
					text.append("���ӳɹ�!\n");
					break;
				}
				
			}
			
		}
	});
	

	public void get(){
		text.append("dfdsafsdfa");
	}
}
