
public class Startup {

	public static void main(String[] args) {
		System.out.println("Ready to start!");
		int i=0;
		do{
			System.out.println("This is the "+i+" time!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}while(i>6);
		
		System.out.println("Time to over");

	}

}
