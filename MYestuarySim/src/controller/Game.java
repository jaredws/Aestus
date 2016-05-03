package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.Background;
import view.StartingView;
import view.TotalView;

public class Game {
	Random rand = new Random();
	static Random r = new Random();
	static StartingView SV;
	static CrabControl CC;
	static TurtleControl TC;
	static BlueCrabControl BCC;
	static ButtonControl BC;
	static TotalView TV;
	static PopulationControl PopC;
	static CordGrassControl CGC;
	static PhragmitesControl PC;
	static HealthControl HC;

	
	public static void main(String[] args){
		Game G = new Game();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//ugh
		ScreenButtonStart s = new ScreenButtonStart();
		SV = new StartingView(s);
		SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		while(SV.Showing){
			SV.checkStart();
			SV.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
		ScreenButton S = new ScreenButton();
		TV = new TotalView(S);
		CC = new CrabControl();
		BC = new ButtonControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		TC = new TurtleControl();
		BCC = new BlueCrabControl();
		PopC = new PopulationControl();
		PC = new PhragmitesControl();
		CGC = new CordGrassControl();
		HC = new HealthControl();
		TV.update(G);
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		SV.dispose(); 
		for(int i = 0; i<3; i++){
			PC.addPhragmites(300+100*i,200);
			CGC.addCordGrass(200,300-100*i);
		}
		CC.addCrab(200,200);
		CC.addCrab(200,300);
		BCC.addBlueCrab(200, 100);
		/**
		 * Create a timerTask for updating the population.
		 * Since the population will naturally correct itself, we want to delay that to allow the player
		 * to mess with the estuary and see the effects.
		 */
		Timer timer = new Timer();
		class updatePopulation extends TimerTask {
			public void run() {
				if(!S.pause){
				PopC.update(G);
				}
			}
		}
		class moveObjects extends TimerTask{
			public void run(){
				if(!S.pause){
				CC.moveCrabs();
				TC.moveTurtles();
				BCC.moveBlueCrabs();
				PC.age();
				CGC.age();
			}
			}
		}
		timer.scheduleAtFixedRate(new updatePopulation(), 0,3500);//every 3 seconds
		timer.scheduleAtFixedRate(new moveObjects(), 0, 50);//every 50 milliseconds
		
		TV.repaint();
		while(true){
			//We can later compile all the CC. and s. stuff into a CC.tick() function
			//Population control needs to know a tick rate for spawning
			//CC.clickAddCrab(S);
			//TC.clickAddTurtle(S);
			//BCC.clickAddBlueCrab(S);
			//PC.clickAddPhragmites(S);
			//CGC.clickAddCordGrass(S);
			S.checkPos(CC,TC,BCC,CGC,PC,BC);
			TV.update(G);
			TV.repaint();
			if(S.pause) continue;
			CC.deleteCrabs(BC);
			TC.deleteTurtles(BC);
			BCC.deleteBlueCrabs(BC);
			CGC.deleteCordGrass(BC);
			PC.deletePhragmites(BC);
			//PopC.update(G);
			
			try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
	}

	public Random getRand() {
		return rand;
	}


	public static CrabControl getCrabControl() {
		return CC;
	}

	public static ButtonControl getButtonControl() {
		return BC;
	}

	public static TotalView getTotalView() {
		return TV;
	}
	
	public static TurtleControl getTurtleControl() {
		return TC;
	}
	
	public static BlueCrabControl getBlueCrabControl() {
		return BCC;
	}
	
	public static PhragmitesControl getPhragmitesControl(){
		return PC;
	}
	
	public static CordGrassControl getCordGrassControl(){
		return CGC;
	}
	
	public static HealthControl getHealthControl(){
		return HC;
	}
	
	public int calculateHealth(){
		int c,bc,t,p,cg;
		c = 2*CC.getCrabs().size();
		bc = 2*BCC.getBlueCrabs().size();
		t = TC.getTurtles().size();
		p = PC.getPhragmites().size();
		cg = CGC.getCordGrass().size();
		return (bc+t+cg-p-c);
	}
}

