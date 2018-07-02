package example300;

/*
 * 实例157 实现文件锁定功能
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;

public class EncryptInput {
	@SuppressWarnings("unused")
	public static void fileLock(String file){
		FileOutputStream fp=null;
		FileLock lock=null;
		try{
			fp=new FileOutputStream(file);
			lock=fp.getChannel().tryLock();
			Thread.sleep(60*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String file="/test1/012/test.txt";
		fileLock(file);

	}

}
