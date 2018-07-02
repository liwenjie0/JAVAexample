package example300.network;

/*
 * ʵ��269 �ͻ���һ�Զ�ͨ��
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
		setTitle("�ͻ���һ�Զ�ͨ�š�������������");
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
			text.append("�������������ӳɹ�");
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
                text.append("�ȴ��¿ͻ�����......\n");
                socket = server.accept();// �����׽��ֶ���
                vector.add(socket);// ���׽��ֶ�����ӵ�����������
                text.append("�ͻ������ӳɹ���" + socket + "\n");
                new ServerThread(socket).start();// �����������̶߳���
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
				text.append(sockett+"���˳���\n");
				vector.remove(sockett);
				e.printStackTrace();
			}
			
		}
	}

}
