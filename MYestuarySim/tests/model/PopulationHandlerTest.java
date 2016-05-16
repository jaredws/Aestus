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
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		g = new Game();
		ph = new PopulationHandler(g);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ph = null;
		g = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the return of makeX
	 */
	@Test
	public void makeXTest() {
		assertTrue("Should return a number between 0 and " + (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12,
				ph.makeX() >=0 && ph.makeX() < (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12);
		assertFalse("Should not return a number > " + (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12,
				ph.makeX() > (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the return of makeY
	 */
	@Test
	public void makeYTest() {
		assertTrue("Should return a number between 0 and " + (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12,
				ph.makeY() >=0 && ph.makeY() < (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12);
		assertFalse("Should not return a number > " + (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12,
				ph.makeY() > (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12);
	}
}
