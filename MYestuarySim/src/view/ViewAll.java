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


public class ViewAll extends ViewTemplate{
	
	private List<BufferedImage> images;
	
	/**
	 * Buffer the images of all objects.
	 */
	public ViewAll(){
		images = new ArrayList<BufferedImage>();
		BufferedImage image;
		String[] names = {"Blue Crab","Crab Front","Crab side left","grass","Turtle"};
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image);
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
		}
		
	}
	/**
	 * 
	 * @param enum the enumerated type of the object
	 * @return The buffered image of the object
	 */
	public BufferedImage getImage(ePictures num){
		return(images.get(num.getIndex()));
	}

}