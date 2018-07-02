package useful;

import java.io.File;
//递归删除同名文件夹
public class DeleteDirectory {

	public static void main(String[] args) {
		delete("E:\\新建文件夹\\awt\\awt");
		

	}
	
	private static void delete(String path){
		File myfile=new File(path);
		String[] s=myfile.list();
		//System.out.println(s[0]);
		if(s.length>0){
			delete(path+"\\awt");
		}else if(s.length==0){
			return;
		}
		File temp;
		if(path.endsWith(File.separator)){
			//如果要进行复制的文件夹是以系统默认的文件分隔符结尾
			temp=new File(path+s[0]);		//实例化文件对象
		}else{
			temp=new File(path+File.separator+s[0]);
		}
		temp.delete();
	}

}
