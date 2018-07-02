package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class ViewOfMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewOfMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton button_toget = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_toget, 118, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_toget, 72, SpringLayout.WEST, contentPane);
		contentPane.add(button_toget);
		
		
		JButton button_toset = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.WEST, button_toset, 73, SpringLayout.EAST, button_toget);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_toset, 0, SpringLayout.SOUTH, button_toget);
		contentPane.add(button_toset);
	}

}
