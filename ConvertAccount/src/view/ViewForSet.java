package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewForSet extends JFrame {

	private JPanel contentPane;
	private JTextField textField_account;
	private JTextField textField_password;
	private JButton button_confirm;

	/**
	 * Create the frame.
	 */
	public ViewForSet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		setMinimumSize(new Dimension(450, 300));
		setMaximumSize(new Dimension(450, 300));
		setResizable(false);
		setTitle("SET");
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel label_account = new JLabel("Account");
		springLayout.putConstraint(SpringLayout.NORTH, label_account, 60, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, label_account, 60, SpringLayout.WEST, contentPane);
		contentPane.add(label_account);
		
		JLabel label_password = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, label_password, 105, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, label_password, 0, SpringLayout.WEST, label_account);
		contentPane.add(label_password);
		
		textField_account = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_account, 30, SpringLayout.EAST, label_account);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_account, 0, SpringLayout.SOUTH, label_account);
		springLayout.putConstraint(SpringLayout.EAST, textField_account, -65, SpringLayout.EAST, contentPane);
		contentPane.add(textField_account);
		textField_account.setColumns(10);
		
		textField_password = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_password, 0, SpringLayout.WEST, textField_account);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_password, 0, SpringLayout.SOUTH, label_password);
		springLayout.putConstraint(SpringLayout.EAST, textField_password, 0, SpringLayout.EAST, textField_account);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		button_confirm= new JButton("Ã·Ωª");
		springLayout.putConstraint(SpringLayout.NORTH, button_confirm, 36, SpringLayout.SOUTH, textField_password);
		springLayout.putConstraint(SpringLayout.WEST, button_confirm, 170, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, button_confirm, -170, SpringLayout.EAST, contentPane);
		contentPane.add(button_confirm);
	}
}
