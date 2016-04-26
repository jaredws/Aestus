package controller;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.CordGrass;


public class CordGrassControl {
	Random rand;
	List<CordGrass> CordGrass;

	public void addCordGrass(int x, int y){
		CordGrass.add(new CordGrass(x,y));
	}
	
	public List<CordGrass> getCordGrass() {
		return this.CordGrass;
	}
	
	public CordGrassControl(){
		rand  = new Random();
		CordGrass = new ArrayList<CordGrass>();
	}
	
	
	public void deleteCordGrass(ButtonControl bc){
		for(int i = 0; i < CordGrass.size(); i++){
			if(CordGrass.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && CordGrass.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((CordGrass.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (CordGrass.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					CordGrass.remove(i);
					i--;
				}
			}
		}
	}
	
	
	protected void removeCordGrass(int i){
		CordGrass.remove(i);
	}
}
