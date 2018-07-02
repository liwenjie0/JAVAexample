package example300;

/*
 * 实例099 去掉字符串中的所有空格
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteBlank extends JFrame {

	private JPanel contentPane;
	private JTextField inputtext;
	private JTextField outputtext;
	private Button change;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBlank frame = new DeleteBlank();
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
	public DeleteBlank() {
		setTitle("去除字符串中的所有空格");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label0=new JLabel("输入字符串：");
		label0.setBounds(21,12,75,15);
		contentPane.add(label0);
		
		inputtext=new JTextField();
		inputtext.setBounds(102, 5, 258, 30);
		inputtext.setColumns(10);
		contentPane.add(inputtext);
		
		change=new Button("去除空格");
		change.setBounds(10, 50, 82, 23);
		change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_change_actionPerformed(arg0);
				
			}
		});
		contentPane.add(change);
		
		outputtext=new JTextField();
		outputtext.setBounds(102, 46, 258, 30);
		outputtext.setColumns(10);
		contentPane.add(outputtext);
		
	}
	
	protected void do_change_actionPerformed(ActionEvent e){
		String text=inputtext.getText();
		StringBuilder strBuilder=new StringBuilder();
		for(int i=0;i<text.length();i++){
			char chatAt=text.charAt(i);
			if(chatAt==' '){
				continue;
			}
			strBuilder.append(chatAt);
		}
		outputtext.setText(strBuilder.toString());
	}

}
