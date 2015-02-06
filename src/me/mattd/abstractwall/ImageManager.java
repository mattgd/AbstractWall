package me.mattd.abstractwall;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager {

	static int imageWidth = 600;
	static int imageHeight = 600;
	public static BufferedImage bImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
	
	public static void createImage() {
		Graphics2D g2;
		g2 = bImage.createGraphics();
		g2.drawRect(0, 0, imageWidth, imageHeight);
		g2.setPaint(GradientColor.generateGradient());
		g2.fillRect(0, 0, imageWidth, imageHeight);
		//g2.dispose();
		saveTemporaryImage();
	}
	
	public static void saveTemporaryImage() {
		String imagesDirectory = System.getProperty("user.home");
		imagesDirectory = imagesDirectory + "/Pictures/AbstractWall/";
		String fileName = "abstractwall_" + System.currentTimeMillis() + ".png";
		
		try {
		    File outputfile = new File(imagesDirectory + fileName);
		    
		    if (!outputfile.exists()) {
		    	outputfile.mkdirs();
		    }
		    
		    ImageIO.write(bImage, "png", outputfile);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
