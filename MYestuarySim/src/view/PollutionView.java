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
 * The Class PollutionView. Produces the images needed for the various pollution states,
 * used by the @see view.TotalView.java
 * @author Team 0
 */
public class PollutionView extends ViewTemplate{
	
	/** The list of images. */
	private List<Image> images;
	
	/** The screen size. */
	Dimension screenSize;
	
	/**
	 * Constructor
	 * Creates a new instance of PollutionView with default imageloads
	 * Buffer the images we will need to move the pollution around the screen.
	 */
	public PollutionView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"pollution1","pollution2","pollution3"};
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
			image = ImageIO.read(new File("./img/"+fileName+".png"));              
			images.add(image.getScaledInstance((int)screenSize.getWidth()/20, -1,Image.SCALE_SMOOTH));
	       } catch (IOException ex) {
	    	   System.out.println("Pollution Image read error");
	       }
		}
	}
	

	
	
	/**
	 * Gets the image.
	 *
	 * @param i - the type of the trash (held in the trash model)
	 * @return The buffered image of the pollution
	 */
	public Image getImage(int i){
		//
			return(images.get(i)); //bag of chips
		}
	}
