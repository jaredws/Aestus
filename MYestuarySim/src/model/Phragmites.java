package model;

import java.awt.Dimension;

/**
 * The Class Phragmites, contains the location, size, growth state.
 * Handled by the Phragmites handler and ScreenControl.
 * @author Team 0
 */
public class Phragmites extends Grabbable {

	
	/** The x location. */
	private int x;
	
	/** The y location. */
	private int y;
	
	/** The size x. */
	public static int sizeX;
	
	/** The size y. */
	public static int sizeY;
	
	/** The life(growth) state. */
	private int life;
	
	/**
	 * Constructor 
	 * Instantiates a new phragmites with default values
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 * @param screenSize the screen size
	 */
	public Phragmites(int x, int y, Dimension screenSize){
		life = 0;
		this.x = x;
		this.y = y;
		
		Phragmites.sizeX = (int)screenSize.getWidth()/12-50;
		Phragmites.sizeY = ((int)screenSize.getWidth()/12*257/140);
		
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
		return Phragmites.sizeX;
	}
	
	/**
	 * Gets the size y.
	 *
	 * @return the size y
	 */
	public int getSizeY() {
		return Phragmites.sizeY;
	}
	
	/**
	 * Sets the size y.
	 *
	 * @param y the new size y
	 */
	public void setSizeY(int y) {
		Phragmites.sizeY = y;
	}
	
	/**
	 * Sets the size x.
	 *
	 * @param x the new size x
	 */
	public void setSizeX(int x) {
		Phragmites.sizeX = x;
	}
	
	/**
	 * Increases the growth state.
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
