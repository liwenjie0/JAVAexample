package example300;

/*
 * 实例151 从XML文件中读取数据
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ReadXMLDataBase {
	private Document document;
	public String readXMl(String passWord){
		File xml_file=new File("src/example300/users.xml");	// 根据XML文件地址
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();	// 定义从XMl文档获取生成DOM对象的解析器，得到 DOM 解析器的工厂实例
		try{
			DocumentBuilder builder=factory.newDocumentBuilder();	//从 DOM 工厂获得 DOM 解析器
			document=builder.parse(xml_file);	// 根据XML获取DOM文档实例
			
		}catch(Exception e){
			e.printStackTrace();
		}
		String subNodeTag=document.getElementsByTagName(passWord).item(0).getFirstChild().getNodeValue();
		return subNodeTag;	// 返回读取的信息
	}
}
