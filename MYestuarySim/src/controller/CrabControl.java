package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Crab;

public class CrabControl {
	Random rand = new Random();
	List<Crab> crabs = new ArrayList<Crab>();
	
	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y));
	}
	
	public List<Crab> getCrabs() {
		return this.crabs;
	}
	
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			if(rand.nextInt()%25 == 5){
				crabs.get(i).setX(crabs.get(i).getX() + rand.nextInt()%6 - 3);
				crabs.get(i).setY(crabs.get(i).getY() + rand.nextInt()%6 - 3);
			}
		}
	}
	
	public void deleteCrabs(){
		/*for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).getX() > buttons.get(0).x - buttons.get(0).sizeX/2 && crabs.get(i).x < buttons.get(0).x + buttons.get(0).sizeX/4){
				if((crabs.get(i).y > buttons.get(0).y-buttons.get(0).sizeY) && (crabs.get(i).y < buttons.get(0).y + buttons.get(0).sizeY/2)){
					crabs.remove(i);
					i--;
				}
			}
		}*/
	}
	
	public void clickAddCrab(ScreenButton s){
		
		/*if(s.clickx > 0 && s.addCrab){
			addCrab(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}*/
	}
}
