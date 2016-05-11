package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import controller.Game;

public class PopulationControl {
	
	/*
	 * The total population of plants to be dependent on the number of animals
	 * The total population of animals is limited by the number of plants both upper and lower bounds
	 * TotalPlant = NonInvasive + 0.8*Invasive//Invasive plants take up 'less room' so more can be there
	 * TotalAnimal = (-1/36)TotalPlant^2 + (35/18)*TotalPlant - 325/36 // used mathematica to solve a system so at 35 plants we peak at 25 animals
	 * 		the numbers can and probably will be adjusted so the screen isn't over crowded, remmber this compounds as animals decrease effective 'total plant'
	 * TotalAnimal = NonInvasive + 1.4*Invasive //this is the identity for the division of the Animals
	 * 
	 * I also want it to be more likely to spawn an Invasive species. This can be population dependent if we wish.
	 */
	
	int NIP; //current noninvasive plant
	int IP; //current invasive plant
	int NIA;//current noninvasive animal
	int IA; //current invasive animal
	int TP; //current total plants
	int TA; //current total animals
	int P; //current total pollution
	
	int CordGrassDied;
	int PhragmitesDied;
	int TurtleDied;
	int BlueCrabDied;
	int MittenCrabDied;
	
	private int TotalPlant;
	private double TotalAnimal;
	private int NonInvasivePlant;
	private int InvasivePlant;
	private int NonInvasiveAnimal;
	private int InvasiveAnimal;
	private int Pollution;
	private Game game;
	Random rand;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public PopulationControl(Game g){
		this.game = g;
		this.BlueCrabDied = 0;
		this.CordGrassDied = 0;
		this.PhragmitesDied = 0;
		this.TurtleDied = 0;
		this.MittenCrabDied = 0;
	}
	
	
	public int makeX(){
		return rand.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12;
	}
	public int makeY(){
		return rand.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12;
	}
	
	public void calculate(){
		NIP = Game.getCordGrassControl().getCordGrass().size(); //calculate current noninvasive plant
		IP = Game.getPhragmitesControl().getPhragmites().size(); //calculate current invasive plant
		NIA = Game.getTurtleControl().getTurtles().size() + Game.getBlueCrabControl().getBlueCrabs().size();//calculate current noninvasive animal
		IA = Game.getCrabControl().getCrabs().size(); //calculate current invasive animal
		P=Game.getPollutionControl().getPollutionSize();
		TP = NIP + IP;
		TA = NIA + IA;
		NonInvasivePlant = NIP;
		InvasivePlant = IP;
		NonInvasiveAnimal = NIA;
		TotalAnimal = TA;
		//make plants a set max always approaching it
		TotalPlant = 35 - 2*P; // - 2*TrashCount;
		//TotalPlant = (int) (2*NonInvasivePlant + 1.5*InvasivePlant - TotalAnimal);
		TotalAnimal = (int) totAnimal();//((-9/115)*Math.pow(TP,2) + (357/115)*TP - (294/115) - P);//0 animals at 3 plants, 15 at a net 20
		InvasiveAnimal = (int) ((TotalAnimal - NonInvasiveAnimal));//some of these lines may not be necessary
		NonInvasiveAnimal = (int) TotalAnimal - InvasiveAnimal;//all are included for my train of thought -JS
//		System.out.println("Max Total Animals: "+TotalAnimal);
//		System.out.println("Native Plant: "+NIP+"   Invasive Plant: "+IP);
//		System.out.println("Native Animals: "+NIA+"  Invasive Crabs: "+IA);
//		System.out.println("Turtles: "+Game.getTurtleControl().getTurtles().size()+"     BlueCrabs: "+Game.getBlueCrabControl().getBlueCrabs().size());	
	}
/**
 * a, b, and c are the coefficients for the quadratic relationship between plants and animals
 * ax^2 + bx + c
 * a must be negative to have a downward parabolic shape
 * This means that as plants over populate, animals will run out of room
 * @return
 */
	public double totAnimal(){
		double a = -0.08;
		double b = 3.2;
		double c = -14;
		return (a*TP*TP+b*TP+c);
	}
	/**
	 * Update the population limits
	 * Spawn species within the limits
	 *
	 * @param g- the updated Game
	 * gives access to all the controllers
	 */ 
	public void update(Game g){
		game = g;
		//Call calculate to adjust the maximum allowed species
		calculate();
		//Spawn within the calculations
		spawn();
	}
	
	/**
	 * Depending on how much Research has been done, the probability of spawing creatures changes
	 * Before any research: Invasives spawn 3/4 of the time
	 * After the first research in competing species: invasives spawn 1/2 of the time
	 * Once both species have been researched: invasives spawn 3/8 of the time
	 * 
	 * Turtles are a 'prize' of the game
	 * Initial spawn: 1/6
	 * Researched: 1/4
	 * 
	 */
	
