import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FindFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose method of search");
		System.out.println("1 - Search through File");
		System.out.println("2 - Search through Directory");
		
		int method = sc.nextInt();
		
		switch (method) {
		case 1: findWordInFile();
		case 2: findWordInDirectory();
		}
		
		

	}
	
	private static void findWordInDirectory() {
		boolean wordFound = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What directory would you like to search?");
		String directory = sc.nextLine();
		
		System.out.println("Directory " + directory);
		
		System.out.println("Enter search word");	
		String search = sc.nextLine();
		
		FileFinder fileFinder = new FileFinder(new File(directory));
		fileFinder.find(search);
	}

	private static void findWordInFile() {
		boolean wordFound = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What file path would you like to search?");
		String filePath = sc.nextLine();
		
		System.out.println("File path " + filePath);
		
		System.out.println("Enter search word");	
		String search = sc.nextLine();
		
		try {
			Scanner in = new Scanner(new File(filePath));
			while (in.hasNext()) {
				String text = in.next();				
				
	            //System.out.println(text);
	            
				if (text.equals(search)) {
					System.out.println("Word was found!");
					wordFound = true;
					in.close();
					return;
				}	
			}
			
			if (!wordFound)
				System.out.println("Word not found in file.");
			
			in.close();
		} catch (IOException e) {
			System.out.println("File doesn't exist!");
			sc.close();
			return;
		}
		
		sc.close();
	}

}
