package model;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * The Class CordGrassHandler. Contains a list of CordGrass objects and functionality to add, remove, move them.
 * @author Team 0
 */
public class CordGrassHandler {
	
	/** The random object for use in various functionality of the class */
	Random rand;
	
	/** The Cord grass list.
	 * @see Model.CordGrass.java
	 */
	List<CordGrass> CordGrass;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** True if research has been performed on any cordgrass */
	private boolean Researched;
	
	/** The number of Removed objects */
	int Removed;

	/**
	 * Adds a new cord grass to the list.
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 */
	public void addCordGrass(int x, int y){
		CordGrass.add(new CordGrass(x,y,screenSize));
	}
	
	/**
	 * Gets the cord grass list.
	 *
	 * @return the cord grass list
	 */
	public List<CordGrass> getCordGrass() {
		return this.CordGrass;
	}
	
	/**
	 * Constructor 
	 * Instantiates a new cord grass handler with default values
	 */
	public CordGrassHandler(){
		rand  = new Random();
		CordGrass = new ArrayList<CordGrass>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
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
	 * Removes the cord grass.
	 *
	 * @param i the i
	 */
	public void removeCordGrass(int i){
		CordGrass.remove(i);
		Removed++;
	}
	
	/**
	 * Gets the cord grass.
	 *
	 * @param i the i
	 * @return the cord grass
	 */
	public CordGrass getCordGrass(int i){
		return CordGrass.get(i);
	}

	/**
	 * Age all of the cordgrass. Wrapper that calls live for each cordgrass
	 */
	public void age(){
		for(int i = 0; i < CordGrass.size(); i++){
			CordGrass.get(i).live();
		}
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
