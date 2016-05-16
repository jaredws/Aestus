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
		assertEquals("TotalPlant should be 35-2*P=27",ph.getTotalPlant(),27);
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
		Game.getPhragmitesControl().setResearched(false);
		Game.getCordGrassControl().setResearched(false);
		Pc = Game.getPhragmitesControl().getPhragmites().size();
		CGc = Game.getCordGrassControl().getCordGrass().size();
		ph.spawnTest();
		
		assertTrue("There should be 1 more element in CordGrass or Phragmites", Game.getPhragmitesControl().getPhragmites().size() > Pc || Game.getCordGrassControl().getCordGrass().size() > CGc);
		
		Game.getPhragmitesControl().setResearched(true);
		Game.getCordGrassControl().setResearched(true);
		Pc = Game.getPhragmitesControl().getPhragmites().size();
		CGc = Game.getCordGrassControl().getCordGrass().size();
		ph.spawnTest();
		assertTrue("There should be 1 more element in CordGrass or Phragmites", Game.getPhragmitesControl().getPhragmites().size() > Pc || Game.getCordGrassControl().getCordGrass().size() > CGc);
		
		Game.getPhragmitesControl().setResearched(false);
		Game.getCordGrassControl().setResearched(true);
		Pc = Game.getPhragmitesControl().getPhragmites().size();
		CGc = Game.getCordGrassControl().getCordGrass().size();
		ph.spawnTest();
		assertTrue("There should be 1 more element in CordGrass or Phragmites", Game.getPhragmitesControl().getPhragmites().size() > Pc || Game.getCordGrassControl().getCordGrass().size() > CGc);
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
		Game.getPhragmitesControl().setResearched(false);
		Game.getCordGrassControl().setResearched(false);
		Pc = Game.getPhragmitesControl().getPhragmites().size();
		CGc = Game.getCordGrassControl().getCordGrass().size();
		ph.spawnTest();
		
		assertTrue("There should be 1 more element in CordGrass or Phragmites", Game.getPhragmitesControl().getPhragmites().size() < Pc || Game.getCordGrassControl().getCordGrass().size() < CGc);
	}
	
	/**
	 * @author Steven
	 * @Tests Get TotalPlant result testing
	 */
	@Test
	public void setTotalPlantTest() {
		ph.setTotalPlant(25);
		assertEquals("TotalPlant should be 25",ph.getTotalPlant(),25);
	}
	
	/**
	 * @author Steven
	 * @Tests Get TotalAnimal result testing
	 */
	@Test
	public void setTotalAnimalTest() {
		ph.setTotalAnimal(10);
		assertEquals("TotalAnimal should be 10",(int)ph.getTotalAnimal(),10);
	}
}
