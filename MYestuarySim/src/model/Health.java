package model;

import java.awt.Dimension;

/**
 * 
 * @author Steven
 *
 */
public class Health {
	//With this outline, there's no difference between a crab and anyhting else. 
	//We'll have to change the name of this class to Interactable Object or something
	//Add a name and just name the different items
	
	private int x;
	private int y;
	//The sizes may need to be a ratio to the screen size. -JS
	//temporary public variables
	public static int sizeX;
	public static int sizeY;
	public int move;
	public int XDir;
	public int YDir;
	
	public Health(int x, int y,Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		this.sizeX = (int)screenSize.getWidth()/12;
		this.sizeY = sizeX*3/4;
		XDir = 0;
		YDir = 0;
    }
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	
	public void setSizeY(int y) {
		this.sizeY = y;
	}
	
	public void setSizeX(int x) {
		this.sizeX = x;
	}
}
