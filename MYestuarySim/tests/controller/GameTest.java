package controller;

import static org.junit.Assert.*;

import java.util.Random;

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

/**
 * @author Steven Sell
 * @Test Tests all functions of Game
 */

public class GameTest {

	static Game g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new Game(true);
		g.start(g);
		g.run(g);
		g.end(g);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		g = null;
		Game.SV.dispose();
		Game.TV.dispose();
		Game.EV.dispose();
	}
	
	/**
	 * @author Steven
	 * @Tests Tests Setters and Getters of Game
	 */
	@Test
	public void getterSetterTest() {
		
		g.setTesting(true);
		assertTrue("Testing should be true",g.getTesting());
		assertTrue("getCrabHandler should return an instance of the Handler class",Game.getCrabHandler() instanceof CrabHandler);
		assertTrue("getBlueCrabHandler should return an instance of the Handler class",Game.getBlueCrabHandler() instanceof BlueCrabHandler);
		assertTrue("getPhragmitesHandler should return an instance of the Handler class",Game.getPhragmitesHandler() instanceof PhragmitesHandler);
		assertTrue("getCordGrassHandler should return an instance of the Handler class",Game.getCordGrassHandler() instanceof CordGrassHandler);
		assertTrue("getTurtleHandler should return an instance of the Handler class",Game.getTurtleHandler() instanceof TurtleHandler);
		assertTrue("getHealthHandler should return an instance of the Handler class",Game.getHealthHandler() instanceof HealthHandler);
		assertTrue("getPollutionHandler should return an instance of the Handler class",Game.getPollutionHandler() instanceof PollutionHandler);
		assertTrue("getPopulationHandler should return an instance of the Handler class",Game.getPopulationHandler() instanceof PopulationHandler);
		assertTrue("getToolControl should return an instance of the Control class",Game.getToolControl() instanceof ToolControl);
		assertTrue("getCountdownControl should return an instance of the Control class",Game.getCountdownControl() instanceof CountdownControl);
		assertTrue("getTotalView should return an instance of the View class",Game.getTotalView() instanceof TotalView);
		assertTrue("getRand should return an instance of the Random class",g.getRand() instanceof Random);
	}

}
