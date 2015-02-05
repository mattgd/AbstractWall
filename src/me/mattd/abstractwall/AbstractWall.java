package me.mattd.abstractwall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JApplet;
import javax.swing.JFrame;

/*
 * Add maximum size
 * Add ability to set size
 * 
 */

public class AbstractWall extends JApplet {
	
	private static final long serialVersionUID = 3890823863443284982L;
	
	static int windowHeight, borderHeight, windowWidth, borderWidth;

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		windowHeight = 800;
		borderHeight = 39;
		windowWidth = 800;
		borderWidth = 17;
		
		TriangleColor.populateColorChoices(); // Adds all of the possible triangle color choices to a List
		
		JFrame f = new JFrame("AbstractWall");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new AbstractWall();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		f.setSize(new Dimension(windowWidth + borderWidth, windowHeight + borderHeight));
		f.show();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

	    Polygon poly = new Polygon();
	    
	    int lastX = 0, lastY = 0;
	    
	    for (int yLine = 0; yLine < windowHeight; yLine += 100) {
	    	
	    	lastY = yLine;
	    	
	    	for (int xLine = 0; xLine < windowWidth; xLine += 100) {
		    	
		    	lastX = xLine;
		    	
		    	// Left side (bottom) triangle
		    	poly.addPoint(lastX, lastY);
	    		poly.addPoint(lastX, lastY + 100);
			    poly.addPoint(lastX + 100, lastY + 100);
			    
			    g2.setPaint(TriangleColor.generateGradient());
			    g2.fill(poly);
			    
			    g2.drawPolygon(poly);
			    
			    poly.reset();
			    
			    // Right side (top) triangle
		    	poly.addPoint(lastX, lastY);
	    		poly.addPoint(lastX + 100, lastY);
			    poly.addPoint(lastX + 100, lastY + 100);
			    
			    g2.setPaint(TriangleColor.generateGradient());
			    g2.fill(poly);
			    
			    g2.drawPolygon(poly); // Draw the triangle
			    
			    poly.reset(); // Reset the polygon

		    }
	    	
	    }
	    
	    
	    
    }

}

/*
 * for (int count = 0; count < windowWidth / 100; count++) {
	    	poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX, lastY + 100);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
	    }
	    
	    lastX = 0;
	    lastY = 0;
	    
	    for (int count = 0; count < windowWidth / 100; count++) {
	    	poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX + 100, lastY);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
	    }
	    
	    lastX = 100;
	    lastY = 0;
	    
	    for (int count = 0; count < windowWidth / 100; count++) {
	    	poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX, lastY + 100);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
	    }
	    
	    lastX = 100;
	    lastY = 0;
	    
	    for (int count = 0; count < windowWidth / 100; count++) {
	    	poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX + 100, lastY);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
	    }

	    poly.addPoint(0, 0);
	    poly.addPoint(100, 100);
	    poly.addPoint(0, 100);

	    g2.drawPolygon(poly);
	    
	    
	    // Left side / bottom triangle
	    	poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX, lastY + 100);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
	    	
		    
		    poly.addPoint(lastX, lastY);
		    poly.addPoint(lastX + 100, lastY + 100);
		    poly.addPoint(lastX + 100, lastY);
		    g2.drawPolygon(poly);
		    lastX += 100;
		    lastY += 100;
		    poly.reset();
 */
