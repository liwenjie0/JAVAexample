package example300.GUI;

/*
 * ʵ��209 ����ʱ��Ĳ�������
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DownloadSoft extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	       try {
	            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadSoft frame = new DownloadSoft();
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
	public DownloadSoft() {
		setTitle("���ļ�������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u8981\u4E0B\u8F7D\u7684\u6587\u4EF6");
        contentPane.add(label, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button=new JButton("��ʼ����");
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
				
			}
		});
        panel.add(button);
        
        JScrollPane scrollPane=new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table=new JTable();
        scrollPane.setViewportView(table);
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowActivated(WindowEvent e) {
        		do_this_windowActiviated(e);
        	}
		});
              
	}
	
	protected void do_button_actionPerformed(ActionEvent e){
		getGlassPane().setVisible(true);
	}
	protected void do_this_windowActiviated(WindowEvent e){
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(new Object[]{"����","������","����ʱ��","�������","�۸�"});
		model.addRow(new Object[]{"JAVA�����ŵ���ͨ��2��","�廪��ѧ������","2010-07-01","�������ʦ���Ŵ���","59.8"});
		model.addRow(new Object[]{"PHP�����ŵ���ͨ����2�棩","|�廪��ѧ������","2010-07-01","�������ʦ���Ŵ���","69.8"});
		model.addRow(new Object[]{"Visual Basic�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "69.8Ԫ"});
		model.addRow(new Object[]{"Visual C++�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "69.8Ԫ"});
		table.setModel(model);
		//setGlassPane(new GlassPane());
		
	}
	
	

}
