package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import model.Background;
import view.TotalView;

public class Game {
	Random rand = new Random();
	static CrabControl CC;
	static ButtonControl BC;
	static TotalView TV;


	
	public static void main(String[] args){
		Game G = new Game();
		ScreenButton S = new ScreenButton();
		TV = new TotalView(S);
		CC = new CrabControl();
		BC = new ButtonControl();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
//		CC.addCrab(600, 600);
//		CC.addCrab(200, 400);
//		CC.addCrab(700, 500);
//		CC.addCrab(400, 400);

		while(true){
			//We can later compile all the CC. and s. stuff into a CC.tick() function
			CC.clickAddCrab(S);
			S.checkPos(CC);
			CC.moveCrabs();
			CC.deleteCrabs(BC);
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
	
}
