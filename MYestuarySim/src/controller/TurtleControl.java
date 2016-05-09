package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Turtle;

public class TurtleControl {
	Random rand;
	List<Turtle> turtles;
	Dimension screenSize;
	boolean Researched;

	public void addTurtle(int x, int y){
		turtles.add(new Turtle(x,y,screenSize));
	}
	
	public List<Turtle> getTurtles() {
		return this.turtles;
	}
	
	public TurtleControl(){
		rand  = new Random();
		turtles = new ArrayList<Turtle>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Researched = false;
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
					i--;
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
		return this.Researched;
	}
}
