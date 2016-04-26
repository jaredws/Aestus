package controller;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * @author Steven
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Turtle;

public class TurtleControl {
	Random rand;
	List<Turtle> turtles;

	public void addTurtle(int x, int y){
		turtles.add(new Turtle(x,y));
	}
	
	public List<Turtle> getTurtles() {
		return this.turtles;
	}
	
	public TurtleControl(){
		rand  = new Random();
		turtles = new ArrayList<Turtle>();
	}
	
	public void moveTurtles(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int j = 0;
		for(int i = 0; i < turtles.size(); i++){
			if(turtles.get(i).getX() >= screenSize.getWidth() || turtles.get(i).getY() >= screenSize.getHeight() || turtles.get(i).getX()<=0 || turtles.get(i).getY()<=0){
				continue;
			}
			j = rand.nextInt();
			if(j%20==4){
				turtles.get(i).setX(turtles.get(i).getX() + j%10*(rand.nextInt()%2));
			}
			if(j%20==-4){
				turtles.get(i).setY(turtles.get(i).getY() + j%10*(rand.nextInt()%2));
			}
		}
	}
	
	public void deleteTurtles(ButtonControl bc){
		for(int i = 0; i < turtles.size(); i++){
			if(turtles.get(i).getX() > bc.getButtons().get(0).getX() - bc.getButtons().get(0).getSizeX()/2 && turtles.get(i).getX() < bc.getButtons().get(0).getX() + bc.getButtons().get(0).getSizeX()/4){
				if((turtles.get(i).getY() > bc.getButtons().get(0).getY()-bc.getButtons().get(0).getSizeY()) && (turtles.get(i).getY() < bc.getButtons().get(0).getY() + bc.getButtons().get(0).getSizeY()/2)){
					turtles.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddTurtle(ScreenButton s){

		if(s.clickx > 0 && s.addTurtle){
			addTurtle(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addTurtle = false;
		}
	}
	
	protected void removeTurtle(int i){
		turtles.remove(i);
	}
}
