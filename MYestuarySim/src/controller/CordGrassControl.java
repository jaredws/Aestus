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
	List<CordGrass> cgrass;

	public void addCordGrass(int x, int y){
		cgrass.add(new CordGrass(x,y));
	}
	
	public List<CordGrass> getCordGrass() {
		return this.cgrass;
	}
	
	public CordGrassControl(){
		rand  = new Random();
		cgrass = new ArrayList<CordGrass>();
	}
	
	public void moveCordGrass(){
		int j = 0;
		for(int i = 0; i < cgrass.size(); i++){
			j = rand.nextInt();
			if(j%25 == 4){
				cgrass.get(i).setX(cgrass.get(i).getX() + j%8 - 4);
				cgrass.get(i).setY(cgrass.get(i).getY() + j%10 - 5);
			}
		}
	}
	
	public void deleteCordGrass(ButtonControl bc){
		for(int i = 0; i < cgrass.size(); i++){
			if(cgrass.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && cgrass.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((cgrass.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (cgrass.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					cgrass.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddCordGrass(ScreenButton s){

		if(s.clickx > 0 && s.addCrab){
			addCordGrass(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}
	}
	
	protected void removeCordGrass(int i){
		cgrass.remove(i);
	}
}
