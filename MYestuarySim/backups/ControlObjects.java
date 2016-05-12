package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class ControlObjects {

	private List<Tool> ButtonList;
	private List<BlueCrab> BlueCrabs;
	private List<Crab> Crabs;
	private List<Turtle> Turtles;
	private List<CordGrass> CordGrass;
	private List<Phragmites> Phragmites;
	private List<Pollution> Pollution;
	//I want these to be lists of the higher classes
	//example List<List<MovingObject>> MovingStuff;
	private List<List> MovingStuff;
	private List<List> Everything;
	Dimension screenSize;
	
	protected ControlObjects() {
		ButtonList = new ArrayList<Tool>();
		BlueCrabs = new ArrayList<BlueCrab>();
		Crabs = new ArrayList<Crab>();
		Turtles = new ArrayList<Turtle>();
		CordGrass = new ArrayList<CordGrass>();
		Phragmites = new ArrayList<Phragmites>();
		MovingStuff = new ArrayList<List>();
		Pollution = new ArrayList<Pollution>();
		MovingStuff.add(BlueCrabs);
		MovingStuff.add(Crabs);
		MovingStuff.add(Turtles);
		Everything = new ArrayList<List>();
		Everything.add(BlueCrabs);
		Everything.add(Crabs);
		Everything.add(Phragmites);
		Everything.add(Turtles);
		Everything.add(CordGrass);
		Everything.add(Pollution);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	
	/**
	 * A public method to manage the constructor 
	 * may be necessary
	 * @return
	 */
	public ControlObjects create(){
		return new ControlObjects();
	}
	
	/**
	 *A short, neat way to move all the objects 
	 *
	 */
	public boolean moveAll(){
		try{
			for(List<MovingObject> list: MovingStuff){
				for(MovingObject mo: list){
					mo.move();
				}
			}
			return true;
		}catch(IndexOutOfBoundsException ex){
			return false;
		}
	}
	
	/**
	 * To only be used by the PopulationControl
	 * Removes the oldest member of the living species
	 * @param class Enum
	 * @return completion
	 */
	protected boolean remove(eImages c){
		switch (c){
		case BLUECRAB:{ BlueCrabs.remove(0); return true;}
		case INVASIVECRAB:{ Crabs.remove(0); return true;}
		case PHRAGMITES: {Phragmites.remove(0); return true;}
		case CORDGRASS: {CordGrass.remove(0); return true;}
		case TURTLE: {Turtles.remove(0); return true;}
		default: return false;
		}
	}
	/**
	 * Methods to add Creatures to their Lists
	 * @param x
	 * @param y
	 * @return successful addition
	 */
	public boolean addBlueCrab(int x, int y){
		return BlueCrabs.add(new BlueCrab(x,y,screenSize));
	}
	
	public boolean addCrab(int x, int y){
		return Crabs.add(new Crab(x,y,screenSize));
	}
	
	public boolean addPhragmites(int x, int y){
		return Phragmites.add(new Phragmites(x,y,screenSize));
	}
	
	public boolean addCordGrass(int x, int y){
		return CordGrass.add(new CordGrass(x,y,screenSize));
	}
	
	public boolean addTurtle(int x, int y){
		return Turtles.add(new Turtle(x,y,screenSize));
	}
	

}