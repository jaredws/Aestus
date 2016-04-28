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
	}
	
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			crabs.get(i).moveCrab(rand.nextInt(),screenSize);
		}
	}
	
	public void deleteCrabs(ButtonControl bc){
		for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && crabs.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((crabs.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (crabs.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					crabs.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddCrab(ScreenButton s){

		if(s.clickx > 0 && s.addCrab){
			addCrab(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}
	}
	
	protected void removeCrab(int i){
		crabs.remove(i);
	}
	
	public Crab getCrab(int i){
		return crabs.get(i);
	}
}
