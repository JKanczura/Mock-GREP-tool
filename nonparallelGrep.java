package edu.albany.hw5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class nonparallelGrep{
	
	
	public void findWords(File file, String word) {
		String x;
		Scanner sc = null;
		int i = 1;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sc.hasNext()) {
			i++;
			if ((x = sc.nextLine()).contains(word)) {
				System.out.println(i-1 + ": " + x);
			}
		}
	}
}