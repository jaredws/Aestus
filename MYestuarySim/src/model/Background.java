package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	int sizeX;
	int sizeY;
	public BufferedImage perfect;
	public BufferedImage ok;
	public BufferedImage bad;
	
	public Background(int x, int y) {
		this.sizeX = x;
		this.sizeY = y;
		try {                
	          perfect = ImageIO.read(new File("./img/estuary.png"));
	          ok = ImageIO.read(new File("./img/ok.png")); 
	          bad = ImageIO.read(new File("./img/bad.png")); 
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}
}
