package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.Random;

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

	
	public static void main(String[] args){
		Game G = new Game();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
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
		BC = new ButtonControl();
		TC = new TurtleControl();
		BCC = new BlueCrabControl();
		PopC = new PopulationControl();
		PC = new PhragmitesControl();
		CGC = new CordGrassControl();
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		SV.dispose(); 
		for(int i = 0; i<5; i++){
			int k = r.nextInt(1350);
			int l = r.nextInt(300)+500;
			PC.addPhragmites(k,l);
		}
		


		
		while(true){
			//We can later compile all the CC. and s. stuff into a CC.tick() function
			//Population control needs to know a tick rate for spawning
			CC.clickAddCrab(S);
			TC.clickAddTurtle(S);
			BCC.clickAddBlueCrab(S);
			S.checkPos(CC,TC,BCC,CGC,PC);
			CC.moveCrabs();
			TC.moveTurtles();
			BCC.moveBlueCrabs();
			CC.deleteCrabs(BC);
			TC.deleteTurtles(BC);
			BCC.deleteBlueCrabs(BC);
			CGC.deleteCordGrass(BC);
			PC.deletePhragmites(BC);
			PopC.update(G);
			TV.update(G);
			TV.repaint();
			try {
    			Thread.sleep(50);
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
}

