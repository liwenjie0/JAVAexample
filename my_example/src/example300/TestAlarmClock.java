package example300;

/*
 * 实例067 局部内部类的简单应用
 */
import javax.swing.JOptionPane;

public class TestAlarmClock {

	public static void main(String[] args) {
		AlarmClock clock=new AlarmClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "是否退出");
		System.exit(0);
	}

}
