package model;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.ToolControl;

public class BlueCrabControl {
	Random rand;
	Dimension screenSize;
	public List<BlueCrab> BlueCrabs;
	private boolean Researched;
	int Removed;

	public void addBlueCrab(int x, int y){
		BlueCrabs.add(new BlueCrab(x,y,screenSize));
	}
	
	public List<BlueCrab> getBlueCrabs() {
		return this.BlueCrabs;
	}
	
	public BlueCrabControl(){
		rand  = new Random();
		BlueCrabs = new ArrayList<BlueCrab>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	public void moveBlueCrabs(){
		
		for(int i = 0; i < BlueCrabs.size(); i++){
			BlueCrabs.get(i).moveBlueCrab(rand.nextInt(),screenSize);
		}
	}
	
	public void deleteBlueCrabs(ToolControl tc){
		for(int i = 0; i < BlueCrabs.size(); i++){
			if(BlueCrabs.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && BlueCrabs.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((BlueCrabs.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (BlueCrabs.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					BlueCrabs.remove(i);
					Removed++;
					i--;
				}
			}
		}
	}
	
	protected void removeBlueCrab(int i){
		BlueCrabs.remove(i);
	}
	
	public BlueCrab getBlueCrab(int i){
		return BlueCrabs.get(i);
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