	private void spawn(){//call calculate and spawn at appropriate intervals
		rand = new Random();
		if(TotalPlant>TP){
			//If neither has been Researched
			if(!(game.getPhragmitesControl().isResearched()) && !(game.getCordGrassControl().isResearched())){
				if(rand.nextInt(4)%4==0){//1/4 probability of adding Non-Invasive
					Game.getCordGrassControl().addCordGrass(makeX(), makeY());
				}
				else{//3/4ths probability of add Invasive
					Game.getPhragmitesControl().addPhragmites(makeX(), makeY());
				}

			}
			//If both have been researched
			else if(game.getPhragmitesControl().isResearched() &&  (game.getCordGrassControl().isResearched())){
				if(rand.nextInt(8)%3==0){//3/8 probability of adding Invasive
					Game.getPhragmitesControl().addPhragmites(makeX(), makeY());
				}
				else{// 5/8th probability of adding Non invasive
					Game.getCordGrassControl().addCordGrass(makeX(), makeY());
				}
			}
			else{//If either has been researched
				if(rand.nextInt(2)%2==0){// 1/2 probability of adding Non-Invasive 
					Game.getCordGrassControl().addCordGrass(makeX(), makeY());
				}
				else{// 1/2 probability of adding Invasive
					Game.getPhragmitesControl().addPhragmites(makeX(), makeY());
				}
			}
		}
		if(TotalPlant<TP){
				if(rand.nextInt(8)%3==0){//3/8 probability of removing invasive 
					try{Game.getPhragmitesControl().removePhragmites(0);PhragmitesDied++;}catch(IndexOutOfBoundsException ex){}
				}
				else{
					try{Game.getCordGrassControl().removeCordGrass(0);CordGrassDied++;}catch(IndexOutOfBoundsException ex){}
				}
		}
		//When there is room for more animals
		//By the implementation of the Turtle and Crab Species spawning
		// there is a slight chance of increasing the population too much
		// but the handler will remove the extra animal(s) below
		if(TotalAnimal>TA){
			//Turtles spawn independently of the crabs
			if(Game.getTurtleControl().isResearched()){//If turtles have been researched
				if((rand.nextInt(4))%4==0){//1/4th probability of spawning a turtle
						Game.getTurtleControl().addTurtle(makeX(),makeY());
				}
			}
			else{
				if((rand.nextInt(6))%6==0){// 1/6 probability of spawning a turtle
					Game.getTurtleControl().addTurtle(makeX(), makeY());
				}
			}
			//Neither Crab species is researched
			if(!(Game.getBlueCrabControl().isResearched()) && !(Game.getCrabControl().isResearched())){
				if(rand.nextInt(4)%4==0){//1/4 probability of spawning non invasive crab
						Game.getBlueCrabControl().addBlueCrab(makeX(),makeY());
				}
				else{// 3/4 th probability of adding an invasive crab
					Game.getCrabControl().addCrab(makeX(),makeY());
				}
			}
			//Both Crab species are researched
			else if(Game.getBlueCrabControl().isResearched() && Game.getCrabControl().isResearched()){
				if(rand.nextInt(8)%3==0){//  3/8th probability of adding Invasive
					Game.getCrabControl().addCrab(makeX(),makeY());
				}
				else{// 5/8th probability of adding Non invasive
					Game.getBlueCrabControl().addBlueCrab(makeX(),makeY());
				}
			}
			//Either has crab been researched
			else{//If either has been researched
				if(rand.nextInt(2)%2==0){// 1/2 probability of adding Non-Invasive 
					Game.getBlueCrabControl().addBlueCrab(makeX(),makeY());
				}
				else{// 1/2 probability of adding Invasive
					Game.getCrabControl().addCrab(makeX(),makeY());	
				}
			}
		}
		if(TotalAnimal<TA){
			if(rand.nextInt(8)%3==0){// 3/8th probability to remove an invasive
				try{Game.getCrabControl().removeCrab(0);MittenCrabDied++;}catch(IndexOutOfBoundsException ex){}
			}
			else{// 5/8th probability of removing an non invasive
				if(rand.nextInt(8)%2==0){//3/8th probability of removing a crab
					try{Game.getBlueCrabControl().removeBlueCrab(0);BlueCrabDied++;}catch(IndexOutOfBoundsException ex){}
				}
				else{// 5/8th probability to remove a turtle
					try{Game.getTurtleControl().removeTurtle(0);TurtleDied++;}catch(IndexOutOfBoundsException ex){}
				}
				
			}
		}
	}
	public int getTotalPlant() {
		return TotalPlant;
	}
	public double getTotalAnimal() {
		return TotalAnimal;
	}
	public int getNonInvasivePlant() {
		return NonInvasivePlant;
	}
	public int getInvasivePlant() {
		return InvasivePlant;
	}
	public int getNonInvasiveAnimal() {
		return NonInvasiveAnimal;
	}
	public int getInvasiveAnimal() {
		return InvasiveAnimal;
	}
	public int getPollution() {
		return Pollution;
	}
	public int getMittenDie() {
		return this.MittenCrabDied;
	}
	public int getBlueCrabDie() {
		return this.BlueCrabDied;
	}
	public int getTurtleDie() {
		return this.TurtleDied;
	}
	public int getPhragDie() {
		return this.PhragmitesDied;
	}
	public int getCordDie() {
		return this.CordGrassDied;
	}

}