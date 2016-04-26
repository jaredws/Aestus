package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Turtle
 */

public class TurtleTest {
	
	static Turtle t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		t = new Turtle(8,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		t = null;
	}

	@Test
	public void setXTest() {
		t.setX(10);
		assertEquals("X should be 10",t.getX(),10);
	}
	
	@Test
	public void setYTest() {
		t.setY(12);
		assertEquals("Y should be 12",t.getY(),12);
	}
	
	@Test
	public void getSizeXTest() {
		assertEquals("sizeX should be 165",t.getSizeX(),165);
	}
	
	@Test
	public void getSizeYTest() {
		assertEquals("sizeY should be 165",t.getSizeY(),165);
	}

}
