package thread;

public class ThreadSafeTest1 implements Runnable {
	int num=10;
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				if(num>0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"tickets num="+ num--);
				}else{
					break;
				}
			}
			
		}
		
	}
	
	private void doit(){
		synchronized (this) {
			System.out.println(00);
		}
		System.out.println(01);
	}
	
	public static void main(String[] args) {
		ThreadSafeTest1 t=new ThreadSafeTest1();
		Thread tA=new Thread(t,"tA");
		Thread tB=new Thread(t,"tB");
		Thread tC=new Thread(t,"tC");
		Thread tD=new Thread(t,"tD");
		tA.start();
		tB.start();
		tC.start();
		tD.start();

	}

}
