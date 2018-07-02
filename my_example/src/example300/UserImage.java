package example300;

/*
 * 实例064 策略模式的简单应用
 */
public class UserImage {

	public static void main(String[] args) {
		System.out.println("用户选择gif格式：");
		ImageSaver saver=TypeChooser.getSaver("gif");
		saver.save();
		System.out.println("用户选择jpeg格式");
		saver=TypeChooser.getSaver("jpeg");
		saver.save();
		System.out.println("用户选择png格式");
		saver=TypeChooser.getSaver("png");
		saver.save();
		

	}

}
