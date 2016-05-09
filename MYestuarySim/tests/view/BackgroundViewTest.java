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

public class BackgroundViewTest {
	
	static BackgroundView bgv;
	static Random rand;
	static BufferedImage bgvi,bgvi2,bgvi3;
	static BufferedImage img,img2,img3;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bgv = new BackgroundView();
		bgvi = Helper.toBufferedImage(bgv.switchImage(0));
		bgvi2 = Helper.toBufferedImage(bgv.switchImage(1));
		bgvi3 = Helper.toBufferedImage(bgv.switchImage(2));
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			img = ImageIO.read(new File("./img/background3.png"));
			img2 = ImageIO.read(new File("./img/background2.png"));
			img3 = ImageIO.read(new File("./img/background1.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		img = Helper.toBufferedImage(img.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH));
		img2 = Helper.toBufferedImage(img2.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH));
		img3 = Helper.toBufferedImage(img3.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bgv = null;
		bgvi = null;bgvi2 = null;bgvi3 = null;
		img = null;img2 = null;img3 = null;
	}

	@Test
	public void imageDimensionTest() {
		assertEquals("The height of each image should be equal",bgvi.getHeight(null),img.getHeight(null));
		assertEquals("The width of each image should be equal",bgvi.getWidth(null),img.getWidth(null));
		assertEquals("The height of each image should be equal",bgvi2.getHeight(null),img2.getHeight(null));
		assertEquals("The width of each image should be equal",bgvi2.getWidth(null),img2.getWidth(null));
		assertEquals("The height of each image should be equal",bgvi3.getHeight(null),img3.getHeight(null));
		assertEquals("The width of each image should be equal",bgvi3.getWidth(null),img3.getWidth(null));
	}
	
	@Test
	public void imagePixelComparisonTest() {
		int w = bgvi.getHeight(null);
		int h = bgvi.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img.getRGB(ry, rx),bgvi.getRGB(ry, rx));
		}
	}
	
	@Test
	public void image2PixelComparisonTest() {
		int w = bgvi2.getHeight(null);
		int h = bgvi2.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img2.getRGB(ry, rx),bgvi2.getRGB(ry, rx));
		}
	}
	
	@Test
	public void image3PixelComparisonTest() {
		int w = bgvi3.getHeight(null);
		int h = bgvi3.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img3.getRGB(ry, rx),bgvi3.getRGB(ry, rx));
		}
	}
}
