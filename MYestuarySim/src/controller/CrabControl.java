package controller;

import java.util.Random;

public class CrabControl {
	Random rand = new Random();
	
	public void addCrab(int x, int y){
		//crabs.add(new Crab(x,y));
	}
	
	public void moveCrabs(){
		/*for(int i = 0; i < crabs.size(); i++){
			if(rand.nextInt()%25 == 5){
					crabs.get(i).x = crabs.get(i).x + rand.nextInt()%6 - 3;
					crabs.get(i).y = crabs.get(i).y + rand.nextInt()%6 - 3;
			}
		}*/
	}
	
	public void deleteCrabs(){
		/*for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).x > buttons.get(0).x - buttons.get(0).sizeX/2 && crabs.get(i).x < buttons.get(0).x + buttons.get(0).sizeX/4){
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
