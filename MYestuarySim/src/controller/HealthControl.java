package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Health;

/**
 * @author Steven
 */
public class HealthControl {

	Dimension screenSize;
	public List<Health> Stars;

	public void addStar(int x, int y){
		Stars.add(new Health(x,y,screenSize));
	}
	
	//added a comment
	
	public List<Health> getStars() {
		return this.Stars;
	}
	
	public HealthControl(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public void deleteStars(ButtonControl bc){
		/*for(int i = 0; i < BlueCrabs.size(); i++){
			if(BlueCrabs.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && BlueCrabs.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((BlueCrabs.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (BlueCrabs.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					BlueCrabs.remove(i);
					i--;
				}
			}
		}*/
	}
	
	protected void removeStar(int i){
		Stars.remove(i);
	}
	
	public Health getStar(int i){
		return Stars.get(i);
	}
	
	public int check(int health){
		/*if(health < 0){
			return 0;
		}else if(health < 5){
			return 1;
		}else if(health < 10){
			return 2;
		}else if(health < 15){
			return 3;
		}else*/
			return 4;
	}
}