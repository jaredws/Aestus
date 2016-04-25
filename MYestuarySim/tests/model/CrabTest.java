package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Crab
 */

public class CrabTest {
	
	static Crab c;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c = new Crab(8,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c = null;
	}

	@Test
	public void setXTest() {
		c.setX(10);
		assertEquals("X should be 10",c.getX(),10);
	}
	
	@Test
	public void setYTest() {
		c.setY(12);
		assertEquals("Y should be 12",c.getY(),12);
	}
	
	@Test
	public void getSizeXTest() {
		assertEquals("sizeX should be 165",c.getSizeX(),165);
	}
	
	@Test
	public void getSizeYTest() {
		assertEquals("sizeY should be 165",c.getSizeY(),165);
	}

}
