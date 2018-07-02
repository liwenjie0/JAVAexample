package example300;

/*
 * ʵ��035 ʹ�ð�ť�ؼ�����ʵ�ּ���������
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class ButtonArrayExample extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonArrayExample frame = new ButtonArrayExample();
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
	public ButtonArrayExample() {
		super();
		setTitle("��ť����ʵ�ּ��������� "); // ���ô���ı���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 350);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		BorderLayout borderLayout=(BorderLayout)getContentPane().getLayout();
		borderLayout.setHgap(20);	//���������ˮƽ���
		borderLayout.setVgap(10);	//��������Ĵ�ֱ���
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setPreferredSize(new Dimension(12, 50));
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		GridLayout gridLayout=new GridLayout(4, 0);	//�������񲼾ֹ�����
		gridLayout.setHgap(5);	//���������ˮƽ���
		gridLayout.setVgap(5);	//��������Ĵ�ֱ���
		
		JPanel panel=new JPanel();
		panel.setLayout(gridLayout);
		contentPane.add(panel,BorderLayout.CENTER);
		String[][]names={{"1","2","3","+"},{"4","5","6","-"},{"7","8","9","*"},{".","0","=","/"}};
		JButton[][] buttons=new JButton[4][4];
		for(int row=0;row<names.length;row++){
			for(int col=0;col<names[row].length;col++){
				buttons[row][col]=new JButton(names[row][col]);
				panel.add(buttons[row][col]);
			}
		}
		
	}

}
