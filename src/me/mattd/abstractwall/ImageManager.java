package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageManager {

	static int imageWidth = 600;
	static int imageHeight = 600;
	static String imageLocation;
	static BufferedImage gradient;
	static File temporaryFile;
	
	public static void saveImage(int type, String filePath) {
		
		String imagesDirectory = ProgramData.dataDirectory;
		
		if (filePath == null) {
			filePath = "abstractwall_" + System.currentTimeMillis() + ".png";
			imageLocation = imagesDirectory + filePath;
		} else {
			imageLocation = filePath;
		}
		
		try {
		    File outputfile = new File(imageLocation);
		    
		    if (!outputfile.exists()) {
		    	outputfile.mkdirs();
		    }
		    
		    if (type == 0) {
		    	ImageIO.write(createGradientImage(), "png", outputfile);
		    	temporaryFile = new File(outputfile.getPath()); // Set the location of the temporary file
		    } else {
		    	ImageIO.write(gradient, "png", outputfile);
		    	
		    	// Deletes the temporary gradient image if it exists
		    	if (temporaryFile.exists()) {
		    		temporaryFile.delete();
		    	}
		    }
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	 public static BufferedImage createGradientImage() {
		 gradient = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		 
		 // Set the image paint to the gradient
		 Graphics2D g = gradient.createGraphics();
		 GradientPaint paint = new GradientPaint(0.0f, 0.0f, generateColor(), imageWidth, imageHeight, generateColor()); // "imageWidth, imageHeight" are orientation values
		 g.setPaint(paint);
		 g.fill(new Rectangle2D.Double(0, 0, imageWidth, imageHeight));
		 
		 // Clear the graphic and image
		 g.dispose();
		 gradient.flush();

		 return gradient;
	 }
	 
	 // Generates a random RGB value
	 static Color generateColor() {
		 Random rand = new Random();
		 int red, green, blue = 0;
		 red = rand.nextInt(256);
		 green = rand.nextInt(256);
		 blue = rand.nextInt(256);
		 Color color = new Color(red, green, blue);
		 return color;
	 }
	 
	 static String getImageLocation() {
		 return imageLocation;
	 }
}
