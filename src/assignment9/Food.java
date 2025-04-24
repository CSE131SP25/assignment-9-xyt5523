package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
        x = Math.random() * (1.0 - 2 * FOOD_SIZE) + FOOD_SIZE;
        y = Math.random() * (1.0 - 2 * FOOD_SIZE) + FOOD_SIZE;
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
		return FOOD_SIZE;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor();
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
}
