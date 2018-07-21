package edu.albany.hw5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class grep extends Thread{
	
	private File myFile;
	private String toFind;
	private int beginCount = 0;
	private int endCount = 0;
	
	public grep(File file, String x, int bc, int ec){
		myFile = file;
		toFind = x;
		beginCount = bc;
		endCount = ec;
	}

	@Override
	public void run() {
			int i = 0;
			String x; 
			BufferedReader sc = null; 
		
			try {
				sc = new BufferedReader(new FileReader(myFile));
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				System.exit(1);
			}
			
			try {
				while((x = sc.readLine()) != null){
					if (i >= beginCount && i <= endCount){
						if(x.contains(toFind)){
							System.out.println(i + 1 + ": " + x);
						}
					}
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getToFind() {
		return toFind;
	}

	public void setToFind(String toFind) {
		this.toFind = toFind;
	}
	
}