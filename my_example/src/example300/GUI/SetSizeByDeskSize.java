package example300.GUI;
/*
 * 实例190 根据桌面大小调整窗口大小
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SetSizeByDeskSize extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetSizeByDeskSize frame = new SetSizeByDeskSize();
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
	public SetSizeByDeskSize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label=new JLabel("根据屏幕大小改变窗体");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowOpened(e);
				do_this_windowOpened(e);
			}
		});
	}
	
	private void do_this_windowOpened(WindowEvent e){
		Toolkit toolkit=getToolkit();
		Dimension screenSize=toolkit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		int new_width=(int)(width*0.8);
		int new_height=(int)(height*0.8);
		setSize(new_width, new_height);
		setLocation((int)(width*0.1), (int)(height*0.05));
	}

}
