package model;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.ToolControl;

/**
 * @author Steven Sell
 * @Test Tests all functions of PollutionHandler
 */

public class PollutionHandlerTest {

	static PollutionHandler ph;
	static ToolControl tc;
	static Pollution p;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ph = new PollutionHandler();
		p = new Pollution(10, 10);
		tc = new ToolControl(10, 10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ph = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds Pollution and tests the x/y coordinates of the Pollution.
	 */
	@Test
	public void addPollutionTest() {
		ph.addPollution(3, 2);
		assertEquals("Pollution at first position should have an X of 3",ph.getPollution(0).getX(),3);
		assertEquals("Pollution at first position should have a Y of 2",ph.getPollution(0).getY(),2);
		assertEquals("Pollution size should be 1", ph.getPollutionSize(),1);
	}
	
	/**
	 * @author Steven
	 * @Tests Ages the Pollution and tests the age of that CordGrass.
	 */
	@Test
	public void ageTest() {
		ph = new PollutionHandler();
		ph.addPollution(3, 2);
		ph.age();ph.age();
		assertEquals("CordGrass life should be 2",ph.getPollution(0).getLife(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Adds Pollution, deletes that Pollution, then verifies that it was actually deleted
	 */
	@Test
	public void deletePollutionTest() {
		ph = new PollutionHandler();
		ph.addPollution(20, 20);
		ph.deletePollution(tc);
		assertEquals("The size of the array should be 0",ph.getPollution().size(),0);
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		assertEquals("Removed should be 1", ph.getRemoved(),1);
	}

}
