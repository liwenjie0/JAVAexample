package useful_net;

import java.io.*;
import java.net.*;

public class SendMessagetoWeChat {
	private static String token;
	private static String id="wx8c327a3e82a6d39c";
	private static String sercet="082ab94273b1ba2db5c1d49e07f74245";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			URL url=new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx1a1531ba312f34d0&secret=cb12c83dcef984692f8c771535eb9132");
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			InputStream in=connection.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			System.out.println("接受成功");
			String s1=reader.readLine();
			System.out.println(s1);
			System.out.println(s1.length());;
			token=s1.substring(17, 155);
			System.out.println(token);
			connection.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			URL url1=new URL("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+token);
			HttpURLConnection connection1=(HttpURLConnection)url1.openConnection();			
			connection1.setDoOutput(true);
			connection1.setDoInput(true);
			connection1.setConnectTimeout(5000);
			connection1.setReadTimeout(5000);
			connection1.setRequestMethod("POST");
			
			String s2="{\"filter\":{\"is_to_all\":true,\"group_id\":\"\"},\"text\":{\"content\":\"stupid\"},\"msgtype\":\"text\"}";
			System.out.println(s2);
			OutputStream out=connection1.getOutputStream();
			BufferedWriter sender=new BufferedWriter(new OutputStreamWriter(out));
			sender.write(s2);
			sender.flush();
			sender.close();
			
			InputStream in1=connection1.getInputStream();
			BufferedReader reader1=new BufferedReader(new InputStreamReader(in1));
			String s3=reader1.readLine();
			System.out.println(s3);
			
			connection1.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
