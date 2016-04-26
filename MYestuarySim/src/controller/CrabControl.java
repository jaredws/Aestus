package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import model.Crab;

public class CrabControl {
	Random rand;
	List<Crab> crabs;

	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y));
	}
	
	public List<Crab> getCrabs() {
		return this.crabs;
	}
	
	public CrabControl(){
		rand  = new Random();
		crabs = new ArrayList<Crab>();
	}
	
	public void moveCrabs(){
		int j = 0;
		for(int i = 0; i < crabs.size(); i++){
			j = rand.nextInt();
			if(j%25 == 4){
				crabs.get(i).setX(crabs.get(i).getX() + j%8 - 4);
				crabs.get(i).setY(crabs.get(i).getY() + j%10 - 5);
			}
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
}
