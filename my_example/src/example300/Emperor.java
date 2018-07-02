package example300;

/*
 * 实例046 单例模式的应用
 * 单例模式的特点在于仅能获得一个对象。
 */
public class Emperor {
	private static Emperor emperor=null;
	private Emperor(){	}
	public static Emperor getInstance(){
		if(emperor==null){
			emperor=new Emperor();
		}
		return emperor;
	}
	public void getName(){
		System.out.println("我是皇帝：迪玛西亚");
	}
	
}
