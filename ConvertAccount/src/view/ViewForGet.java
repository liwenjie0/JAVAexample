package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewForGet extends JFrame {

	private JPanel contentPane;
	private JTextField textField_key;
	private JButton button_confirm;

	/**
	 * Create the frame.
	 */
	public ViewForGet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("SET");
		setResizable(false);
		setVisible(true);
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel label_key = new JLabel("Key");
		springLayout.putConstraint(SpringLayout.NORTH, label_key, 68, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, label_key, 50, SpringLayout.WEST, contentPane);
		contentPane.add(label_key);
		
		textField_key = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_key, 20, SpringLayout.EAST, label_key);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_key, 0, SpringLayout.SOUTH, label_key);
		springLayout.putConstraint(SpringLayout.EAST, textField_key, -55, SpringLayout.EAST, contentPane);
		contentPane.add(textField_key);
		textField_key.setColumns(10);
		
		button_confirm = new JButton("Ã·Ωª");
		springLayout.putConstraint(SpringLayout.NORTH, button_confirm, 56, SpringLayout.SOUTH, textField_key);
		springLayout.putConstraint(SpringLayout.WEST, button_confirm, 175, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, button_confirm, -175, SpringLayout.EAST, contentPane);
		contentPane.add(button_confirm);
		
	}

}
