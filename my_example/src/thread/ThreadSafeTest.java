package thread;
/*
 * ����߳�ͬʱ����numһ�����ݡ�ѭ����numִ�м�2����
 */
public class ThreadSafeTest implements Runnable {
	int num=10;
	String name;
	public ThreadSafeTest() {
		// TODO Auto-generated constructor stub
	}
	public ThreadSafeTest(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		while(true){
			if(num>0){
				try{
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("tickets num=" + num--);
			}else{
				System.out.println(" is exit");
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		ThreadSafeTest t=new ThreadSafeTest();
		Thread tA=new Thread(t);
		Thread tB=new Thread(t);
		Thread tC=new Thread(t);
		Thread tD=new Thread(t);
		tA.start();
		tB.start();
		tC.start();
		tD.start();
	}

}
