package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Button {
	int x;
	int y;
	int type;
	int sizeX;
	int sizeY;
	public BufferedImage image;
	public Button(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.sizeX = 100;
		this.sizeY = 100;
		this.type = type;
		try {    
			if(type == 0){
	          image = ImageIO.read(new File("./img/trashB.png"));
			}
			else if(type == 1){
				image = ImageIO.read(new File("./img/bucket.png"));
			}
			} catch (IOException ex) {
	            // handle exception...
	       }
	    }
	}

