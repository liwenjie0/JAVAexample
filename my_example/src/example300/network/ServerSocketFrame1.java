package example300.network;

/*
 * ʵ��261 ʹ��socketͨ��
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ServerSocketFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField textField;
	private PrintWriter writer;
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketFrame1 frame = new ServerSocketFrame1();
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
	public ServerSocketFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea=new JTextArea();
		scrollPane.setViewportView(textArea);
		
		final JPanel panel=new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		final JLabel label=new JLabel("���������͵���Ϣ:");
		panel.add(label);
		textField=new JTextField();
		textField.setPreferredSize(new Dimension(230, 25));
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(textField.getText());
				textArea.append("���������͵���Ϣ�ǣ�"+textField.getText()+"\n");
				textField.setText("");
				
			}
		});
		panel.add(textField);
		
	}
	
	public void getServer(){
		try{
			server=new ServerSocket(1978);
			textArea.append("�������׽��ִ����ɹ���");
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getClientInfo(){
		try{
			while(true){
				textArea.append("���ܿͻ������͵���Ϣ��"+reader.readLine()+"\n");
			}
		}catch(Exception e){
			textArea.append("�ͻ������˳���\n");
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
				if(writer!=null){
					writer.close();
				}
				if(socket!=null){
					socket.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
				textArea.append("�ȴ��ͻ������ӡ���\n");
				try{
				socket=server.accept();
				textArea.append("�ͻ������ӳɹ���\n");
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
				}catch(Exception e){
					e.printStackTrace();
				}
				getClientInfo();
			}
			
		}
	});

}
