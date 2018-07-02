package example300.GUI;
/*
 * ʵ��208 ������Ϣ�Ի���
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomDialog frame = new CustomDialog();
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
	public CustomDialog() {
		setTitle("���ϵͳ�����ľͺ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uFF01\u8282\u65E5\u5E86\u5178\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		label.setBounds(84, 33, 213, 30);
		label.setFont(new Font("SansSerif", Font.PLAIN, 24));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6B63\u786E\u56DE\u7B54\uFF0C\u5C31\u53EF\u4EE5\u8FDB\u5165\u672C\u7CFB\u7EDF\u3002");
		label_1.setBounds(45, 105, 183, 15);
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		contentPane.add(label_1);
		
		JLabel label_2=new JLabel("����isjdfhsdkjfjsdklfsadkfh");
		label_2.setBounds(45, 125,183,15);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u8FDB\u5165\u6D4B\u8BD5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_button_actionPerformed(arg0);
			}
		});
		button.setBounds(237, 168, 93, 23);
		contentPane.add(button);
	}
	
	protected void do_button_actionPerformed(ActionEvent e){
        // �Ի�������������
        String[] options = new String[] { "7��1��", "8��1��", "5��1��", "10��1��" };
        String message = "�ҹ��Ľ�������ÿ��ļ��¼��գ�";// �Ի����е���Ϣ
        int num = JOptionPane.showOptionDialog(this, message, "��������",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, "8��1��");// ��ʾ�Զ���Ի���
        if (options[num].equals("8��1��")) {
            JOptionPane.showMessageDialog(this, "��ϲ���ش���ȷ��");// �ش���ȷ����ʾ
        } else {
            JOptionPane.showMessageDialog(this, "�ش�����ټ���");// �ش�������ʾ
            
        }
	}
}
