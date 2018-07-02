package my_example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Httprequest {

	public static void main(String[] args) {
		try {
			URL url=new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8c327a3e82a6d39c&secret=082ab94273b1ba2db5c1d49e07f74245");
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(8000);
			connection.setReadTimeout(8000);
			InputStream in=connection.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			System.out.println("接受成功");
			String s1=reader.readLine();
			System.out.println(s1);
			System.out.println(s1.length());;
			String token=s1.substring(17, 155);
			System.out.println(token);
			
			URL url1=new URL("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+token);
			HttpURLConnection connection1=(HttpURLConnection)url1.openConnection();
			connection1.setRequestMethod("GET");
			connection1.setConnectTimeout(8000);
			connection1.setReadTimeout(8000);
			InputStream in1=connection1.getInputStream();
			BufferedReader reader1=new BufferedReader(new InputStreamReader(in1));
			System.out.println("接受成功");
			System.out.println(reader1.readLine());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getaccess_token(){
		try{
		URL url=new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8c327a3e82a6d39c&secret=082ab94273b1ba2db5c1d49e07f74245");
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		InputStream in=connection.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		System.out.println("接受成功");
		String s1=reader.readLine();
		String token=s1.substring(17, 155);
		return token;
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
