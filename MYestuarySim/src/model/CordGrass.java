package model;

import java.awt.Dimension;

/**
 * 
 * @author Steven
 *
 */
public class CordGrass extends Grabbable {
	//With this outline, there's no difference between a crab and anyhting else. 
	//We'll have to change the name of this class to Interactable Object or something
	//Add a name and just name the different items
	
	private int x;
	private int y;
	//The sizes may need to be a ratio to the screen size. -JS
	//temporary public variables
	public static int sizeX;
	public static int sizeY;
	private int life;
	public CordGrass(int x, int y, Dimension screenSize){
		life = 0;
		this.x = x;
		this.y = y;
		CordGrass.sizeX = (int)screenSize.getWidth()/12;
		CordGrass.sizeY = sizeX*257/228;
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
		return CordGrass.sizeX;
	}
	
	public int getSizeY() {
		return CordGrass.sizeY;
	}
	
	public void setSizeY(int y) {
		CordGrass.sizeY = y;
	}
	
	public void setSizeX(int x) {
		CordGrass.sizeX = x;
	}
	public void live(){
		life++;
	}
	public int getLife() {
		return this.life;
	}
}
