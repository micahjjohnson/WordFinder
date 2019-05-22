import java.io.File;

public class FileFinder2 {
	
	public static void main(String[] args) {
		File startingDirectory = new File("/Users/micahjohnson/Documents");
		find(startingDirectory, ".java");
	}

	public static void find(File aFile, String extension) {
		if (aFile.isDirectory()) {
			for (File child : aFile.listFiles()) {
				find(child, extension);
			}
		} else {
			String fileName = aFile.toString();
			if (fileName.endsWith(extension)) {
				System.out.println(fileName);
			}
		}
	}
}