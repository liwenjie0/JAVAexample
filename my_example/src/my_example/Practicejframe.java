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
		
		JLabel jlabel=new JLabel("����һ��JFrame����");
		jlabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jlabel);
		
		JButton btn1=new JButton("����");
		btn1.setSize(50, 20);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();//�����ļ�ѡ��Ի���
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("��ѡ���ļ���");
				//��ʾ�ļ�ѡ��Ի���
				int i=fileChooser.showOpenDialog(getContentPane());
				//�ж��û�����Ƿ�Ϊ�򿪰�ť
				if(i==JFileChooser.APPROVE_OPTION){
					//��ȡѡ�е��ļ�����
					
				}
				
			}
		});
		container.add(btn1, BorderLayout.SOUTH);
		
		//һ����������������
		container.setBackground(Color.white);
		jf.setVisible(true);
		//jf.setSize(200, 160);
		jf.setBounds(200, 150, 300, 210);
		//���ô���Ĺرշ�ʽ
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Practicejframe().CreateJFrame("����һ������");
	}

}
