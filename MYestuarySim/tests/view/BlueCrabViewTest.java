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

public class BlueCrabViewTest {
	
	static BlueCrabView bcv;
	static Random rand;
	static BufferedImage bcvi;
	static BufferedImage img;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bcv = new BlueCrabView();
		bcvi = Helper.toBufferedImage(bcv.getImage(0));
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			img = ImageIO.read(new File("./img/BlueCrab.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		img = Helper.toBufferedImage(img.getScaledInstance((int)screenSize.getWidth()/(38+12), -1,Image.SCALE_SMOOTH));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bcv = null;
		bcvi = null;
		img = null;
	}

	@Test
	public void imageDimensionTest() {
		assertEquals("The height of each image should be equal",bcvi.getHeight(null),img.getHeight(null));
		assertEquals("The width of each image should be equal",bcvi.getWidth(null),img.getWidth(null));
	}
	
	@Test
	public void imagePixelComparisonTest() {
		int w = bcvi.getHeight(null);
		int h = bcvi.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img.getRGB(ry, rx),bcvi.getRGB(ry, rx));
		}
	}
	
	@Test
	public void getImageTest() {
		for(int i=0;i<100;i++) {
			bcv.getImage(50);
		}
		assertEquals("Count should be 100",bcv.getCount(),100);
		for(int i=0;i<150;i++) {
			bcv.getImage(50);
		}
		assertEquals("Count should be 250",bcv.getCount(),250);
		for(int i=0;i<51;i++) {
			bcv.getImage(50);
		}
		assertEquals("Count should be 0",bcv.getCount(),0);
	}
}
