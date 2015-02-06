package me.mattd.abstractwall;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowComponents {
	
	public static List<Component> windowComponents = new ArrayList<Component>();
	
	// Create all of the GUI component objects
	public static void setupGUI(JPanel panel, GridBagConstraints c) {
		
		
		
		// Width inputs
		JLabel widthLabel = new JLabel();
		widthLabel.setText("Wallpaper Width: ");
		panel.add(widthLabel, c);
		
		JTextField widthField = new JTextField(20);
		
		// Height inputs
		JLabel heightLabel = new JLabel();
		heightLabel.setText("Wallpaper Height: ");
		
		JTextField heightField = new JTextField(20);
		
		
		// Buttons
		JButton createButton = new JButton();
		createButton.setText("Create Wallpaper");
		
		//TODO Fix last component not setting size
	}
	
}
