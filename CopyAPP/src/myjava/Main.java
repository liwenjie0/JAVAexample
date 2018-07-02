package myjava;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CopyOperation copyOperator=new CopyOperation();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsOfCopy frame = new WindowsOfCopy(copyOperator);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
