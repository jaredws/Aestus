package controller;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import view.StartingView;
/**
 * @author Steven Sell
 * @Test Tests all functions of StartScreenControl
 */
public class StartScreenControlTest {

	static Game G;
	static Robot r;
	static Dimension screenSize;
	static StartScreenControl s;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r = new Robot();
		G = new Game(true);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		s = new StartScreenControl();
		Game.SV = new StartingView(s);
		Game.SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		G = null;
		Game.SV.dispose();
		r = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Explores each function of the Main Menu to make sure it's functioning correctly
	 */
	@Test
	public void mainMenuTest() {
		s.check();
		int x = 0;
		while(x < 100) {
			if(x==10) {
				r.mouseMove(StartingView.getSettingsX()+StartingView.getSettings().getWidth(null)/2,StartingView.getSettingsY()+StartingView.getSettings().getHeight(null)/2);
			} else if(x==20) {
				r.mouseMove(StartingView.getTimeUpX()+StartingView.getTimeUp().getWidth(null)/2,StartingView.getTimeUpY()+StartingView.getTimeUp().getHeight(null)/2);
			} else if(x==30) {
				r.mouseMove(StartingView.getTimeDownX()+StartingView.getTimeDown().getWidth(null)/2,StartingView.getTimeDownY()+StartingView.getTimeDown().getHeight(null)/2);
			} else if(x==40) {
				r.mouseMove(StartingView.getSoundX()+StartingView.getSound().getWidth(null)/2,StartingView.getSoundY()+StartingView.getSound().getHeight(null)/2);
			} else if(x==50) {
				r.mouseMove(StartingView.getClipboardX()+StartingView.getClipboard().getWidth(null)+100, StartingView.getSettingsY()+StartingView.getSettings().getHeight(null)/2);
			} else if(x==60) {
				r.mouseMove(StartingView.getPlayX()+StartingView.getPlay().getWidth(null)/2,StartingView.getPlayY()+StartingView.getPlay().getHeight(null)/2);
			}else if(x==70) {
				r.mouseMove(StartingView.getClipboardX()+StartingView.getClipboard().getWidth(null)+100, StartingView.getSettingsY()+StartingView.getSettings().getHeight(null)/2);
			}
			if(x % 10 == 0) {
				r.mousePress(1024);
				r.mouseRelease(1024);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.check();
			if(x==10) assertTrue("Settings should be true",s.getSettings());
			else if(x==20) assertTrue("TimeInc should be true",s.getTimeInc());
			else if(x==30) assertTrue("TimeDec should be true",s.getTimeDec());
			else if(x==40) assertFalse("Sound should be false",SoundController.getSound());
			else if(x==50) assertTrue("Main should be true",s.getMain());
			else if(x==60) assertTrue("Intro should be true",s.getIntro());
			else if(x==70) assertFalse("Showing should be false",s.getShowing());
			x++;
			
		}
	}
}
