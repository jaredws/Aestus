package controller;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JLabel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BlueCrabHandler;
import model.CordGrassHandler;
import model.CrabHandler;
import model.HealthHandler;
import model.PhragmitesHandler;
import model.PollutionHandler;
import model.PopulationHandler;
import model.TurtleHandler;
import view.EndingView;
import view.ToolView;
import view.TotalView;
/**
 * @author Steven Sell
 * @Test Tests all functions of EndScreenControl
 */
public class EndScreenControlTest {

	static Game G;
	static Robot r;
	static Dimension screenSize;
	static EndScreenControl ESC;
	static PopulationHandler PopH;
	static EndingView EV;
	
	@BeforeClass
	public static void setUp() throws Exception {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		r = new Robot();
		G = new Game(true);
		G.start(G);
		G.run(G);
		int health = G.calculateHealth();
		ESC = new EndScreenControl();
		EV = new EndingView(ESC, Game.PopH, health);
		EV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		Game.TV.dispose();
		EV.add(EV.getScoreLabel());
		EV.add(EV.getResearchedLabel());
		for(JLabel l: EV.getSpeciesLabels()) {
			if(!l.getText().equals("Species")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		for(JLabel l: EV.getRemoveLabels()) {
			if(!l.getText().equals("Removed")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		for(JLabel l: EV.getDiedLabels()) {
			if(!l.getText().equals("Died")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		for(JLabel l: EV.getEndLabels()) {
			if(!l.getText().equals("End")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		
		Game.getCrabHandler().setResearched(true);
		Game.getBlueCrabHandler().setResearched(true);
		Game.getTurtleHandler().setResearched(true);
		Game.getPhragmitesHandler().setResearched(true);
		Game.getCordGrassHandler().setResearched(true);
		ESC.checkPos();
		EV.repaint();
		EV.update(EV.getGame());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		EV.dispose();
		EV.close();
		G = null;
		r = null;
		EV = null;
		ESC = null;
		PopH = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to see if Easter Egg works
	 */
	@Test
	public void researcherTest() {
		ESC.checkPos();
		EV.repaint();
		EV.update(G);
		for (int i=0; i<100; i++){  
		    int mov_x = (((EndingView.getResearcherX()+EndingView.getResearcher().getWidth(null)/2+50) * i)/100) + (200*(100-i)/100);
		    int mov_y = (((EndingView.getResearcherY()+EndingView.getResearcher().getHeight(null)/2+50) * i)/100) + (400*(100-i)/100);
		    r.mouseMove(mov_x,mov_y);
		    r.delay(3);
		}
		r.mousePress(1024);
		r.delay(100);
		r.mouseRelease(1024);
		ESC.checkPos();
		EV.repaint();
		EV.update(G);
		assertFalse("Clicked should be false",ESC.getClicked());
		assertTrue("EasterEgg should be true",ESC.getEE());
	}
	
	
	
	
}
