package example300;

/*
 * ʵ��064 ����ģʽ�ļ�Ӧ��
 */
public class UserImage {

	public static void main(String[] args) {
		System.out.println("�û�ѡ��gif��ʽ��");
		ImageSaver saver=TypeChooser.getSaver("gif");
		saver.save();
		System.out.println("�û�ѡ��jpeg��ʽ");
		saver=TypeChooser.getSaver("jpeg");
		saver.save();
		System.out.println("�û�ѡ��png��ʽ");
		saver=TypeChooser.getSaver("png");
		saver.save();
		

	}

}
