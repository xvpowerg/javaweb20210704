package tw.com.tools;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadFile {
	
	public static void uploadFile(String filePath,
			String fileName,
			InputStream inputStr) throws IOException {
		Path targetPath =  Paths.get(filePath, fileName);
		Files.copy(inputStr, targetPath,
				StandardCopyOption.REPLACE_EXISTING);		
	}
	public static void uploadFile(Path targetPath,
			InputStream inputStr) throws IOException {
		Files.copy(inputStr, targetPath,
				StandardCopyOption.REPLACE_EXISTING);		
	}
}
