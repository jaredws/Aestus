package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of Background
 */

public class BackgroundTest {

	static Background b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		b = new Background(250,150);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		b = null;
	}

	/**
	 * @author Steven
	 * @Test Tests the getX() function of Background
	 */
	@Test
	public void getXTest() {
		assertEquals("X should be 250",b.getX(),250);
	}
	
	/**
	 * @author Steven
	 * @Test Tests the getY() function of Background
	 */
	@Test
	public void getYTest() {
		assertEquals("Y should be 150",b.getY(),150);
	}
	
	/**
	 * @author Steven
	 * @Test Tests the check() function of Background
	 */
	@Test
	public void checkTest() {
		assertEquals("check(20) should return 2",b.check(20),2);
		assertEquals("check(101) should return 1",b.check(101),1);
		assertEquals("check(201) should return 0",b.check(201),0);
	}
}
