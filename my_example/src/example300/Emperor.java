package example300;

/*
 * ʵ��046 ����ģʽ��Ӧ��
 * ����ģʽ���ص����ڽ��ܻ��һ������
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
		System.out.println("���ǻʵۣ���������");
	}
	
}
