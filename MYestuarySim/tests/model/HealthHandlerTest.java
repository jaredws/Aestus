package model;

import static org.junit.Assert.*;
import java.awt.Dimension;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.ToolControl;

/**
 * @author Steven Sell
 * @Test Tests all functions of HealthHandler
 */

public class HealthHandlerTest {

	static HealthHandler hh;
	static ToolControl tc;
	static Dimension d;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hh = new HealthHandler();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		hh = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Verifies the check function of HealthHandler
	 */
	@Test
	public void checkTest() {
		assertEquals("Should return 0", hh.check(0), 0);
		assertEquals("Should return 1", hh.check(1), 1);
		assertEquals("Should return 2", hh.check(99), 2);
		assertEquals("Should return 3", hh.check(149), 3);
		assertEquals("Should return 4", hh.check(199), 4);
		assertEquals("Should return 5", hh.check(201), 5);
	}
}
