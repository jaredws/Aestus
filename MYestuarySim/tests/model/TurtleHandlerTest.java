package model;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.ToolControl;

/**
 * @author Steven Sell
 * @Test Tests all functions of TurtleHandler
 */

public class TurtleHandlerTest {

	static TurtleHandler th;
	static ToolControl tc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		th = new TurtleHandler();
		tc = new ToolControl(10, 10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		th = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a Turtle and tests the x/y coordinates of the Turtle.
	 */
	@Test
	public void addTurtleTest() {
		th.addTurtle(3, 2);
		assertEquals("Crab at first position should have an X of 3",th.getTurtle(0).getX(),3);
		assertEquals("Crab at first position should have a Y of 2",th.getTurtles().get(0).getY(),2);
	}
	
	/**
	 * @author Steven
	 * @Tests Moves a Turtle's position at random to test the move method
	 */
	@Test
	public void moveTurtleTest() {
		th.addTurtle(3, 2);
		th.moveTurtles();
	}
	
	/**
	 * @author Steven
	 * @Tests Adds a Turtle, deletes that Turtle, then verifies that it was actually deleted
	 */
	@Test
	public void deleteTurtleTest() {
		th = new TurtleHandler();
		th.addTurtle(400, 10);
		th.deleteTurtles(tc);
		assertEquals("The size of the array should be 0",th.getTurtles().size(),0);
	}
	
	
	/**
	 * @author Steven
	 * @Tests Sets researched, then tests to make sure it was set properly
	 */
	@Test
	public void setResearchedTest() {
		th.setResearched(true);
		assertTrue("Researched should be true",th.getResearched());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks that Removed is what is expected
	 */
	@Test
	public void getRemoved() {
		assertEquals("Removed should be 1", th.getRemoved(),1);
	}

}
