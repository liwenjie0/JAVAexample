import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class testxml {
	private static Document document;
	public static void main(String[] args) {
		String word="url";
		
		File xml_file=new File("src/example300/users.xml");	// ����XML�ļ���ַ
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();	// �����XMl�ĵ���ȡ����DOM����Ľ�����
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			document=builder.parse(xml_file);	// ����XML��ȡDOM�ĵ�ʵ��
		}catch(Exception e){
			e.printStackTrace();
		}
		String subNodeTag=document.getElementsByTagName(word).item(0).getFirstChild().getNodeValue();
		System.out.println(document.getElementsByTagName(word).item(0).getTextContent());

	}

}
