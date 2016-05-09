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

public class PhragmitesViewTest {
	
	static PhragmitesView pv;
	static Random rand;
	static BufferedImage pvi;
	static BufferedImage img;
	static Dimension screenSize;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pv = new PhragmitesView();
		pvi = Helper.toBufferedImage(pv.getImage(0));
		rand = new Random();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			img = ImageIO.read(new File("./img/Phragmites.png"));
        } catch (IOException ex) {
    	   System.out.println("Image read error");
        }
		img = Helper.toBufferedImage(img.getScaledInstance((int)screenSize.getWidth()/(38+12), -1,Image.SCALE_SMOOTH));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		pv = null;
		pvi = null;
		img = null;
	}

	@Test
	public void imageDimensionTest() {
		assertEquals("The height of each image should be equal",pvi.getHeight(null),img.getHeight(null));
		assertEquals("The width of each image should be equal",pvi.getWidth(null),img.getWidth(null));
	}
	
	@Test
	public void imagePixelComparisonTest() {
		int w = pvi.getHeight(null);
		int h = pvi.getWidth(null);
		for(int i=0;i<100;i++) {
			int rx = rand.nextInt(w);
			int ry = rand.nextInt(h);
			assertEquals("The integer pixels should be equal",img.getRGB(ry, rx),pvi.getRGB(ry, rx));
		}
	}
}
