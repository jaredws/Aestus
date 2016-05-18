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
 * The Class HealthView. Produces the images needed for the various health states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class HealthView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/**
	 * Constructor
	 * Instantiates a new healthview with default imageloads and multiple scaled instances of each.
	 */
	public HealthView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"Star"};
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH))	;
	       } catch (IOException ex) {
	    	   System.out.println("Star Image read error");
	       }
		}
		
	}
	
	/**
	 * Gets the image.
	 *
	 * @param i the index of the desired image
	 * @return the image
	 */
	public Image getImage(int i){
		return(images.get(0));
	}

}
