package useful;

import java.io.File;
//�ݹ�ɾ��ͬ���ļ���
public class DeleteDirectory {

	public static void main(String[] args) {
		delete("E:\\�½��ļ���\\awt\\awt");
		

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
			//���Ҫ���и��Ƶ��ļ�������ϵͳĬ�ϵ��ļ��ָ�����β
			temp=new File(path+s[0]);		//ʵ�����ļ�����
		}else{
			temp=new File(path+File.separator+s[0]);
		}
		temp.delete();
	}

}
