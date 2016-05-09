package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author karpybizman
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Pollution;

public class PollutionControl {
	Random rand;
	List<Pollution> Pollution;
	Dimension screenSize;
	int Removed;
	

	public void addPollution(int x, int y){
		Pollution.add(new Pollution(x,y,screenSize,rand.nextInt(3)));
	}
	
	public List<Pollution> getPhragmites() {
		return this.Pollution;
	}
	
	public PollutionControl(){
		rand  = new Random();
		Pollution = new ArrayList<Pollution>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Removed = 0;
	}
	
	
	public void deletePollution(ToolControl tc){
		for(int i = 0; i < Pollution.size(); i++){
			if(Pollution.get(i).getX() > tc.getRecycle().getX() - tc.getRecycle().getSizeX()/2 && Pollution.get(i).getX() < tc.getRecycle().getX() + tc.getRecycle().getSizeX()/4){
				if((Pollution.get(i).getY() > tc.getRecycle().getY()-tc.getRecycle().getSizeY()) && (Pollution.get(i).getY() < tc.getRecycle().getY() + tc.getRecycle().getSizeY()/2)){
					Pollution.remove(i);
					Removed++;
					i--;
				}
			}
		}
	}
	
	protected void removePollution(int i){
		Pollution.remove(i);
	}
	public List<Pollution> getPollution(){
		return this.Pollution;
	}
	
	public Pollution getPollution(int i){
		return Pollution.get(i);
	}
	
	public int getPollutionSize(){
		return Pollution.size();
	}
	
	public void age(){
		for(int i = 0; i < Pollution.size(); i++){
			Pollution.get(i).live();
		}
	}
	
	public int getRemoved(){
		return Removed;
	}
}
