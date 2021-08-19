package tw.com.web.tools;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
	private static String image_path = "";  
	
	public static void setImagePath(String path) {
		image_path = path;
	}
	public static String getImagePath() {
		return image_path;
	}
	
	public static Path getImageIOPath() {
		return Paths.get(image_path);
	}
}
