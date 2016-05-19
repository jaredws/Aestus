package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

/**
 * The Class HealthHandler. Contains a list of health objects and functionality to add stars and check health
 * @author Team 0 
 */
public class HealthHandler {

	/** The screen size. */
	Dimension screenSize;
	
	/** The list of Stars. */
	public List<Health> Stars;

	/**
	 * Adds a star to the list.
	 *
	 * @param x the x location for spawn
	 * @param y the y location for spawn
	 */
	/*public void addStar(int x, int y){
		Stars.add(new Health(x,y,screenSize));
	}*/
	
	/**
	 * Gets the list of stars.
	 *
	 * @return the list of stars
	 */
	/*public List<Health> getStars() {
		return this.Stars;
	}*/
	
	/**
	 * Instantiates a new health handler.
	 */
	public HealthHandler(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * Gets the star at the given index
	 *
	 * @param i the index of the star
	 * @return the star
	 */
	/*public Health getStar(int i){
		return Stars.get(i);
	}*/
	
	/**
	 * Check the health level of the estuary
	 *
	 * @param health the health
	 * @return the int health status of the estuary
	 */
	public int check(int health){
		if(health <= 0){
			return 0;
		}else if(health <=50){
			return 1;
		}else if(health < 100){
			return 2;
		}else if(health < 150){
			return 3;
		}else if(health < 200){
			return 4;
		}else
			return 5;
	}
}