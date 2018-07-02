package example300;

/*
 * ʵ��150 �ڸ����ļ�ʱʹ�ý����� 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserMonitorFrame extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField pathTextField,saveTextField;
	JButton pathButton,saveButton,copyButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMonitorFrame frame = new UserMonitorFrame();
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
	public UserMonitorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("�ڸ����ļ�ʱʹ�ý�����");
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 465, 262);
		panel1.setLayout(null);
		contentPane.add(panel1);
		
		JLabel pathLabel1=new JLabel("�ļ���ַ");
		pathLabel1.setBounds(42, 45, 72, 15);
		panel1.add(pathLabel1);
		
		pathTextField=new JTextField();
		pathTextField.setBounds(124, 42, 197, 21);
		pathTextField.setColumns(10);
		panel1.add(pathTextField);
		
		pathButton=new JButton("ѡ���ļ�");
		pathButton.setBounds(341, 41, 93, 23);
		pathButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_pathButton_actionPerformed(arg0);
				
			}
		});
		panel1.add(pathButton);
		
		JLabel saveLabel=new JLabel("���Ƶ�ַ");
		saveLabel.setBounds(42, 104, 72, 15);
		panel1.add(saveLabel);
		
		saveTextField=new JTextField();
		saveTextField.setBounds(124, 101, 197, 21);
		saveTextField.setColumns(10);
		panel1.add(saveTextField);
		
		saveButton=new JButton("���Ƶ�ַ");
		saveButton.setBounds(341, 100, 93, 23);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_saveButton_actionPerformed(arg0);
				
			}
		});
		panel1.add(saveButton);
		
		copyButton=new JButton("ȷ������");
		copyButton.setBounds(169, 145, 93, 23);
		copyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_copyButtton_actionPerformed(arg0);
				
			}
		});
		panel1.add(copyButton);
		
	}
	
	public JFileChooser getChooser(){
		JFileChooser fileChooser=new JFileChooser();
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (Exception e) {
            e.printStackTrace();
        }// ���ü�����
        SwingUtilities.updateComponentTreeUI(fileChooser);// ʹ���õĽ�������Ч
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // ָʾֻ��ʾĿ¼
        fileChooser.showOpenDialog(this);
        return fileChooser;
	}
	//ѡ��Ҫ���Ƶ��ļ���ť�ĵ����¼�
	protected void do_pathButton_actionPerformed(ActionEvent e){
		FileDialog fd=new FileDialog(this);
		fd.setVisible(true);
		String filePath=fd.getDirectory()+fd.getFile();
		pathTextField.setText(filePath);
	}
	
	protected void do_saveButton_actionPerformed(ActionEvent e){
		JFileChooser fc=getChooser();
		if((fc.getSelectedFile()!=null)&&(!fc.getSelectedFile().equals(""))){
			String strPath=fc.getSelectedFile().getPath();
			saveTextField.setText(strPath);
		}
	}
	
	protected void do_copyButtton_actionPerformed(ActionEvent e){
		Thread thread=new Thread(this);
		thread.start();
	}
	
	@Override
	public void run(){
		ProgressMonitorTest test=new ProgressMonitorTest();
		String path=pathTextField.getText();
		String save=saveTextField.getText();
		System.out.println(save+path.substring(path.lastIndexOf("\\"), path.length()));
		test.useProgressMonitor(this, path, save+path.substring(path.lastIndexOf("\\"), path.length()));
	}
}
