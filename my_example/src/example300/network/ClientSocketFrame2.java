package example300.network;

/*
 * ʵ��263 ʹ��socket���ݶ���
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientSocketFrame2 extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JTextField tf_id;
	private JTextField tf_name;
	private JTextArea text;
	private ObjectOutputStream out=null;
	private ObjectInputStream in=null;
	private Socket socket;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSocketFrame2 frame = new ClientSocketFrame2();
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
	public ClientSocketFrame2() {
		setTitle("�ͻ��˳���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		text=new JTextArea();
		scrollPane.setViewportView(text);
		
		final JPanel panel=new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		final JLabel label0=new JLabel("��ţ�");
		panel.add(label0);
		
		tf_id=new JTextField();
		tf_id.setPreferredSize(new Dimension(70, 25));
		panel.add(tf_id);
		
		final JLabel label1=new JLabel("���ƣ�");
		panel.add(label1);
		tf_name=new JTextField();
		tf_name.setPreferredSize(new Dimension(100,25));
		panel.add(tf_name);
		
		button=new JButton("����");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                Student stud = new Student();
                stud.setId(tf_id.getText());
                stud.setName(tf_name.getText());
                try {
                    out.writeObject(stud);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } 
                text.append("���������͵�  ����ǣ�" + tf_id.getText() + "  �����ǣ�"+tf_name.getText()+"\n"); // ���ı�������Ϣ��ʾ���ı�����
                tf_id.setText(null); // ���ı������
                tf_name.setText(null);
			}
		});
		panel.add(button);
	}

	public void connect(){
		text.append("�������ӷ���������");
		try{
			socket=new Socket("192.168.0.103", 1978);
			text.append("���ӳɹ���\n");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            text.append("������ӡ�\n"); // �ı�������ʾ��Ϣ
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
               getClientInfo();
            
			
		}
	});
	private void getClientInfo(){
		   try {
	            while (true) { // ����׽���������״̬
	                Student stud = (Student)in.readObject();
	                if (stud!=null)
	                text.append("���յ����������͵�  ���Ϊ��" + stud.getId() + "  ����Ϊ��" +stud.getName() + "\n"); // ��÷�������Ϣ
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        finally {
	            try {
	                if (in != null) {
	                    in.close();// �ر���
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
