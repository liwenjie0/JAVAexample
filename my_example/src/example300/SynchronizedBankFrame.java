package example300;

/*
 * 实例243 使用方法实现线程同步
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SynchronizedBankFrame extends JFrame {

	private JPanel contentPane;
    private JTextArea thread1TextArea;
    private JTextArea thread2TextArea;
    private JButton startButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SynchronizedBankFrame frame = new SynchronizedBankFrame();
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
	public SynchronizedBankFrame() {
		setTitle("使用方法实现线程同步");
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
		
		JLabel label0=new JLabel("一号线程");
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
		
		JLabel label1=new JLabel("二号线程");
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
		Bank bank=new Bank();
		Thread thread1=new Thread(new Transfer(bank, thread1TextArea));
		thread1.start();
		Thread thread2=new Thread(new Transfer(bank, thread2TextArea));
		thread2.start();
		
	}
	
	private class Transfer implements Runnable{
		private Bank bank;
		private JTextArea textArea;
		
		public Transfer(Bank bank,JTextArea textArea){
			this.bank=bank;
			this.textArea=textArea;
		}
		
		@Override
		public void run() {
			for(int i=0;i<10;i++){
				bank.deposit(10);//向账户存入10块
				String text=textArea.getText();
				textArea.setText(text+"账户余额是:"+bank.getAccount()+"\n");
			}
		}
	}
	
	private class Bank{
		private int account=100;
		public synchronized void deposit(int money){
			account+=money;
		}
		public int getAccount(){
			return account;
		}
	}

}
