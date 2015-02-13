package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/*
 * Features to add:
 * Radial gradient
 * Set default save location
 * Clean up temporary files on close
 */

public class AbstractWall extends JApplet {
	
	private static final long serialVersionUID = 1L;
	static String version = "1.0.2";

	static int windowHeight, windowWidth;
	
	private JFrame frame;
	private ImageIcon imagePreview;
	private JTextField heightTextField;
	private JTextField widthTextField;
	private JLabel imageLabel;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractWall window = new AbstractWall();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public AbstractWall() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		ProgramData.loadDataDirectory(); // Load the location of the temporary data
		windowWidth = 379;
		windowHeight = 365;
		frame = new JFrame();
		frame.setTitle("AbstractWall");
		frame.setBounds(100, 100, windowWidth, windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// Create the menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, windowWidth, 25);
		
		// Build the Settings button on the menu
		JMenu menu = new JMenu("Settings");
		menu.setMnemonic(KeyEvent.VK_S); // Accessible by Alt-S
		menu.getAccessibleContext().setAccessibleDescription("Change program settings.");
		menuBar.add(menu);
		
		menu.addMenuListener(new MenuListener() {
	        @Override
	        public void menuSelected(MenuEvent e) {
	        	SettingsFrame.openSettings();
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {}

	        @Override
	        public void menuCanceled(MenuEvent e) {}
	    });
		
		frame.getContentPane().add(menuBar); // Add the menu bar to the frame
		
		JLabel widthLabel = new JLabel("Wallpaper Width:");
		widthLabel.setBounds(10, 36, 97, 20);
		frame.getContentPane().add(widthLabel);
		
		widthTextField = new JTextField();
		widthTextField.setBounds(113, 36, 73, 20);
		frame.getContentPane().add(widthTextField);
		widthTextField.setColumns(10);
		widthTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				checkWidthInput(widthTextField);
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkWidthInput(widthTextField);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkWidthInput(widthTextField);
			}
			
	    });
		
		JLabel heightLabel = new JLabel("Wallpaper Height:");
		heightLabel.setBounds(10, 60, 100, 20);
		frame.getContentPane().add(heightLabel);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(113, 60, 73, 20);
		frame.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		heightTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				checkHeightInput(heightTextField);
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkHeightInput(heightTextField);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkHeightInput(heightTextField);
			}
			
	    });
		
		JLabel pixelsLabel1 = new JLabel("pixels");
		pixelsLabel1.setBounds(187, 39, 34, 14);
		frame.getContentPane().add(pixelsLabel1);
		
		JLabel pixelsLabel2 = new JLabel("pixels");
		pixelsLabel2.setBounds(187, 63, 34, 14);
		frame.getContentPane().add(pixelsLabel2);
		
		JLabel descLabel = new JLabel("Wallpaper Preview");
		descLabel.setBounds(10, 95, 107, 14);
		frame.getContentPane().add(descLabel);
		
		JLabel borderLabel = new JLabel();
		borderLabel.setBounds(10, 115, 353, 180);
		frame.getContentPane().add(borderLabel);
		
		// Set the image border
		Border imageBorder = BorderFactory.createLineBorder(Color.black);
		borderLabel.setBorder(imageBorder);
		
		
		JButton createButton = new JButton("Create Wallpaper");
		createButton.setBounds(230, 45, 133, 23);
		frame.getContentPane().add(createButton);
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (imagePreview != null) {
					frame.getContentPane().remove(imageLabel);
				}
				
				ImageManager.saveImage(0, null);
				
				if (ImageManager.getImageLocation() != null) {
					
					imagePreview = new ImageIcon(ImageManager.getImageLocation());
					imageLabel = new JLabel(imagePreview);
					imageLabel.setBounds(10, 115, 353, 180);
					
					frame.getContentPane().add(imageLabel);
					frame.revalidate();
					frame.repaint();
				}
			}
	    });
		
		JButton saveButton = new JButton("Save Wallpaper");
		saveButton.setBounds(230, 304, 133, 23);
		frame.getContentPane().add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser() {
					
					private static final long serialVersionUID = 1L; // Required for "good practice"

					@Override
				    public void approveSelection() {
				        File file = getSelectedFile();
				        if (file.exists() && getDialogType() == SAVE_DIALOG) {
				            int result = JOptionPane.showConfirmDialog(this, "This file already exists. Would you like to overwrite it?", "Existing File", JOptionPane.YES_NO_CANCEL_OPTION);
				            switch (result) {
				                case JOptionPane.YES_OPTION:
				                    super.approveSelection();
				                    return;
				                case JOptionPane.NO_OPTION:
				                    return;
				                case JOptionPane.CLOSED_OPTION:
				                    return;
				                case JOptionPane.CANCEL_OPTION:
				                    cancelSelection();
				                    return;
				            }
				        }
				        super.approveSelection();
				    } 
				};
				
				chooser.addChoosableFileFilter(new OpenFileFilter("png", "PNG image"));
				
				int returnVal = chooser.showSaveDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					ImageManager.saveImage(1, chooser.getSelectedFile().getPath());
				}
				
			}
	    });
		
		
	}
		
	// TODO Re-factor input checks
	public static void checkWidthInput(JTextField widthTextField) {
		
		if (widthTextField.getText() != "") {
			
			// Try/Catch for user input
			try {
				int width = Integer.parseInt(widthTextField.getText());
				if (width <= 10000) {
					ImageManager.imageWidth = Integer.parseInt(widthTextField.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Wallpaper width must be less than 10000 pixels.");
				}
			} catch(NumberFormatException e) {
				System.out.println("Input is not an integer.");
			}
			
		}
		
	}
	
	public static void checkHeightInput(JTextField heightTextField) {
		
		if (heightTextField.getText() != "") {
			
			// Try/Catch for user input
			try {
				int height = Integer.parseInt(heightTextField.getText());
				if (height <= 10000) {
					ImageManager.imageHeight = Integer.parseInt(heightTextField.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Wallpaper height must be less than 10000 pixels.");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Input is not an integer.");
			}
			
		}
		
	}

}
