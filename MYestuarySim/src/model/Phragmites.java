package model;

import java.awt.Dimension;

/**
 * 
 * @author Steven
 *
 */
public class Phragmites extends Grabbable {
	//With this outline, there's no difference between a crab and anyhting else. 
	//We'll have to change the name of this class to Interactable Object or something
	//Add a name and just name the different items
	
	private int x;
	private int y;
	//The sizes may need to be a ratio to the screen size. -JS
	//temporary public variables
	public static int sizeX;
	public static int sizeY;
	public int life;
	
	public Phragmites(int x, int y, Dimension screenSize){
		life = 0;
		this.x = x;
		this.y = y;
		Phragmites.sizeX = (int)screenSize.getWidth()/12;
		Phragmites.sizeY = sizeX*370/236;
		
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
		return Phragmites.sizeX;
	}
	
	public int getSizeY() {
		return Phragmites.sizeY;
	}
	
	public void setSizeY(int y) {
		Phragmites.sizeY = y;
	}
	
	public void setSizeX(int x) {
		Phragmites.sizeX = x;
	}
	public void live(){
		life++;
	}
}
