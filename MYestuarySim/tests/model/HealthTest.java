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

public class HealthTest {
	static Dimension screenSize;
	static Health h;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = new Dimension(200,300);
		h = new Health(8,7,screenSize);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		h = null;
	}

	@Test
	public void setXTest() {
		h.setX(10);
		assertEquals("X should be 10",h.getX(),10);
	}
	
	@Test
	public void setYTest() {
		h.setY(12);
		assertEquals("Y should be 12",h.getY(),12);
	}
	
	@Test
	public void setSizeXTest() {
		h.setSizeX(180);
		assertEquals("sizeX should be 180",h.getSizeX(),180);
	}
	
	@Test
	public void setSizeYTest() {
		h.setSizeY(185);
		assertEquals("sizeY should be 185",h.getSizeY(),185);
	}
}
