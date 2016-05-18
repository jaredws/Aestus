package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import controller.Game;

/**
 * The Class PopulationHandler.
 * @author Team 0
 */
public class PopulationHandler {
	
	/*Non-java doc Comment
	 * The total population of plants to be dependent on the number of animals
	 * The total population of animals is limited by the number of plants both upper and lower bounds
	 * TotalPlant = NonInvasive + 0.8*Invasive//Invasive plants take up 'less room' so more can be there
	 * TotalAnimal = (-1/36)TotalPlant^2 + (35/18)*TotalPlant - 325/36 // used mathematica to solve a system so at 35 plants we peak at 25 animals
	 */
	
	/** The nip. */
	private int NIP; //current noninvasive plant
	
	/** The ip. */
	private int IP; //current invasive plant
	
	/** The nia. */
	private int NIA;//current noninvasive animal
	
	/** The ia. */
	private int IA; //current invasive animal
	
	/** The tp. */
	private int TP; //current total plants
	
	/** The ta. */
	private int TA; //current total animals
	
	/** The p. */
	private int P; //current total pollution
	
	/** The Cord grass died. */
	private int CordGrassDied;
	
	/** The Phragmites died. */
	private int PhragmitesDied;
	
	/** The Turtle died. */
	private int TurtleDied;
	
	/** The Blue crab died. */
	private int BlueCrabDied;
	
	/** The Mitten crab died. */
	private int MittenCrabDied;
	
	/** The Total plant. */
	private int TotalPlant;
	
	/** The Total animal. */
	private double TotalAnimal;
	
	/** The Non invasive plant. */
	private int NonInvasivePlant;
	
	/** The Invasive plant. */
	private int InvasivePlant;	
	
	/** The Non invasive animal. */
	private int NonInvasiveAnimal;
	
	/** The Invasive animal. */
	private int InvasiveAnimal;
	
	/** The Pollution. */
	private int Pollution;
	
	/** The game. */
	private Game game;
	
	/** The rand. */
	Random rand;
	
	/** The screen size. */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * Instantiates a new population handler.
	 *
	 * @param g the g
	 */
	public PopulationHandler(Game g){
		this.game = g;
		this.BlueCrabDied = 0;
		this.CordGrassDied = 0;
		this.PhragmitesDied = 0;
		this.TurtleDied = 0;
		this.MittenCrabDied = 0;
		rand = new Random();
	}
	
	/**
	 * Make x.
	 *
	 * @return the int
	 */
	public int makeX(){
		return rand.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12;
	}
	
	/**
	 * Make y.
	 *
	 * @return the int
	 */
	public int makeY(){
		return rand.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12;
	}
	
	/**
	 * Calculate the maximum capacity of the ecosystem.
	 * The number of animals is dependent upon the number of plants less the pollution.
	 */
	public void calculate(){
		if(!game.getTesting()){
			NIP = Game.getCordGrassHandler().getCordGrass().size(); //calculate current noninvasive plant
			IP = Game.getPhragmitesHandler().getPhragmites().size(); //calculate current invasive plant
			NIA = Game.getTurtleHandler().getTurtles().size() + Game.getBlueCrabHandler().getBlueCrabs().size();//calculate current noninvasive animal
			IA = Game.getCrabHandler().getCrabs().size(); //calculate current invasive animal
			P=Game.getPollutionHandler().getPollutionSize();
		}
		TP = NIP + IP;
		TA = NIA + IA;
		NonInvasivePlant = NIP;
		InvasivePlant = IP;
		NonInvasiveAnimal = NIA;
		TotalAnimal = TA;
		//make plants a set max always approaching it minus the amount of pollution
		TotalPlant = 20 - P; // - 2*PollutionCount;
		TotalAnimal = (int) maxAnimal();//0 animals at 5 plants max animals at 20 plants
		InvasiveAnimal = (int) ((TotalAnimal - NonInvasiveAnimal));
		NonInvasiveAnimal = (int) TotalAnimal - InvasiveAnimal;
	}

/**
 * a, b, and c are the coefficients for the quadratic relationship between plants and animals
 * ax^2 + bx + c
 * a must be negative to have a downward parabolic shape
 * This will cause animals to die off as plants over crowd their space.
 *
 * @return the double
 */
	public double maxAnimal(){
		double a = -0.08;
		double b = 3.2;
		double c = -14;
		return (a*TP*TP+b*TP+c);
	}
	
