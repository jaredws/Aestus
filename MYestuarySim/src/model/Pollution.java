package model;
import java.awt.Dimension;
/**
 * 
 * @author Jared+karpzey4ever <33333
 *
 */
public class Pollution extends Grabbable {
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
	public int type;
	
	public Pollution(int x, int y){
		this.x = x;
		this.y = y;
		this.sizeX = 165;
		this.sizeY = 165;
		type=0;
    }
	
	public Pollution(int x, int y, Dimension screenSize,int type){
		this.x = x;
		this.y = y;
		Pollution.sizeX = (int)screenSize.getWidth()/12;
		Pollution.sizeY = sizeX*138/182;
		this.type=type;
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
	public void live(){
		life++;
	}
}
