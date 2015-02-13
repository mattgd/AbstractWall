package me.mattd.abstractwall;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProgramData {
	
	static String dataDirectory = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "AbstractWall" + File.separator;
	
	public static void loadDataDirectory() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/data.cfg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String directory = prop.getProperty("temporary-file-save-location"); 
		
		if (directory.length() != 0) {
			dataDirectory = directory;
		}
	}
	
	public static void setProgramDataDirectory(String directory) {
		// Load the program properties configuration
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/data.cfg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File setFile = new File(directory);
		
		if (setFile.exists()) {
			prop.setProperty("temporary-file-save-location", directory); // Set the data directory property
		} else {
			System.out.println("Invalid directory setting.");
		}
		
		dataDirectory = directory; // Set the global dataDirectory
	}
}
