package model;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhragmitesHandler {
	Random rand;
	List<Phragmites> Phragmites;
	Dimension screenSize;
	private boolean Researched;
	int Removed;

	public void addPhragmites(int x, int y){
		Phragmites.add(new Phragmites(x,y,screenSize));
	}
	
	public List<Phragmites> getPhragmites() {
		return this.Phragmites;
	}
	
	public PhragmitesHandler(){
		rand  = new Random();
		Phragmites = new ArrayList<Phragmites>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	public boolean getResearched() {
		return this.isResearched();
	}
	
	public void removePhragmites(int i){
		Phragmites.remove(i);
		Removed++;
	}
	
	public Phragmites getPhragmites(int i){
		return Phragmites.get(i);
	}
	
	public void age(){
		for(int i = 0; i < Phragmites.size(); i++){
			Phragmites.get(i).live();
		}
	}
	
	public int getRemoved(){
		return Removed;
	}

	public boolean isResearched() {
		return Researched;
	}

	public void setResearched(boolean researched) {
		Researched = researched;
	}
}
