package controller;

public class PoplulationControl {
	
	/*
	 * The total population of plants to be dependent on the number of animals
	 * The total population of animals is limited by the number of plants both upper and lower bounds
	 * TotalPlant = NonInvasive + 0.8*Invasive - TotalAnimal //Invasive plants take up 'less room' so more can be there
	 * TotalAnimal = (-1/36)TotalPlant^2 + (35/18)*TotalPlant - 325/36 // used mathematica to solve a system so at 35 plants we peak at 25 animals
	 * 		the numbers can and probably will be adjusted so the screen isn't over crowded, remmber this compounds as animals decrease effective 'total plant'
	 * TotalAnimal = NonInvasive + 1.4*Invasive //this is the identity for the division of the Animals
	 * 
	 * I also want it to be more likely to spawn an Invasive species. This can be population dependent if we wish.
	 */
	private int TotalPlant;
	private int TotalAnimal;
	private int NonInvasivePlant;
	private int InvasivePlant;
	private int NonInvasiveAnimal;
	private int InvasiveAnimal;
	
	public void calculate(){
		int NIP = 0; //current noninvasive plant
		int IP = 0; //current invasive plant
		int NIA = 0 ;//current noninvasive animal
		int IA = 0; //current invasive animal
		int TP = NIP + IP;
		int TA = NIA + IA;
		TotalPlant = (int) (NonInvasivePlant + 0.8*InvasivePlant);
		TotalAnimal = (int) ((-1/36)*TotalPlant + (35/18)*TotalPlant - 325/36);
		InvasiveAnimal = (int) ((TotalAnimal - NonInvasiveAnimal)/1.4);
		NonInvasiveAnimal = (int) TotalAnimal - InvasiveAnimal;
		
		
	}
	
	public void spawn(){
		
	}

}
