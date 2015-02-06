package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.GradientPaint;
import java.util.Random;

public class GradientColor {
	
	static Random rand = new Random();
	static Color primaryColor, secondaryColor;
	
	public static GradientPaint generateGradient() {
		GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, generateColor(), (float) AbstractWall.windowWidth, (float) AbstractWall.windowHeight, generateColor(), true);
		return gradientPaint;
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