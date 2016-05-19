package controller;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.BlueCrabHandler;
import model.CordGrassHandler;
import model.CrabHandler;
import model.HealthHandler;
import model.PhragmitesHandler;
import model.PollutionHandler;
import model.PopulationHandler;
import model.TurtleHandler;
import view.ToolView;
import view.TotalView;
/**
 * @author Steven Sell
 * @Test Tests all functions of ScreenControl
 */
public class ScreenControlTest {

	Game G;
	Robot r;
	Dimension screenSize;
	ScreenControl SC;
	ToolView TLV;
	
	@Before
	public void setUp() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		r = new Robot();
		G = new Game(true);
		SC = new ScreenControl();
		Game.TV = new TotalView(SC);
		Game.CH = new CrabHandler();
		Game.TH = new TurtleHandler();
		Game.BCH = new BlueCrabHandler();
		Game.CGH = new CordGrassHandler();
		Game.PH = new PhragmitesHandler();
		Game.TLC = new ToolControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		Game.PolH = new PollutionHandler();
		Game.PopH = new PopulationHandler(G);
		Game.HH = new HealthHandler();
		Game.CDC = new CountdownControl();
		
		TLV = new ToolView(); 
		Game.TV.update(G);
		Game.TV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
	}

	@After
	public void tearDown() throws Exception {
		G = null;
		r = null;
		SC = null;
		Game.TV.dispose();
		TLV = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if pausing the game works
	 */
	@Test
	public void pauseTest() {
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getPauseB().getX()+Game.TLC.getPauseB().getSizeX()/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getPauseB().getY()+Game.TLC.getPauseB().getSizeY()/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("Pause should be true",SC.getPause());
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getPauseB().getX()+Game.TLC.getPauseB().getSizeX()/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getPauseB().getY()+Game.TLC.getPauseB().getSizeY()/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertFalse("Pause should be false",SC.getPause());
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if researching a Crab works
	 */
	@Test
	public void crabResearchTest() {
		Game.CH.addCrab(200, 400);
		Game.CH.addCrab(200, 400);
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("MagGlass should be true",SC.getMagGlass());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.CH.getCrab(0).getX()+20) * i)/100) + ((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.CH.getCrab(0).getY()+20) * i)/100) + ((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("isResearched should be true",Game.getCrabHandler().isResearched());		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if researching a BlueCrab works
	 */
	@Test
	public void blueCrabResearchTest() {
		Game.BCH.addBlueCrab(200, 400);
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("MagGlass should be true",SC.getMagGlass());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.BCH.getBlueCrab(0).getX()+20) * i)/100) + ((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.BCH.getBlueCrab(0).getY()+20) * i)/100) + ((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("isResearched should be true",Game.getBlueCrabHandler().isResearched());		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if researching a Turtle works
	 */
	@Test
	public void turtleResearchTest() {
		Game.TH.addTurtle(200, 400);
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("MagGlass should be true",SC.getMagGlass());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.TH.getTurtle(0).getX()+20) * i)/100) + ((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.TH.getTurtle(0).getY()+20) * i)/100) + ((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("isResearched should be true",Game.getTurtleHandler().isResearched());		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if researching Phragmites works
	 */
	@Test
	public void phragmitesResearchTest() {
		Game.PH.addPhragmites(200, 400);
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("MagGlass should be true",SC.getMagGlass());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.PH.getPhragmites(0).getX()+20) * i)/100) + ((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.PH.getPhragmites(0).getY()+20) * i)/100) + ((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("isResearched should be true",Game.getPhragmitesHandler().isResearched());		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if researching CordGrass works
	 */
	@Test
	public void cordGrassResearchTest() {
		Game.CGH.addCordGrass(200, 400);
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("MagGlass should be true",SC.getMagGlass());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.CGH.getCordGrass(0).getX()+20) * i)/100) + ((Game.TLC.getMag().getX()+TLV.getMag().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.CGH.getCordGrass(0).getY()+20) * i)/100) + ((Game.TLC.getMag().getY()+TLV.getMag().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("isResearched should be true",Game.getCordGrassHandler().isResearched());		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if deleting Phragmites works
	 */
	@Test
	public void deletePhragmitesTest() {
		Game.PH.addPhragmites(200, 400);
		int size = Game.PH.getPhragmites().size();
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getShears().getX()+TLV.getShears().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getShears().getY()+TLV.getShears().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("Shears should be true",SC.getShears());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.PH.getPhragmites(0).getX()+20) * i)/100) + ((Game.TLC.getShears().getX()+TLV.getShears().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.PH.getPhragmites(0).getY()+20) * i)/100) + ((Game.TLC.getShears().getY()+TLV.getShears().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertEquals("The # of Phragmites should be "+(size-1),Game.PH.getPhragmites().size(),size-1);		
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if deleting CordGrass works
	 */
	@Test
	public void deleteCordGrassTest() {
		Game.CGH.addCordGrass(200, 400);
		int size = Game.CGH.getCordGrass().size();
		for (int i=0; i<100; i++){  
		    int mov_x = (((Game.TLC.getShears().getX()+TLV.getShears().getWidth(null)/2) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((Game.TLC.getShears().getY()+TLV.getShears().getHeight(null)/2) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertTrue("Shears should be true",SC.getShears());
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.CGH.getCordGrass(0).getX()+20) * i)/100) + ((Game.TLC.getShears().getX()+TLV.getShears().getWidth(null)/2)*(100-i)/100);
		    int mov_y = (((Game.CGH.getCordGrass(0).getY()+20) * i)/100) + ((Game.TLC.getShears().getY()+TLV.getShears().getHeight(null)/2)*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
		Game.TV.repaint();
		Game.TV.update(G);
		assertEquals("The # of CordGrass should be "+(size-1),Game.PH.getPhragmites().size(),size-1);		
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the Crab drag functionality
	 */
	@Test
	public void dragCrabTest() {
		Game.CH.addCrab(200, 400);
		r.delay(500);
		r.mouseMove(Game.CH.getCrab(0).getX()+10, Game.CH.getCrab(0).getY()+10);
		r.mousePress(1024);
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.TLC.getCrabTrap().getX()+TLV.getCrabTrap().getWidth(null)/2+50) * i)/100) + (210*(100-i)/100);
		    int mov_y = (((Game.TLC.getCrabTrap().getY()+TLV.getCrabTrap().getHeight(null)/2+10) * i)/100) + (410*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.delay(100);
		assertTrue("Grabbing should return true",SC.grabbing);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the Turtle drag functionality
	 */
	@Test
	public void dragTurtleTest() {
		Game.TH.addTurtle(200, 400);
		r.delay(500);
		r.mouseMove(Game.TH.getTurtle(0).getX()+10, Game.TH.getTurtle(0).getY()+10);
		r.mousePress(1024);
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.TLC.getCrabTrap().getX()+TLV.getCrabTrap().getWidth(null)/2+50) * i)/100) + (210*(100-i)/100);
		    int mov_y = (((Game.TLC.getCrabTrap().getY()+TLV.getCrabTrap().getHeight(null)/2+10) * i)/100) + (410*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.delay(100);
		assertTrue("Grabbing should return true",SC.grabbing);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the BlueCrab drag functionality
	 */
	@Test
	public void dragBlueCrabTest() {
		Game.BCH.addBlueCrab(200, 400);
		r.delay(500);
		r.mouseMove(Game.BCH.getBlueCrab(0).getX()+10, Game.BCH.getBlueCrab(0).getY()+10);
		r.mousePress(1024);
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.TLC.getCrabTrap().getX()+TLV.getCrabTrap().getWidth(null)/2+50) * i)/100) + (210*(100-i)/100);
		    int mov_y = (((Game.TLC.getCrabTrap().getY()+TLV.getCrabTrap().getHeight(null)/2+10) * i)/100) + (410*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.delay(100);
		assertTrue("Grabbing should return true",SC.grabbing);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the Pollution drag functionality
	 */
	@Test
	public void dragPollutionTest() {
		Game.PolH.addPollution(200, 400);
		r.delay(500);
		r.mouseMove(Game.PolH.getPollution(0).getX()+10, Game.PolH.getPollution(0).getY()+10);
		r.mousePress(1024);
		for (int i=0; i<100; i++){  
			SC.checkPos(Game.CH, Game.TH, Game.BCH, Game.CGH, Game.PH, Game.TLC, Game.PolH);
			Game.TV.repaint();
			Game.TV.update(G);
		    int mov_x = (((Game.TLC.getRecycle().getX()+TLV.getRecycle().getWidth(null)/2+50) * i)/100) + (210*(100-i)/100);
		    int mov_y = (((Game.TLC.getRecycle().getY()+TLV.getRecycle().getHeight(null)/2+10) * i)/100) + (410*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.delay(100);
		assertTrue("Grabbing should return true",SC.grabbing);
	}
	
	/**
	 * @author Steven
	 * @Tests Tests click position getters and setters
	 */
	@Test
	public void clickTest() {
		SC.setClicked(true);
		assertTrue("Clicked should be true",SC.getClicked());
		SC.setClickx(25);
		assertEquals("ClickX should be 25",SC.getClickx(),25);
		SC.setClicky(37);
		assertEquals("ClickY should be 37",SC.getClicky(),37);
		
	}
}
