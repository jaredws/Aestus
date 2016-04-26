package controller;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.BlueCrab;

public class BlueCrabControl {
	Random rand;
	
	public List<BlueCrab> BlueCrabs;

	public void addBlueCrab(int x, int y){
		BlueCrabs.add(new BlueCrab(x,y));
	}
	
	//added a comment
	
	public List<BlueCrab> getBlueCrabs() {
		return this.BlueCrabs;
	}
	
	public BlueCrabControl(){
		rand  = new Random();
		BlueCrabs = new ArrayList<BlueCrab>();
	}
	
	public void moveBlueCrabs(){
		for(int i = 0; i < BlueCrabs.size(); i++){
			if(rand.nextInt()%25 == 4){
				BlueCrabs.get(i).setX(BlueCrabs.get(i).getX() + rand.nextInt()%8 - 3);
				BlueCrabs.get(i).setY(BlueCrabs.get(i).getY() + rand.nextInt()%8 - 3);
			}
		}
	}
	
	public void deleteBlueCrabs(ButtonControl bc){
		for(int i = 0; i < BlueCrabs.size(); i++){
			if(BlueCrabs.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && BlueCrabs.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((BlueCrabs.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (BlueCrabs.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					BlueCrabs.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddBlueCrab(ScreenButton s){

		if(s.clickx > 0 && s.addBlueCrab){
			addBlueCrab(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addBlueCrab = false;
		}
	}
	
	protected void removeBlueCrab(int i){
		BlueCrabs.remove(i);
	}
}