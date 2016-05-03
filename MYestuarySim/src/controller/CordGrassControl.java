package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
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
	Dimension screenSize;

	public void addCordGrass(int x, int y){
		CordGrass.add(new CordGrass(x,y,screenSize));
	}
	
	public List<CordGrass> getCordGrass() {
		return this.CordGrass;
	}
	
	public CordGrassControl(){
		rand  = new Random();
		CordGrass = new ArrayList<CordGrass>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	
	public void deleteCordGrass(ButtonControl bc){
		for(int i = 0; i < CordGrass.size(); i++){
			if(CordGrass.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && CordGrass.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((CordGrass.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (CordGrass.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
//					CordGrass.remove(i);
//					i--;
				}
			}
		}
	}
	
	/*public void clickAddCordGrass(ScreenButton s){

		if(s.clickx > 0 && s.addCordGrass){
			addCordGrass(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCordGrass= false;
		}
	}*/
	
	
	protected void removeCordGrass(int i){
		CordGrass.remove(i);
	}
	
	public CordGrass getCordGrass(int i){
		return CordGrass.get(i);
	}

	public void age(){
		for(int i = 0; i < CordGrass.size(); i++){
			CordGrass.get(i).live();
		}
	}

}
