package use;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Testit {

	public static void main(String[] args) {
		System.out.println("OK");
		try {
			Socket socket=new Socket("192.168.2.31",8089);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//PrintWriter pw=new PrintWriter(socket.getOutputStream());
			bw.write("seng mo to you \n");		
			//bw.newLine();
			bw.flush();
			if(socket.isClosed()){
			System.out.println("is close");
			}
			if(socket.isClosed()){
				System.out.println("is close");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
