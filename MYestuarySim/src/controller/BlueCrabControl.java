package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.BlueCrab;

public class BlueCrabControl {
	Random rand;
	List<BlueCrab> bcrabs;

	public void addBlueCrab(int x, int y){
		bcrabs.add(new BlueCrab(x,y));
	}
	
	public List<BlueCrab> getBlueCrabs() {
		return this.bcrabs;
	}
	
	public BlueCrabControl(){
		rand  = new Random();
		bcrabs = new ArrayList<BlueCrab>();
	}
	
	public void moveBlueCrabs(){
		for(int i = 0; i < bcrabs.size(); i++){
			if(rand.nextInt()%25 == 4){
				bcrabs.get(i).setX(bcrabs.get(i).getX() + rand.nextInt()%8 - 3);
				bcrabs.get(i).setY(bcrabs.get(i).getY() + rand.nextInt()%8 - 3);
			}
		}
	}
	
	public void deleteBlueCrabs(ButtonControl bc){
		for(int i = 0; i < bcrabs.size(); i++){
			if(bcrabs.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && bcrabs.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((bcrabs.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (bcrabs.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					bcrabs.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddBlueCrab(ScreenButton s){

		if(s.clickx > 0 && s.addCrab){
			addBlueCrab(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}
	}
}
