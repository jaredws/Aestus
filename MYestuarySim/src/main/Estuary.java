package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Estuary {
	int x;
	int y;
	int sizeX;
	int sizeY;
	public BufferedImage perfect;
	public BufferedImage ok;
	public BufferedImage bad;
	public Estuary(int x, int y){
		this.x = x;
		this.y = y;
		this.sizeX = 1500;
		this.sizeY = 1000;
		try {                
	          perfect = ImageIO.read(new File("./img/estuary.png"));
	          ok = ImageIO.read(new File("./img/ok.png")); 
	          bad = ImageIO.read(new File("./img/bad.png")); 
	       } catch (IOException ex) {
	            // handle exception...
	       }
	    }
	
	public BufferedImage check(int crabs){
		if(crabs < 9){
			return bad;
		}else if(crabs < 15){
			return ok;
		}else
			return perfect;
		
	}
	}

