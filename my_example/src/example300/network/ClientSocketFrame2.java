package example300.network;

/*
 * 实例263 使用socket传递对象
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
		setTitle("客户端程序");
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
		final JLabel label0=new JLabel("编号：");
		panel.add(label0);
		
		tf_id=new JTextField();
		tf_id.setPreferredSize(new Dimension(70, 25));
		panel.add(tf_id);
		
		final JLabel label1=new JLabel("名称：");
		panel.add(label1);
		tf_name=new JTextField();
		tf_name.setPreferredSize(new Dimension(100,25));
		panel.add(tf_name);
		
		button=new JButton("发送");
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
                text.append("服务器发送的  编号是：" + tf_id.getText() + "  名称是："+tf_name.getText()+"\n"); // 将文本框中信息显示在文本域中
                tf_id.setText(null); // 将文本框清空
                tf_name.setText(null);
			}
		});
		panel.add(button);
	}

	public void connect(){
		text.append("尝试连接服务器……");
		try{
			socket=new Socket("192.168.0.103", 1978);
			text.append("连接成功！\n");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            text.append("完成连接。\n"); // 文本域中提示信息
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
	            while (true) { // 如果套接字是连接状态
	                Student stud = (Student)in.readObject();
	                if (stud!=null)
	                text.append("接收到服务器发送的  编号为：" + stud.getId() + "  名称为：" +stud.getName() + "\n"); // 获得服务器信息
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        finally {
	            try {
	                if (in != null) {
	                    in.close();// 关闭流
	                }
	                if (socket != null) {
	                    socket.close(); // 关闭套接字
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } 
	        }
	}
}
