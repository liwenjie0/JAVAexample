package example300.network;

/*
 * 实例256 建立客户端套接字
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ClientSocketFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextArea text;
	private Socket socket;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSocketFrame frame = new ClientSocketFrame();
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
	public ClientSocketFrame() {
		setTitle("建立客户端套接字");
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

	public void connect(){
		text.append("尝试连接……\n");
		try{
			socket=new Socket("127.0.0.1",1978);
			text.append("完成连接！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
