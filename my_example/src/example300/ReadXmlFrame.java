package example300;

/*
 * 实例151 从XML文件中读取数据
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReadXmlFrame extends JFrame {

	private JPanel contentPane;
	private JTextField classNameTextField;
	private JTextField urlTextField;
	private JTextField userNameTextField;
	private JTextField passWordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ReadXmlFrame frame = new ReadXmlFrame();
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
	public ReadXmlFrame() {
		setTitle("从XML文件中读取内容");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 434, 245);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		ReadXMLDataBase readXML=new ReadXMLDataBase();
		
		JLabel classNameLabel=new JLabel("驱动代码");
		classNameLabel.setBounds(48, 49, 74, 15);
		panel1.add(classNameLabel);
		
		classNameTextField=new JTextField();
		classNameTextField.setBounds(132, 46, 238, 21);
		classNameTextField.setText(readXML.readXMl("className"));
		classNameTextField.setColumns(10);
		panel1.add(classNameTextField);
		
		JLabel urlLabel=new JLabel("URL:");
		urlLabel.setBounds(66, 90, 54, 15);
		panel1.add(urlLabel);
		
		urlTextField=new JTextField();
		urlTextField.setText(readXML.readXMl("url"));
		urlTextField.setBounds(132, 87, 238, 21);
		urlTextField.setColumns(10);
		panel1.add(urlTextField);
		
		JLabel userNameLabel=new JLabel("用户名：");
		userNameLabel.setBounds(66, 127, 54, 15);
		panel1.add(userNameLabel);
		
		userNameTextField=new JTextField();
		userNameTextField.setText(readXML.readXMl("userName"));
		userNameTextField.setBounds(132, 124, 238, 21);
		userNameTextField.setColumns(10);
		panel1.add(userNameTextField);
		
		JLabel passWordLabel=new JLabel("密码：");
		passWordLabel.setBounds(66,171,454,15);
		panel1.add(passWordLabel);
		
		passWordTextField=new JTextField();
		passWordTextField.setBounds(132, 168, 238, 21);
		passWordTextField.setText(readXML.readXMl("passWord"));
		passWordTextField.setColumns(10);
		panel1.add(passWordTextField);
		
		
	}

}
