package example300;

/*
 * 实例035 使用数组设置JTable表格的列名与列宽
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;

public class ArrayCreateTable extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayCreateTable frame = new ArrayCreateTable();
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
	public ArrayCreateTable() {
		setTitle("用数组设置JTable表格的列与宽");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(getTable(table));
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	private JTable getTable(JTable table){
		if(table==null){
			table=new JTable();
			table.setRowHeight(25);
			//定义列名数组
			String[] columns={"ID","姓名","性别","出生日期","邮箱","居住地","备注"};
			//定义列宽数组
			int[] columnWidth={ 10,30,10,40,70,60,70};
			//创建表格数据模型
			DefaultTableModel model=new DefaultTableModel(columns, 15);
			table.setModel(model);	//设置表格数据模型
			
			TableColumnModel columnModel=table.getColumnModel();	//获取列模型
			int count=columnModel.getColumnCount();	//获取列数
			for(int i=0;i<count;i++){
				TableColumn column=columnModel.getColumn(i);
				column.setPreferredWidth(columnWidth[i]);
			}
			
			
		}
		return table;
	}
}
