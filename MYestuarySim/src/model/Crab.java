package model;

import java.awt.Dimension;

public class Crab extends Grabbable {
	
	private int x;
	private int y;
	public static int sizeX;
	public static int sizeY;
	public int move;
	public int XDir;
	public int YDir;
	
	public Crab(int x, int y,Dimension screenSize){
		move = 0;
		this.x = x;
		this.y = y;
		Crab.sizeX = (int)screenSize.getWidth()/12;
		Crab.sizeY = sizeX*124/254;
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
	
	public int getXDir() {
		return this.XDir;
	}
	
	public int getYDir() {
		return this.YDir;
	}
	
	public int getSizeX() {
		return Crab.sizeX;
	}
	
	public int getSizeY() {
		return Crab.sizeY;
	}
	
	public void setSizeY(int y) {
		Crab.sizeY = y;
	}
	
	public void setSizeX(int x) {
		Crab.sizeX = x;
	}
	
	public void setMove(int x) {
		this.move = x;
	}
	
	public void moveCrab(int J,Dimension screenSize){
		if((move%8)==0){
			
			XDir = J%6 - J%2;
			YDir = J%2 + J%1;
		}
		if(x >= screenSize.getWidth() - 100){
			XDir = -4;
		}
		if(x - 100 <= 0 ){
			XDir = 4;
		}
		if(y >= screenSize.getHeight() - 100){
			YDir = -1;
		}
		if(y - 100 <= 0 ){
			YDir = 1;
		}
		
		move++;
		if(move > 40){
			setX(getX() + XDir);
			setY(getY() + YDir);
			}
	}
}
