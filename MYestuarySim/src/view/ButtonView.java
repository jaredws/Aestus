package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



public class ButtonView{

	private List<BufferedImage> images;

	public ButtonView(){
		images = new ArrayList<BufferedImage>();
		BufferedImage image;
		String[] fileNames = {"trashB", "bucket", "bucket"};
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
	 * @return BufferedImage
	 * 0-trash, 1-bucket
	 */
	public BufferedImage getImage(int i){
		return images.get(i);
	}
}
