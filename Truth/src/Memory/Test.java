package Memory;

import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date=new Date();
		long i1=System.currentTimeMillis();
		MemorialDay m=new MemorialDay();
		long i2=System.currentTimeMillis();
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
		System.out.println(m.getTotalday());
		
		MemorialDay m0=new MemorialDay(2017, 6, 19);
		System.out.println(m0.getTotalday());
		
	}

}
