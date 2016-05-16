package model;

import java.awt.Dimension;



/**
 * The Class CordGrass. contains the location, size, growth tracker of the object.
 * @author Team 0
 */
public class CordGrass extends Grabbable {
	
	/** The x location. */
	private int x;
	
	/** The y location. */
	private int y;
	
	/** The size x. */
	public static int sizeX;
	
	/** The size y. */
	public static int sizeY;
	
	/** The life, tracks how large the object is. */
	private int life;
	
	/**
	 * Constructor
	 * Instantiates a new cord grass with default value for life
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 * @param screenSize the size of the screen
	 */
	public CordGrass(int x, int y, Dimension screenSize){
		life = 0;
		this.x = x;
		this.y = y;
		CordGrass.sizeX = (int)screenSize.getWidth()/12;
		CordGrass.sizeY = sizeX*257/228;
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
		return CordGrass.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return CordGrass.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		CordGrass.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		CordGrass.sizeX = x;
	}
	
	/**
	 * Live increases the size of the object
	 */
	public void live(){
		life++;
	}
	
	/**
	 * Gets the life.
	 *
	 * @return the life
	 */
	public int getLife() {
		return this.life;
	}
}
