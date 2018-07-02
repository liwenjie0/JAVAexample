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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class ClientSocketFrame3 extends JFrame {

	private JPanel contentPane;
	private JTextArea text;
	private JTextField input;
	private Socket socket;
	private int index=-1;
	private PrintWriter writer;
	private BufferedReader reader;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSocketFrame3 frame = new ClientSocketFrame3();
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
	public ClientSocketFrame3() {
		setTitle("�ͻ��˳���");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JLabel title_label=new JLabel("һ�Զ�ͨ�š����ͻ��˳���");
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
		final JLabel label0=new JLabel("�ͻ��� ������Ϣ");
		panel.add(label0);
		input=new JTextField();
		input.setPreferredSize(new Dimension(180, 25));
		panel.add(input);
		final JButton button=new JButton("����");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("�����͵���ϢΪ��"+input.getText()+"\n");
				writer.println(input.getText());
				input.setText(null);
				
			}
		});
		panel.add(button);
		
        addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent e) {
                writer.println(String.valueOf(index-1));// ��������˷����˳��ͻ�������ֵ
            }
        });
	}

	public void connect(){
		text.append("�������ӡ���");
		try{
			socket=new Socket("192.168.0.103", 1978);
			text.append("���ӳɹ���\n");
			writer=new PrintWriter(socket.getOutputStream(),true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			index=Integer.parseInt(reader.readLine());
			text.append("���ǵ�"+index+"�����ӵĿͻ�����\n");
			t.start();
	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			getServerInfo();
			
		}
	});
	
    private void getServerInfo() {
        try {
            while (true) { // ����׽���������״̬
                if (reader != null) {
                    String line = reader.readLine();// ��ȡ���������͵���Ϣ
                    if (line != null){
                        text.append("���յ����������͵���Ϣ��" + line + "\n"); // ��ÿͻ�����Ϣ
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    
}