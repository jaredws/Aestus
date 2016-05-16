package model;

import java.awt.Dimension;

/**
 * The Class BlueCrab.
 * Stores the location, size, and movement variables of a blue crab
 * @author Team 0
 */
public class BlueCrab extends Grabbable {
	
	/** The x location. */
	private int x;
	
	/** The y location. */
	private int y;
	
	/** The static size x. */
	public static int sizeX;
	
	/** The static size y. */
	public static int sizeY;
	
	/** The movement counter of the crab */
	public int move;
	
	/** The X dir. */
	public int XDir;
	
	/** The Y dir. */
	public int YDir;
	
	/**
	 * Constructor
	 * Instantiates a new blue crab.
	 *
	 * @param x the x position for placement
	 * @param y the y position for placement
	 * @param screenSize the screen size
	 */
	public BlueCrab(int x, int y,Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		BlueCrab.sizeX = (int)screenSize.getWidth()/12;
		BlueCrab.sizeY = sizeX*119/243;
		XDir = 0;
		YDir = 0;
    }
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the size x.
	 *
	 * @return the size x
	 */
	public int getSizeX() {
		return BlueCrab.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return BlueCrab.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		BlueCrab.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		BlueCrab.sizeX = x;
	}
	
	/**
	 * Gets the y dir.
	 *
	 * @return the y dir
	 */
	public int getYDir() {
		return this.YDir;
	}
	
	/**
	 * Gets the x dir.
	 *
	 * @return the x dir
	 */
	public int getXDir() {
		return this.XDir;
	}
	
	/**
	 * Sets the move.
	 *
	 * @param m the new move
	 */
	public void setMove(int m) {
		this.move = m;
	}
	
	/**
	 * Gets the move.
	 *
	 * @return the move
	 */
	public int getMove() {
		return this.move;
	}
	
	/**
	 * Moves blue crab fluidly.
	 *
	 * @param J the random number
	 * @param screenSize the screen size
	 */
	public void moveBlueCrab(int J,Dimension screenSize){
		if((move%7)==0){
			
			XDir = J%5 - J%2;
			YDir = J%4 + J%2;
		}
		if(x >= screenSize.getWidth() - 100){
			XDir = -3;
		}
		if(x - 100 <= 0 ){
			XDir = 3;
		}
		if(y >= screenSize.getHeight() - 100){
			YDir = -3;
		}
		if(y - 100 <= 0 ){
			YDir = 3;
		}
		move++;
		if(move > 40){
			setX(getX() + XDir);
			setY(getY() + YDir);
		}
	}
}
