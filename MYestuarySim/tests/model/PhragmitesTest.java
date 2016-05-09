package model;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Phragmites
 */

public class PhragmitesTest {
	static Dimension screenSize = new Dimension();
	static Phragmites p;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize.setSize(200, 300);
		p = new Phragmites(8,7,screenSize);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		p = null;
	}

	@Test
	public void setXTest() {
		p.setX(10);
		assertEquals("X should be 10",p.getX(),10);
	}
	
	@Test
	public void setYTest() {
		p.setY(12);
		assertEquals("Y should be 12",p.getY(),12);
	}
	
	@Test
	public void setSizeXTest() {
		p.setSizeX(180);
		assertEquals("sizeX should be 180",p.getSizeX(),180);
	}
	
	@Test
	public void setSizeYTest() {
		p.setSizeY(185);
		assertEquals("sizeY should be 185",p.getSizeY(),185);
	}
	
	@Test
	public void liveTest() {
		p.live();
		assertEquals("Life should be 1",p.getLife(),1);
	}

}
