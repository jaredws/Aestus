package controller;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BlueCrabHandler;
import model.CordGrassHandler;
import model.CrabHandler;
import model.HealthHandler;
import model.PhragmitesHandler;
import model.PollutionHandler;
import model.PopulationHandler;
import model.TurtleHandler;
import view.ToolView;
import view.TotalView;

public class ScreenControlTest {

	static Game G;
	static Robot r;
	static Dimension screenSize;
	static ScreenControl SC;
	static ToolView TLV;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r = new Robot();
		G = new Game(true);
		SC = new ScreenControl();
		Game.TV = new TotalView(SC);
		Game.CH = new CrabHandler();
		Game.TH = new TurtleHandler();
		Game.BCH = new BlueCrabHandler();
		Game.CGH = new CordGrassHandler();
		Game.PH = new PhragmitesHandler();
		Game.TLC = new ToolControl(10, 10);
		Game.PolH = new PollutionHandler();
		Game.PopH = new PopulationHandler(G);
		Game.HH = new HealthHandler();
		Game.CDC = new CountdownControl();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		TLV = new ToolView(); 
		Game.TV.update(G);
		Game.TV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		G = null;
		r = null;
		TLV = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Explores each function of the Main Menu to make sure it's functioning correctly
	 */
	@Test
	public void mainMenuTest() {
		//SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.update(G);
		Game.TV.repaint();
		r.mouseMove(200, 400);
		int x = 0;
		while(x < 100) {
			if(x==10) {
				for (int i=0; i<100; i++){  
				    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
				    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
				    r.mouseMove(mov_x,mov_y);
				    r.delay(10);
				}
				//r.mouseMove(Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2,Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2);
			} else if(x==20) {
				for (int i=0; i<100; i++){  
				    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
				    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
				    r.mouseMove(mov_x,mov_y);
				    r.delay(10);
				}
				//r.mouseMove(Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2,Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2);
			}
			if(x % 10 == 0) {
				r.mousePress(1024);
				r.delay(100);
				r.mouseRelease(1024);
			}
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			if(x==10||x==20){
				for (int i=0; i<100; i++){  
				    int mov_x = ((200 * i)/100) + (Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2*(100-i)/100);
				    int mov_y = ((400 * i)/100) + (Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2*(100-i)/100);
				    r.mouseMove(mov_x,mov_y);
				    r.delay(10);
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			if(x==10) assertTrue("MagGlass should be true",SC.getMagGlass());
			else if(x==20) assertFalse("MagGlass should be false",SC.getMagGlass());
			x++;
			
		}
	}
}
