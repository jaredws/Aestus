package model;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of BlueCrab
 */

public class BlueCrabTest {
	static Dimension screenSize = new Dimension();
	static BlueCrab bc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize.setSize(500, 500);
		bc = new BlueCrab(101,101,screenSize);
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
	
	@Test
	public void setMoveTest() {
		bc.setMove(30);
		assertEquals("move should be 30",bc.getMove(),30);
	}
	
	@Test
	public void moveBlueCrabTest() {
		//If 1
		bc.setMove(7);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("XDir should be 0",bc.getXDir(),0);
		assertEquals("YDir should be 2",bc.getYDir(),2);
		
		//If 2
		bc.setX(1000);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("XDir should be -3",bc.getXDir(),-3);
		
		//If 3
		bc.setX(20);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("XDir should be 3",bc.getXDir(),3);
		
		//If 4
		bc.setY(1000);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("YDir should be -3",bc.getYDir(),-3);
		
		//If 5
		bc.setY(20);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("YDir should be 3",bc.getYDir(),3);
		
		bc.setMove(41);
		bc.moveBlueCrab(10, screenSize);
		assertEquals("X should be 23",bc.getX(),23);
		assertEquals("Y should be 23",bc.getY(),23);
	}

}
