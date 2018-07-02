package myapp;

import java.awt.EventQueue;

import view.ViewForGet;
import view.ViewForSet;
import view.ViewOfMain;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOfMain v=new ViewOfMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
