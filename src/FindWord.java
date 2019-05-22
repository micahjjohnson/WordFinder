import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class FindWord {
	
	private static String filePath;
	
	private static int occurrences;
	private boolean matchCase;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Would you like to type directory or search?");
		System.out.println("1 - type");
		System.out.println("2 - Search with file chooser");
		
		int method = sc.nextInt();
		
		switch (method) {
		case 1: getUserInput();
		case 2: openFileChooser();
		}
		
		Scanner scs = new Scanner(System.in);
		System.out.println("Enter search word");	
		String search = scs.nextLine();
		
		findWordInFile(new File(filePath), search);
		
		System.out.println("Occurrences: " + occurrences);
	}
	
	private static void getUserInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type full directory:");
		
		String filePath = sc.nextLine();
		System.out.println(filePath);
	}
	
	private static void openFileChooser() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) 
		{
			filePath = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(filePath);
		}
	}
	/*
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
	*/

	public static void findWordInFile(File file, String phrase) {
		boolean wordFound = false;
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String text = in.next();				
				
	            //System.out.println(text);
	            
				if (text.equals(phrase)) {
					++occurrences;
					wordFound = true;
					///in.close();
					//return;
				}	
			}
			
			if (!wordFound)
				System.out.println("Word not found in file.");
			
			in.close();
		} catch (IOException e) {
			System.out.println("File doesn't exist!");
			return;
		}
	}

}
