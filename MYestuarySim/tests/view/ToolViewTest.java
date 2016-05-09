package view;

/**
 * @author Steven
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

public class ToolViewTest {
	
	static ToolView tv;
	static Random rand;
	static BufferedImage recycleTV,shearsTV,magTV,crabtrapTV,pauseBTV;
	static BufferedImage recycle,shears,mag,crabtrap,pauseB;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tv = new ToolView();
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			recycle = ImageIO.read(new File("./img/recycle.png"));
			shears = ImageIO.read(new File("./img/shears.png"));
			mag = ImageIO.read(new File("./img/mag.png"));
			crabtrap = ImageIO.read(new File("./img/crabtrap.png"));
			pauseB = ImageIO.read(new File("./img/pauseB.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		recycle = Helper.toBufferedImage(recycle.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		shears = Helper.toBufferedImage(shears.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		mag = Helper.toBufferedImage(mag.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		crabtrap = Helper.toBufferedImage(crabtrap.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		pauseB = Helper.toBufferedImage(pauseB.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tv = null;
		recycleTV = null;shearsTV = null;magTV = null;
		recycle = null;shears = null;mag = null;
	}
	
	@Test
	public void getRecycleTest() {
		recycleTV = Helper.toBufferedImage(tv.getRecycle());
		assertEquals("The height of each image should be equal",recycleTV.getHeight(null),recycle.getHeight(null));
		assertEquals("The width of each image should be equal",recycleTV.getWidth(null),recycle.getWidth(null));
		int w = recycleTV.getHeight(null);
		int h = recycleTV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",recycle.getRGB(ry, rx),recycleTV.getRGB(ry, rx));
		}
	}
	
	@Test
	public void getShearsTest() {
		shearsTV = Helper.toBufferedImage(tv.getShears());
		assertEquals("The height of each image should be equal",shearsTV.getHeight(null),shears.getHeight(null));
		assertEquals("The width of each image should be equal",shearsTV.getWidth(null),shears.getWidth(null));
		int w = shearsTV.getHeight(null);
		int h = shearsTV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",shears.getRGB(ry, rx),shearsTV.getRGB(ry, rx));
		}
	}
	
	@Test
	public void getMagTest() {
		magTV = Helper.toBufferedImage(tv.getMag());
		assertEquals("The height of each image should be equal",magTV.getHeight(null),mag.getHeight(null));
		assertEquals("The width of each image should be equal",magTV.getWidth(null),mag.getWidth(null));
		int w = magTV.getHeight(null);
		int h = magTV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",mag.getRGB(ry, rx),magTV.getRGB(ry, rx));
		}
	}
	
	@Test
	public void getCrabTrapTest() {
		crabtrapTV = Helper.toBufferedImage(tv.getCrabTrap());
		assertEquals("The height of each image should be equal",crabtrapTV.getHeight(null),crabtrap.getHeight(null));
		assertEquals("The width of each image should be equal",crabtrapTV.getWidth(null),crabtrap.getWidth(null));
		int w = crabtrapTV.getHeight(null);
		int h = crabtrapTV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",crabtrap.getRGB(ry, rx),crabtrapTV.getRGB(ry, rx));
		}
	}
	
	@Test
	public void getPauseBTest() {
		pauseBTV = Helper.toBufferedImage(tv.getPauseB());
		assertEquals("The height of each image should be equal",pauseBTV.getHeight(null),pauseB.getHeight(null));
		assertEquals("The width of each image should be equal",pauseBTV.getWidth(null),pauseB.getWidth(null));
		int w = pauseBTV.getHeight(null);
		int h = pauseBTV.getWidth(null);
		for(int i=0;i<10;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",pauseB.getRGB(ry, rx),pauseBTV.getRGB(ry, rx));
		}
	}
}
