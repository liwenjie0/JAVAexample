package example300;

/*
 * 实例066 普通内部类的简单应用
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ButtonTestColor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonTestColor frame = new ButtonTestColor();
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
	public ButtonTestColor() {
		
		 setTitle("普通内部类的简单应用");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 300, 200);
	        contentPane = new JPanel();
	        contentPane.setLayout(null);
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.requestFocus();
	        setContentPane(contentPane);

	        final JButton redButton = new JButton();
	        redButton.setText("红色");
	        redButton.setBounds(15, 20, 82, 30);
	        redButton.addActionListener(new ColorAction(Color.RED));
	        contentPane.add(redButton);

	        final JButton greenButton = new JButton();
	        greenButton.setText("绿色");
	        greenButton.setBounds(100, 20, 82, 30);
	        greenButton.addActionListener(new ColorAction(Color.GREEN));
	        contentPane.add(greenButton);

	        final JButton blueButton = new JButton();
	        blueButton.setText("蓝色");
	        blueButton.setBounds(185, 20, 82, 30);
	        blueButton.addActionListener(new ColorAction(Color.BLUE));
	        contentPane.add(blueButton);
	}
	
    private class ColorAction implements ActionListener {
        
        private Color background;
        
        public ColorAction(Color background) {
            this.background = background;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	contentPane.setBackground(background);
            
        }
    }

}
