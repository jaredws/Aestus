package model;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.Game;

/**
 * @author Steven Sell
 * @Test Tests all functions of PopulationHandler
 */

public class PopulationHandlerTest {

	static Game g;
	static Dimension screenSize;
	static PopulationHandler ph;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		g = new Game(true);
		g.start(g);
		g.run(g);
		ph = Game.getPopulationHandler();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		g = null;
		ph = null;
		screenSize = null;
		Game.getTotalView().dispose();
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the return of makeX
	 */
	@Test
	public void makeXTest() {
		assertTrue("Should return a number between 0 and " + (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12,
				ph.makeX() >=0 && ph.makeX() < (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12);
		assertFalse("Should not return a number > " + (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12,
				ph.makeX() > (int)screenSize.getWidth()*9/12+(int)screenSize.getWidth()/12);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the return of makeY
	 */
	@Test
	public void makeYTest() {
		assertTrue("Should return a number between 0 and " + (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12,
				ph.makeY() >=0 && ph.makeY() < (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12);
		assertFalse("Should not return a number > " + (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12,
				ph.makeY() > (int)screenSize.getHeight()*8/12 + (int)screenSize.getHeight()/12);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests maxAnimal based on the number of plants
	 */
	@Test
	public void maxAnimalTest() {
		ph.setTP(5);
		assertEquals("Max Animals should be a function of (-0.08*TP*TP+3.2*TP-14)",(int)ph.maxAnimal(),0);
	}
	
	/**
	 * @author Steven
	 * @Tests Checks all variables after calculate runs
	 */
	@Test
	public void calculateTest() {
		ph.setNIP(10);
		ph.setIP(2);
		ph.setNIA(13);
		ph.setIA(9);
		ph.setP(4);
		
		ph.calculate();
		
		assertEquals("TP should be NIP+IP=12",ph.getTP(),12);
		assertEquals("TA should be NIA+IA=22",ph.getTA(),22);
		assertEquals("NonInvasivePlant should be NIP=10",ph.getNonInvasivePlant(),10);
		assertEquals("InvasivePlant should be IP=2",ph.getInvasivePlant(),2);
		assertEquals("TotalPlant should be 35-2*P=16",ph.getTotalPlant(),16);
		assertEquals("TotalAnimal should be maxAnimal="+ph.maxAnimal(),(int)ph.getTotalAnimal(),(int)ph.maxAnimal());
		assertEquals("InvasiveAnimal should be TotalAnimal-NonInvasiveAnimal="+((int)ph.maxAnimal()-13),ph.getInvasiveAnimal(),(int)ph.maxAnimal()-13);
		assertEquals("NonInvasiveAnimal should be TotalAnimal-InvasiveAnimal="+((int)ph.maxAnimal()-ph.getInvasiveAnimal()),ph.getNonInvasiveAnimal(),(int)ph.maxAnimal()-ph.getInvasiveAnimal());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks all variables after spawn runs when TotalPlant > TP
	 */
	@Test
	public void spawnTest1() {
		int Pc, CGc;
		ph.setTotalPlant(25);
		ph.setTP(10);
		for(int i=0;i<100;i++) {
			Game.getPhragmitesHandler().setResearched(false);
			Game.getCordGrassHandler().setResearched(false);
			Pc = Game.getPhragmitesHandler().getPhragmites().size();
			CGc = Game.getCordGrassHandler().getCordGrass().size();
			ph.spawnTest();
			
			assertTrue("There should be 1 more element in CordGrass or Phragmites", 
					Game.getPhragmitesHandler().getPhragmites().size() > Pc || 
					Game.getCordGrassHandler().getCordGrass().size() > CGc);
			
			Game.getPhragmitesHandler().setResearched(true);
			Game.getCordGrassHandler().setResearched(true);
			Pc = Game.getPhragmitesHandler().getPhragmites().size();
			CGc = Game.getCordGrassHandler().getCordGrass().size();
			ph.spawnTest();
			assertTrue("There should be 1 more element in CordGrass or Phragmites", 
					Game.getPhragmitesHandler().getPhragmites().size() > Pc || 
					Game.getCordGrassHandler().getCordGrass().size() > CGc);
			
			Game.getPhragmitesHandler().setResearched(false);
			Game.getCordGrassHandler().setResearched(true);
			Pc = Game.getPhragmitesHandler().getPhragmites().size();
			CGc = Game.getCordGrassHandler().getCordGrass().size();
			ph.spawnTest();
			assertTrue("There should be 1 more element in CordGrass or Phragmites", 
					Game.getPhragmitesHandler().getPhragmites().size() > Pc || 
					Game.getCordGrassHandler().getCordGrass().size() > CGc);
		}
	}
	
	/**
	 * @author Steven
	 * @Tests Checks all variables after spawn runs when TotalPlant < TP
	 */
	@Test
	public void spawnTest2() {
		int Pc, CGc;
		ph.setTotalPlant(10);
		ph.setTP(25);
		for(int i=0;i<100;i++) {
			Game.getPhragmitesHandler().setResearched(false);
			Game.getCordGrassHandler().setResearched(false);
			Pc = Game.getPhragmitesHandler().getPhragmites().size();
			CGc = Game.getCordGrassHandler().getCordGrass().size();
			ph.spawnTest();
			
			assertTrue("There should be 1 less element in CordGrass or Phragmites", 
					Game.getPhragmitesHandler().getPhragmites().size() < Pc || 
					Game.getCordGrassHandler().getCordGrass().size() < CGc);
		}
	}
	
	/**
	 * @author Steven
	 * @Tests Checks all variables after spawn runs when TotalAnimal > TA
	 */
	@Test
	public void spawnTest3() {
		//Turtles
		int Tc;
		ph.setTotalAnimal(25);
		ph.setTA(10);
		for(int i=0;i<100;i++) {
			Game.getTurtleHandler().setResearched(true);
			Tc = Game.getTurtleHandler().getTurtle().size();
			ph.spawnTest();
			
			assertTrue("There could be 1 more added to Turtle", Game.getTurtleHandler().getTurtle().size() >= Tc);
			
			Game.getTurtleHandler().setResearched(false);
			Tc = Game.getTurtleHandler().getTurtle().size();
			ph.spawnTest();
			
			assertTrue("There could be 1 more added to Turtle", Game.getTurtleHandler().getTurtle().size() >= Tc);
		}
		//Crabs
		int Cc, BCc;
		for(int i=0;i<100;i++) {
			Game.getCrabHandler().setResearched(false);
			Game.getBlueCrabHandler().setResearched(false);
			Cc = Game.getCrabHandler().getCrabs().size();
			BCc = Game.getBlueCrabHandler().getBlueCrabs().size();
			ph.spawnTest();
			
			assertTrue("There should be 1 more element in Crab or BlueCrab", 
					Game.getCrabHandler().getCrabs().size() >= Cc && 
					Game.getBlueCrabHandler().getBlueCrabs().size() >= BCc);
			
			Game.getCrabHandler().setResearched(true);
			Game.getBlueCrabHandler().setResearched(true);
			Cc = Game.getCrabHandler().getCrabs().size();
			BCc = Game.getBlueCrabHandler().getBlueCrabs().size();
			ph.spawnTest();
			
			assertTrue("There should be 1 more element in Crab or BlueCrab", 
					Game.getCrabHandler().getCrabs().size() >= Cc && 
					Game.getBlueCrabHandler().getBlueCrabs().size() >= BCc);
		
			Game.getCrabHandler().setResearched(true);
			Game.getBlueCrabHandler().setResearched(false);
			Cc = Game.getCrabHandler().getCrabs().size();
			BCc = Game.getBlueCrabHandler().getBlueCrabs().size();
			ph.spawnTest();
			
			assertTrue("There should be 1 more element in Crab or BlueCrab", 
					Game.getCrabHandler().getCrabs().size() >= Cc && 
					Game.getBlueCrabHandler().getBlueCrabs().size() >= BCc);
		}
	}
	
	/**
	 * @author Steven
	 * @Tests Checks all variables after spawn runs when TotalAnimal > TA
	 */
	@Test
	public void spawnTest4() {
		//Turtles
		int Cc,BCc,Tc;
		ph.setTotalAnimal(10);
		ph.setTA(25);
		for(int i=0;i<100;i++) {
			Cc = Game.getCrabHandler().getCrabs().size();
			BCc = Game.getBlueCrabHandler().getBlueCrabs().size();
			Tc = Game.getTurtleHandler().getTurtle().size();
			ph.spawnTest();
			
			
			assertTrue("There could be 1 removed from Crab", Game.getCrabHandler().getCrabs().size() <= Cc);
			assertTrue("There could be 1 removed from BlueCrab", Game.getBlueCrabHandler().getBlueCrabs().size() <= BCc);
			assertTrue("There could be 1 removed from Turtle", Game.getTurtleHandler().getTurtles().size() <= Tc);
		}
		
	}
	
	/**
	 * @author Steven
	 * @Tests Tests Setters and Getters of PopulationHandler
	 */
	@Test
	public void getterSetterTest() {
		ph.setTotalPlant(25);
		assertEquals("TotalPlant should be 25",ph.getTotalPlant(),25);
		ph.setTotalAnimal(10);
		assertEquals("TotalAnimal should be 10",(int)ph.getTotalAnimal(),10);
		ph.setPollution(15);
		assertEquals("Pollution should be 15",ph.getPollution(),15);
		ph.setMittenDie(10);
		assertEquals("MittenDie should be 10",ph.getMittenDie(),10);
		ph.setBlueCrabDie(5);
		assertEquals("BlueCrabDie should be 5",ph.getBlueCrabDie(),5);
		ph.setTurtleDie(3);
		assertEquals("TurtleDie should be 3",ph.getTurtleDie(),3);
		ph.setPhragDie(2);
		assertEquals("PhragDie should be 2",ph.getPhragDie(),2);
		ph.setCordDie(7);
		assertEquals("CordDie should be 7",ph.getCordDie(),7);
		ph.setNIP(21);
		assertEquals("NIP should be 21",ph.getNIP(),21);
		ph.setIP(11);
		assertEquals("IP should be 11",ph.getIP(),11);
		ph.setNIA(5);
		assertEquals("NIA should be 5",ph.getNIA(),5);
		ph.setIA(7);
		assertEquals("IA should be 7",ph.getIA(),7);
		ph.setP(9);
		assertEquals("P should be 9",ph.getP(),9);
		ph.setNonInvasivePlant(24);
		assertEquals("NonInvasivePlant should be 24",ph.getNonInvasivePlant(),24);
		ph.setNonInvasiveAnimal(3);
		assertEquals("NonInvasiveAnimal should be 3",ph.getNonInvasiveAnimal(),3);
		ph.setInvasiveAnimal(4);
		assertEquals("InvasiveAnimal should be 4",ph.getInvasiveAnimal(),4);
		ph.setInvasivePlant(8);
		assertEquals("InvasivePlant should be 8",ph.getInvasivePlant(),8);
		
	}
}
