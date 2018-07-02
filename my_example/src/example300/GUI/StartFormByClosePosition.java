package example300.GUI;

/*
 * 实例187 从上次关闭位置启动窗体
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartFormByClosePosition extends JFrame {

	private JPanel contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFormByClosePosition frame = new StartFormByClosePosition();
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
	public StartFormByClosePosition() {
		setTitle("\u4ECE\u4E0A\u6B21\u5173\u95ED\u4F4D\u7F6E\u542F\u52A8\u7A97\u4F53");
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("image0.jpeg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
        
        addComponentListener(new ComponentAdapter() {
        	@Override
        	public void componentMoved(ComponentEvent e) {
        		do_this_componentMoved(e);
        	}
		});
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowOpened(WindowEvent e) {
        		do_this_windowOpened(e);
        	}
        	@Override
        	public void windowClosing(WindowEvent e) {
        		do_this_windowClosing(e);
        	}
		});
        
	}
	
	private void do_this_componentMoved(ComponentEvent e){
		Point location=getLocation();
		int x=location.x;
		int y=location.y;
		label.setText("窗体当前坐标：X="+x+",Y="+y);
	}
	private void do_this_windowClosing(WindowEvent e){
		Preferences root=Preferences.userRoot();
		Point location=getLocation();
		root.putInt("locationX", location.x);
		root.putInt("locationY", location.y);
	}
	private void do_this_windowOpened(WindowEvent e){
		Preferences root=Preferences.userRoot();
		int x=root.getInt("locationX", 100);
		int y=root.getInt("locationY", 100);
		setLocation(x, y);
	}

}
