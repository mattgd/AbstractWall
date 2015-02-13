package me.mattd.abstractwall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SettingsFrame {
	public static void openSettings() {
		JFrame settingsFrame = new JFrame("Settings");
		settingsFrame.getContentPane().setLayout(null); // Absolute layout
		settingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		settingsFrame.setSize(428, 125);
		settingsFrame.setLocation(300, 300);
		
		JLabel versionLabel = new JLabel("Version: " + AbstractWall.version);
		versionLabel.setBounds(10, 10, 80, 20);
		settingsFrame.getContentPane().add(versionLabel);
		
		JLabel tempFileLabel = new JLabel("Files Directory:");
		tempFileLabel.setBounds(10, 35, 84, 20);
		settingsFrame.getContentPane().add(tempFileLabel);
		
		final JTextField tempFileTextField = new JTextField(ProgramData.dataDirectory); //TODO Does not set text.
		tempFileTextField.setBounds(103, 36, 300, 20);
		settingsFrame.repaint();
		settingsFrame.getContentPane().add(tempFileTextField);
		
		JButton saveButton = new JButton("Save Settings");
		saveButton.setBounds(289, 60, 112, 20);
		settingsFrame.getContentPane().add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String directory = tempFileTextField.getText();
				ProgramData.setProgramDataDirectory(directory); // Set the data directory
			}
		});
		
		settingsFrame.setVisible(true);
		settingsFrame.setAlwaysOnTop(true); // Show frame on top until the user closes it
	}
}
 