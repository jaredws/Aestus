package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 * @author Steven
 */
public class HealthHandler {

	Dimension screenSize;
	public List<Health> Stars;

	public void addStar(int x, int y){
		Stars.add(new Health(x,y,screenSize));
	}
	
	public List<Health> getStars() {
		return this.Stars;
	}
	
	public HealthHandler(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public Health getStar(int i){
		return Stars.get(i);
	}
	
	public int check(int health){
		if(health <= 0){
			return 0;
		}else if(health <= 1){
			return 1;
		}else if(health < 12){
			return 2;
		}else if(health < 23){
			return 3;
		}else if(health < 31){
			return 4;
		}else
			return 5;
	}
}