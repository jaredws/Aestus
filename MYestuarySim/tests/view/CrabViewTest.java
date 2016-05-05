package view;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CrabViewTest {
	
	static CrabView cv;
	static Image image;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cv = new CrabView();
		try { 
			image = ImageIO.read(new File("./img/Crab Front.png"));
       } catch (IOException ex) {
    	   System.out.println("Crab Image read error");
       }
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cv = null;
	}

	@Test
	public void test() {
		assertTrue(cv.getImage(0).hashCode()==image.hashCode());
	}

}
