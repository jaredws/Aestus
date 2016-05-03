package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.BlueCrab;
import model.CordGrass;
import model.Crab;
import model.Grabbable;
import model.Phragmites;
import model.Turtle;
import controller.Game;

public class ScreenButton extends JButton {
	
	//Implament listener on the frame??? -JS
	int x;
	int y;
	int magX;
	int magY;
	int j = 0;
	public int clickx;
	int clicky;
	public boolean addCrab;//Do we really need this?
	public boolean addTurtle;
	public boolean addBlueCrab;
	public boolean addCordGrass;
	public boolean addPhragmites;
	Grabbable grabbed;
	boolean grabbing;
	boolean clicked;
	Random rand = new Random();
	Dimension screenSize;
	public boolean magGlass = false;
	public boolean menu;
	public int research;
	public boolean pause;
	
	ImageIcon icon;
	
	public ScreenButton(){
		icon = new ImageIcon("../img/mag.png");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	    setBorderPainted(false);
	    setFocusPainted(false);
	    setContentAreaFilled(false);

	    menu = false;
	    research = -1;
		pause = false;
	    
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	if((e.getX() > 0 && e.getX() < (100)) && (e.getY() > (screenSize.getHeight()-150) && e.getY() < screenSize.getHeight())){
        		int k = rand.nextInt(5);
        		switch(k){
        		case (0):addCrab = true;break;
        		case (1):addTurtle = true;break;
        		case (2):addBlueCrab = true;break;
        		case (3):addPhragmites = true;break;
        		case (4):addCordGrass = true;break;
        		}
        	}
        	grabbing = false;
            clickx = e.getX();
            clicky = e.getY();
            x = e.getX();
            y = e.getY();
            clicked = true;
            pause = false;
        }
        
