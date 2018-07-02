package Memory;

import java.util.Calendar;
import java.util.Date;

public class MemorialDay {
	private final int STARTYEAR=2014;
	private final int STARTMONTH=10;
	private final int STARTDAY=23;
	private final String STARTDATE="2014-10-23";
	private int total_day=0;	//存放总天数
	private int year_of_all=0,month_of_all=0,week_of_all=0;
	private boolean bissextile=false,tothesecond=false,samemonth=false;
	
	public MemorialDay(){
		Calendar calendar=Calendar.getInstance();	
		int nowyear=calendar.get(Calendar.YEAR);
		if(nowyear>2014){
		int nowmonth=calendar.get(Calendar.MONTH)+1;
		int nowday=calendar.get(Calendar.DAY_OF_MONTH);
		acculating(nowyear, nowmonth, nowday);
		}
		
	}
	
	public  MemorialDay(int nowyear,int nowmonth,int nowday){
		
		if(nowyear-STARTYEAR>=0){
			acculating(nowyear, nowmonth, nowday);
		}else if(nowyear-STARTYEAR==0){
			if(nowmonth-STARTMONTH>0){
				
			}else if(nowmonth-STARTMONTH==0){
				if(nowday-STARTDAY>=0){
					
				}
			}
		}
	}
	//获得天数
	public int getTotalday(){
		return total_day;
	}
	//获得年数
	public int getYear_of_all(){
		return year_of_all;
	}
	//获得月数
	public int getMonth_of_all(){
		return month_of_all;
	}
	//获得周数
	public int getWeek_of_all(){
		return week_of_all;
	}
	
	private void acculating(int nowyear,int nowmonth,int nowday){
		acculatingyear(nowyear);
		acculatingmonth(nowmonth);
		accultatingday(nowday);
		month_of_all=(int)total_day/30+1;
		week_of_all=(int)total_day/7+1;
	}
	
	private void acculatingyear(int nowyear){
		bissextile=isBissextile(nowyear);
		year_of_all=year_of_all+nowyear-STARTYEAR;
		if(((int)(year_of_all/4))>0){
			total_day+=365*4+1;
			total_day-=295;
		}else{
			int temp=year_of_all%4;
			switch(temp){
			case 0:				
				break;
			case 1:
				total_day+=365;
				break;
			case 2:
				total_day+=365*2;
				break;
			case 3:
				total_day+=365*3+1;
				break;
			default:
				break;
			}
			total_day-=295;
		}
		
	}
	
	private void acculatingmonth(int nowmonth){		
		if(year_of_all==0){
			int temp=nowmonth-STARTMONTH;
			switch(temp){
			case 0:
				samemonth=true;
				break;
			case 1:
				total_day+=9;
			case 2:
				total_day+=9+30;
				break;
			default:
				break;
			}
		}else{
			for(int i=1;i<nowmonth;i++){
				switch(i){
				case 1:
					total_day+=31;
					break;
				case 2:
					if(bissextile){
						total_day+=29;
					}else if(!bissextile){
						total_day+=28;
					}
					break;
				case 3:
					total_day+=31;
					break;
				case 4:
					total_day+=30;
					break;
				case 5:
					total_day+=31;
					break;
				case 6:
					total_day+=30;
					break;
				case 7:
					total_day+=31;
					break;
				case 8:
					total_day+=31;
					tothesecond=true;
					break;
				case 9:
					total_day+=30;
					break;
				case 10:
					total_day+=31;
					break;
				case 11:
					total_day+=30;
					break;
				default:
					break;
				}
			}
		}
		
	}
	
	private void accultatingday(int nowday){	
		if(samemonth){
			total_day+=nowday-STARTDAY;
		}else{
			total_day+=nowday;
			if(tothesecond){
				if(nowday>=23){
					year_of_all+=1;
				}
			}
		}
	}
	//判断当年是否为闰年
	private boolean isBissextile(int nowyear){
		if(nowyear%4==0){
			return true;
		}
		return false;
	}
	
	
}
