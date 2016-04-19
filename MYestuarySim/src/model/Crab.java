package model;

public class Crab {
	//Needs a moving picture
	
	private int x;
	private int y;
	//The sizes may need to be a ratio to the screen size. -JS
	//temporary public variables
	public int sizeX;
	public int sizeY;
	
	public Crab(int x, int y){
		this.x = x;
		this.y = y;
		this.sizeX = 165;
		this.sizeY = 165;
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
	
}
