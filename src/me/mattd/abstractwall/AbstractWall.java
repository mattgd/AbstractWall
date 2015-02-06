package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
		frame = new JFrame();
		frame.setTitle("AbstractWall");
		frame.setBounds(100, 100, 379, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel widthLabel = new JLabel("Wallpaper Width:");
		widthLabel.setBounds(10, 11, 97, 20);
		frame.getContentPane().add(widthLabel);
		
		widthTextField = new JTextField();
		widthTextField.setBounds(113, 11, 73, 20);
		frame.getContentPane().add(widthTextField);
		widthTextField.setColumns(10);
		
		JLabel heightLabel = new JLabel("Wallpaper Height:");
		heightLabel.setBounds(10, 35, 100, 20);
		frame.getContentPane().add(heightLabel);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(113, 35, 73, 20);
		frame.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel pixelsLabel1 = new JLabel("pixels");
		pixelsLabel1.setBounds(187, 14, 34, 14);
		frame.getContentPane().add(pixelsLabel1);
		
		JLabel pixelsLabel2 = new JLabel("pixels");
		pixelsLabel2.setBounds(187, 38, 34, 14);
		frame.getContentPane().add(pixelsLabel2);
		
		JLabel descLabel = new JLabel("Wallpaper Preview");
		descLabel.setBounds(10, 70, 107, 14);
		frame.getContentPane().add(descLabel);
		
		JLabel borderLabel = new JLabel();
		borderLabel.setBounds(10, 90, 353, 180);
		frame.getContentPane().add(borderLabel);
		
		// Set the image border
		Border imageBorder = BorderFactory.createLineBorder(Color.black);
		borderLabel.setBorder(imageBorder);
		
		
		JButton createButton = new JButton("Create Wallpaper");
		createButton.setBounds(230, 20, 133, 23);
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
					imageLabel.setBounds(10, 90, 353, 180);
					
					frame.getContentPane().add(imageLabel);
					frame.revalidate();
					frame.repaint();
				}
			}
	    });
		
		JButton saveButton = new JButton("Save Wallpaper");
		saveButton.setBounds(230, 279, 133, 23);
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

}
