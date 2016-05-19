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
		for(int i = 0;i<359;i++){
			CDC.updateCountdown();
		}
		assertEquals("Image should be 13",CDC.getImage(),13);
		for(int i = 0;i<64;i++){
			CDC.updateCountdown();
		}
		assertEquals("Image should be 14",CDC.getImage(),14);
		for(int i = 0;i<23;i++){
			CDC.updateCountdown();
		}
		assertEquals("Image should be 15",CDC.getImage(),15);
		
		int time = CDC.getTime();
		while(CDC.getCounter()%4!=0) {
			CDC.updateCountdown();
		}
		CDC.updateCountdown();
		assertEquals("Time should be one less than previously",CDC.getTime(),time-1);
		
	}
	
	/**
	 * @author Steven
	 * @Tests Tests Setters and Getters of Game
	 */
	@Test
	public void getterSetterTest() {
		
		
	}

}
