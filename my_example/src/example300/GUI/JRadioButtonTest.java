package example300.GUI;

/*
 * 实例220 单选按钮的简单应用
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JRadioButtonTest extends JFrame {

	private JPanel contentPane;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JLabel label;
	    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioButtonTest frame = new JRadioButtonTest();
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
	public JRadioButtonTest() {
		setTitle("单选按钮的应用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 2, 5, 5));
		setContentPane(contentPane);
		
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 1, 5, 5));
		
		radioButton1=new JRadioButton("图片1");
		radioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_radioButton1(e);
				
			}
		});
		buttonPanel.add(radioButton1);
		
		radioButton2=new JRadioButton("图片2");
		radioButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_radioButton2(e);
				
			}
		});
		buttonPanel.add(radioButton2);
		
		radioButton3=new JRadioButton("图片3");
		radioButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_radioButton3(e);
				
			}
		});
		buttonPanel.add(radioButton3);
		
		label=new JLabel();
		contentPane.add(label);
		
		ButtonGroup group=new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		
	}
	
	protected void do_radioButton1(ActionEvent e){
		if(radioButton1.isSelected()){
			ImageIcon icon=new ImageIcon(this.getClass().getResource("1.png"));
			label.setIcon(icon);
		}
	}
	protected void do_radioButton2(ActionEvent e){
		if(radioButton2.isSelected()){
			ImageIcon icon=new ImageIcon(this.getClass().getResource("2.png"));
			label.setIcon(icon);
		}

	}
	protected void do_radioButton3(ActionEvent e){
		if(radioButton3.isSelected()){
			ImageIcon icon=new ImageIcon(this.getClass().getResource("3.png"));
			label.setIcon(icon);
		}
	}

}
