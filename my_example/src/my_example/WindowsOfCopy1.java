package my_example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class WindowsOfCopy1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JButton confirm;
	private JButton cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsOfCopy1 frame = new WindowsOfCopy1();
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
	public WindowsOfCopy1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 150, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -5, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6E90\u6587\u4EF6\u5939\uFF1A");
		sl_panel.putConstraint(SpringLayout.NORTH, label, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, panel);
		panel.add(label);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.EAST, label);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 300, SpringLayout.EAST, label);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u76EE\u6807\u6587\u4EF6\u5939\uFF1A");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 20, SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, label);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("\u9009\u62E9\u2026");
		sl_panel.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.EAST, textField);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFileSelect(textField);
			}
		});
		
		button_1 = new JButton("\u9009\u62E9\u2026");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, button_1, 10, SpringLayout.EAST, textField_1);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFileSelect(textField_1);
			}
		});
		
		
		JLabel notice = new JLabel("\u6CE8\u610F\uFF1A\u76EE\u6807\u6587\u4EF6\u5939\u4E0D\u5F97\u5305\u542B\u6E90\u6587\u4EF6\u5939\uFF01");
		sl_panel.putConstraint(SpringLayout.NORTH, notice, 10, SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, notice, 10, SpringLayout.WEST, panel);
		panel.add(notice);
		
		confirm = new JButton("\u786E\u5B9A");
		sl_contentPane.putConstraint(SpringLayout.NORTH, confirm, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, confirm, 249, SpringLayout.WEST, contentPane);
		contentPane.add(confirm);
		
		cancel = new JButton("\u53D6\u6D88");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cancel, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, cancel, -32, SpringLayout.WEST, confirm);
		contentPane.add(cancel);

	}
	
	private void openFileSelect(JTextField jtext){
		JFileChooser fileChooser=new JFileChooser();//创建文件选择对话框
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("请选择文件夹");
		//显示文件选择对话框
		int i=fileChooser.showOpenDialog(getContentPane());
		//判断用户点击是否为打开按钮
		if(i==JFileChooser.APPROVE_OPTION){
			//获取选中的文件对象
			File selectedDirectory=fileChooser.getSelectedFile();
			//设置文本框的内容为选择的路径
			jtext.setText(selectedDirectory.toString());
		}
		
	}
}
