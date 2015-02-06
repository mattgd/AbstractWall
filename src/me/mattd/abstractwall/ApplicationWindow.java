package me.mattd.abstractwall;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApplicationWindow {

	private JFrame frmAbstractwall;
	private JTextField heightTextField;
	private JTextField widthTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frmAbstractwall.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbstractwall = new JFrame();
		frmAbstractwall.setTitle("AbstractWall");
		frmAbstractwall.setBounds(100, 100, 337, 340);
		frmAbstractwall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbstractwall.getContentPane().setLayout(null);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(106, 35, 73, 20);
		frmAbstractwall.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel widthLabel = new JLabel("Wallpaper Width:");
		widthLabel.setBounds(10, 11, 83, 20);
		frmAbstractwall.getContentPane().add(widthLabel);
		
		JLabel heightLabel = new JLabel("Wallpaper Height:");
		heightLabel.setBounds(10, 35, 86, 20);
		frmAbstractwall.getContentPane().add(heightLabel);
		
		widthTextField = new JTextField();
		widthTextField.setBounds(106, 11, 73, 20);
		frmAbstractwall.getContentPane().add(widthTextField);
		widthTextField.setColumns(10);
		
		JLabel pixelsLabel1 = new JLabel("pixels");
		pixelsLabel1.setBounds(180, 14, 27, 14);
		frmAbstractwall.getContentPane().add(pixelsLabel1);
		
		JLabel pixelsLabel2 = new JLabel("pixels");
		pixelsLabel2.setBounds(180, 38, 27, 14);
		frmAbstractwall.getContentPane().add(pixelsLabel2);
		
		JButton createButton = new JButton("Create Wallpaper");
		createButton.setBounds(90, 66, 117, 23);
		frmAbstractwall.getContentPane().add(createButton);
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractWall.createImage();
			}
	    });
		
		
		JButton saveButton = new JButton("Save Wallpaper");
		saveButton.setBounds(193, 268, 117, 23);
		frmAbstractwall.getContentPane().add(saveButton);
		
		/*Canvas canvas = new Canvas();
		canvas.setBackground();
		canvas.setBounds(10, 95, 300, 169);
		canvas.
		
		frmAbstractwall.getContentPane().add(canvas);*/
	}
}
