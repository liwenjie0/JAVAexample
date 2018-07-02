package example300;

/*
 * ʵ��133 �����滻�ı��ļ�����
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReplaceTool extends JFrame {

	private JPanel contentPane;
	private JTextField inputword;
	private JTextField resultword;
	private JButton selectFile;
	private JButton startReplace;
	private File textFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReplaceTool frame = new ReplaceTool();
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
	public ReplaceTool() {
		setTitle("�滻����");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,0,5,5));
		
		JLabel label0=new JLabel("�滻ǰ�ַ�����");
		contentPane.add(label0);
		
		inputword=new JTextField();
		inputword.setColumns(10);
		contentPane.add(inputword);
		
		selectFile=new JButton("ѡ���ļ�");
		contentPane.add(selectFile);
		selectFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_chooseButton_actionPerformed(arg0);
				
			}
		});
		
		JLabel label1=new JLabel("�滻���ַ�����");
		contentPane.add(label1);
		
		resultword=new JTextField();
		resultword.setColumns(10);
		contentPane.add(resultword);
		
		startReplace=new JButton("��ʼ�滻");
		contentPane.add(startReplace);
		startReplace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_replaceButton_actionPerformed(e);
				
			}
		});
			
	}
	
	protected void do_chooseButton_actionPerformed(ActionEvent e){
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("�ı��ļ�", "txt"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("��ѡ���ļ�!");
		chooser.setMultiSelectionEnabled(false);
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			textFile=chooser.getSelectedFile();
		}
	}
	
	protected void do_replaceButton_actionPerformed(ActionEvent e){
		String before=inputword.getText();
		if(before.isEmpty()){
			JOptionPane.showMessageDialog(this, "�������滻ǰ�ַ���", "������Ϣ", JOptionPane.WARNING_MESSAGE);
		}
		String after=resultword.getText();
		if(after.isEmpty()){
			JOptionPane.showMessageDialog(this, "�������滻���ַ���", "������Ϣ", JOptionPane.WARNING_MESSAGE);
		}
		FileReader reader=null;
		FileWriter writer=null;
		StringBuilder sb=new StringBuilder();
		int flag=0;
		char[] temp=new char[1024];
		try{
			reader=new FileReader(textFile);
			while((flag=reader.read(temp))!=-1){
				sb.append(temp);
			}
			String content=sb.toString().replace(before,after);
			writer=new FileWriter(textFile);
			writer.write(content);
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(this, "�ַ����滻�ɹ�");
		
	}

}
