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
 * The Class BackgroundView. Produces the images needed for the various background states,
 * used by the @see view.TotalView.java
 *
 * @author Team 0
 */

public class BackgroundView {
	
	/** The list of images. */
	private List<Image> images;
	
	/**
	 * Constructor
	 * Creates a new instance of BackgroundView with default values, loads default images.
	 * Buffer the Backgrounds we will circulate through.
	 */
	public BackgroundView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"background3","background2","background1"};
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH));
	       } catch (IOException ex) {
	    	   System.out.println("Background Image read error");
	       }
		}	
	}
	
	/**
	 * Switch the image based on estuary health.
	 *
	 * @param i the index of the image: 0 - good, 1 - poor, 2 - bad
	 * @return Buffered Image of the corresponding background
	 * 
	 */
	public Image switchImage(int i){
		return images.get(i);
	}

}
