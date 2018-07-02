import javax.swing.JOptionPane;

import example300.AlarmClock;


public class Test300 {

	public static void main(String[] args) {
		AlarmClock clock=new AlarmClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "ÊÇ·ñÍË³ö");
		System.exit(0);
	}

}
