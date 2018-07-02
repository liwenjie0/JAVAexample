package example300.GUI;

/*
 * 实例202 设置信息提示对话框的图标
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MessageDialogIcon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageDialogIcon frame = new MessageDialogIcon();
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
	public MessageDialogIcon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 171);
		setTitle("个人银行");
		setIconImage(new ImageIcon(this.getClass().getResource("money.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
        JLabel label = new JLabel("\u4E2A\u4EBA\u94F6\u884C\u63D0\u6B3E\u673A");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setBounds(6, 6, 310, 37);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("\u63D0\u6B3E\u91D1\u989D\uFF1A");
        label_1.setBounds(6, 55, 71, 18);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(67, 49, 236, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button=new JButton("确定");
        button.setBounds(124, 91, 90, 30);
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_this_actionPerformed(arg0);
				
			}
		});
        contentPane.add(button);	
	}
	
	protected void do_this_actionPerformed(ActionEvent e){
		String string =textField.getText();
		URL resource=getClass().getResource("money.png");
		ImageIcon icon=new ImageIcon(resource);
		JOptionPane.showMessageDialog(this, "你在我这存"+string+"这钱了吧！", "取钱啊！", JOptionPane.WARNING_MESSAGE, icon);
		
	}

}
