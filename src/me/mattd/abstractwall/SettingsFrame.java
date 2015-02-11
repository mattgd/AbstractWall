package me.mattd.abstractwall;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SettingsFrame {
	public static void openSettings() {
		JFrame settingsFrame = new JFrame("Settings");
		settingsFrame.getContentPane().setLayout(null); // Absolute layout
		settingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		settingsFrame.setSize(428, 105);
		settingsFrame.setLocation(300, 300);
		
		JLabel versionLabel = new JLabel("Version: " + AbstractWall.version);
		versionLabel.setBounds(10, 10, 80, 20);
		settingsFrame.getContentPane().add(versionLabel);
		
		JLabel tempFileLabel = new JLabel("Files Directory:");
		tempFileLabel.setBounds(10, 35, 84, 20);
		settingsFrame.getContentPane().add(tempFileLabel);
		
		JTextField tempFileTextField = new JTextField();
		tempFileTextField.setBounds(103, 36, 300, 20);
		settingsFrame.getContentPane().add(tempFileTextField);
				
		settingsFrame.setVisible(true);
		settingsFrame.setAlwaysOnTop(true); // Show frame on top until the user closes it
	}
}
 