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

	public void addPollution(int x, int y){
		Pollution.add(new Pollution(x,y,screenSize));
	}
	
	public List<Pollution> getPhragmites() {
		return this.Pollution;
	}
	
	public PollutionControl(){
		rand  = new Random();
		Pollution = new ArrayList<Pollution>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	
	public void deletePollution(ButtonControl bc){
		for(int i = 0; i < Pollution.size(); i++){
			if(Pollution.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && Pollution.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((Pollution.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (Pollution.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
//					Phragmites.remove(i);
//					i--;
				}
			}
		}
	}
	
	protected void removePollution(int i){
		Pollution.remove(i);
	}
	
	public Pollution getPollution(int i){
		return Pollution.get(i);
	}
	
	public int getPollutionSize(){
		return Pollution.size();
	}
	/*
	public void age(){
		for(int i = 0; i < Pollution.size(); i++){
			Pollution.get(i).live();
		}
	}*/
}
