package model;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controller.SoundController;
import controller.ToolControl;

public class TurtleHandler {
	Random rand;
	List<Turtle> turtles;
	Dimension screenSize;
	private boolean Researched;
	int Removed;

	public void addTurtle(int x, int y){
		turtles.add(new Turtle(x,y,screenSize));
	}
	
	public List<Turtle> getTurtles() {
		return this.turtles;
	}
	
	public TurtleHandler(){
		rand  = new Random();
		turtles = new ArrayList<Turtle>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	public void moveTurtles(){
			
			for(int i = 0; i < turtles.size(); i++){
				turtles.get(i).moveTurtle(rand.nextInt(),screenSize);
			}
	}
	
	public void deleteTurtles(ToolControl tc){
		for(int i = 0; i < turtles.size(); i++){
			if(turtles.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && turtles.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((turtles.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (turtles.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					turtles.remove(i);
					Removed++;
					i--;
					SoundController.playTrap();
				}
			}
		}
	}
	
	protected void removeTurtle(int i){
		turtles.remove(i);
	}
	
	public Turtle getTurtle(int i){
		return turtles.get(i);
	}
	
	public boolean getResearched() {
		return this.isResearched();
	}
	
	public int getRemoved(){
		return Removed;
	}

	public boolean isResearched() {
		return Researched;
	}

	public void setResearched(boolean researched) {
		Researched = researched;
	}

}
