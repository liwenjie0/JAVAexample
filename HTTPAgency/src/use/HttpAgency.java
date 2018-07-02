package use;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.ws.handler.MessageContext.Scope;

public class HttpAgency {

	public static void main(String[] args) {
		HttpAgency httpAgency=new HttpAgency();
		httpAgency.getServer();

	}
	

	private ServerSocket clientServer;
	private Socket socket;
		
	public HttpAgency(){
		
	}
	
	public void getServer(){
		try {
			clientServer=new ServerSocket(8089);
			while(true){
				socket=clientServer.accept();
				new ClientThread(socket).start();
				System.out.println("get a new socket");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
