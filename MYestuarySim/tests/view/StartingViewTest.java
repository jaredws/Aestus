package view;

/**
 * @author Steven Sell
 * @Test Tests all functions of StartingView
 */

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.StartScreenControl;

public class StartingViewTest {
	
	static StartingView sv;
	static StartScreenControl ssc;
	static Random rand;
	static BufferedImage BG,title,play,settings,exit,intro,clipboard,timeUp,timeDown,soundOn,soundOff;
	static BufferedImage BGSV,titleSV,playSV,settingsSV,exitSV,introSV,clipboardSV,timeUpSV,timeDownSV,soundOnSV,soundOffSV;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ssc = new StartScreenControl();
		sv = new StartingView(ssc);
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			BG = ImageIO.read(new File("./img/bg.png"));
			title = ImageIO.read(new File("./img/title.png"));
			play = ImageIO.read(new File("./img/playButton.png"));
			settings = ImageIO.read(new File("./img/settingsButton.png"));
			exit = ImageIO.read(new File("./img/exitButton.png"));
			intro = ImageIO.read(new File("./img/Intro.png"));
			clipboard = ImageIO.read(new File("./img/clipboard.png"));
			timeUp = ImageIO.read(new File("./img/plus.png"));
			timeDown = ImageIO.read(new File("./img/minus.png"));
			soundOn = ImageIO.read(new File("./img/soundOn.png"));
			soundOff = ImageIO.read(new File("./img/soundOff.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		BG = Helper.toBufferedImage(BG.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH));
		title = Helper.toBufferedImage(title.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		play = Helper.toBufferedImage(play);
		settings = Helper.toBufferedImage(settings);
		exit = Helper.toBufferedImage(exit.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		intro = Helper.toBufferedImage(intro.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		clipboard = Helper.toBufferedImage(clipboard);
		timeUp = Helper.toBufferedImage(timeUp);
		timeDown = Helper.toBufferedImage(timeDown);
		soundOn = Helper.toBufferedImage(soundOn);
		soundOff = Helper.toBufferedImage(soundOff);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sv = null;ssc=null;rand=null;screenSize=null;
		BG = null;title = null;play = null;
		settings = null;exit = null;intro = null;
		clipboard = null;timeUp = null;timeDown = null;
		soundOn = null;soundOff = null;
	}
	
	
	
	/**
	 * @author Steven
	 * @Tests Creates a play button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getPlayTest() {
		playSV = Helper.toBufferedImage(StartingView.getPlay());
		assertEquals("The height of each image should be equal",playSV.getHeight(null),play.getHeight(null));
		assertEquals("The width of each image should be equal",playSV.getWidth(null),play.getWidth(null));
		int w = playSV.getHeight(null);
		int h = playSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",play.getRGB(ry, rx),playSV.getRGB(ry, rx));
		}
		assertEquals("PlayX should be "+((int)screenSize.getWidth()/2-play.getWidth(null)/2),StartingView.getPlayX(),(int)screenSize.getWidth()/2-play.getWidth(null)/2);
		assertEquals("PlayY should be 300",StartingView.getPlayY(),300);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a settings button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getSettingsTest() {
		settingsSV = Helper.toBufferedImage(StartingView.getSettings());
		assertEquals("The height of each image should be equal",settingsSV.getHeight(null),settings.getHeight(null));
		assertEquals("The width of each image should be equal",settingsSV.getWidth(null),settings.getWidth(null));
		int w = settingsSV.getHeight(null);
		int h = settingsSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",settings.getRGB(ry, rx),settingsSV.getRGB(ry, rx));
		}
		assertEquals("SettingsX should be "+((int)screenSize.getWidth()/2-settings.getWidth(null)/2),StartingView.getSettingsX(),(int)screenSize.getWidth()/2-settings.getWidth(null)/2);
		assertEquals("SettingsY should be 400",StartingView.getSettingsY(),400);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a clipboard and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getClipboardTest() {
		clipboardSV = Helper.toBufferedImage(StartingView.getClipboard());
		assertEquals("The height of each image should be equal",clipboardSV.getHeight(null),clipboard.getHeight(null));
		assertEquals("The width of each image should be equal",clipboardSV.getWidth(null),clipboard.getWidth(null));
		int w = clipboardSV.getHeight(null);
		int h = clipboardSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",clipboard.getRGB(ry, rx),clipboardSV.getRGB(ry, rx));
		}
		assertEquals("ClipboardX should be "+((int)screenSize.getWidth()/2-clipboard.getWidth(null)/2),StartingView.getClipboardX(),(int)screenSize.getWidth()/2-clipboard.getWidth(null)/2);
		assertEquals("ClipboardY should be "+((int)screenSize.getHeight()/2-clipboard.getHeight(null)/2),StartingView.getClipboardY(),(int)screenSize.getHeight()/2-clipboard.getHeight(null)/2);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a timeUp button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getTimeUpTest() {
		timeUpSV = Helper.toBufferedImage(StartingView.getTimeUp());
		assertEquals("The height of each image should be equal",timeUpSV.getHeight(null),timeUp.getHeight(null));
		assertEquals("The width of each image should be equal",timeUpSV.getWidth(null),timeUp.getWidth(null));
		int w = timeUpSV.getHeight(null);
		int h = timeUpSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",timeUp.getRGB(ry, rx),timeUpSV.getRGB(ry, rx));
		}
		assertEquals("TimeUpX should be "+((int)screenSize.getWidth()/2-timeUp.getWidth(null)/2+100),StartingView.getTimeUpX(),(int)screenSize.getWidth()/2-timeUp.getWidth(null)/2+100);
		assertEquals("TimeUpY should be "+((int)screenSize.getHeight()/2-timeUp.getHeight(null)/2),StartingView.getTimeUpY(),(int)screenSize.getHeight()/2-timeUp.getHeight(null)/2);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a timeDown button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getTimeDownTest() {
		timeDownSV = Helper.toBufferedImage(StartingView.getTimeDown());
		assertEquals("The height of each image should be equal",timeDownSV.getHeight(null),timeDown.getHeight(null));
		assertEquals("The width of each image should be equal",timeDownSV.getWidth(null),timeDown.getWidth(null));
		int w = timeDownSV.getHeight(null);
		int h = timeDownSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",timeDown.getRGB(ry, rx),timeDownSV.getRGB(ry, rx));
		}
		assertEquals("TimeDownX should be "+((int)screenSize.getWidth()/2-timeDown.getWidth(null)/2-100),StartingView.getTimeDownX(),(int)screenSize.getWidth()/2-timeDown.getWidth(null)/2-100);
		assertEquals("TimeDownY should be "+((int)screenSize.getHeight()/2-timeDown.getHeight(null)/2),StartingView.getTimeDownY(),(int)screenSize.getHeight()/2-timeDown.getHeight(null)/2);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a soundOn button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getSoundOnTest() {
		soundOnSV = Helper.toBufferedImage(StartingView.getSoundOn());
		assertEquals("The height of each image should be equal",soundOnSV.getHeight(null),soundOn.getHeight(null));
		assertEquals("The width of each image should be equal",soundOnSV.getWidth(null),soundOn.getWidth(null));
		int w = soundOnSV.getHeight(null);
		int h = soundOnSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",soundOn.getRGB(ry, rx),soundOnSV.getRGB(ry, rx));
		}
		assertEquals("SoundX should be 100",StartingView.getSoundX(),100);
		assertEquals("SoundY should be 100",StartingView.getSoundY(),100);
	}
	
	/**
	 * @author Steven
	 * @Tests Creates a soundOff button and makes sure it's equal to what the getter returns
	 */
	@Test
	public void getSoundOffTest() {
		soundOffSV = Helper.toBufferedImage(StartingView.getSoundOff());
		assertEquals("The height of each image should be equal",soundOffSV.getHeight(null),soundOff.getHeight(null));
		assertEquals("The width of each image should be equal",soundOffSV.getWidth(null),soundOff.getWidth(null));
		int w = soundOffSV.getHeight(null);
		int h = soundOffSV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",soundOff.getRGB(ry, rx),soundOffSV.getRGB(ry, rx));
		}
		assertEquals("SoundX should be 100",StartingView.getSoundX(),100);
		assertEquals("SoundY should be 100",StartingView.getSoundY(),100);
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to make sure incTime increases the time by 12 seconds
	 */
	@Test
	public void incTimeTest() {
		assertEquals("Time should be 120 seconds",StartingView.getTime(),120);
		StartingView.incTime();
		assertEquals("Time should be 132 seconds",StartingView.getTime(),132);
	}
	
	/**
	 * @author Steven
	 * @Tests Checks to make sure decTime decreases the time by 12 seconds
	 */
	@Test
	public void decTimeTest() {
		assertEquals("Time should be 132 seconds",StartingView.getTime(),132);
		StartingView.decTime();
		assertEquals("Time should be 120 seconds",StartingView.getTime(),120);
		for(int i =0;i<10;i++) {
			StartingView.decTime();
		}
		assertEquals("Time should be 0 seconds",StartingView.getTime(),0);
		for(int i =0;i<10;i++) {
			StartingView.incTime();
		}
	}
}
