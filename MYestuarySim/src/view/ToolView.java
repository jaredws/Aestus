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

public class ToolView extends ViewTemplate{
	
	private List<Image> images;
	Dimension screenSize;

	public ToolView(){
		images = new ArrayList<Image>();
		Image image;
		String[] names = {"recycle","shears","mag","crabtrap","pauseB","shearsOpen","shearsClose"};
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		for(String fileName: names){
		try {                
			image = ImageIO.read(new File("./img/"+fileName+".png"));
			images.add(image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH));
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
		}
		
	}

	public Image getImage(int i) {
		return images.get(i);
	}
	
	public Image getMag() {
		return images.get(2);
	}
	
	public Image getShears(){
		return images.get(1);
	}
	
	public Image getCrabTrap() {
		return images.get(3);
	}
	
	public Image getRecycle() {
		return images.get(0);
	}
	
	public Image getPauseB() {
		return images.get(4);
	}
	
	public Image getShearsOpen() {
		return images.get(5);
	}
	
	public Image getShearsClose() {
		return images.get(6);
	}
}
