package model;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.Game;

/**
 * @author Steven Sell
 * @Test Tests all functions of PopulationHandler
 */

public class PopulationHandlerTest {

	static PopulationHandler ph;
	static Game g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new Game();
		ph = new PopulationHandler();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ph = null;
		g = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a blue crab and tests the x/y coordinates of the crab.
	 */
	@Test
	public void addCrabTest() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(ph.makeX());
		System.out.println(ph.makeY());
		System.out.println((int)screenSize.getWidth()*9/12);
	}
}
