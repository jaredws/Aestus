package model;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.ToolControl;

/**
 * @author Steven Sell
 * @Test Tests all functions of BlueCrabHandler
 */

public class BlueCrabHandlerTest {

	static BlueCrabHandler bc;
	static ToolControl tc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bc = new BlueCrabHandler();
		tc = new ToolControl(10, 10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bc = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a blue crab and tests the x/y coordinates of the crab.
	 */
	@Test
	public void addCrabTest() {
		bc.addBlueCrab(3, 2);
		assertEquals("Crab at first position should have an X of 3",bc.getBlueCrab(0).getX(),3);
		assertEquals("Crab at first position should have a Y of 2",bc.getBlueCrabs().get(0).getY(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Moves a blue crab's position at random to test the move method
	 */
	@Test
	public void moveBlueCrabsTest() {
		bc.addBlueCrab(3, 2);
		bc.moveBlueCrabs();
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a blue crab, deletes that blue crab, then verifies that it was actually deleted
	 */
	@Test
	public void deleteCrabTest() {
		bc = new BlueCrabHandler();
		bc.addBlueCrab(400, 10);
		bc.deleteBlueCrabs(tc);
		assertEquals("The size of the array should be 0",bc.getBlueCrabs().size(),0);

		//System.out.println(tc.getCrabTrap().getX()- tc.getCrabTrap().getSizeX()/2);
		//System.out.println(tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4);
		//System.out.println(tc.getCrabTrap().getY()- tc.getCrabTrap().getSizeY()/2);
		//System.out.println(tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/4);
	}
	
	
	/**
	 * @author Steven
	 * @Tests Sets researched, then tests to make sure it was set properly
	 */
	@Test
	public void setResearchedTest() {
		bc.setResearched(true);
		assertTrue("Researched should be true",bc.getResearched());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		assertEquals("Removed should be 1", bc.getRemoved(),1);
	}

}
