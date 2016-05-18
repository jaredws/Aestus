package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * The Class PhragmitesView. Produces the images needed for the various phragmites states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class PhragmitesView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** The screen size. */
	Dimension screenSize;
	/**
	 * Constructor
	 * Creates a new instance of MagView with default imageloads
	 * Buffer the images we will need to move the magnifying glass around the screen.
	 */
	public PhragmitesView(){
		images = new ArrayList<Image>();
		Image image;
		String names = "Phragmites";
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try{
		image = ImageIO.read(new File("./img/"+names+".png"));
			for(int i = 0; i < 38; i++){               
				images.add(image.getScaledInstance((int)screenSize.getWidth()/(38+12-i), -1,Image.SCALE_SMOOTH));
			}
		} catch (IOException ex) {
	    	   System.out.println("BlueCrab Image read error");
	       }
	}
		
	
	/**
	 * Gets the image.
	 *
	 * @param i the index of the desired image
	 * @return The buffered image of the BlueCrab
	 * 0-Front, 1-back, 2-left, 3-right
	 */
	public Image getImage(int i){
		if(i < 38)
			return images.get(i);
		else
			return images.get(37);
	}
}
