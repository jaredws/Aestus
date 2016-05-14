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
 * @author Jared Sharpe
 *
 */

public class TurtleView extends ViewTemplate{
	
	private List<Image> images;
	Dimension screenSize;
	Image image2, image3;
	int test = 0;
	/**
	 * Buffer the images we will need to move crabs around the screen.
	 */
	//may consider making this private and using a method to only allow one instnace
	public TurtleView(){
		images = new ArrayList<Image>();
		Image image;
		String names = "Turtle";
		String name = "Turtle2";
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try{
		image = ImageIO.read(new File("./img/"+names+".png"));
			for(int i = 0; i < 38; i++){               
				images.add(image.getScaledInstance((int)screenSize.getWidth()/(38+12-i), -1,Image.SCALE_SMOOTH));
			}
			image2 = ImageIO.read(new File("./img/"+name+".png"));
			image2 = image2.getScaledInstance((int)screenSize.getWidth()/13, -1,Image.SCALE_SMOOTH);
		
		} catch (IOException ex) {
	    	   System.out.println("BlueCrab Image read error");
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
		if(i < 38)
			return images.get(i);
		else {
			if(test < 200) {
				test++;
				return images.get(37);
			} else if(test < 300) {
				test++;
				return image2;
			} else if(test == 300){ 
				test = 0;
			}
		}
		return image2;
	}
}