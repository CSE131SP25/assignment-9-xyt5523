package assignment9;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food f;
	private int direction;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.f = new Food();
		this.direction = 4;
	}
	
	public void play() {
		int currentDirection = 4;
		while (snake.isInbounds()) { 
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);    
	      if(dir != -1) {
	    	  snake.changeDirection(dir);
	      }
	      snake.move();
	      
	      if(snake.eatFood(f)) {
	    	  f = new Food();
	      }
	      updateDrawing();
		}
		StdDraw.setPenColor(10,10,10);
		StdDraw.text(0.1, 0.1, "Game Over!");
		System.out.println("Game over!");
		StdDraw.pause(2000); 
	    StdDraw.show();
	}
	
	
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		f.draw();
		
		  StdDraw.setPenColor(StdDraw.BLACK);
		  StdDraw.text(0.1, 0.95, "Score: " + snake.score()); 
	
		StdDraw.pause(50);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
