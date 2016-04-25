package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of CrabControl
 */

public class CrabControlTest {

	static CrabControl c;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new CrabControl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a crab and tests the x/y coordinates of the crab.
	 */
	@Test
	public void addCrabTest() {
		c.addCrab(3, 2);
		assertEquals("Crab at first position should have an X of 3",c.getCrabs().get(0).getX(),3);
		assertEquals("Crab at first position should have a Y of 2",c.getCrabs().get(0).getY(),2);
	}

}
