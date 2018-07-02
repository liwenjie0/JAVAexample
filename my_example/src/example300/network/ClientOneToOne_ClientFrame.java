package example300.network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientOneToOne_ClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField send;
	private JTextArea text;
	private JList user_List;
	private JTextField newUser;
	private boolean loginFlag=false;
	private PrintWriter out;
	private String myName=null;
	private Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOneToOne_ClientFrame frame = new ClientOneToOne_ClientFrame();
					frame.setVisible(true);
					frame.createSocket();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientOneToOne_ClientFrame() {
		setTitle("客户端一对一通信——客户端程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel0=new JPanel();
		contentPane.add(panel0, BorderLayout.SOUTH);
		final JLabel lable0=new JLabel("输入连天内容：");
		panel0.add(lable0);
		send=new JTextField();
		send.setPreferredSize(new Dimension(180, 25));
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				send();
				
			}
		});
		panel0.add(send);
		final JButton send_button=new JButton("发送");
		send_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
				
			}
		});
		panel0.add(send_button);
		
		final JSplitPane splitPane=new JSplitPane();
		splitPane.setDividerLocation(100);
		contentPane.add(splitPane, BorderLayout.CENTER);
		final JScrollPane scrollPane_Right=new JScrollPane();
		splitPane.setRightComponent(scrollPane_Right);
		text=new JTextArea();
		scrollPane_Right.setViewportView(text);
		final JScrollPane scrollPane_Left=new JScrollPane();
		splitPane.setLeftComponent(scrollPane_Left);
		user_List=new JList();
		user_List.setModel(new DefaultComboBoxModel(new String[] {""}));
		scrollPane_Left.setViewportView(user_List);
		
		final JPanel panel1=new JPanel();
		contentPane.add(panel1, BorderLayout.NORTH);
		final JLabel label1=new JLabel("输入用户名称");
		panel1.add(label1);
		newUser=new JTextField();
		newUser.setPreferredSize(new Dimension(180, 25));
		panel1.add(newUser);
		final JButton user_button=new JButton("登录");
		user_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(loginFlag){
					JOptionPane.showMessageDialog(null, "在同意窗口只能登陆一次");
					return;
				}
				myName=newUser.getText().trim();
				out.println("用户:"+myName);
				out.flush();
				newUser.setEnabled(false);
				loginFlag=true;
				
			}
		});
		panel1.add(user_button);
		
	}
	
	private void send(){
		if(!loginFlag){
			JOptionPane.showMessageDialog(null, "您还未登录！");
			return ;
		}
		String sendMessage=send.getText();
		if(sendMessage.equals("")){
			return;
		}
		String receiverName=(String)user_List.getSelectedValue();
		String msg=myName+"：发送给："+receiverName+"：的信息是："+sendMessage;
		out.println(msg);
		out.flush();
		send.setText(null);
		text.append(msg+"\n");
	}
	public void createSocket(){
		text.append("正在创建连接……");
		try{
			socket=new Socket("192.168.0.103", 1978);
			text.append("连接服务器成功！\n");
			out=new PrintWriter(socket.getOutputStream());
			new ClientThread(socket).start();
		}catch(Exception e){
			e.printStackTrace();
			text.append("创建连接失败！");
		}
	}

	private class ClientThread extends Thread{
		private Socket socket;
		public ClientThread(Socket s){
			this.socket=s;
		}
		@Override
		public void run() {
			try{
				BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true){
					String info=reader.readLine();
					if(!info.startsWith("MSG:")){
						DefaultComboBoxModel model=(DefaultComboBoxModel)user_List.getModel();	// 获得列表框的模型
						model.removeAllElements();
						int count=Integer.parseInt(info.substring(info.length()-1, info.length()));
						for(int i=0;i<count;i++){
							info=reader.readLine();
							model.addElement(info);
						}
					} else {
                        text.append(info + "\n");// 在文本域中显示信息
                    }
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
