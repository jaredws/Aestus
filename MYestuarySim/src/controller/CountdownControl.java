package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import view.CountdownView;
import view.StartingView;

/**
 * 
 * @author Team 0
 * A Controller that times the game. It contains the time left for the game to run
 * and stores which image state the clock must show.
 *
 */
public class CountdownControl {
	/**
	 * A dimension that takes in the screen size the game is running on.
	 */
	Dimension screenSize;
	/**
	 * A connecting view that connects to see which image must be called.
	 */
	CountdownView CDV;
	/**
	 * The current time the decrements as time progress, in seconds.
	 */
	private int time;
	/**
	 * Default time is set to 1 minute (60 seconds).
	 */
	final static int defaultTime = 120;
	/**
	 * Time can be changed from the settings menu in the main screen and this reflects that.
	 */
	final int timeChange = StartingView.getTime();
	/**
	 * Represents the time that was chosen either from default or from starting view.
	 */
	private int totalTime;
	/**
	 * Contains an integer that represents which image on the clock should be shown.
	 */
	private int image;
	/**
	 * Takes totalTime and divides it by twelve to know when to switch images (there are 12 clock positions).
	 */
	private int twelfth;
	/**
	 * The counter shows how many times updateCountdown() has been called. 
	 */
	private int counter;
	
	/**
	 * Creates a new CountdownControl, creating a new CountdownView and takes in the screen size 
	 * while setting the time to the setting-changed time and stores the twelfth. 
	 */
	public CountdownControl(){
		CDV = new CountdownView();
		counter = 0;
		time = timeChange;
		totalTime = time;
		twelfth = totalTime/12;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * Updates the time and is called from game 4 times a second. 
	 * Every four calls it decrements the time.
	 * Every other call it tells the view to switch the image from white clock 
	 * to orange clock to simulate flashing. 
	 */
	public void updateCountdown() {
		
		if(counter%4 == 0){
			time--;
		}
		image = (totalTime-time)/twelfth;
		if(image == 9 && counter%4 == 2){
			image = 13;
		}
		else if(image == 10 && counter%4 == 2){
			image = 14;
		}
		else if(image == 11 && counter%2 == 1){
			image = 15;
		}
		counter++;
	}
	
	/**
	 * Gets the current game time left
	 * @return time left in game
	 */
	public int getTime() {
		return this.time;
	}

	/**
	 * Gets the default time hardcoded into the game.
	 * @return the default time from game.
	 */
	public static int getDefaultTime() {
		return defaultTime;
	}
	/**
	 * Returns the current image number based on time from 0 to 14
	 * @return image number
	 */
	public int getImage(){
		return image;
	}
	/**
	 * Returns the counter
	 * @return counter
	 */
	public int getCounter(){
		return counter;
	}
}
