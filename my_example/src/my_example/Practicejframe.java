package my_example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Practicejframe extends JFrame {
	public void CreateJFrame(String title){
		JFrame jf=new JFrame(title);
		Container container=jf.getContentPane();
		
		JLabel jlabel=new JLabel("这是一个JFrame窗体");
		jlabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jlabel);
		
		JButton btn1=new JButton("点我");
		btn1.setSize(50, 20);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();//创建文件选择对话框
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("请选择文件夹");
				//显示文件选择对话框
				int i=fileChooser.showOpenDialog(getContentPane());
				//判断用户点击是否为打开按钮
				if(i==JFileChooser.APPROVE_OPTION){
					//获取选中的文件对象
					
				}
				
			}
		});
		container.add(btn1, BorderLayout.SOUTH);
		
		//一下设置容器的属性
		container.setBackground(Color.white);
		jf.setVisible(true);
		//jf.setSize(200, 160);
		jf.setBounds(200, 150, 300, 210);
		//设置窗体的关闭方式
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Practicejframe().CreateJFrame("创建一个窗体");
	}

}
