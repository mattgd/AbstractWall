package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GradientColor {
	
	static List<Color> colorChoices = new ArrayList<Color>();
	
	static Random rand = new Random();
	static int randomColor;
	static Color primaryColor, secondaryColor;
	
	public static GradientPaint generateGradient() {
		GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, generateColor(), (float) AbstractWall.windowWidth, (float) AbstractWall.windowHeight, generateColor(), true);
		return gradientPaint;
	}
	
	public static Color pickColorOne() {
	    randomColor = rand.nextInt(colorChoices.size());
		return colorChoices.get(randomColor);
	}
	
	public static Color pickColorTwo() {
		int randomSecondary = 0;

		if (randomColor == 0) {
			randomSecondary = rand.nextInt(2) - 1;
			
			if (randomSecondary == -1) {
				randomSecondary = colorChoices.size() - 1;
			}
			
		} else {
			randomSecondary = rand.nextInt(2) - 1;
			randomSecondary = randomColor + randomSecondary;
		}
		
		if (colorChoices.get(randomColor) == colorChoices.get(randomSecondary)) {
			pickColorTwo(); // Colors have to be a gradient
		}
		
		return colorChoices.get(randomSecondary);
	}
	
	// Adds all of the possible triangle color choices to a List
	public static void populateColorChoices() {
		colorChoices.add(Color.blue);
		colorChoices.add(Color.magenta);
		colorChoices.add(Color.pink);
		colorChoices.add(Color.red);
		colorChoices.add(Color.orange);
		colorChoices.add(Color.yellow);
		colorChoices.add(Color.green);
		colorChoices.add(Color.cyan);
	}
	
	static Color generateColor() {
		int red, green, blue = 0;
		red = rand.nextInt(256);
		green = rand.nextInt(256);
		blue = rand.nextInt(256);
		
		Color color = new Color(red, green, blue);
		
		return color;
	}
	
}

/* Gradient Rules
 * 
 * 1/6 turn of the color wheel
 * 
 * Color options: black, blue, cyan, dark_gray, gray, green, light_gray, magenta, orange, pink, red, white, yellow
 *
 * Gradient options:
 * 
 * blue > magenta
 * magenta > pink
 * pink > red
 * red > orange
 * orange > yellow
 * yellow > green
 * green > cyan
 * cyan > blue
 *
 */