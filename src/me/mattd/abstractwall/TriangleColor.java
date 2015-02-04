package me.mattd.abstractwall;

import java.awt.Color;
import java.awt.GradientPaint;

public class TriangleColor {
	
	public static GradientPaint generateGradient() {
		GradientPaint gradientPaint = new GradientPaint(50.0f, 50.0f, Color.red, 75.0f, 75.0f, Color.green, true);
		return gradientPaint;
	}
	
}
