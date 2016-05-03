package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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

public class BackgroundView {
	
	private List<Image> images;
	
	/**
	 * Buffer the Backgrounds we will circulate through 
	 * 
	 */
	public BackgroundView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"Good","Okay","bad"};
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
	         image = ImageIO.read(new File("./img/"+fileName+".png"));
	         images.add(image.getScaledInstance((int)screenSize.getWidth(), -1,1));
	       } catch (IOException ex) {
	            // handle exception...
	       }
		}	
	}
	
	/**
	 * 
	 * @param i
	 * @return Buffered Image of the corresponding background
	 * 
	 * i should be the index of the buffered Image
	 * 0 - Good, 1 - poor, 2 - bad
	 */
	public Image switchImage(int i){
		return images.get(i);
	}

}