	/**
	 * Update the population limits
	 * Spawn species within the limits.
	 *
	 * @param g the g
	 */ 
	public void update(Game g){
		game = g;
		//Call calculate to adjust the maximum allowed species
		calculate();
		//Spawn within the calculations
		spawn();
	}
	
	/**
	 * Spawn test.
	 */
	public void spawnTest() {
		if(game.getTesting()) spawn();
	}
	
	/**
	 * Depending on how much Research has been done, the probability of spawning creatures changes
	 * Before any research: Invasives spawn 3/4 of the time
	 * After the first research in competing species: invasives spawn 1/2 of the time
	 * Once both species have been researched: invasives spawn 3/8 of the time
	 * 
	 * Turtles are a 'prize' of the game
	 * Initial spawn: 1/6
	 * Researched: 1/4.
	 */
	
	private void spawn(){//call calculate and spawn at appropriate intervals
		rand = new Random();
		if(TotalPlant>TP){
			//If neither has been Researched
			if(!(Game.getPhragmitesHandler().isResearched()) && !(Game.getCordGrassHandler().isResearched())){
				if(rand.nextInt(4)%4==0){//1/4 probability of adding Non-Invasive
					Game.getCordGrassHandler().addCordGrass(makeX(), makeY());
				}
				else{//3/4ths probability of add Invasive
					Game.getPhragmitesHandler().addPhragmites(makeX(), makeY());
				}

			}
			//If both have been researched
			else if(Game.getPhragmitesHandler().isResearched() &&  (Game.getCordGrassHandler().isResearched())){
				if(rand.nextInt(8)%3==0){//3/8 probability of adding Invasive
					Game.getPhragmitesHandler().addPhragmites(makeX(), makeY());
				}
				else{// 5/8th probability of adding Non invasive
					Game.getCordGrassHandler().addCordGrass(makeX(), makeY());
				}
			}
			else{//If either has been researched
				if(rand.nextInt(2)%2==0){// 1/2 probability of adding Non-Invasive 
					Game.getCordGrassHandler().addCordGrass(makeX(), makeY());
				}
				else{// 1/2 probability of adding Invasive
					Game.getPhragmitesHandler().addPhragmites(makeX(), makeY());
				}
			}
		}
		if(TotalPlant<TP){
				if(rand.nextInt(8)%3==0){//3/8 probability of removing invasive 
					try{Game.getPhragmitesHandler().removePhragmites(0);PhragmitesDied++;}catch(IndexOutOfBoundsException ex){}
				}
				else{
					try{Game.getCordGrassHandler().removeCordGrass(0);CordGrassDied++;}catch(IndexOutOfBoundsException ex){}
				}
		}
		//When there is room for more animals
		//By the implementation of the Turtle and Crab Species spawning
		// there is a slight chance of increasing the population too much
		// but the handler will remove the extra animal(s) below
		if(TotalAnimal>TA){
			//Turtles spawn independently of the crabs
			if(Game.getTurtleHandler().isResearched()){//If turtles have been researched
				if((rand.nextInt(4))%4==0){//1/4th probability of spawning a turtle
					Game.getTurtleHandler().addTurtle(makeX(),makeY());
				}
			}
			else{
				if((rand.nextInt(6))%6==0){// 1/6 probability of spawning a turtle
					Game.getTurtleHandler().addTurtle(makeX(), makeY());
				}
			}
			//Neither Crab species is researched
			if(!(Game.getBlueCrabHandler().isResearched()) && !(Game.getCrabHandler().isResearched())){
				if(rand.nextInt(4)%4==0){//1/4 probability of spawning non invasive crab
					Game.getBlueCrabHandler().addBlueCrab(makeX(),makeY());
				}
				else{// 3/4 th probability of adding an invasive crab
					Game.getCrabHandler().addCrab(makeX(),makeY());
				}
			}
			//Both Crab species are researched
			else if(Game.getBlueCrabHandler().isResearched() && Game.getCrabHandler().isResearched()){
				if(rand.nextInt(8)%3==0){//  3/8th probability of adding Invasive
					Game.getCrabHandler().addCrab(makeX(),makeY());
				}
				else{// 5/8th probability of adding Non invasive
					Game.getBlueCrabHandler().addBlueCrab(makeX(),makeY());
				}
			}
			//Either has crab been researched
			else{//If either has been researched
				if(rand.nextInt(2)%2==0){// 1/2 probability of adding Non-Invasive 
					Game.getBlueCrabHandler().addBlueCrab(makeX(),makeY());
				}
				else{// 1/2 probability of adding Invasive
					Game.getCrabHandler().addCrab(makeX(),makeY());	
				}
			}
		}
		if(TotalAnimal<TA){
			if(rand.nextInt(8)%3==0){// 3/8th probability to remove an invasive
				try{Game.getCrabHandler().removeCrab(0);MittenCrabDied++;}catch(IndexOutOfBoundsException ex){}
			}
			else{// 5/8th probability of removing an non invasive
				if(rand.nextInt(8)%2==0){//3/8th probability of removing a crab
					try{Game.getBlueCrabHandler().removeBlueCrab(0);BlueCrabDied++;}catch(IndexOutOfBoundsException ex){}
				}
				else{// 5/8th probability to remove a turtle
					try{Game.getTurtleHandler().removeTurtle(0);TurtleDied++;}catch(IndexOutOfBoundsException ex){}
				}
				
			}
		}
		if(rand.nextInt(50)==1){
			Game.getPollutionHandler().addPollution(makeX(), makeY());
		}
	}
	
