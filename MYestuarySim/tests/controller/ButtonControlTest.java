package controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of ButtonControl
 */

public class ButtonControlTest {

	static ButtonControl b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//b = new ButtonControl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//b = null;
	}

	@Test
	public void getButtonsTest() {
		assertEquals("Y of first button should be 500", b.getButtons().get(0).getY(),500);
		assertEquals("Y of second button should be 625", b.getButtons().get(1).getY(),625);
		
	}

}
