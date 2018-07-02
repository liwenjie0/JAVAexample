package example300.GUI;

/*
 * 实例196 背景为渐变颜色的主界面
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ShadePanel extends JPanel {
	public ShadePanel() {
		super();
		setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		Graphics2D g2d=(Graphics2D)g;
		super.paintComponents(g2d);
		int width=getWidth();
		int height=getHeight();
		// 创建填充模式对象
		GradientPaint paint=new GradientPaint(0, 0, Color.CYAN, 0, height, Color.MAGENTA);
		g2d.setPaint(paint);	// 设置绘图对象的填充模式
		g2d.fillRect(0, 0, width, height);	// 绘制矩形填充控件界面
	}
}
