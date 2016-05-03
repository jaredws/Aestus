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
	static Dimension screenSize;
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

}
