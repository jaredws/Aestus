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
	List<Phragmites> phrags;

	public void addPhragmites(int x, int y){
		phrags.add(new Phragmites(x,y));
	}
	
	public List<Phragmites> getPhragmites() {
		return this.phrags;
	}
	
	public PhragmitesControl(){
		rand  = new Random();
		phrags = new ArrayList<Phragmites>();
	}
	
	public void movePhragmites(){
		int j = 0;
		for(int i = 0; i < phrags.size(); i++){
			j = rand.nextInt();
			if(j%25 == 4){
				phrags.get(i).setX(phrags.get(i).getX() + j%8 - 4);
				phrags.get(i).setY(phrags.get(i).getY() + j%10 - 5);
			}
		}
	}
	
	public void deletePhragmites(ButtonControl bc){
		for(int i = 0; i < phrags.size(); i++){
			if(phrags.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && phrags.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((phrags.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (phrags.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					phrags.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddPhragmites(ScreenButton s){

		if(s.clickx > 0 && s.addCrab){
			addPhragmites(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}
	}
}
