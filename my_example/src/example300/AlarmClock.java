package example300;

/*
 * 实例067 局部内部类的简单应用
 */
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.timer.Timer;

public class AlarmClock {
	private int delay;	//表示延时时间
	private boolean flag;	//表示是否要发出声音
	
	public AlarmClock(int delay,boolean flag){
		this.delay=delay;
		this.flag=flag;
	}

	public void start(){
		class Printer implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat format=new SimpleDateFormat("k:m:s");
				String result=format.format(new Date());
				System.out.println("当前的时间是："+result);
				if(flag){
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		new javax.swing.Timer(delay, new Printer()).start();
	}

}
