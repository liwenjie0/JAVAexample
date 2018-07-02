package example300.network;

/*
 * ʵ��268 һ�������������ͻ���ͨ��
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ServerSocketFrame3 extends JFrame {

	private JPanel contentPane;
	private JTextArea text;
	private JTextField input;
	private ServerSocket server;
	private Socket socket;
	private Vector<Socket> vector=new Vector<Socket>();
	private int counts=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketFrame3 frame = new ServerSocketFrame3();
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
	public ServerSocketFrame3() {
		setTitle("�ͻ��˳���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JLabel title_label=new JLabel("һ�Զ�ͨ�š�������˳���");
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("����", Font.BOLD, 22));
		title_label.setForeground(new Color(0, 0, 255));
		contentPane.add(title_label, BorderLayout.NORTH);
		
		final JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);	
		text=new JTextArea();
		text.setLineWrap(true);
		scrollPane.setViewportView(text);
		
		final JPanel panel=new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		final JLabel label0=new JLabel("����˷�����Ϣ");
		panel.add(label0);
		input=new JTextField();
		input.setPreferredSize(new Dimension(180, 25));
		panel.add(input);
		final JButton button=new JButton("����");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<vector.size();i++){
					Socket socket0=vector.get(i);
					PrintWriter writer;
					try{
						if(socket0!=null && !socket.isClosed()){
							writer=new PrintWriter(socket0.getOutputStream(),true);
							writer.println(input.getText());
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				text.append("����˷�����ϢΪ��"+input.getText());
				input.setText(null);
				
			}
		});
		panel.add(button);
	}

	public void getServer(){
		try{
			server=new ServerSocket(1978);
			text.append("�������ӳɹ���\n");
			text.append("�ȴ����ӡ���");
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			try{
			while(true){
				socket=server.accept();
				counts++;
				text.append("��"+counts+"�ͻ����ӳɹ���\n");
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println(String.valueOf(counts));
				vector.add(socket);
				new ServerThread(socket,counts).start();;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	});
	
	class ServerThread extends Thread{
		Socket socket=null;
		BufferedReader reader=null;
		int id;
		public ServerThread(Socket socket,int id){
			this.socket=socket;
			this.id=id;
		}
		@Override
		public void run() {
			try{
				if(socket!=null){
					reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					int index=-1;
					try{
						while(true){
							String line=reader.readLine();
							System.out.println(line);
							try{
								index=Integer.parseInt(line);
							}catch(Exception e){
								index=-1;
							}
							if(line!=null){
								text.append("����"+id+"�ͻ������͵���Ϣ��"+line+"\n");
							}
						}
					}catch(Exception e){
                        if (index != -1) {
                            vector.set(index, null);// ���˳��Ŀͻ����׽�������Ϊnull
                            text.append("��" + (index + 1) + "���ͻ����Ѿ��˳���\n"); // ����쳣��Ϣ
                            //counts--;
                        }
						e.printStackTrace();
					}finally {
                        try {
                            if (reader != null) {
                                reader.close();// �ر���
                            }
                            if (socket != null) {
                                socket.close(); // �ر��׽���
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
