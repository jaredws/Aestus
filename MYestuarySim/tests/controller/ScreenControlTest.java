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
import view.TotalView;

public class ScreenControlTest {

	static CrabHandler CC;
	static TurtleHandler TTC;
	static BlueCrabHandler BC;
	static CordGrassHandler CGC;
	static PhragmitesHandler PC;
	static ToolControl TC;
	static PollutionHandler POC;
	static ScreenControl SC;
	static Robot r;
	static TotalView TV;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		SC = new ScreenControl();
		TV = new TotalView(SC);
		CC = new CrabHandler();
		PopulationHandler PopH = new PopulationHandler(null);
		HealthHandler HH = new HealthHandler();
		TTC = new TurtleHandler();
		BC = new BlueCrabHandler();
		CGC = new CordGrassHandler();
		PC = new PhragmitesHandler();
		TC = new ToolControl(5, 10);
		POC = new PollutionHandler();
		r = new Robot();
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SC = null;
		CC = null;
		TTC = null;
		BC = null;
		CGC = null;
		PC = null;
		TC = null;
		POC = null;
		r = null;
	}

	@Test
	public void clickMagTest() {
		int x = 0;
		while(x<100){
			
			r.mouseMove(TC.getMag().getX()+TC.getMag().getSizeX()/2,
					TC.getMag().getY()+TC.getMag().getSizeY()/2);
			r.mousePress(1024);r.mouseRelease(1024);System.out.println(SC.getClickx());
			SC.checkPos(CC, TTC, BC, CGC, PC, TC, POC);
			x++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
