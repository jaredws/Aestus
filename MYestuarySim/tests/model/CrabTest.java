package model;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Crab
 */

public class CrabTest {
	static Dimension screenSize;
	static Crab c;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = new Dimension(200,300);
		c = new Crab(8,7,screenSize);
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
	public void setSizeXTest() {
		c.setSizeX(180);
		assertEquals("sizeX should be 180",c.getSizeX(),180);
	}
	
	@Test
	public void setSizeYTest() {
		c.setSizeY(185);
		assertEquals("sizeY should be 185",c.getSizeY(),185);
	}

}
