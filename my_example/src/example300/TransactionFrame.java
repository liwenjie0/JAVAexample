package example300;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TransactionFrame extends JFrame {

	private JPanel contentPane;
	private JButton startButton;
	private JTextArea thread1TextArea;
	private JTextArea thread2TextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionFrame frame = new TransactionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransactionFrame() {
		setTitle("简答的线程通信");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		startButton=new JButton("开始存钱");
		startButton.setFont(new Font("微软雅黑",Font.PLAIN,16));
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
				
			}
		});
		buttonPanel.add(startButton);
		
		JPanel processPanel=new JPanel();
		processPanel.setLayout(new GridLayout(1, 2, 5, 5));
		contentPane.add(processPanel, BorderLayout.CENTER);
		
		JPanel thread1Panel=new JPanel();
		thread1Panel.setLayout(new BorderLayout(0,0));
		processPanel.add(thread1Panel);
		
		JLabel label0=new JLabel("卖家");
		label0.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label0.setHorizontalAlignment(SwingConstants.CENTER);
		thread1Panel.add(label0, BorderLayout.NORTH);
		
		JLabel label2=new JLabel("dsfsdafsdaf");
		
		JScrollPane thread1ScrollPanel=new JScrollPane();
		thread1Panel.add(thread1ScrollPanel, BorderLayout.CENTER);
		
		thread1TextArea=new JTextArea();
		thread1TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		thread1ScrollPanel.setViewportView(thread1TextArea);
		
		JPanel thread2Panel=new JPanel();
		thread2Panel.setLayout(new BorderLayout(0, 0));
		processPanel.add(thread2Panel);
		
		JLabel label1=new JLabel("买家");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		thread2Panel.add(label1, BorderLayout.NORTH);
		
		JScrollPane thread2ScrollPanel=new JScrollPane();
		thread2Panel.add(thread2ScrollPanel, BorderLayout.CENTER);
		
		thread2TextArea=new JTextArea();
		thread2TextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		thread2ScrollPanel.setViewportView(thread2TextArea);
			
	}
	
	protected void do_button_actionPerformed(ActionEvent e){
		Sender sender=new Sender();
		Receiver receiver=new Receiver(sender);
		Thread t1=new Thread(sender);
		Thread t2=new Thread(receiver);
		sender.setIsValid(false);
		t1.start();
		t2.start();
	}
	
	private  class Sender implements Runnable{
		private String[] products={"JAVA编程词典","Java范例大全","视频学java编程","细说java","Java开发实战宝典"};
		private volatile String product;
		private volatile boolean isValid;
		public boolean isIsValid(){
			return isValid;
		}
		public void setIsValid(boolean isValid){
			this.isValid=isValid;
		}
		public String getProduct(){
			return product;
		}
		@Override
		public void run() {
			for(int i=0;i<5;i++){
				while(isValid){
					Thread.yield();
				}
				product=products[i];
				String text=thread1TextArea.getText();
				thread1TextArea.setText(text+"发送："+product+"\n");
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				isValid=true;
			}
			
		}
	}
	
	private class Receiver implements Runnable{
		private Sender sender;
		public Receiver(Sender sender){
			this.sender=sender;
		}
		
		@Override
		public void run() {
			for(int i=0;i<5;i++){
				while(!sender.isValid){
					Thread.yield();
				}
				String text=thread2TextArea.getText();
				thread2TextArea.setText(text+"收到："+sender.getProduct()+"\n");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				sender.setIsValid(false);
			}
			
		}
	}

}
