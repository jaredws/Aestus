package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import controller.SoundController;
import controller.ToolControl;

/**
 * The Class TurtleHandler. Contains a list of turtles with functionality to add, remove
 * Used by @see controller.Game class
 */
public class TurtleHandler {
	
	/** The random object used for various random functionality in the class */
	Random rand;
	
	/** The list of turtles. */
	List<Turtle> turtles;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** True if any of the turtles have been researched */
	private boolean Researched;
	
	/** The number of Removed turtles. */
	int Removed;

	/**
	 * Adds a new turtle instance to the list.
	 *
	 * @param x the x location of spawn
	 * @param y the y location of spawn
	 */
	public void addTurtle(int x, int y){
		turtles.add(new Turtle(x,y,screenSize));
	}
	
	/**
	 * Gets the list of turtles.
	 *
	 * @return the list of turtles
	 */
	public List<Turtle> getTurtles() {
		return this.turtles;
	}
	
	/**
	 * Constructor
	 * Instantiates a new turtle handler with default values.
	 */
	public TurtleHandler(){
		rand  = new Random();
		turtles = new ArrayList<Turtle>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	/**
	 * Move turtles. A wrapper function that calls the move function of each turtle in the list. 
	 */
	public void moveTurtles(){
			
			for(int i = 0; i < turtles.size(); i++){
				turtles.get(i).moveTurtle(rand.nextInt(),screenSize);
			}
	}
	
	/**
	 * Delete turtles if they are in the range of the crab trap.
	 *
	 * @param tc the ToolControl - to get the range of the crab trap.
	 */
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
	
	/**
	 * Removes the turtle.
	 * @param i the index of the turtle
	 */
	protected void removeTurtle(int i){
		turtles.remove(i);
	}
	
	/**
	 * Gets the turtle.
	 * @param i the index of the turtle
	 * @return the turtle
	 */
	public Turtle getTurtle(int i){
		return turtles.get(i);
	}
	
	/**
	 * Gets the turtle.
	 * @return the turtle
	 */
	public List<Turtle> getTurtle(){
		return turtles;
	}
	
	/**
	 * Gets the researched.
	 * @return the researched
	 */
	public boolean getResearched() {
		return this.isResearched();
	}
	
	/**
	 * Gets the number of removed turtles.
	 * @return the number of removed turtles
	 */
	public int getRemoved(){
		return Removed;
	}

	/**
	 * Checks if any turtles are researched.
	 *
	 * @return true, if is researched
	 */
	public boolean isResearched() {
		return Researched;
	}

	/**
	 * Sets the researched variable.
	 *
	 * @param researched the new researched
	 */
	public void setResearched(boolean researched) {
		Researched = researched;
	}

}
