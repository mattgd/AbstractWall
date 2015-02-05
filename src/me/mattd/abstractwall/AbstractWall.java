package me.mattd.abstractwall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;
import javax.swing.JFrame;

/*
 * Add maximum size
 * Add ability to set size
 * 
 * Two color gradient
 * Increasing color gradient
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
		
		GradientColor.populateColorChoices(); // Adds all of the possible triangle color choices to a List
		
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

	    g2.drawRect(0, 0, windowWidth, windowHeight);
	    g2.setPaint(GradientColor.generateGradient());
	    g2.fillRect(0, 0, windowWidth, windowHeight);
    }

}
