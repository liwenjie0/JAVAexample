package example300.network;

/*
 * 实例249 获得内网所有IP地址
 * PS：本程序有在线程运行问题上存在很大的缺陷！
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class GainAllIpFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton showAllIP,exit;
	public static volatile Hashtable<String, String> pingMap;	// 用于存储所ping的IP是否为内网IP的集合
	private volatile boolean isgo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GainAllIpFrame frame = new GainAllIpFrame();
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
	public GainAllIpFrame() {

		isgo=true;
		
		setTitle("获取内网所有IP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel,BorderLayout.NORTH);
		
		showAllIP=new JButton("显示所有IP");
		showAllIP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
                try {
                    
                    gainAllIP();
                } catch (Exception e1) {
                    textArea.setText(null);
                    JOptionPane.showMessageDialog(null, "应用程序异常，请再试一次。");
                }
			}
		});
		buttonPanel.add(showAllIP);
		
		exit=new JButton("退出");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		buttonPanel.add(exit);
		
		JScrollPane scrollPanel=new JScrollPane();
		contentPane.add(scrollPanel, BorderLayout.CENTER);
		textArea=new JTextArea();
		scrollPanel.setViewportView(textArea);
		
		pingMap=new Hashtable<String, String>();

	}
	
	public void gainAllIP()throws Exception{
		InetAddress host=InetAddress.getLocalHost();
		String hostAddress=host.getHostAddress();
		System.out.println(hostAddress);
		int pos=hostAddress.lastIndexOf(".");
		String wd=hostAddress.substring(0, pos+1);
		System.out.println("开始查询");
		for(int i=1;i<255;i++){
			String ip=wd+i;
			PingIPThread thread0=new PingIPThread(ip);
			thread0.start();
		}
		/*while(isgo){
			Thread.yield();
			//Thread.sleep(5000);
			
			System.out.println("等待");
		}*/
		
		System.out.println("查询完毕");
		Set<String> set=pingMap.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			
			String key=it.next();
			String value=pingMap.get(key);
			System.out.println(key);
			if(value.equals("true")){
				textArea.append(key+"\n");
			}
		}
	}
	
	class PingIPThread extends Thread{
		public String ip;
		public PingIPThread(String ip){
			this.ip=ip;
		}
		@Override
		public void run() {
			try{
				 // 获得所ping的IP进程，-w 280是等待每次回复的超时时间，-n 1是要发送的回显请求数
				Process process=Runtime.getRuntime().exec("ping "+ip+" -w 280 -n 1");
				InputStream inputStream=process.getInputStream();
				InputStreamReader in=new InputStreamReader(inputStream);
				BufferedReader inr=new BufferedReader(in);
				String line=inr.readLine();
				while(line!=null){
					if(line!=null && !line.equals("")){
						if(line.substring(0, 2).equals("来自") 
								|| (line.length()>10 
										&& line.substring(0, 10).equals("Reply from"))){
							pingMap.put(ip, "true");// 向集合中添加IP
						}
					}
					line=inr.readLine();
				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			isgo=false;
			
		}
	}

}
