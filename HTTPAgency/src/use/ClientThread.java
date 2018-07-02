package use;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket socket;
	private InputStream clientInput;
	private OutputStream clientOutput;
	
	public ClientThread(Socket socket) {
		this.socket=socket;
		clientInput=null;
		clientOutput=null;
		
	}
	
	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			System.out.println(br.readLine());
			br.close();
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wake up");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("this thread is to the end!");
	}

}
