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
 * 
 * @author Jared Sharpe
 *
 */


public class ViewAll extends ViewTemplate{
	
	private List<Image> images;
	
	/**
	 * Buffer the images of all objects.
	 */
	public ViewAll(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"Blue Crab","Crab Front","Phragmites","grass","Turtle"};
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,1))	;
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
		}
		
	}
	/**
	 * 
	 * @param index from the eClasses enum the enumerated type of the object
	 * @return The buffered image of the object
	 */
	public Image getImage(int i){
		return(images.get(i));
	}

}