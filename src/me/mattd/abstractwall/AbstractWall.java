package me.mattd.abstractwall;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Add maximum size
 * Add ability to set size
 * 
 * Radial gradient
 * Expand to all 16777216 color options
 * Temporary file, preview, save
 * Allow user to set wallpaper size
 */

//TODO Use LayoutManager

public class AbstractWall extends JApplet {
	
	private static final long serialVersionUID = 3890823863443284982L;
	static int windowHeight, borderHeight, windowWidth, borderWidth;
	
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
		
		f.setLayout(new GridLayout(3,2));
		f.add(new JButton("Create Wallpaper"));
		f.add(new JLabel("Wallpaper Width: "));
		f.add(new JTextField(20));
		f.add(new JLabel("Wallpaper Height: "));
		f.add(new JTextField(20));
		
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

}
