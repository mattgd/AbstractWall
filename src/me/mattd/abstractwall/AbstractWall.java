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

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		JFrame f = new JFrame("AbstractWall");
       
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new AbstractWall();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		f.setSize(new Dimension(800, 600));
		f.show();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

	    Polygon poly = new Polygon();

	    poly.addPoint(150, 150);
	    poly.addPoint(250, 100);
	    poly.addPoint(325, 125);

	    g2.drawPolygon(poly);
		
    }

}
