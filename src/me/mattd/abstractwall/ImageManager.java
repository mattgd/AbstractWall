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
	public static BufferedImage bImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
	
	public static void saveTemporaryImage() {
		String imagesDirectory = System.getProperty("user.home");
		imagesDirectory = imagesDirectory + "/Pictures/AbstractWall/";
		String fileName = "abstractwall_" + System.currentTimeMillis() + ".png";
		
		try {
		    File outputfile = new File(imagesDirectory + fileName);
		    
		    if (!outputfile.exists()) {
		    	outputfile.mkdirs();
		    }
		    
		    ImageIO.write(createGradientImage(), "png", outputfile);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	 public static BufferedImage createGradientImage() {
		 BufferedImage gradient = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g = gradient.createGraphics();
		 GradientPaint paint = new GradientPaint(0.0f, 0.0f, generateColor(), imageWidth, imageHeight, generateColor()); // "imageWidth, imageHeight" are orientation values
		 g.setPaint(paint);
		 g.fill(new Rectangle2D.Double(0, 0, imageWidth, imageHeight));

		 g.dispose();
		 gradient.flush();

		 return gradient;
	 }
	 
	 static Color generateColor() {
		 Random rand = new Random();
		 int red, green, blue = 0;
		 red = rand.nextInt(256);
		 green = rand.nextInt(256);
		 blue = rand.nextInt(256);
			
		 Color color = new Color(red, green, blue);
			
		 System.out.println("Red: " + color.getRed() + "\nGreen: " + color.getGreen() + "\nBlue: " + color.getBlue());
			
		 return color;
	 }
	
}


/* Gradient Rules
 * 
 * 1/6 turn of the color wheel
 * 
 * Color options: black, blue, cyan, dark_gray, gray, green, light_gray, magenta, orange, pink, red, white, yellow
 *
 * Gradient options:
 * 
 * blue > magenta
 * magenta > pink
 * pink > red
 * red > orange
 * orange > yellow
 * yellow > green
 * green > cyan
 * cyan > blue
 *
 */
