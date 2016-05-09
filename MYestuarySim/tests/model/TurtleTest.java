package model;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Turtle
 */

public class TurtleTest {
	static Dimension screenSize = new Dimension();
	static Turtle t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize.setSize(200, 300);
		t = new Turtle(8,7,screenSize);
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
	public void setSizeXTest() {
		t.setSizeX(170);
		assertEquals("sizeX should be 170",t.getSizeX(),170);
	}
	
	@Test
	public void setSizeYTest() {
		t.setSizeY(190);
		assertEquals("sizeY should be 190",t.getSizeY(),190);
	}
	
	@Test
	public void setMoveTest() {
		t.setMove(30);
		assertEquals("move should be 30",t.getMove(),30);
	}
	
	@Test
	public void moveTurtleTest() {
		//If 1
		t.setMove(20);
		t.moveTurtle(10, screenSize);
		assertEquals("XDir should be 2",t.getXDir(),2);
		assertEquals("YDir should be 2",t.getYDir(),2);
		
		//If 2
		t.setX(1000);
		t.moveTurtle(10, screenSize);
		assertEquals("XDir should be -2",t.getXDir(),-2);
		
		//If 3
		t.setX(20);
		t.moveTurtle(10, screenSize);
		assertEquals("XDir should be 2",t.getXDir(),2);
		
		//If 4
		t.setY(1000);
		t.moveTurtle(10, screenSize);
		assertEquals("YDir should be -2",t.getYDir(),-2);
		
		//If 5
		t.setY(20);
		t.moveTurtle(10, screenSize);
		assertEquals("YDir should be 2",t.getYDir(),2);
		
		t.setMove(41);
		t.moveTurtle(10, screenSize);
		assertEquals("X should be 22",t.getX(),22);
		assertEquals("Y should be 22",t.getY(),22);
	}

}
