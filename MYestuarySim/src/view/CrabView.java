package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * The Class CrabView. Produces the images needed for the various crab states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class CrabView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** The Image objects to be displayed depending on the circumstance. */
	Image image2, image3;
	
	/** A counter used in calculating which image of the crab to load. */
	int count;
	/**
	 * Constructor
	 * Creates a new instance of CrabView with default imageloads.
	 * Buffer the images we will need to move Crabs around the screen.
	 */
	public CrabView(){
		images = new ArrayList<Image>();
		Image image;
		String names = "Crab";
		String bcrab1 = "Crab1";
		String bcrab2 = "Crab2";
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try{
		image = ImageIO.read(new File("./img/"+names+".png"));
			for(int i = 0; i < 38; i++){               
				images.add(image.getScaledInstance((int)screenSize.getWidth()/(38+12-i), -1,Image.SCALE_SMOOTH));
			}
		image2 = ImageIO.read(new File("./img/"+bcrab1+".png"));
		image3 = ImageIO.read(new File("./img/"+bcrab2+".png"));
		image2 = image2.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH);
		image3 = image3.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH);
		} catch (IOException ex) {
	    	   System.out.println("Crab Image read error");
	       }
	}
		
	
	/**
	 * Gets the image.
	 *
	 * @param i the index of the image to get
	 * @return The buffered image of the Crab
	 * 0-Front, 1-back, 2-left, 3-right
	 */
	public Image getImage(int i){
		if(i < 38)
			return images.get(i);
		else {
			if(count < 200) {
				count++;
				return image2;
			} else if(count < 300) {
				count++;
				return image3;
			} else if(count == 300){ 
				count = 0;
			}
		}
		return image3;
	}
	
	/**
	 * Gets the count.
	 */
	public int getCount() {
		return count;
	}
}
