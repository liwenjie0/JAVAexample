import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class testxml {
	private static Document document;
	public static void main(String[] args) {
		String word="url";
		
		File xml_file=new File("src/example300/users.xml");	// 根据XML文件地址
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();	// 定义从XMl文档获取生成DOM对象的解析器
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();
			document=builder.parse(xml_file);	// 根据XML获取DOM文档实例
		}catch(Exception e){
			e.printStackTrace();
		}
		String subNodeTag=document.getElementsByTagName(word).item(0).getFirstChild().getNodeValue();
		System.out.println(document.getElementsByTagName(word).item(0).getTextContent());

	}

}
