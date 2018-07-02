package example300;

/*
 * 实例102 用List集合传递学生信息
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
		setTitle("用List集合保存信息");
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
			String[] columns={"姓名","性别","出生日期"};
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
	      // 创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("李哥,男,1981-1-1");// 添加数据到集合对象
        list.add("小陈,女,1981-1-1");
        list.add("小刘,男,1981-1-1");
        list.add("小张,男,1981-1-1");
        list.add("小董,男,1981-1-1");
        list.add("小吕,男,1981-1-1");
        list.add("张三,男,1991-1-4");
        list.add("小花,女,1989-1-1");
        return list;
	}
	
}
