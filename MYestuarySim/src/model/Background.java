package model;


public class Background {
	private int sizeX;
	private int sizeY;
	
	public Background(int x, int y) {
		this.sizeX = x;
		this.sizeY = y;
	}
	
	public int check(int crabs){
		if(crabs < 9){
			return 2;
		}else if(crabs < 15){
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
