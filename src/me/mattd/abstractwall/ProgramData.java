package me.mattd.abstractwall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ProgramData {
	
	static String dataDirectory = System.getProperty("user.home") + "/Documents/AbstractWall/";
	static String imageDirectory;
	
	public static void getProgramDataDirectory() {
		BufferedReader br = null;
		 
		try {
 
			String currentLine;
			
			FileReader fr = new FileReader(dataDirectory + File.separator + "data.txt");
			br = new BufferedReader(fr);
			
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void setProgramDataDirectory(String directory) {
		File file = new File(directory);
		
		if (file.getParentFile().exists()) {
			dataDirectory = directory;
			
			file = new File(dataDirectory);
			if (!file.exists()) {
				PrintWriter writer;
				
				try {
					writer = new PrintWriter(directory, "UTF-8");
					writer.println("temporary-file-save-location=" + directory);
					writer.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
