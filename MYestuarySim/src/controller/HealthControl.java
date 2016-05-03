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
	
	public List<Health> getStars() {
		return this.Stars;
	}
	
	public HealthControl(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public Health getStar(int i){
		return Stars.get(i);
	}
	
	public int check(int health){
		if(health < 0){
			return 1;
		}else if(health < 5){
			return 2;
		}else if(health < 10){
			return 3;
		}else if(health < 15){
			return 4;
		}else
			return 5;
	}
}