package example300.GUI;
/*
 * 实例196 背景为渐变颜色的主界面
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class GlassPane extends JComponent {

	public GlassPane(){
		addMouseListener(new MouseAdapter() {
		});
		addMouseMotionListener(new MouseMotionAdapter() {
		});
		addKeyListener(new KeyAdapter() {
		});
		setFont(new Font("Default", Font.BOLD, 16));
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("正在下载", 190, 130);
	}
}
