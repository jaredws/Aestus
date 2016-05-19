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
 * The Class MagView. Produces the images needed for the various magnifying glass states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class MagView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** The screen size. */
	Dimension screenSize;
	
	/**
	 * Constructor
	 * Creates a new instance of MagView with default imageloads
	 * Buffer the images we will need to move the magnifying glass around the screen.
	 */
	public MagView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"mag", "magGlow"};
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
			image = ImageIO.read(new File("./img/"+fileName+".png"));
			images.add(image);
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
	       } catch (IOException ex) {
	    	   System.out.println("Mag Image read error");
	       }
		}
		
	}
	
	/**
	 * Gets the image.
	 *
	 * @param i the index of the desired image
	 * @return The buffered image
	 */
	public Image getImage(int i){
			return images.get(i);
	}
}
