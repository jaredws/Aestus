package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of ButtonControl
 */

public class ToolControlTest {

	static ToolControl t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		t = new ToolControl(5,10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		t = null;
	}

	@Test
	public void getToolsTest() {
		//assertEquals("Y of first button should be 500", t.getTools().get(0).getY(),500);
		//assertEquals("Y of second button should be 625", t.getTools().get(1).getY(),625);
		
	}

}
