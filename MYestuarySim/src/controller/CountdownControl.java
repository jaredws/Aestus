package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import view.CountdownView;

/**
 * 
 * @author Steven
 *
 */

public class CountdownControl {
	Dimension screenSize;
	CountdownView CDV;
	//imageX is the x position of the image
	//progress is the percentage of the time completed
	//time is the amount of time for the game
	//incX is the amount x is increased by
	//width is the width of the bar
	private int imageX, imageY, progress, incX;
	private int width = 400;
	private int time = 10;
	public CountdownControl(){
		CDV = new CountdownView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.imageX = 0;
		this.progress = 0;
		this.incX = width/time;
		this.imageY = (int)screenSize.getHeight()-CDV.getImage().getHeight(null)-30;
		
	}
	
	//Should only be called once every second
	public void updateCountdown() {
		progress = (imageX/width)*100;
		this.imageX += incX;
		time--;
	}
	
	public int getImageX() {
		return this.imageX;
	}
	
	public int getProgress() {
		return progress;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getImageY() {
		return this.imageY;
	}
	
	
}