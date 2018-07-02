package showdirect;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode {
	private boolean explored=false;
	
	public MyNode(File file){
		setUserObject(file);	//将此节点的用户对象设置为file
	}
	
	public boolean getAllowChildren(){	//如果此节点拥有子节点，则返回true
		return isDirectory();	
	}
	public boolean isLeaf(){	//如果此节点不拥有子节点，则返回true
		return !isDirectory();
	}
	public File getFile(){
		return (File)getUserObject();
	}
	public boolean isExplored(){
		return explored;
	}
	public String toString(){	//获取文件夹名称
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
					//从其父节点移除children，并通过将其添加到此节点的子数组的结尾，使其成为此节点的子节点
					add(new MyNode(children[i]));
				}
			}
			explored=true;
		}
	}
	
	
	protected boolean isDirectory(){	//判断文件是否是一个路径
		File file=getFile();
		return file.isDirectory();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
