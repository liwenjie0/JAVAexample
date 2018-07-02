package example300.GUI;

/*
 * 实例230 表头与列的高度设置
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ResizeTableTest extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTable table2;

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
					ResizeTableTest frame = new ResizeTableTest();
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
	public ResizeTableTest() {
		setTitle("设置表格宽度和高度");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 2, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel=new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout( 0, 0));
		
		JLabel label1=new JLabel("默认的表格");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		panel.add(label1, BorderLayout.NORTH);
		
        JScrollPane scrollPane1 = new JScrollPane();
        panel.add(scrollPane1, BorderLayout.CENTER);
        
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        
        JPanel panel2 = new JPanel();
        contentPane.add(panel2);
        panel2.setLayout(new BorderLayout(0, 0));
        
        JLabel label2 = new JLabel("\u81EA\u5B9A\u4E49\u8868\u683C");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(label2, BorderLayout.NORTH);
        
        JScrollPane scrollPane2 = new JScrollPane();
        panel2.add(scrollPane2, BorderLayout.CENTER);

        table2 = new JTable();
        table2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table2.setRowHeight(35);
        JTableHeader header = table2.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane2.setViewportView(table2);
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowActivated(WindowEvent e) {
        		do_this_windowActivated(e);
        	}
		});
	}
	
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "排名", "语言" });
        model.addRow(new Object[] { "1", "Java" });
        model.addRow(new Object[] { "2", "C" });
        model.addRow(new Object[] { "3", "C#" });
        table1.setModel(model);
        table2.setModel(model);
    }

}
