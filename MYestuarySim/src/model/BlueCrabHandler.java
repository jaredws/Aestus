package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import controller.SoundController;
import controller.ToolControl;

/**
 * @author Steven
 */

/**
 * The Class BlueCrabHandler. Contains a list of BlueCrabs, functionality to move the crabs
 * 
 * @author Team 0
 */
public class BlueCrabHandler {
	
	/** The random object used for various functionality of the game */
	Random rand;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** The Blue crabs.
	 * @see Model.BlueCrab.java
	 */
	public List<BlueCrab> BlueCrabs;
	
	/** The Researched. */
	private boolean Researched;
	
	/** The number of Removed objects */
	int Removed;

	/**
	 * 
	 * Adds a blue crab to the list.
	 *
	 * @param x the x coordinate for placement
	 * @param y the y coordinate for placement
	 */
	public void addBlueCrab(int x, int y){
		BlueCrabs.add(new BlueCrab(x,y,screenSize));
	}
	
	/**
	 * Gets the list of blue crabs.
	 *
	 * @return the blue crabs list
	 */
	public List<BlueCrab> getBlueCrabs() {
		return this.BlueCrabs;
	}
	
	/**
	 * Instantiates a new blue crab handler.
	 */
	public BlueCrabHandler(){
		rand  = new Random();
		BlueCrabs = new ArrayList<BlueCrab>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	/**
	 * Move all the blue crabs. wrapper, just calls the move function for each crab in the list
	 */
	public void moveBlueCrabs(){
		
		for(int i = 0; i < BlueCrabs.size(); i++){
			BlueCrabs.get(i).moveBlueCrab(rand.nextInt(),screenSize);
		}
	}
	
	/**
	 * Delete a blue crab if it is in the crab trap. 
	 * @param tc the ToolControl
	 */
	public void deleteBlueCrabs(ToolControl tc){
		for(int i = 0; i < BlueCrabs.size(); i++){
			if(BlueCrabs.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && BlueCrabs.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((BlueCrabs.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (BlueCrabs.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					BlueCrabs.remove(i);
					Removed++;
					i--;
					SoundController.playTrap();
				}
			}
		}
	}
	
	/**
	 * Removes the blue crab.
	 *
	 * @param i the integer of the blue crab
	 */
	protected void removeBlueCrab(int i){
		BlueCrabs.remove(i);
	}
	
	/**
	 * Gets the blue crab.
	 *
	 * @param i the integer of the blue crab
	 * @return the blue crab
	 */
	public BlueCrab getBlueCrab(int i){
		return BlueCrabs.get(i);
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