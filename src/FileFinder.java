import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileFinder {
	private File[] children;

	public FileFinder(File startingDirectory) {
		children = startingDirectory.listFiles();
	}

	public void find(String text) {
		for (File child : children) {
			String fileName = child.toString();
			//System.out.println(fileName);
			
			if (child.isDirectory()) {
				File[] innerChildren = child.listFiles();
				
				for (File innerChild : innerChildren) {
					try {
						searchFile(innerChild, text);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				try {
					searchFile(child, text);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
	}
	
	private void searchFile(File file, String searchText) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		
		while (in.hasNext()) {
			String word = in.next();				
			//System.out.println(word);
			
			if (word.equals(searchText)) { // later if wordIsFound()
				System.out.println(file.toString());
				in.close();
				return;
			}	
		}
		
		in.close();
	}

	/*
	public void find(String extension) {
		for (File child : children) {
			String fileName = child.toString();
			if (child.isDirectory()) {
				FileFinder finder = new FileFinder(child);
				finder.find(extension);
			} else if (fileName.endsWith(extension)) {
				System.out.println(fileName);
			}
		}
	}
	*/
}