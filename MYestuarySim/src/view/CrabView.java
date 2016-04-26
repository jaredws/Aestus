package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * 
 * @author Jared Sharpe
 *
 */


public class CrabView extends ViewTemplate{
	
	private List<BufferedImage> images;
	
	/**
	 * Buffer the images we will need to move crabs around the screen.
	 */
	//may consider making this private and using a method to only allow one instnace
	public CrabView(){
		images = new ArrayList<BufferedImage>();
		BufferedImage image;
		String[] names = {"Blue Crab", "Crab Front", "Crab side left", "Crab side right"};
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image);
	       } catch (IOException ex) {
	    	   System.out.println("Crab Image read error");
	       }
		}
		
	}
	/**
	 * 
	 * @param i
	 * @return The buffered image of the crab
	 * 0-Front, 1-back, 2-left, 3-right
	 */
	public BufferedImage getImage(int i){
		//Must remove %4 will be changed when calling it from above with motion idicator.
		return(images.get(i%4));
	}

}
