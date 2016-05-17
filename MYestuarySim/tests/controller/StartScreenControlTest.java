package controller;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

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
import view.BackgroundView;
import view.StartingView;
import view.TotalView;

public class StartScreenControlTest {

	static Game G;
	static Robot r;
	static Dimension screenSize;
	static StartScreenControl s;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r = new Robot();
		G = new Game(true);
		//G.start(G);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		s = new StartScreenControl();
		Game.SV = new StartingView(s);
		Game.SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		G = null;
		r = null;
	}

	@Test
	public void clickPlayTest() {
		int x = 0;
		while(s.getShowing() && x < 1000) {
			s.check();
			Game.SV.update(G);
			r.mouseMove(StartingView.getPlayX()+StartingView.getPlay().getWidth(null)/2,StartingView.getPlayY()+StartingView.getPlay().getHeight(null)/2);
			r.mousePress(1024);
			r.mouseRelease(1024);
			x++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		assertFalse("Showing should be false",s.getShowing());
	}
}
