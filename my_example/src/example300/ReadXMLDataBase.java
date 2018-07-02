package example300;

/*
 * ʵ��151 ��XML�ļ��ж�ȡ����
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ReadXMLDataBase {
	private Document document;
	public String readXMl(String passWord){
		File xml_file=new File("src/example300/users.xml");	// ����XML�ļ���ַ
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();	// �����XMl�ĵ���ȡ����DOM����Ľ��������õ� DOM �������Ĺ���ʵ��
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();	//�� DOM ������� DOM ������
			document=builder.parse(xml_file);	// ����XML��ȡDOM�ĵ�ʵ��
			
		}catch(Exception e){
			e.printStackTrace();
		}
		String subNodeTag=document.getElementsByTagName(passWord).item(0).getFirstChild().getNodeValue();
		return subNodeTag;	// ���ض�ȡ����Ϣ
	}
}
