import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class TestJason {

	public static void main(String[] args) {
		try{
		URL url = new URL("https://raw.githubusercontent.com/liwenjie0/android-labs/master/app/src/main/java/edu/hzuapps/androidworks/homeworks/com1314080901221/Jasontext.txt");
        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(8000);
        //��ȡ������
        int responecode=httpURLConnection.getResponseCode();
        System.out.println("������Ϊ��"+"="+responecode);
        //�ж��Ƿ�����ɹ���200������ɹ�
        if(responecode==200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String responecontent=readInput(reader);
            System.out.println("��Ϣ��ȡ���"+"!!!!!!!!");
            System.out.println(responecontent);
        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
        private static String readInput(BufferedReader in ){
            String temp=null;
            try {
             temp = in.readLine();

            }catch (Exception e){

            }
            return temp;
        }
}
