package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author Steven
 *
 */

public class CountdownView {
	
	private List<Image> images;

	
	Dimension screenSize;
	
	public CountdownView(){
		images = new ArrayList<Image>();
		Image image;
		String names = "";
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try{
			for(int i = 1; i < 13; i++){ 
				image = ImageIO.read(new File("./img/Clock " + i +".png"));          
				images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
			}
			images.add(images.get(0));
			image = ImageIO.read(new File("./img/Clock 10 Flash.png"));          
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
			image = ImageIO.read(new File("./img/Clock 11 Flash.png"));          
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
			image = ImageIO.read(new File("./img/Clock 12 Flash.png"));          
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
		} catch (IOException ex) {
	    	   System.out.println("Crab Image read error");
	       }
	}

	public Image getImage(int i){
		return images.get(i);
	}
	

}
