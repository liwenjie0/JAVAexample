package example300;

/*
 * ʵ��102 ��List���ϴ���ѧ����Ϣ
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Classinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classinfo frame = new Classinfo();
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
	public Classinfo() {
		setTitle("��List���ϱ�����Ϣ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(getTable());
	}
	private JTable getTable(){
		if(table==null){
			table=new JTable();
			table.setRowHeight(23);
			String[] columns={"����","�Ա�","��������"};
			DefaultTableModel model=new DefaultTableModel(columns, 0);
			table.setModel(model);
			List<String> students=getStudents();
			for(String info:students){
				String[] args=info.split(",");
				model.addRow(args);
			}
			
		}
		return table;
	}

	private List<String> getStudents() {
	      // ����List���϶���
        List<String> list = new ArrayList<String>();
        list.add("���,��,1981-1-1");// ������ݵ����϶���
        list.add("С��,Ů,1981-1-1");
        list.add("С��,��,1981-1-1");
        list.add("С��,��,1981-1-1");
        list.add("С��,��,1981-1-1");
        list.add("С��,��,1981-1-1");
        list.add("����,��,1991-1-4");
        list.add("С��,Ů,1989-1-1");
        return list;
	}
	
}
