package me.mattd.abstractwall;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowComponents {
	
	public static List<Component> windowComponents = new ArrayList<Component>();
	
	// Create all of the GUI component objects
	public static void setupGUI() {
		
		// Width inputs
		JLabel widthLabel = new JLabel();
		widthLabel.setText("Wallpaper Width: ");
		widthLabel.setSize(103, 13);
		widthLabel.setLocation(10, 15);
		windowComponents.add(widthLabel);
		
		JTextField widthField = new JTextField(20);
		widthField.setSize(50, 25);
		widthField.setLocation(110, 10);
		windowComponents.add(widthField);
		
		// Height inputs
		JLabel heightLabel = new JLabel();
		heightLabel.setText("Wallpaper Height: ");
		heightLabel.setSize(103, 13);
		heightLabel.setLocation(10, 45);
		windowComponents.add(heightLabel);
		
		JTextField heightField = new JTextField(20);
		heightField.setSize(50, 25);
		heightField.setLocation(110, 50);
		windowComponents.add(heightField);
		
		// Buttons
		JButton createButton = new JButton();
		createButton.setText("Create Wallpaper");
		createButton.setSize(103, 13);
		createButton.setLocation(10, 45);
		windowComponents.add(createButton);
		
		//TODO Fix last component not setting size
	}
	
}
