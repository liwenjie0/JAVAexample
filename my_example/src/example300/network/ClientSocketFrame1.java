package example300.network;

/*
 * 实例261 使用socket通信
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientSocketFrame1 extends JFrame {

	private JPanel contentPane;
	private PrintWriter writer;
	private BufferedReader reader;
	private Socket socket;
	private JTextArea textArea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSocketFrame1 frame = new ClientSocketFrame1();
					frame.setVisible(true);
					frame.connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientSocketFrame1() {
		setTitle("客户端程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		JLabel label=new JLabel("客户端发送信息：");
		panel.add(label);
		textField=new JTextField();
		textField.setPreferredSize(new Dimension(270, 25));
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(textField.getText());
				textArea.append("客户端发送信息是:"+textField.getText()+"\n");
				writer.flush(); 
				textField.setText("");
				
			}
		});
		panel.add(textField);
		
	}
	
	public void connect(){
		textArea.append("尝试连接……:");
		try{
			socket=new Socket("192.168.0.103",1978);
			writer=new PrintWriter(socket.getOutputStream());
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			textArea.append("连接完成！");
			t.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getServerInfo(){
		try{
			while(true){
				if(reader!=null){
					textArea.append("接收到服务器发送的信息："+reader.readLine()+"\n");
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
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
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			getServerInfo();
			
		}
	});

}
