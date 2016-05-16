package model;

import java.awt.Dimension;


/**
 * The Class Crab. Stores the location, size, direction, velocity, and functionality for movement.
 * @author Team 0
 */
public class Crab extends Grabbable {
	
	/** The x location. */
	private int x;
	
	/** The y location . */
	private int y;
	
	/** The size x. */
	public static int sizeX;
	
	/** The size y. */
	public static int sizeY;
	
	/** The move counter. */
	public int move;
	
	/** The X dir of the crab. */
	public int XDir;
	
	/** The Y dir of the crab. */
	public int YDir;
	
	/**
	 * Constructor
	 * Instantiates a new crab with default values
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 * @param screenSize the screen size
	 */
	public Crab(int x, int y,Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		Crab.sizeX = (int)screenSize.getWidth()/12;
		Crab.sizeY = sizeX*124/254;
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
	 * Gets the x dir.
	 *
	 * @return the x dir
	 */
	public int getXDir() {
		return this.XDir;
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
	 * Gets the size x.
	 *
	 * @return the size x
	 */
	public int getSizeX() {
		return Crab.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return Crab.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		Crab.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		Crab.sizeX = x;
	}
	
	/**
	 * Sets the move.
	 *
	 * @param x the new move
	 */
	public void setMove(int x) {
		this.move = x;
	}
	
	/**
	 * Move crab.
	 *
	 * @param J the j
	 * @param screenSize the screen size
	 */
	public void moveCrab(int J,Dimension screenSize){
		if((move%8)==0){
			
			XDir = J%6 - J%2;
			YDir = J%2 + J%1;
		}
		if(x >= screenSize.getWidth() - 100){
			XDir = -4;
		}
		if(x - 100 <= 0 ){
			XDir = 4;
		}
		if(y >= screenSize.getHeight() - 100){
			YDir = -1;
		}
		if(y - 100 <= 0 ){
			YDir = 1;
		}
		
		move++;
		if(move > 40){
			setX(getX() + XDir);
			setY(getY() + YDir);
			}
	}
}
