package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BlueCrabHandler;
import model.CordGrassHandler;
import model.CrabHandler;
import model.PhragmitesHandler;
import model.PollutionHandler;
import model.TurtleHandler;

public class ScreenControlTest {

	static CrabHandler CC;
	static TurtleHandler TTC;
	static BlueCrabHandler BC;
	static CordGrassHandler CGC;
	static PhragmitesHandler PC;
	static ToolControl TC;
	static PollutionHandler POC;
	static ScreenControl SC;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SC = new ScreenControl();
		CC = new CrabHandler();
		TTC = new TurtleHandler();
		BC = new BlueCrabHandler();
		CGC = new CordGrassHandler();
		PC = new PhragmitesHandler();
		TC = new ToolControl(5, 10);
		POC = new PollutionHandler();
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
