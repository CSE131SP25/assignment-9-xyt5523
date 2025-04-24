package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = ColorUtils.getRandomColor();
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double setX(int x){
		return x;
	}
	
	public double getSize(){
		return size;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		double centerX = x+size/2.0;
		double centerY = y+size/2.0;
		StdDraw.filledCircle(centerX, centerY, size);
	}
	
}
