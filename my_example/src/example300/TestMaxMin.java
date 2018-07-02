package example300;

/*
 * 实例069 静态内部类的简单应用
 */
public class TestMaxMin {

	public static void main(String[] args) {
		double[] array=new double[5];
		for(int i=0;i<array.length;i++){
			array[i]=100*Math.random();
		}
		System.out.println("源数组：");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("最大值："+MaxMin.getResult(array).getMax());
		System.out.println("最小值："+MaxMin.getResult(array).getMin());
	}

}
