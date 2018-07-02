package example300.network;

/*
 * 实例254 解析网页中的内容 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InternetContentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JButton button;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternetContentFrame frame = new InternetContentFrame();
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
	public InternetContentFrame() {
		super();
		setTitle("解析网页中的内容");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 375);
		contentPane = (JPanel) getContentPane();
		
		JPanel panel0=new JPanel();
		contentPane.add(panel0, BorderLayout.NORTH);
		
		final JLabel label=new JLabel("输入网址");
		panel0.add(label);
		
		text=new JTextField();
		text.setPreferredSize(new Dimension(260, 25));
		//text.setSize(new Dimension(260, 25));
		panel0.add(text);
		
		button=new JButton("解析网页");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            String address = text.getText().trim();// 获得输入的网址
                Collection urlCollection = getURLCollection(address);// 调用方法，获得网页内容的集合对象
                Iterator it = urlCollection.iterator();  // 获得集合的迭代器对象
                while(it.hasNext()){
                    textArea.append((String)it.next()+"\n");       // 在文本域中显示解析的内容
                }
				
			}
		});
		panel0.add(button);
		
		JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea=new JTextArea();
		textArea.setFont(new Font("", Font.BOLD, 14));
		scrollPane.setViewportView(textArea);
			
	}
	public Collection<String> getURLCollection(String urlString){
		URL url=null;
		URLConnection conn=null;
		Collection<String> urlCollection=new ArrayList<String>();
		try{
			url=new URL(urlString);
			conn=url.openConnection();
			conn.connect();
			System.out.println(conn.getContentLength());
			InputStream is=conn.getInputStream();
			InputStreamReader ir=new InputStreamReader(is, "UTF-8");
			BufferedReader br=new BufferedReader(ir);
			String nextLine=br.readLine();
			while(nextLine!=null){
				urlCollection.add(nextLine);
				nextLine=br.readLine();
			}
			br.close();
			ir.close();
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return urlCollection;
	}

}
