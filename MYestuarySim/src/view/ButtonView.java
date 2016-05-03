package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.Image;


public class ButtonView{

	private List<Image> images;

	public ButtonView(){
		images = new ArrayList<Image>();
		Image image;
		String[] fileNames = {"recycle", "bucket", "menuSmall", "help2","mag","pause"};
		
		
		for(String name: fileNames){
			try {    
				image = ImageIO.read(new File("./img/"+name+".png"));
				images.add(image);
				} catch (IOException ex) {
				// handle exception...
			}

		}
		
	}
	
	/**
	 * 
	 * @param i
	 * @return Image
	 * 0-trash, 1-bucket
	 */
	public Image getImage(int i){
		return images.get(i);
	}
}
