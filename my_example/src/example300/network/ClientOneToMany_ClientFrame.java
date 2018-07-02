package example300.network;

/*
 * ʵ��269 �ͻ���һ�Զ�ͨ��
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
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientOneToMany_ClientFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextArea text;
	private JTextField input;
	private PrintWriter out;
	private Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOneToMany_ClientFrame frame = new ClientOneToMany_ClientFrame();
					frame.setVisible(true);
					frame.createSocke();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientOneToMany_ClientFrame() {
		setTitle("�ͻ���һ�Զ�ͨ�š����ͻ��˳���");
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
		
		final JPanel panel=new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		final JLabel label=new JLabel("�������ݣ�");
		panel.add(label);
		input=new JTextField();
		input.setPreferredSize(new Dimension(200, 25));
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				send();
				
			}
		});
		panel.add(input);
		final JButton send=new JButton("����");
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
				
			}
		});
		panel.add(send);
		
	}
	
	private void send(){
		String info=input.getText();
		if(info.equals("")){
			return;
		}else if(info.equals("88")){
			System.exit(0);
		}
		out.println(info);
		text.append("��������ϢΪ��"+info+"\n");
		input.setText("");
	}

	public void createSocke(){
		try{
		text.append("���ڴ������ӡ���");
		socket=new Socket("192.168.0.103", 1978);
		text.append("�������ӳɹ���\n");
		out=new PrintWriter(socket.getOutputStream(),true);
		new ClientThread(socket).start();;
		}catch(UnknownHostException e0){
			e0.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
	}
	private class ClientThread extends Thread{
		Socket socket;
		public ClientThread(Socket s){
			socket=s;
		}
		@Override
		public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));// ��������������
                while (true) {
                    String info = in.readLine();// ��ȡ��Ϣ
                    text.append(info + "\n");// ���ı�������ʾ��Ϣ
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
}
