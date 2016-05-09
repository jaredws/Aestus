package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Button
 */

public class ToolTest {

	static Tool b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		b = new Tool(5,3,1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		b = null;
	}

	@Test
	public void getXTest() {
		assertEquals("X should be 5",b.getX(),5);
	}
	
	@Test
	public void getYTest() {
		assertEquals("Y should be 3",b.getY(),3);
	}
	
	@Test
	public void getSizeXTest() {
		assertEquals("sizeX should be 100",b.getSizeX(),100);
	}
	
	@Test
	public void getSizeYTest() {
		assertEquals("sizeY should be 100",b.getSizeY(),100);
	}
	
	@Test
	public void getTypeTest() {
		assertEquals("Type should be 1",b.getType(),1);
	}

}
