package example300.GUI;

/*
 * ʵ��196 ����Ϊ������ɫ��������
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
		// �������ģʽ����
		GradientPaint paint=new GradientPaint(0, 0, Color.CYAN, 0, height, Color.MAGENTA);
		g2d.setPaint(paint);	// ���û�ͼ��������ģʽ
		g2d.fillRect(0, 0, width, height);	// ���ƾ������ؼ�����
	}
}
