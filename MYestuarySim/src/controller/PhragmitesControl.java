package controller;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Phragmites;

public class PhragmitesControl {
	Random rand;
	List<Phragmites> Phragmites;

	public void addPhragmites(int x, int y){
		Phragmites.add(new Phragmites(x,y));
	}
	
	public List<Phragmites> getPhragmites() {
		return this.Phragmites;
	}
	
	public PhragmitesControl(){
		rand  = new Random();
		Phragmites = new ArrayList<Phragmites>();
	}
	
	
	public void deletePhragmites(ButtonControl bc){
		for(int i = 0; i < Phragmites.size(); i++){
			if(Phragmites.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && Phragmites.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((Phragmites.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (Phragmites.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					Phragmites.remove(i);
					i--;
				}
			}
		}
	}
	
	
	protected void removePhragmites(int i){
		Phragmites.remove(i);
	}
}
