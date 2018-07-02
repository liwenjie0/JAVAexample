import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML0 {
	private static String URL0="http://192.168.0.103:8080/teststruts/";
	private static String URL1="https://123.sogou.com/";
	private static String URL2="http://www.baidu.com";
	
	public static void main(String[] args) {
		try {	
			URL url=new URL(URL0);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();	
			connection.setReadTimeout(5000);
			InputStream in=connection.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in,"utf-8"));
			System.out.println("接受成功！");
			/*for(int i=0;i<5;i++){
				System.out.println(reader.readLine());
			}*/
			String strt=getString(reader);
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			org.w3c.dom.Document dou=builder.parse(in);
			
			
			connection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String getString(BufferedReader reader){
		StringBuilder sb=new StringBuilder();
		int len;
		try {
			char[] c =new char[1024];
			len=reader.read(c);
			while(len!=-1){
				sb.append(c, 0, len);
				//System.out.println(c);
				len=reader.read(c);
			}
			System.out.println(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
