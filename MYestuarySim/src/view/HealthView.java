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
 * 
 * @author Steven
 *
 */


public class HealthView extends ViewTemplate{
	
	private List<Image> images;
	
	/**
	 * Buffer the images we will need to move BlueCrabs around the screen.
	 */
	//may consider making this private and using a method to only allow one instnace
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
	 * 
	 * @param i
	 * @return The buffered image of the BlueCrab
	 * 0-Front, 1-back, 2-left, 3-right
	 */
	public Image getImage(int i){
		//Must remove %4 will be changed when calling it from above with motion idicator.
		return(images.get(0));
	}

}
