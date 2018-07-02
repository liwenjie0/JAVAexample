package example300.GUI;

/*
 * 实例235 实现表格的查找功能
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchTable extends JFrame {

	private JPanel contentPane;
	private JButton doSearch;
	private JTextField input;
	private JTable table;
	private TableRowSorter<TableModel> sorter=new TableRowSorter<TableModel>();
	
	
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
					SearchTable frame = new SearchTable();
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
	public SearchTable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				super.windowActivated(e);
				do_this_windowActived(e);
				
			}
		});
		setTitle("支持查找功能的表格");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel0=new JPanel();
		contentPane.add(panel0, BorderLayout.NORTH);
		
		JLabel label0=new JLabel("关键字：");
		label0.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		panel0.add(label0);
		
		input=new JTextField();
		input.setColumns(20);
		input.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		panel0.add(input);
		
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		doSearch=new JButton("查找");
		doSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
				
			}
		});
		doSearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		buttonPanel.add(doSearch);
		
		JScrollPane scrollPane=new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table=new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		table.setRowHeight(30);
		JTableHeader header=table.getTableHeader();
		header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		scrollPane.setViewportView(table);
	}
	
	protected void do_this_windowActived(WindowEvent e){
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(new Object[] { "书名", "出版社", "出版时间", "丛书类别", "定价" });
		model.addRow(new Object[] { "Java从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "59.8元" });
	    model.addRow(new Object[] { "PHP从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
	    model.addRow(new Object[] { "Visual Basic从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
	    model.addRow(new Object[] { "Visual C++从入门到精通（第2版）", "清华大学出版社", "2010-07-01", "软件工程师入门丛书", "69.8元" });
	    model.setRowCount(10);
	    sorter.setModel(model);
	    table.setRowSorter(sorter);
		
		
	}
	protected void do_button_actionPerformed(ActionEvent e) {
		sorter.setRowFilter(RowFilter.regexFilter(input.getText()));
	}

}
