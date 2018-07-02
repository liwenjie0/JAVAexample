package example300.GUI;

/*
 * 实例205 支持图片预览的文件选择对话框
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

import javax.imageio.ImageIO;
import javax.imageio.stream.IIOByteBuffer;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PicPreviewFileSelectDialog extends JFrame {
	private final int SIZE=230;
	private JPanel contentPane;
	private BackgroundPanel paint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicPreviewFileSelectDialog frame = new PicPreviewFileSelectDialog();
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
	public PicPreviewFileSelectDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		
		JFileChooser fileChooser=new JFileChooser();
		contentPane.add(fileChooser, BorderLayout.CENTER);	
		paint=new BackgroundPanel();
		paint.setBorder(new BevelBorder(BevelBorder.LOWERED));	//设置面板的边框
		paint.setPreferredSize(new Dimension(230, 230));
		fileChooser.setAccessory(paint);
		
		fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				do_this_propertyChange(evt);
				
			}
		});
		fileChooser.setFileFilter(new FileNameExtensionFilter("文件选择器", "jpg","png","gif","jpeg"));
	}
	
	protected void do_this_propertyChange(PropertyChangeEvent e){
		if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY==e.getPropertyName()){
			File pic=(File)e.getNewValue();
			if(pic!=null&&pic.isFile()){
				try{
					Image image=getToolkit().getImage(pic.toURI().toURL());
					/*BufferedImage inimage=ImageIO.read(pic.toURI().toURL());
					double height=inimage.getHeight();
					double width=inimage.getWidth();
					int newheight,newwidth;
					if(height>width){
						newheight=SIZE;
						double temp=SIZE/height;
						newwidth=(int)(width*temp);
					}else{
						newwidth=SIZE;
						double temp=SIZE/width;
						newheight=(int)(height*temp);
					}
					BufferedImage outimage=new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_BGR);
					Graphics g=outimage.createGraphics();
					g.drawImage(inimage,0 , 0, newwidth, newheight, null);
					Image newimage=outimage.getScaledInstance(, 200, 0);*/
					
					paint.setImage(image.getScaledInstance(-1, -1, 10));
					paint.repaint();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	}
}
