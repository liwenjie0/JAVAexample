package example300.GUI;

/*
 * 实例195 实现带背景图片的窗体
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SetFormBackImage extends JFrame {

	private JPanel contentPane;
	private Image image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFormBackImage frame = new SetFormBackImage();
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
	public SetFormBackImage() {
		setTitle("实现带背景图片的 窗体");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 500, 503);
		
		image=new ImageIcon(this.getClass().getClassLoader().getResource("image0.jpeg")).getImage();
		
		contentPane = new JPanel(){
			/*@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				if(image!=null){
					g.drawImage(image, 0, 0, this);
				}
				
			}*/
		};
		contentPane=new BackgroundPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//contentPane.setOpaque(false);
		
		BackgroundPanel panel=new BackgroundPanel();
		panel.setImage(image);
		contentPane.add(panel, BorderLayout.CENTER);
		
		
	}

}
