package example300;

/*
 * ʵ��069 ��̬�ڲ���ļ�Ӧ��
 */
public class TestMaxMin {

	public static void main(String[] args) {
		double[] array=new double[5];
		for(int i=0;i<array.length;i++){
			array[i]=100*Math.random();
		}
		System.out.println("Դ���飺");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("���ֵ��"+MaxMin.getResult(array).getMax());
		System.out.println("��Сֵ��"+MaxMin.getResult(array).getMin());
	}

}
