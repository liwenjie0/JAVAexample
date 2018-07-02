package example300.GUI;

/*
 * ʵ��232 ���ñ���ѡ��ģʽ
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

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TableSelectModelTest extends JFrame {

	private JPanel contentPane;
    private JTable table;
    private JCheckBox checkBox;

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
					TableSelectModelTest frame = new TableSelectModelTest();
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
	public TableSelectModelTest() {
		setTitle("���ñ���ѡ��ģʽ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel=new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2,1,5,5));
		
		JPanel panel1=new JPanel();
		panel.add(panel1);
		
		JLabel label1 = new JLabel("\u884C\u9009\u62E9\u6A21\u5F0F\uFF1A");
        label1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        panel1.add(label1);
        
        JRadioButton rowRadioButton1=new JRadioButton("��ѡ");
        rowRadioButton1.setSelected(true);
        rowRadioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_rowRadioButton1_actionPerformed(e);
				
			}
		});
        rowRadioButton1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        panel1.add(rowRadioButton1);
        
        JRadioButton rowRadioButton2 = new JRadioButton("\u8FDE\u7EED\u591A\u884C");
        rowRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rowRadioButton2_actionPerformed(e);
            }
        });
        rowRadioButton2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        panel1.add(rowRadioButton2);
        
        JRadioButton rowRadioButton3 = new JRadioButton("\u4EFB\u610F\u591A\u884C");
        rowRadioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rowRadioButton3_actionPerformed(e);
            }
        });
        rowRadioButton3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        panel1.add(rowRadioButton3);
        
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(rowRadioButton1);
        buttonGroup.add(rowRadioButton2);
        buttonGroup.add(rowRadioButton3);
        
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        
        checkBox = new JCheckBox("\u7981\u7528\u5217\u9009\u62E9");
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox_actionPerformed(e);
            }
        });
        checkBox.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        panel2.add(checkBox);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        scrollPane.setViewportView(table);
        
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowActivated(WindowEvent e) {
        		super.windowActivated(e);
        		do_this_windowActived(e);
        	}
		});
	}
	protected void do_this_windowActived(WindowEvent e){
		DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(new Object[]{"����","������","����ʱ��","�������","����"});
		tableModel.addRow(new Object[] { "Java�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "59.8Ԫ" });
        tableModel.addRow(new Object[] { "PHP�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "69.8Ԫ" });
        tableModel.addRow(new Object[] { "Visual Basic�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "69.8Ԫ" });
        tableModel.addRow(new Object[] { "Visual C++�����ŵ���ͨ����2�棩", "�廪��ѧ������", "2010-07-01", "�������ʦ���Ŵ���", "69.8Ԫ" });
        table.setModel(tableModel);
        
        int[] columns={150,75,65,120,35};
        TableColumnModel columnModel=table.getColumnModel();
        int columncount=columnModel.getColumnCount();
        for(int i=0;i<columncount;i++){
        	columnModel.getColumn(i).setPreferredWidth(columns[i]);
        }
	}
    protected void do_rowRadioButton1_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    protected void do_rowRadioButton2_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }
    
    protected void do_rowRadioButton3_actionPerformed(ActionEvent e) {
        table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    protected void do_checkBox_actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            checkBox.setText("������ѡ��");
            table.setColumnSelectionAllowed(true);
        } else {
            checkBox.setText("������ѡ��");
            table.setColumnSelectionAllowed(false);
        }
    }

}
