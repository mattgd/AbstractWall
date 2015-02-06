package me.mattd.abstractwall;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class AbstractWall extends JApplet {
	
	private static final long serialVersionUID = 3890823863443284982L;
	static int windowHeight, windowWidth;
	
	private JFrame frmAbstractwall;
	private JTextField heightTextField;
	private JTextField widthTextField;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractWall window = new AbstractWall();
					window.frmAbstractwall.setVisible(true);
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
		frmAbstractwall = new JFrame();
		frmAbstractwall.setTitle("AbstractWall");
		frmAbstractwall.setBounds(100, 100, 337, 340);
		frmAbstractwall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbstractwall.getContentPane().setLayout(null);
		
		JLabel widthLabel = new JLabel("Wallpaper Width:");
		widthLabel.setBounds(10, 11, 97, 20);
		frmAbstractwall.getContentPane().add(widthLabel);
		
		widthTextField = new JTextField();
		widthTextField.setBounds(113, 11, 73, 20);
		frmAbstractwall.getContentPane().add(widthTextField);
		widthTextField.setColumns(10);
		
		JLabel heightLabel = new JLabel("Wallpaper Height:");
		heightLabel.setBounds(10, 35, 100, 20);
		frmAbstractwall.getContentPane().add(heightLabel);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(113, 35, 73, 20);
		frmAbstractwall.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel pixelsLabel1 = new JLabel("pixels");
		pixelsLabel1.setBounds(187, 14, 34, 14);
		frmAbstractwall.getContentPane().add(pixelsLabel1);
		
		JLabel pixelsLabel2 = new JLabel("pixels");
		pixelsLabel2.setBounds(187, 38, 34, 14);
		frmAbstractwall.getContentPane().add(pixelsLabel2);
		
		JButton createButton = new JButton("Create Wallpaper");
		createButton.setBounds(90, 66, 133, 23);
		frmAbstractwall.getContentPane().add(createButton);
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageManager.createImage();
			}
	    });
		
		JButton saveButton = new JButton("Save Wallpaper");
		saveButton.setBounds(178, 268, 133, 23);
		frmAbstractwall.getContentPane().add(saveButton);
		
		
		
		/*Canvas canvas = new Canvas();
		canvas.setBackground();
		canvas.setBounds(10, 95, 300, 169);
		canvas.
		
		frmAbstractwall.getContentPane().add(canvas);*/
	}


	
	

}
