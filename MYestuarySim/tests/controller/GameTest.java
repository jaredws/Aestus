package controller;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.CrabHandler;

/**
 * @author Steven Sell
 * @Test Tests all functions of Game
 */

public class GameTest {

	static Game g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new Game(true);
		g.start(g);
		g.run(g);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		g = null;
	}
	
	@Test
	public void getterSetterTest() {
		if(Game.getCrabHandler() instanceof CrabHandler) System.out.println("test");
	}

}
