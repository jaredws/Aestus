package model;

import java.awt.Dimension;
import java.util.Random;

public class Crab extends Grabbable {
	//With this outline, there's no difference between a crab and anyhting else. 
	//We'll have to change the name of this class to Interactable Object or something
	//Add a name and just name the different items
	
	private int x;
	private int y;
	//The sizes may need to be a ratio to the screen size. -JS
	//temporary public variables
	public int sizeX;
	public int sizeY;
	public int move;
	public int XDir;
	public int YDir;
	
	public Crab(int x, int y){
		move = 0;
		this.x = x;
		this.y = y;
		this.sizeX = 165;
		this.sizeY = 165;
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
	
	public void moveCrab(int J,Dimension screenSize){
		if((move%5)==0){
			
			XDir = J%5 - J%7;
			YDir = J%5 + J%7;
		}
		if(x >= screenSize.getWidth() - 100){
			XDir = -10;
		}
		if(x - 100 <= 0 ){
			XDir = 10;
		}
		if(y >= screenSize.getHeight() - 100){
			YDir = -10;
		}
		if(y - 100 <= 0 ){
			YDir = 10;
		}
		
		move++;
		setX(getX() + XDir);
		setY(getY() + YDir);
	}
}
