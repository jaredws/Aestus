package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
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
	Dimension screenSize;
	boolean Researched;

	public void addPhragmites(int x, int y){
		Phragmites.add(new Phragmites(x,y,screenSize));
	}
	
	public List<Phragmites> getPhragmites() {
		return this.Phragmites;
	}
	
	public PhragmitesControl(){
		rand  = new Random();
		Phragmites = new ArrayList<Phragmites>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Researched = false;
	}

	
	
	/*public void deletePhragmites(ToolControl tc){
		for(int i = 0; i < Phragmites.size(); i++){
			if(Phragmites.get(i).getX() > tc.getTools().get(0).getX() - tc.getTools().get(0).getSizeX()/2 && Phragmites.get(i).getX() < tc.getTools().get(0).getX() + tc.getTools().get(0).getSizeX()/4){
				if((Phragmites.get(i).getY() > tc.getTools().get(0).getY()-tc.getTools().get(0).getSizeY()) && (Phragmites.get(i).getY() < tc.getTools().get(0).getY() + tc.getTools().get(0).getSizeY()/2)){
//					Phragmites.remove(i);
//					i--;
				}
			}
		}
	}*/
	
	protected void removePhragmites(int i){
		Phragmites.remove(i);
	}
	
	public Phragmites getPhragmites(int i){
		return Phragmites.get(i);
	}
	
	public void age(){
		for(int i = 0; i < Phragmites.size(); i++){
			Phragmites.get(i).live();
		}
	}
}
