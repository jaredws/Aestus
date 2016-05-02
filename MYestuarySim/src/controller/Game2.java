package controller;

import view.StartingView;
import view.TotalView;

public class Game2 {

	//implementing the combined ViewAll and ControlObjects classes
	
	ScreenButton sB;
	PopulationControl PopC;
	TotalView TV;
	StartingView SV;
	
	private Game2(){
		sB = new ScreenButton();
		PopC = new PopulationControl();
		TV = new TotalView(sB);
		//SV = new StartingView();
	}
	public static void main(String[] args) {
		Game2 G = new Game2();

	}

}
