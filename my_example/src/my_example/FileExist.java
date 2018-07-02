package my_example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i=0;
		File testfile=new File("E:\\test1\\aini");
		File oldfile=new File("E:\\KuGou\\Lyric");
		File newfile=new File("E:\\KuGou\\Temp");
		File[] s0=oldfile.listFiles();
		File[] s1=newfile.listFiles();
		long starttime=System.currentTimeMillis();
		//File[] temp=isExist(oldfile, newfile);
		long endtime=System.currentTimeMillis();
		System.out.println(s0.length*s1.length+"´Î");
		System.out.println(endtime-starttime);
		System.out.println(oldfile.getName());
		System.out.println(newfile.getName());
		
		checkfolder(testfile);
		
	}

	private static File[] isExist(File oldfile , File newfile){
		List<File> oldlist=new ArrayList<File>(Arrays.asList(oldfile.listFiles()));
		List<File> newlist=new ArrayList<File>(Arrays.asList(newfile.listFiles()));
		System.out.println(oldlist.size()+"::"+newlist.size());
		for(int i=0;i<oldlist.size();i++){
			for(int i1=0;i1<newlist.size();i1++){
				if(oldlist.get(i).getName().equals(newlist.get(i1).getName())){
					System.out.println(oldlist.get(i).getName());
					oldlist.remove(i);
					newlist.remove(i1);
				}
			}
		}
		System.out.println(oldlist.size()+"::"+newlist.size());
		return oldlist.toArray(new File[oldlist.size()]);
	}
	
	private static void checkfolder(File file){
		String[] s=file.list();
		for(String a : s){
			System.out.println(a);
		}
	}
}
