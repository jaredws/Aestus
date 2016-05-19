package model;

import static org.junit.Assert.*;
import java.awt.Dimension;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of PhragmitesHandler
 */

public class PhragmitesHandlerTest {

	static PhragmitesHandler ph;
	static Phragmites p;
	static Dimension d;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		d = new Dimension();
		ph = new PhragmitesHandler();
		p = new Phragmites(5, 5, d);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ph = null;
		p = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds Phragmites and tests the x/y coordinates of the crab.
	 */
	@Test
	public void addPhragmitesTest() {
		ph.addPhragmites(3, 2);
		assertEquals("Phragmites at first position should have an X of 3",ph.getPhragmites(0).getX(),3);
		assertEquals("Phragmites at first position should have a Y of 2",ph.getPhragmites().get(0).getY(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Adds Phragmites and tests the x/y coordinates of the crab.
	 */
	@Test
	public void ageTest() {
		ph.addPhragmites(3, 2);
		ph.age();ph.age();
		assertEquals("Phragmites life should be 2",ph.getPhragmites(0).getLife(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Removes the Phragmites from the array, then verifies that it was actually removed
	 */
	@Test
	public void removePhragmitesTest() {
		ph.removePhragmites(0);
		assertEquals("The size of the array should be 1",ph.getPhragmites().size(),1);
	}
	
	
	/**
	 * @author Steven
	 * @Tests Sets researched, then tests to make sure it was set properly
	 */
	@Test
	public void setResearchedTest() {
		ph.setResearched(true);
		assertTrue("Researched should be true",ph.getResearched());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		ph = new PhragmitesHandler();
		ph.addPhragmites(3, 2);
		ph.removePhragmites(0);
		assertEquals("Removed should be 1", ph.getRemoved(),1);
	}

}
