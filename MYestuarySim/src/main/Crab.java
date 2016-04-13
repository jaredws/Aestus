package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crab {
	int x;
	int y;
	int sizeX;
	int sizeY;
	public BufferedImage image;
	public Crab(int x, int y){
		this.x = x;
		this.y = y;
		this.sizeX = 165;
		this.sizeY = 165;
		try {                
	          image = ImageIO.read(new File("./img/Crab Front.png"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	    }
	}

