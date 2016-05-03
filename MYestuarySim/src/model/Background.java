package model;


public class Background {
	private int sizeX;
	private int sizeY;
	
	public Background(int x, int y) {
		this.sizeX = x;
		this.sizeY = y;
	}
	
	public int check(int health){
		if(health < 15){
			return 2;
		}else if(health < 30){
			return 1;
		}else
			return 0;
		
	}
	
	public int getX() {
		return sizeX;
	}
	
	public int getY() {
		return sizeY;
	}
}
