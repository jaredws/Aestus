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
 * The Class ResearchView. Produces the images needed for the various research states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class ResearchView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** The screen size. */
	Dimension screenSize;
	
	/**
	 * Constructor
	 * Creates a new instance of ResearchView with default imageloads
	 * Buffer the images we will need to move the pollution around the screen.
	 */
	public ResearchView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"MittenResearch", "PhragmitesResearch", "CrabResearch", "TurtleResearch", "CordGrassResearch"};
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
			for(int i = 1; i< 4; i++){
				try {           
					image = ImageIO.read(new File("./img/"+fileName+i+".png"));
					//images.add(image);
					images.add(image.getScaledInstance(-1,(int)screenSize.getHeight() - 150, Image.SCALE_SMOOTH));
			       } catch (IOException ex) {
			    	   System.out.println("Research Image read error");
			       }
			}
		}
		
	}
	
	/**
	 * Gets the image.
	 *
	 * @param i the index of the desired image
	 * @return The buffered image of the Research Window
	 * 0-MittenCrab, 3-Phragmites, 6-BlueCrab, 9-Turtle, 12 CordGrass
	 */
	public Image getImage(int i){
		
			return(images.get(i));
	}
}
