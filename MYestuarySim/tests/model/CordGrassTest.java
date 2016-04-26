package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of CordGrass
 */

public class CordGrassTest {
	
	static CordGrass cg;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cg = new CordGrass(8,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cg = null;
	}

	@Test
	public void setXTest() {
		cg.setX(10);
		assertEquals("X should be 10",cg.getX(),10);
	}
	
	@Test
	public void setYTest() {
		cg.setY(12);
		assertEquals("Y should be 12",cg.getY(),12);
	}
	
	@Test
	public void setSizeXTest() {
		cg.setSizeX(170);
		assertEquals("sizeX should be 170",cg.getSizeX(),170);
	}
	
	@Test
	public void setSizeYTest() {
		cg.setSizeY(185);
		assertEquals("sizeY should be 185",cg.getSizeY(),185);
	}

}
