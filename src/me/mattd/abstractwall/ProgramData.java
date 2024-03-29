package me.mattd.abstractwall;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProgramData {
	
	static String dataDirectory = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "AbstractWall" + File.separator;
	
	// Get the current data directory from the configuration file
	public static void loadDataDirectory() {
		String directory = getProperty().getProperty("temporary-file-save-location"); 
		
		if (directory.length() != 0) {
			dataDirectory = directory;
		}
	}
	
	// Set the data directory
	public static void setProgramDataDirectory(String directory) {
		File setFile = new File(directory);
		
		if (setFile.exists()) {
			getProperty().setProperty("temporary-file-save-location", directory); // Set the data directory property
		} else {
			System.out.println("Invalid directory setting.");
		}
		
		dataDirectory = directory; // Set the global dataDirectory
	}
	
	// Load the program properties configuration
	public static Properties getProperty() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/data.cfg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
