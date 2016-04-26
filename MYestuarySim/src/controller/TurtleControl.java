package controller;

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
		for(int i = 0; i < turtles.size(); i++){
			if(rand.nextInt()%25 == 4){
				turtles.get(i).setX(turtles.get(i).getX() + rand.nextInt()%8 - 3);
				turtles.get(i).setY(turtles.get(i).getY() + rand.nextInt()%8 - 3);
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
}
