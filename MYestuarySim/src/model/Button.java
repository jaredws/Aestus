package model;


public class Button {
	int x;
	int y;
	int type;
	int sizeX;
	int sizeY;

	public Button(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.sizeX = 100;
		this.sizeY = 100;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getType() {
		return type;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
	
}
