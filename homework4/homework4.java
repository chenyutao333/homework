import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class homework4 {
	public static void copyFile(String source,String destination,String file) throws IOException{
		File s = new File(source+"/"+file);
		File d = new File(destination+"/"+file);
		try {
			Files.copy(s.toPath(), d.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("复制错误");
			e.printStackTrace();
		}
	}
	public static void main(String argv[]) throws IOException{
		copyFile("D:","C:/Users/33608/Desktop","test.txt");
		
	}
}

	