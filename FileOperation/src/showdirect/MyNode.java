package showdirect;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode {
	private boolean explored=false;
	
	public MyNode(File file){
		setUserObject(file);	//���˽ڵ���û���������Ϊfile
	}
	
	public boolean getAllowChildren(){	//����˽ڵ�ӵ���ӽڵ㣬�򷵻�true
		return isDirectory();	
	}
	public boolean isLeaf(){	//����˽ڵ㲻ӵ���ӽڵ㣬�򷵻�true
		return !isDirectory();
	}
	public File getFile(){
		return (File)getUserObject();
	}
	public boolean isExplored(){
		return explored;
	}
	public String toString(){	//��ȡ�ļ�������
		File file=getFile();
		String filename=file.toString();
		int index=filename.lastIndexOf("\\");
		return (index!=-1&&index!=filename.length()-1)?filename.substring(index+1):filename;
	}
	public String getString(){
		File file=getFile();
		String filename=file.getAbsolutePath();
		return filename;
	}
	public void explore(){
		if(!isDirectory()){
			return;
		}
		if(!isExplored()){
			File file=getFile();
			File[] children=file.listFiles();
			for(int i=0;i<children.length;++i){
				if(children[i].isDirectory()){
					//���丸�ڵ��Ƴ�children����ͨ��������ӵ��˽ڵ��������Ľ�β��ʹ���Ϊ�˽ڵ���ӽڵ�
					add(new MyNode(children[i]));
				}
			}
			explored=true;
		}
	}
	
	
	protected boolean isDirectory(){	//�ж��ļ��Ƿ���һ��·��
		File file=getFile();
		return file.isDirectory();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
