package model;

import java.awt.Dimension;


/**
 * The Class Health. Keeps track of the health of the estuary in game through stars
 * Each instantiation of this object is a star
 * @author Team 0
 */
public class Health {
	
	/** The x location . */
	private int x;
	
	/** The y location. */
	private int y;
	
	/** The size x. */
	public static int sizeX;
	
	/** The size y. */
	public static int sizeY;
	
	/** The move counter. */
	public int move;
	
	/** The X dir. */
	public int XDir;
	
	/** The Y dir. */
	public int YDir;
	
	/**
	 * Instantiates a new health with default values
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 * @param screenSize the screen size
	 */
	public Health(int x, int y,Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		Health.sizeX = (int)screenSize.getWidth()/12;
		Health.sizeY = sizeX*3/4;
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
		return Health.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return Health.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		Health.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		Health.sizeX = x;
	}
}
