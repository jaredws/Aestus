package model;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author karpybizman
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import controller.SoundController;
import controller.ToolControl;

/**
 * The Class PollutionHandler. Contains a list of pollution objects with functionality to add,remove
 * individual pollution objects.
 * @author Team 0
 */
public class PollutionHandler {
	
	/** The random object used for various functionality of the class */
	Random rand;
	
	/** The list of Pollution. */
	List<Pollution> Pollution;

	/** The screen size. */
	Dimension screenSize;
	
	/** The number of removed objects. */
	int Removed;
	

	/**
	 * Adds a new pollution object to the list.
	 *
	 * @param x the x location for spawning
	 * @param y the y location for spawning
	 */
	public void addPollution(int x, int y){
		Pollution.add(new Pollution(x,y,screenSize,rand.nextInt(3)));
	}

	
	/**
	 * Constructor
	 * Instantiates a new pollution handler with default values.
	 * .
	 */
	public PollutionHandler(){
		rand  = new Random();
		Pollution = new ArrayList<Pollution>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Removed = 0;
	}
	
	
	/**
	 * Delete a pollution from the list if it is in the bounds of the recycling bin.
	 *
	 * @param tc the ToolControl
	 */
	public void deletePollution(ToolControl tc){
		for(int i = 0; i < Pollution.size(); i++){
			if(Pollution.get(i).getX() > tc.getRecycle().getX() - tc.getRecycle().getSizeX() && Pollution.get(i).getX() < tc.getRecycle().getX() + tc.getRecycle().getSizeX()){
				if((Pollution.get(i).getY() > tc.getRecycle().getY()-tc.getRecycle().getSizeY()) && (Pollution.get(i).getY() < tc.getRecycle().getY() + tc.getRecycle().getSizeY()/2)){
					Pollution.remove(i);
					Removed++;
					i--;
					SoundController.playTrash();
				}
			}
		}
	}
	
	/**
	 * Removes the pollution at the given index.
	 *
	 * @param i the index
	 */
	protected void removePollution(int i){
		Pollution.remove(i);
	}
	
	/**
	 * Gets the list of pollution.
	 *
	 * @return the pollution
	 */
	public List<Pollution> getPollution(){
		return this.Pollution;
	}
	
	/**
	 * Gets the pollution at the given index.
	 *
	 * @param i the index
	 * @return the pollution
	 */
	public Pollution getPollution(int i){
		return Pollution.get(i);
	}
	
	/**
	 * Gets the size of the list of pollution.
	 *
	 * @return the pollution size
	 */
	public int getPollutionSize(){
		return Pollution.size();
	}
	
	/**
	 * Increments the growth variable for each pollution object in the list.
	 */
	public void age(){
		for(int i = 0; i < Pollution.size(); i++){
			Pollution.get(i).live();
		}
	}
	
	/**
	 * Gets the number of removed pollution objects.
	 *
	 * @return the number of removed objects 
	 */
	public int getRemoved(){
		return Removed;
	}
	
	public void spawnTrash(){
		addPollution((int)(rand.nextInt((int)screenSize.getHeight()*8/12) + screenSize.getHeight()*1/12) ,rand.nextInt((int)screenSize.getWidth()*8/12)+(int)screenSize.getWidth()/12);
	}
}
