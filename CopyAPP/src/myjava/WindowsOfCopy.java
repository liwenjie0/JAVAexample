package myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowsOfCopy extends JFrame {

	private String sourcePath;
	private String targetPath;
	private CopyOperation copyOperator;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button_source;
	private JButton button_target;
	private JButton button_confirm;
	private JButton button_cancel;
	private JLabel warnning;



	/**
	 * Create the frame.
	 */
	public WindowsOfCopy(CopyOperation c) {
		copyOperator=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);	
		setBounds(100, 100, 500, 300);
		//setMinimumSize(new Dimension(500, 300));
		//setMaximumSize(new Dimension(500, 300));
		setTitle("复制工具");
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
		
		button_source = new JButton("\u9009\u62E9\u2026");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_source, 0, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, button_source, 10, SpringLayout.EAST, textField);
		panel.add(button_source);
		button_source.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFileSelect(textField,true);
			}
		});
		
		button_target = new JButton("\u9009\u62E9\u2026");
		sl_panel.putConstraint(SpringLayout.SOUTH, button_target, 0, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, button_target, 10, SpringLayout.EAST, textField_1);
		panel.add(button_target);
		button_target.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFileSelect(textField_1,false);
			}
		});
		
		
		JLabel notice = new JLabel("注意：源文件夹路径不得包含目标文件夹路径！");
		sl_panel.putConstraint(SpringLayout.NORTH, notice, 10, SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, notice, 10, SpringLayout.WEST, panel);
		panel.add(notice);
		
		button_confirm = new JButton("\u786E\u5B9A");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_confirm, 45, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_confirm, 249, SpringLayout.WEST, contentPane);
		contentPane.add(button_confirm);
		button_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean b0=copyOperator.isContain(sourcePath, targetPath);
				boolean b1=copyOperator.isFileEquals(sourcePath, targetPath);
				if(b1||b0){
					warnning.setText("警告：源路径包含目标路径!");
				}else{				
					System.out.println(sourcePath+"---"+targetPath);
					if(copyOperator.Copy(sourcePath, targetPath)){
						warnning.setText("复制完成");
					}
				}

				
			}
		});
		
		button_cancel = new JButton("\u53D6\u6D88");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_cancel, 0, SpringLayout.NORTH, button_confirm);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_cancel, -32, SpringLayout.WEST, button_confirm);
		contentPane.add(button_cancel);
		button_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearTextField();
				
			}
		});
		
		warnning = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, warnning, 1, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, warnning, 150, SpringLayout.WEST, contentPane);
		contentPane.add(warnning);
		warnning.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 warnning.setText("");
			}
		});


	}
	
	//打开文件选择器，第一个参数输入编辑框，以便选择之后进行赋值，第二个参数用于判断是否要进行选择文件或不选择文件
	private void openFileSelect(JTextField jtext,boolean only){
		JFileChooser fileChooser=new JFileChooser();//创建文件选择对话框
		if(only){
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		}else{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		fileChooser.setDialogTitle("请选择文件夹");
		String jtext_path=jtext.getText();
		if(jtext_path.equals("")){
			fileChooser.setCurrentDirectory(new File("\\"));
		}else{
			String cutpath=jtext_path.substring(0, jtext_path.lastIndexOf("\\"));
			if(cutpath.endsWith(":"))
				cutpath=cutpath+"\\";
			fileChooser.setCurrentDirectory(new File(cutpath));
		}
		
		//显示文件选择对话框
		int i=fileChooser.showOpenDialog(getContentPane());
		//判断用户点击是否为打开按钮
		if(i==JFileChooser.APPROVE_OPTION){
			//获取选中的文件对象
			File selectedDirectory=fileChooser.getSelectedFile();
			//设置文本框的内容为选择的路径
			if(only){
				sourcePath=selectedDirectory.toString();
				jtext.setText(sourcePath);
			}else{
				targetPath=selectedDirectory.toString();
				jtext.setText(targetPath);
			}
		}
		
	}
	
	//清楚输入框的内容
	private void clearTextField(){
		textField.setText("");
		textField_1.setText("");
		warnning.setText("");
	}
}
