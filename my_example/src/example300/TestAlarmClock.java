package example300;

/*
 * ʵ��067 �ֲ��ڲ���ļ�Ӧ��
 */
import javax.swing.JOptionPane;

public class TestAlarmClock {

	public static void main(String[] args) {
		AlarmClock clock=new AlarmClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "�Ƿ��˳�");
		System.exit(0);
	}

}
