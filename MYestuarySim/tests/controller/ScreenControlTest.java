package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BlueCrabControl;
import model.CordGrassControl;
import model.CrabControl;
import model.PhragmitesControl;
import model.PollutionControl;
import model.TurtleControl;

public class ScreenControlTest {

	static CrabControl CC;
	static TurtleControl TTC;
	static BlueCrabControl BC;
	static CordGrassControl CGC;
	static PhragmitesControl PC;
	static ToolControl TC;
	static PollutionControl POC;
	static ScreenControl SC;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SC = new ScreenControl();
		CC = new CrabControl();
		TTC = new TurtleControl();
		BC = new BlueCrabControl();
		CGC = new CordGrassControl();
		PC = new PhragmitesControl();
		TC = new ToolControl(5, 10);
		POC = new PollutionControl();
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
	}

	@Test
	public void test() {
		SC.setClicked(true);
		SC.setClickx(TC.getMag().getX());
	}

}
