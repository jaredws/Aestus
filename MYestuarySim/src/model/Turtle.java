package model;

import java.awt.Dimension;

/**
 * @author Steven
 */
public class Turtle extends Grabbable {
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
	
	public Turtle(int x, int y, Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		Turtle.sizeX = (int)screenSize.getWidth()/12;
		Turtle.sizeY = sizeX*392/648;
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
		return Turtle.sizeX;
	}
	
	public int getSizeY() {
		return Turtle.sizeY;
	}
	
	public void setSizeY(int y) {
		Turtle.sizeY = y;
	}
	
	public void setSizeX(int x) {
		Turtle.sizeX = x;
	}
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
