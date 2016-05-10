package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import model.Crab;

public class CrabControl {
	Random rand;
	List<Crab> crabs;
	Dimension screenSize;
	boolean Researched;
	int Removed;

	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y,screenSize));
	}
	
	public List<Crab> getCrabs() {
		return this.crabs;
	}
	
	public CrabControl(){
		rand  = new Random();
		crabs = new ArrayList<Crab>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Researched = false;
		Removed = 0;
	}
	
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			crabs.get(i).moveCrab(rand.nextInt(),screenSize);
		}
	}
	
	public void deleteCrabs(ToolControl tc){
		for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && crabs.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((crabs.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (crabs.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					crabs.remove(i);
					i--;
				}
			}
		}
	}
	
	protected void removeCrab(int i){
		crabs.remove(i);
	}
	
	public Crab getCrab(int i){
		return crabs.get(i);
	}
	
	public boolean getResearched() {
		return this.Researched;
	}
	
	public int getRemoved(){
		return Removed;
	}
}
