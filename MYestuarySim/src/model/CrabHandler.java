package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import controller.SoundController;
import controller.ToolControl;

/**
 * The Class CrabHandler. Contains a list of crabs with functionality to add crabs, remove them, 
 * or move them
 * @author Team 0
 */
public class CrabHandler {
	
	/** The random object for use in various functionality of the class */
	Random rand;
	
	/** The list of crabs.
	 * @see Model.Crab.java
	 */
	List<Crab> crabs;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** True if and of the crabs have been researched */
	private boolean Researched;
	
	/** The number of Removed crabs. */
	int Removed;

	/**
	 * Adds a new crab to the list.
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 */
	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y,screenSize));
	}
	
	/**
	 * Gets the list of crabs.
	 *
	 * @return the crab list
	 */
	public List<Crab> getCrabs() {
		return this.crabs;
	}
	
	/**
	 * Constructor
	 * Instantiates a new crab handler with default values
	 */
	public CrabHandler(){
		rand  = new Random();
		crabs = new ArrayList<Crab>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	/**
	 * Move crabs. Wrapper function that calls move for each crab in the list 
	 */
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			crabs.get(i).moveCrab(rand.nextInt(),screenSize);
		}
	}
	
	/**
	 * Delete a crab if it is in a crab trap
	 *
	 * @param tc the ToolControl
	 */
	public void deleteCrabs(ToolControl tc){
		for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && crabs.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((crabs.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (crabs.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					crabs.remove(i);
					Removed++;
					i--;
					SoundController.playTrap();
				}
			}
		}
	}
	
	/**
	 * Removes the crab.
	 *
	 * @param i the index of the crab in the list
	 */
	protected void removeCrab(int i){
		crabs.remove(i);
	}
	
	/**
	 * Gets the crab.
	 *
	 * @param i the index of the crab in the list
	 * @return the crab
	 */
	public Crab getCrab(int i){
		return crabs.get(i);
	}
	
	/**
	 * Gets the researched.
	 *
	 * @return the researched
	 */
	public boolean getResearched() {
		return this.isResearched();
	}
	
	/**
	 * Gets the removed.
	 *
	 * @return the removed
	 */
	public int getRemoved(){
		return Removed;
	}

	/**
	 * Checks if is researched.
	 *
	 * @return true, if is researched
	 */
	public boolean isResearched() {
		return Researched;
	}

	/**
	 * Sets the researched.
	 *
	 * @param researched the new researched
	 */
	public void setResearched(boolean researched) {
		Researched = researched;
	}

}
