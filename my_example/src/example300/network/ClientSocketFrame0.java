package example300.network;

/*
 * ʵ��259 ���ܺͷ���Socket��Ϣ
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientSocketFrame0 extends JFrame {

	private JPanel contentPane;
	private PrintWriter writer;
	private Socket socket;
	private JTextField inputtext;
	private JTextArea showtext;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSocketFrame0 frame = new ClientSocketFrame0();
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
	public ClientSocketFrame0() {
		setTitle("�ͻ��˳���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		inputtext=new JTextField();
		contentPane.add(inputtext, BorderLayout.SOUTH);
		inputtext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(inputtext.getText());
				showtext.append("�ͻ��˷��͵���Ϣ�ǣ�"+inputtext.getText()+"\n");
				//writer.write(inputtext.getText());
				inputtext.setText("");
				//writer.append("0000");
				//writer.println();
				writer.flush();
				
			}
		});
		final JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		showtext=new JTextArea();
		scrollPane.setViewportView(showtext);
		
	}

	public void connect(){
		showtext.append("�������ӡ���\n");
		try{
			socket=new Socket("192.168.0.103",1978);
			writer=new PrintWriter(socket.getOutputStream(),true);
			showtext.append("�������!\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
