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
import view.TotalView;

public class ScreenControlTest {

	static CrabHandler CH;
	static TurtleHandler TH;
	static BlueCrabHandler BCH;
	static CordGrassHandler CGH;
	static PhragmitesHandler PH;
	static ToolControl TLC;
	static PollutionHandler PolH;
	static CountdownControl CDC;
	static ScreenControl SC;
	static Robot r;
	static TotalView TV;
	static PopulationHandler PopH;
	static HealthHandler HH;
	static Dimension screenSize;
	static BackgroundView BV;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BV = new BackgroundView();
		SC = new ScreenControl();
		TV = new TotalView(SC);
		CH = new CrabHandler();
		TLC = new ToolControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		TH = new TurtleHandler();
		BCH = new BlueCrabHandler();
		PopH = new PopulationHandler(null);
		PH = new PhragmitesHandler();
		CGH = new CordGrassHandler();
		HH = new HealthHandler();
		PolH = new PollutionHandler();
		CDC = new CountdownControl();
		r = new Robot();
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SC = null;
		BV = null;
		CH = null;
		TH = null;
		BCH = null;
		CGH = null;
		PH = null;
		TLC = null;
		PolH = null;
		PopH = null;
		CDC = null;
		HH = null;
		r = null;
	}

	@Test
	public void clickMagTest() {
		int x = 0;
		TV.repaint();
		while(x<100){
			r.mouseMove(TLC.getMag().getX()+TLC.getMag().getSizeX()/2,TLC.getMag().getY()+TLC.getMag().getSizeY()/2);
			r.mousePress(1024);r.mouseRelease(1024);
			SC.checkPos(CH, TH, BCH, CGH, PH, TLC, PolH);
			TV.repaint();
			x++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
