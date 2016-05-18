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
 * @Test Tests all functions of CountdownControl
 */

public class CountdownControlTest {

	static CountdownControl CDC;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CDC = new CountdownControl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CDC = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Tests updateCountdown results
	 */
	@Test
	public void updateCountdownTest() {
		int t = CDC.getCounter();
		System.out.println(t);
		CDC.updateCountdown();CDC.updateCountdown();
		CDC.updateCountdown();	CDC.updateCountdown();	System.out.println(CDC.getCounter());
	}
	
	/**
	 * @author Steven
	 * @Tests Tests Setters and Getters of Game
	 */
	@Test
	public void getterSetterTest() {
		
		
	}

}
