package example300;

/*
 * Àý064
 */
public class TypeChooser {
	public static ImageSaver getSaver(String type){
		if(type.equalsIgnoreCase("gif")){
			return new GIFSaver();
		}else if(type.equalsIgnoreCase("jpeg")){
			return new JPEGSaver();
		}else if(type.equalsIgnoreCase("png")){
			return new PNGSaver();
		}else{
			return null;
		}
		
	}
}
