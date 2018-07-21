package edu.albany.hw5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class grepTest{
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		long startTime = System.nanoTime();
		
		File file = null;
		Scanner c = null;
		int count = 0;
		
		if (args.length != 2){
			System.err.println("Incorrect number of arguments.");
			System.exit(1);
		}

		try{
			file = new File(args[1]);
			c = new Scanner(file);
		}
		catch(FileNotFoundException e){
			if(!file.exists()){
				System.out.println("File does not exist.");
				System.exit(1);
			}
		}
		while (c.hasNextLine()){
			count++;
			c.nextLine();
		}
		c.close();
		
		int bc = (count + 2 - 1)/2;
		int ec = bc+1;
		
		grep x = new grep(file, args[0], 0, bc-1);
		grep y = new grep(file, args[0], ec - 1, count-1);
		x.start();
		x.join();
		y.start();
		y.join();
		
		System.out.println("Total Time, Parallel: " + (System.nanoTime() - startTime));
		System.out.println("");
		
		startTime = System.nanoTime();
		nonparallelGrep r = new nonparallelGrep();
		r.findWords(file, args[0]);
		System.out.println("Total Time, Non-Parallel: " + (System.nanoTime() - startTime));
		
	}
}