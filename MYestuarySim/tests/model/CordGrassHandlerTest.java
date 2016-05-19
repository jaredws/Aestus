package model;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of CordGrassHandler
 */

public class CordGrassHandlerTest {

	static CordGrassHandler cgh;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cgh = new CordGrassHandler();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cgh = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds CordGrass and tests the x/y coordinates of the CordGrass.
	 */
	@Test
	public void addCordGrassTest() {
		cgh.addCordGrass(3, 2);
		assertEquals("CordGrass at first position should have an X of 3",cgh.getCordGrass(0).getX(),3);
		assertEquals("CordGrass at first position should have a Y of 2",cgh.getCordGrass().get(0).getY(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Ages the CordGrass and tests the age of that CordGrass.
	 */
	@Test
	public void ageTest() {
		cgh = new CordGrassHandler();
		cgh.addCordGrass(3, 2);
		cgh.age();cgh.age();
		assertEquals("CordGrass life should be 2",cgh.getCordGrass(0).getLife(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Removes the CordGrass from the array, then verifies that it was actually removed
	 */
	@Test
	public void removeCordGrassTest() {
		cgh.removeCordGrass(0);
		assertEquals("The size of the array should be 0",cgh.getCordGrass().size(),0);
	}
	
	
	/**
	 * @author Steven
	 * @Tests Sets researched, then tests to make sure it was set properly
	 */
	@Test
	public void setResearchedTest() {
		cgh.setResearched(true);
		assertTrue("Researched should be true",cgh.getResearched());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		cgh = new CordGrassHandler();
		cgh.addCordGrass(3, 2);
		cgh.removeCordGrass(0);
		assertEquals("Removed should be 1", cgh.getRemoved(),1);
	}

}
