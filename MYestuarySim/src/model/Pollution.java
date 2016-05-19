package model;

import java.awt.Dimension;

/**
 * The Class Pollution. Contains the location, size, growth state, type.
 * Used by the PollutionHandler and ScreenControl where there are many instances of this object
 * @author Team 0
 */
public class Pollution extends Grabbable {

	/** The x location. */
	private int x;
	
	/** The y location. */
	private int y;
	
	/** The size x. */
	public static int sizeX;
	
	/** The size y. */
	public static int sizeY;
	
	/** The life(growth) state. */
	public int life;
	
	/** The type of the pollution, this allows the view to produce different images of trash. */
	public int type;
	
	
	
	/**
	 * Constructor
	 * Instantiates a new pollution with default attributes.
	 *
	 * @param x the x location for spawning
	 * @param y the y location for spawning
	 */
	public Pollution(int x, int y){
		this.x = x;
		this.y = y;
		Pollution.sizeX = 165;
		Pollution.sizeY = 165;
		type=0;
    }
	
	/**
	 * Constructor
	 * Instantiates a new pollution.
	 *
	 * @param x the x location for spawning
	 * @param y the y location for spawning
	 * @param screenSize the screen size
	 * @param type the type of pollution. Can be 0,1,2
	 */
	public Pollution(int x, int y, Dimension screenSize, int type){
		this.x = x;
		this.y = y;
		Pollution.sizeX = (int)screenSize.getWidth()/20;
		Pollution.sizeY = sizeX*138/182;
		this.type=type;
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
		return Pollution.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return Pollution.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		Pollution.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		Pollution.sizeX = x;
	}
	
	/**
	 * Gets the life.
	 *
	 * @return the life
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * Increases the growth state of the pollution
	 */
	public void live(){
		life++;
	}
}