	/**
	 * Gets the total plant.
	 *
	 * @return the total plant
	 */
	public int getTotalPlant() {
		return TotalPlant;
	}
	
	/**
	 * Gets the total animal maximum after calculate().
	 *
	 * @return the total animal
	 */
	public double getTotalAnimal() {
		return TotalAnimal;
	}
	
	/**
	 * Gets the non invasive plant maximum after calculate().
	 *
	 * @return the non invasive plant
	 */
	public int getNonInvasivePlant() {
		return NonInvasivePlant;
	}
	
	/**
	 * Gets the invasive plant maximum after calculate().
	 *
	 * @return the invasive plant
	 */
	public int getInvasivePlant() {
		return InvasivePlant;
	}
	
	/**
	 * Gets the non invasive animal maximum after calculate().
	 *
	 * @return the non invasive animal
	 */
	public int getNonInvasiveAnimal() {
		return NonInvasiveAnimal;
	}
	
	/**
	 * Gets the invasive animal maximum after calculate().
	 *
	 * @return the invasive animal
	 */
	public int getInvasiveAnimal() {
		return InvasiveAnimal;
	}
	
	/**
	 * Gets the pollution maximum after calculate()
	 *
	 * @return the pollution
	 */
	public int getPollution() {
		return Pollution;
	}
	
	/**
	 * Gets the number of mitten crabs died (removed from the game by the population handler).
	 *
	 * @return the mitten die
	 */
	public int getMittenDie() {
		return this.MittenCrabDied;
	}
	
	/**
	 * Gets the number blue crabs died (removed from the game by the population handler).
	 *
	 * @return the blue crab die
	 */
	public int getBlueCrabDie() {
		return this.BlueCrabDied;
	}
	
	/**
	 * Gets the number of turtles died (removed from the game by the population handler).
	 *
	 * @return the turtle die
	 */
	public int getTurtleDie() {
		return this.TurtleDied;
	}
	
	/**
	 * Gets the number of phragmites died (removed from the game by the population handler).
	 *
	 * @return the phrag die
	 */
	public int getPhragDie() {
		return this.PhragmitesDied;
	}
	
	/**
	 * Gets the number of cord grasses died (removed from the game by the population handler).
	 *
	 * @return the cord die
	 */
	public int getCordDie() {
		return this.CordGrassDied;
	}
	
	/**
	 * Gets the number of non-invasive plants in the game currently, after calculate().
	 *
	 * @return the nip
	 */
	public int getNIP() {
		return NIP;
	}
	
	/**
	 * Gets the number of invasive plants in the game currently, after calculate().
	 *
	 * @return the ip
	 */
	public int getIP() {
		return IP;
	}
	
	/**
	 * Gets the number of non-invasive animals in the game currently, after calculate().
	 *
	 * @return the nia
	 */
	public int getNIA() {
		return NIA;
	}
	
	/**
	 * Gets the number of invasive animals in the game currently, after calculate().
	 *
	 * @return the ia
	 */
	public int getIA() {
		return IA;
	}
	
