package model;

import java.awt.Dimension;

/**
 * The Class Turtle. Contains the location, size, move magnitude and vector
 */
public class Turtle extends Grabbable {
	
	/** The x location. */
	private int x;
	
	/** The y location. */
	private int y;

	/** The size x of the Turtle. */
	public static int sizeX;
	
	/** The size y of the Turtle. */
	public static int sizeY;
	
	/** The move. */
	private int move;
	
	/** The X dir. */
	private int XDir;
	
	/** The Y dir. */
	private int YDir;
	
	/**
	 * Constructor
	 * Instantiates a new turtle with default values.
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 * @param screenSize the screen size
	 */
	public Turtle(int x, int y, Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		Turtle.sizeX = (int)screenSize.getWidth()/12;
		Turtle.sizeY = sizeX*392/648;
		XDir = 0;
		YDir = 0;
    }
	
	/**
	 * Gets the x location.
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x location.
	 * @param x the new x location
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y location.
	 * @return the y location
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y location.
	 * @param y the new y location
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the size x.
	 * @return the size x
	 */
	public int getSizeX() {
		return Turtle.sizeX;
	}
	
	/**
	 * Gets the size y.
	 * @return the size y
	 */
	public int getSizeY() {
		return Turtle.sizeY;
	}
	
	/**
	 * Gets the x dir.
	 * @return the x dir
	 */
	public int getXDir() {
		return this.XDir;
	}
	
	/**
	 * Gets the y dir.
	 * @return the y dir
	 */
	public int getYDir() {
		return this.YDir;
	}
	
	/**
	 * Gets the move magnitude.
	 * @return the move magnitude 
	 */
	public int getMove() {
		return this.move;
	}
	
	/**
	 * Sets the move magnitude.
	 * @param x the new move magnitude
	 */
	public void setMove(int x) {
		this.move = x;
	}
	
	/**
	 * Sets the size y.
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		Turtle.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		Turtle.sizeX = x;
	}
	
	/**
	 * Moves the turtle randomly inside the bounds of the screen.
	 *
	 * @param J - a random number
	 * @param screenSize the screen size
	 */
	public void moveTurtle(int J,Dimension screenSize){
		if((move%20)==0){
			XDir = J%3 - J%2;
			YDir = J%3 + J%2;
		}
		if(x >= screenSize.getWidth() - 100){
			XDir = -2;
		}
		if(x - 100 <= 0 ){
			XDir = 2;
		}
		if(y >= screenSize.getHeight() - 100){
			YDir = -2;
		}
		if(y - 100 <= 0 ){
			YDir = 2;
		}
		
		move++;
		if(move > 40){
		setX(getX() + XDir);
		setY(getY() + YDir);
		}
	}
}
