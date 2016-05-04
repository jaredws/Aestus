package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

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
	
	private int TotalPlant;
	private int TotalAnimal;
	private int NonInvasivePlant;
	private int InvasivePlant;
	private int NonInvasiveAnimal;
	private int InvasiveAnimal;
	private int Pollution;
	private Game game;
	Random rand;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public int makeX(){
		return rand.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12;
	}
	public int makeY(){
		return rand.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12;
	}
	
	public void calculate(){
		NIP = game.getCordGrassControl().getCordGrass().size(); //calculate current noninvasive plant
		IP = game.getPhragmitesControl().getPhragmites().size(); //calculate current invasive plant
		NIA = game.getTurtleControl().getTurtles().size() + game.getBlueCrabControl().getBlueCrabs().size();//calculate current noninvasive animal
		IA = game.getCrabControl().getCrabs().size(); //calculate current invasive animal
		//P=game.getPollutionControl().getPollution().size();
		TP = NIP + IP;
		TA = NIA + IA;
		NonInvasivePlant = NIP;
		InvasivePlant = IP;
		NonInvasiveAnimal = NIA;
		TotalAnimal = TA;
		//make plants a set max always approaching it
		TotalPlant = 50; //-P; // - 2*TrashCount;
		//TotalPlant = (int) (2*NonInvasivePlant + 1.5*InvasivePlant - TotalAnimal);
		TotalAnimal = (int) ((-15/289)*Math.pow(TP,2) + (600/289)*TP - (1665/289));//0 animals at 3 plants, 15 at a net 20
		InvasiveAnimal = (int) ((TotalAnimal - NonInvasiveAnimal));//some of these lines may not be necessary
		NonInvasiveAnimal = (int) TotalAnimal - InvasiveAnimal;//all are included for my train of thought -JS
		System.out.println("Max Total Animals: "+TotalAnimal);
		System.out.println("Native Plant: "+NIP+"   Invasive Plant: "+IP);
		System.out.println("Native Animals: "+NIA+"  Invasive Crabs: "+IA);
		System.out.println("Turtles: "+game.getTurtleControl().getTurtles().size()+"     BlueCrabs: "+game.getBlueCrabControl().getBlueCrabs().size());
		spawn();
		
	}
	
	public void update(Game g){
		game = g;
		calculate();
	}
	
	private void spawn(){//call calculate and spawn at appropriate intervals
		rand = new Random();
		if(TotalPlant>TP){
			if(rand.nextInt(8)%3==0){//8%3 will be replaced with a probability factor that will be chagned when research happens.
				game.getCordGrassControl().addCordGrass(makeX(),makeY());
			}
			else{
				game.getPhragmitesControl().addPhragmites(makeX(),makeY());
				}
		}
		if(TotalPlant<TP){
				if(rand.nextInt(2)%2==0){
					try{game.getCordGrassControl().removeCordGrass(0);}catch(IndexOutOfBoundsException ex){}
				}
				else{
					try{game.getPhragmitesControl().removePhragmites(0);}catch(IndexOutOfBoundsException ex){}
				}
		}
		if(TotalAnimal>TA){
			if(rand.nextInt(8)%3==0){//3/8 probability of spawning non invasive
				if(rand.nextInt(8)%2==0){//3/8ths probability of adding a turtle
					game.getTurtleControl().addTurtle(makeX(),makeY());
				}
				else{//add a non-invasive
					game.getBlueCrabControl().addBlueCrab(makeX(),makeY());
				}
			}
			else{
				game.getCrabControl().addCrab(makeX(),makeY());				}
		}
		if(TotalAnimal<TA){
			if(rand.nextInt(2)%2==0){
				if(rand.nextInt(8)%2==0){//3/8ths probability of removing a turtle
					try{game.getTurtleControl().removeTurtle(0);}catch(IndexOutOfBoundsException ex){}
				}
				else{//remove a non-invasive
					try{game.getBlueCrabControl().removeBlueCrab(0);}catch(IndexOutOfBoundsException ex){}
				}
			}
			else{//remove an invasive
				try{game.getCrabControl().removeCrab(0);}catch(IndexOutOfBoundsException ex){}
			}
		}
	}

}