        public void mouseReleased(MouseEvent e){
        	grabbed = null;
        	grabbing = false;
        	x = -1;
        	y = -1;
        	j = -1;
        	clicked = false;
        }
        
	});
	
	addMouseMotionListener(new MouseMotionAdapter(){
    	//If mouse is being dragged whilst holding the button
        public void mouseDragged(MouseEvent e){
        	//must be replaced by image height and width /2
        	clicked = false;
        	if(grabbing){
        		x = e.getX();
        		y = e.getY();
        	}
        }
        
		public void mouseMoved(MouseEvent e) {
	        if(magGlass == true) {
	        	magX = e.getX();
	        	magY = e.getY();
	        }
    	}
    });
	}
	public void checkPos(CrabControl c, TurtleControl t, BlueCrabControl bc, CordGrassControl cgc, PhragmitesControl pc, ButtonControl b){
		if(clicked){
			if(clickx > b.getButtons().get(4).getX() && clickx < b.getButtons().get(4).getSizeX()+b.getButtons().get(4).getX() &&
					clicky > b.getButtons().get(4).getY() && clicky < b.getButtons().get(4).getSizeY()+b.getButtons().get(4).getY()) {
				if(magGlass == false) magGlass = true;
				else magGlass = false;
				clicked = false;
			}
			
			if(clickx > b.getButtons().get(3).getX() && clickx < b.getButtons().get(3).getSizeX()+b.getButtons().get(3).getX() &&
					clicky > b.getButtons().get(3).getY() && clicky < b.getButtons().get(3).getSizeY()+b.getButtons().get(3).getY()) {
				if(!menu)
					{menu = true;}
				else 
					{menu = false;}
				clicked = false;
			}
			
			
		if(!magGlass){
			if(!grabbing){
				for(int i = 0; i < c.crabs.size(); i++){
					if((clickx > c.getCrab(i).getX()) && (clickx < (c.getCrab(i).getX() + Crab.sizeX))){
						if(((clicky > c.getCrab(i).getY()) && (clicky < c.getCrab(i).getY()+Crab.sizeY))){
							grabbed = c.getCrab(i);
							grabbing = true;
							j = i;
							break;
							}
						}
				}
			}
		
		if(!grabbing){
			for(int i = 0; i < pc.Phragmites.size(); i++){
				if((clickx > pc.getPhragmites(i).getX()) && (clickx < (pc.getPhragmites(i).getX() + Phragmites.sizeX))){
					if(((clicky > pc.getPhragmites(i).getY()) && (clicky < pc.getPhragmites(i).getY()+Phragmites.sizeY))){
						grabbed = pc.getPhragmites(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		if(!grabbing){
			for(int i = 0; i < bc.BlueCrabs.size(); i++){
				if((clickx > bc.getBlueCrab(i).getX()) && (clickx < (bc.getBlueCrab(i).getX() + BlueCrab.sizeX))){
					if(((clicky > bc.getBlueCrab(i).getY()) && (clicky < bc.getBlueCrab(i).getY()+BlueCrab.sizeY))){
						grabbed = bc.getBlueCrab(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		
		if(!grabbing){
			for(int i = 0; i < t.turtles.size(); i++){
				if((clickx > t.getTurtle(i).getX()) && (clickx < (t.getTurtle(i).getX() + Turtle.sizeX))){
					if(((clicky > t.getTurtle(i).getY()) && (clicky < t.getTurtle(i).getY()+Turtle.sizeY))){
						grabbed = t.getTurtle(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		if(!grabbing){
			for(int i = 0; i < cgc.CordGrass.size(); i++){
				if((clickx > cgc.getCordGrass(i).getX()) && (clickx < (cgc.getCordGrass(i).getX() + CordGrass.sizeX))){
					if(((clicky > cgc.getCordGrass(i).getY()) && (clicky < cgc.getCordGrass(i).getY()+CordGrass.sizeY))){
						grabbed = cgc.getCordGrass(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
			}
		}
		
		if(magGlass){
				for(int i = 0; i < c.crabs.size(); i++){
					if((clickx > c.getCrab(i).getX()) && (clickx < (c.getCrab(i).getX() + Crab.sizeX))){
						if(((clicky > c.getCrab(i).getY()) && (clicky < c.getCrab(i).getY()+Crab.sizeY))){
							research = 0;
							magGlass = false;
							pause = true;
							clicked = false;
							}
						}
				}
				for(int i = 0; i < bc.BlueCrabs.size(); i++){
					if((clickx > bc.getBlueCrab(i).getX()) && (clickx < (bc.getBlueCrab(i).getX() + BlueCrab.sizeX))){
						if(((clicky > bc.getBlueCrab(i).getY()) && (clicky < bc.getBlueCrab(i).getY()+BlueCrab.sizeY))){
							research = 2;
							magGlass = false;
							pause = true;
							clicked = false;
							}
						}
				}
			
				for(int i = 0; i < t.turtles.size(); i++){
					if((clickx > t.getTurtle(i).getX()) && (clickx < (t.getTurtle(i).getX() + Turtle.sizeX))){
						if(((clicky > t.getTurtle(i).getY()) && (clicky < t.getTurtle(i).getY()+Turtle.sizeY))){
							research = 3;
							magGlass = false;
							pause = true;
							clicked = false;
							}
						}
				}
				for(int i = 0; i < pc.Phragmites.size(); i++){
					if((clickx > pc.getPhragmites(i).getX()) && (clickx < (pc.getPhragmites(i).getX() + Phragmites.sizeX))){
						if(((clicky > pc.getPhragmites(i).getY()) && (clicky < pc.getPhragmites(i).getY()+Phragmites.sizeY))){
							research = 1;
							magGlass = false;
							pause = true;
							clicked = false;
							}
						}
				}
			
				for(int i = 0; i < cgc.CordGrass.size(); i++){
					if((clickx > cgc.getCordGrass(i).getX()) && (clickx < (cgc.getCordGrass(i).getX() + CordGrass.sizeX))){
						if(((clicky > cgc.getCordGrass(i).getY()) && (clicky < cgc.getCordGrass(i).getY()+CordGrass.sizeY))){
							research = 4;
							magGlass = false;
							pause = true;
							clicked = false;
							}
						}
				}
			}
		}
		
		
		if((j > -1 && j < c.crabs.size()) && c.getCrab(j).equals(grabbed)){
			c.getCrab(j).setX(x - Crab.sizeX/2);
			c.getCrab(j).setY(y - Crab.sizeY/2);	
		}
		if((j > -1 && j < pc.Phragmites.size()) && pc.getPhragmites(j).equals(grabbed)){
			pc.getPhragmites(j).setX(x - Phragmites.sizeX/2);
			pc.getPhragmites(j).setY(y - Phragmites.sizeY/2);	
		}
		if((j > -1 && j < bc.BlueCrabs.size()) && bc.getBlueCrab(j).equals(grabbed)){
			bc.getBlueCrab(j).setX(x - BlueCrab.sizeX/2);
			bc.getBlueCrab(j).setY(y - BlueCrab.sizeY/2);	
		}
		if((j > -1 && j < t.turtles.size()) && t.getTurtle(j).equals(grabbed)){
			t.getTurtle(j).setX(x - Turtle.sizeX/2);
			t.getTurtle(j).setY(y - Turtle.sizeY/2);	
		}
		if((j > -1 && j < cgc.CordGrass.size()) && cgc.CordGrass.get(j).equals(grabbed)){
			cgc.getCordGrass(j).setX(x - CordGrass.sizeX/2);
			cgc.getCordGrass(j).setY(y - CordGrass.sizeY/2);	
		}
		
		
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ScreenButton.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public int getMagX() {
    	return this.magX;
    }
    
    public int getMagY() {
    	return this.magY;
    }
    
    public boolean getMagGlass() {
    	return this.magGlass;
    }
    
    public boolean getMenu() {
    	return this.menu;
    }
}
	