	/**
	 * Gets the number of total plants in the game currently, after calculate().
	 *
	 * @return the tp
	 */
	public int getTP() {
		return TP;
	}
	
	/**
	 * Gets the number of tatal animals in the game currently, after calculate().
	 *
	 * @return the ta
	 */
	public int getTA() {
		return TA;
	}
	
	/**
	 * Gets the number of pollution in the game currently, after calculate().
	 *
	 * @return the p
	 */
	public int getP() {
		return P;
	}
	
	/**
	 * Sets the total plant.
	 *
	 * @param TP the new total plant
	 */
	public void setTotalPlant(int TP) {
		if(game.getTesting())
			TotalPlant = TP;
	}
	
	/**
	 * Sets the total animal.
	 *
	 * @param TA the new total animal
	 */
	public void setTotalAnimal(double TA) {
		if(game.getTesting())
			TotalAnimal = TA;
	}
	
	/**
	 * Sets the non invasive plant.
	 *
	 * @param NIP the new non invasive plant
	 */
	public void setNonInvasivePlant(int NIP) {
		if(game.getTesting())
			NonInvasivePlant = NIP;
	}
	
	/**
	 * Sets the invasive plant.
	 *
	 * @param IP the new invasive plant
	 */
	public void setInvasivePlant(int IP) {
		if(game.getTesting())
			InvasivePlant = IP;
	}
	
	/**
	 * Sets the non invasive animal.
	 *
	 * @param NIA the new non invasive animal
	 */
	public void setNonInvasiveAnimal(int NIA) {
		if(game.getTesting())
			NonInvasiveAnimal = NIA;
	}
	
	/**
	 * Sets the invasive animal.
	 *
	 * @param IA the new invasive animal
	 */
	public void setInvasiveAnimal(int IA) {
		if(game.getTesting())
			InvasiveAnimal = IA;
	}
	
	/**
	 * Sets the pollution.
	 *
	 * @param P the new pollution
	 */
	public void setPollution(int P) {
		if(game.getTesting())
			Pollution = P;
	}
	
	/**
	 * Sets the mitten die.
	 *
	 * @param MCD the new mitten die
	 */
	public void setMittenDie(int MCD) {
		if(game.getTesting())
			MittenCrabDied = MCD;
	}
	
	/**
	 * Sets the blue crab die.
	 *
	 * @param BCD the new blue crab die
	 */
	public void setBlueCrabDie(int BCD) {
		if(game.getTesting())
			BlueCrabDied = BCD;
	}
	
	/**
	 * Sets the turtle die.
	 *
	 * @param TD the new turtle die
	 */
	public void setTurtleDie(int TD) {
		if(game.getTesting())
			TurtleDied = TD;
	}
	
	/**
	 * Sets the phrag die.
	 *
	 * @param PD the new phrag die
	 */
	public void setPhragDie(int PD) {
		if(game.getTesting())
			PhragmitesDied = PD;
	}
	
	/**
	 * Sets the cord die.
	 *
	 * @param CGD the new cord die
	 */
	public void setCordDie(int CGD) {
		if(game.getTesting())
			CordGrassDied = CGD;
	}
	
	/**
	 * Sets the nip.
	 *
	 * @param N the new nip
	 */
	public void setNIP(int N) {
		if(game.getTesting())
			NIP = N;
	}
	
	/**
	 * Sets the ip.
	 *
	 * @param I the new ip
	 */
	public void setIP(int I) {
		if(game.getTesting())
			IP = I;
	}
	
	/**
	 * Sets the nia.
	 *
	 * @param N the new nia
	 */
	public void setNIA(int N) {
		if(game.getTesting())
			NIA = N;
	}
	
	/**
	 * Sets the ia.
	 *
	 * @param I the new ia
	 */
	public void setIA(int I) {
		if(game.getTesting())
			IA = I;
	}
	
	/**
	 * Sets the tp.
	 *
	 * @param T the new tp
	 */
	public void setTP(int T) {
		if(game.getTesting())
			TP = T;
	}
	
	/**
	 * Sets the ta.
	 *
	 * @param T the new ta
	 */
	public void setTA(int T) {
		if(game.getTesting())
			TA = T;
	}
	
	/**
	 * Sets the p.
	 *
	 * @param p the new p
	 */
	public void setP(int p) {
		if(game.getTesting())
			P = p;
	}

}