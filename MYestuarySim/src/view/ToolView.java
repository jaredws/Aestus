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
 * The Class ToolView. Produces the images needed for the various tool states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class ToolView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** Select the glowing or not glowing image*/
	boolean glowMag;
	boolean glowShears;
	
	/** The screen size. */
	Dimension screenSize;

	/**
	 * Constructor
	 * Creates a new instance of ToolView with default imageloads
	 * Buffer the images we will need to move the pollution around the screen.
	 */
	public ToolView(){
		images = new ArrayList<Image>();
		Image image;
		glowMag = false;
		glowShears = false;
		String[] names = {"recycle","crabtrap","pauseB","shears","mag","shearsOpen","shearsClose","shearsGlow","magGlow"};
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
			image = ImageIO.read(new File("./img/"+fileName+".png"));
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
	       } catch (IOException ex) {
	    	   System.out.println("Tool Image read error");
	       }
		}
		
	}

	/**
	 * Gets the image.
	 *
	 * @param i the index of the desired image
	 * @return the image
	 */
	public Image getImage(int i) {
		return images.get(i);
	}
	
	/**
	 * Gets the mag tool.
	 * @param glow - boolean to select the glowing image or not
	 *
	 * @return the mag
	 */
	public Image getMag() {
		return images.get(4);
	}
	
	/**
	 * Gets the shears.
	 * @param glow - boolean to select the glowing image or not
	 *
	 * @return the shears
	 */
	public Image getShears(){
		return images.get(3);
	}
	
	/**
	 * Gets the crab trap.
	 *
	 * @return the crab trap
	 */
	public Image getCrabTrap() {
		return images.get(1);
	}
	
	/**
	 * Gets the recycling bin.
	 *
	 * @return the recycling bin
	 */
	public Image getRecycle() {
		return images.get(0);
	}
	
	/**
	 * Gets the pause button.
	 *
	 * @return the pause button
	 */
	public Image getPauseB() {
		return images.get(2);
	}
	
	/**
	 * Gets the open shears.
	 *
	 * @return the open shears
	 */
	public Image getShearsOpen() {
		return images.get(5);
	}
	
	/**
	 * Gets the closed shears.
	 *
	 * @return the closed shears 
	 */
	public Image getShearsClose() {
		return images.get(6);
	}
}
