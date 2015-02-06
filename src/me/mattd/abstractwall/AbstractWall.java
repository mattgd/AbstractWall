package me.mattd.abstractwall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;

/*
 * Add maximum size
 * Add ability to set size
 * 
 * Radial gradient
 * Expand to all 16777216 color options
 * Temporary file, preview, save
 * Allow user to set wallpaper size
 */

public class AbstractWall extends JApplet {
	
	private static final long serialVersionUID = 3890823863443284982L;
	static int windowHeight, borderHeight, windowWidth, borderWidth, wallpaperWidth, wallpaperHeight;
	static int imageWidth = 600;
	static int imageHeight = 600;
	public static BufferedImage bImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
	
	public void init() {
        
    }

	public static void main(String args[]) {
		
		windowHeight = 800;
		borderHeight = 39;
		windowWidth = 800;
		borderWidth = 17;
		
		GradientColor.populateColorChoices(); // Adds all of the possible triangle color choices to a List
		
		JFrame f = new JFrame("AbstractWall");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new AbstractWall();
		f.getContentPane().add("Center", applet);
		applet.init();
		
		//WindowComponents.setupGUI(); // Create all of the GUI component objects
		
		f.pack();
		
		f.setSize(new Dimension(windowWidth, windowHeight));
		f.setVisible(true);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(0, 0, windowWidth, windowHeight);
		g2.setPaint(GradientColor.generateGradient());
		g2.fillRect(0, 0, windowWidth, windowHeight);
    }
	
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
