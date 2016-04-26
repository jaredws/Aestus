package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of BlueCrab
 */

public class BlueCrabTest {
	
	static BlueCrab bc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bc = new BlueCrab(8,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bc = null;
	}

	@Test
	public void setXTest() {
		bc.setX(10);
		assertEquals("X should be 10",bc.getX(),10);
	}
	
	@Test
	public void setYTest() {
		bc.setY(12);
		assertEquals("Y should be 12",bc.getY(),12);
	}
	
	@Test
	public void setSizeXTest() {
		bc.setSizeX(185);
		assertEquals("sizeX should be 185",bc.getSizeX(),185);
	}
	
	@Test
	public void setSizeYTest() {
		bc.setSizeY(168);
		assertEquals("sizeY should be 168",bc.getSizeY(),168);
	}

}
