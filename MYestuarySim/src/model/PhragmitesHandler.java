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
 * The Class PhragmitesHandler. Contains a list of phragmites objects and researched property,
 * functionality to add/remove from list.
 * @author Team 0
 */
public class PhragmitesHandler {
	
	/** The random object used for various functionality in the class */
	Random rand;
	
	/** The list of Phragmites. */
	List<Phragmites> Phragmites;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** True if any of the phragmites was researched */
	private boolean Researched;
	
	/** The number of Removed objects. */
	int Removed;

	/**
	 * Adds a new phragmites object to the list .
	 *
	 * @param x the x location for spawning
	 * @param y the y location for spawning
	 */
	public void addPhragmites(int x, int y){
		Phragmites.add(new Phragmites(x,y,screenSize));
	}
	
	/**
	 * Gets the list of phragmites.
	 *
	 * @return the list of phragmites
	 */
	public List<Phragmites> getPhragmites() {
		return this.Phragmites;
	}
	
	/**
	 * Constructor
	 * Instantiates a new phragmites handler with default settings
	 */
	public PhragmitesHandler(){
		rand  = new Random();
		Phragmites = new ArrayList<Phragmites>();
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
	 * Removes the phragmites.
	 *
	 * @param i the index of the phragmites
	 */
	public void removePhragmites(int i){
		Phragmites.remove(i);
		Removed++;
	}
	
	/**
	 * Gets the phragmites at the specified index.
	 *
	 * @param i the index of the phragmites
	 * @return the phragmites
	 */
	public Phragmites getPhragmites(int i){
		return Phragmites.get(i);
	}
	
	/**
	 * Increments the growth status of each phragmites in the list
	 */
	public void age(){
		for(int i = 0; i < Phragmites.size(); i++){
			Phragmites.get(i).live();
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
