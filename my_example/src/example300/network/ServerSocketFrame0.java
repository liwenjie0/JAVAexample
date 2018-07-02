package example300.network;

/*
 * ʵ��259 ���ܺͷ���Socket��Ϣ
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
    private JTextArea text;// �����ı���,������ʾ������Ϣ�ͽ��յ�����Ϣ
    private BufferedReader reader; // ����BufferedReader����
    private ServerSocket server; // ����ServerSocket����
    private Socket socket; // ����Socket����socket
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
		setTitle("�������˳���");
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
			text.append("�������׽��ִ����ɹ���\n");	
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
					socket=server.accept();				
					text.append("���ӳɹ�");
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
			text.append("���ܿͻ������͵���Ϣ��\n");
			while(true){
				text.append(reader.readLine()+"\n");
				
			}
		}catch(Exception e){
			text.append("�ͻ������˳�");
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
