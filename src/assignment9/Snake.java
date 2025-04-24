package assignment9;

import java.util.LinkedList;

public class Snake{

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 0.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private int score;
	
	public Snake() {
		double startX = 0.5;
		double startY = 0.5;
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList <>(); 
		
		int initialLength = 5; 
		   for (int i = 0; i < initialLength; i++) {
		       segments.addFirst(new BodySegment(startX - i * SEGMENT_SIZE, startY, SEGMENT_SIZE));
		    }
		
		this.score = 0;
	}
	
	public int score() {
		return segments.size()-5;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		LinkedList<BodySegment> newSegments = new LinkedList<>();
		
		BodySegment head = segments.getFirst();
		double newX = head.getX() +deltaX;
		double newY = head.getY() +deltaY;
		
		newSegments.add(new BodySegment(newX,newY, SEGMENT_SIZE));
		// Add rest of the segments to previous segment
	    for (int i = 0; i < segments.size() - 1; i++) {
	        BodySegment prev = segments.get(i);
	        newSegments.add(new BodySegment(prev.getX(), prev.getY(), SEGMENT_SIZE));
	        this.score = 0;
	    }

	    segments = newSegments;
	}
	
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(BodySegment segment: segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		double dx = head.getX()- f.getX();
		double dy = head.getY()- f.getY();
		double distance = Math.sqrt(dx*dx+dy*dy);
		if( distance < SEGMENT_SIZE) {
			BodySegment newSegment = new BodySegment(head.getX(),head.getY(),SEGMENT_SIZE);
			segments.addFirst(newSegment);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		if(head.getX() >= 1 || head.getY()>= 1 || head.getX() <= 0 || head.getY() <= 0) {
			return false;
		}else {
			return true;
		}
		
	}
}
