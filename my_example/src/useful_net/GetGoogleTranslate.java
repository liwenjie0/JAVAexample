package useful_net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GetGoogleTranslate {
	static URL url;
	static HttpURLConnection con;
	
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		String word=scanner.nextLine();
		try {
			String words=new String(word.getBytes(), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			url=new URL("https://translate.google.cn/#en/zh-CN/"+word);
			con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setUseCaches(false);
			con.connect();
			InputStream inputStream=con.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
			System.out.println(reader.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
