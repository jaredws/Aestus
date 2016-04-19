package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

import model.Crab;
import controller.Game;

public class ScreenButton extends JButton {
	int x;
	int y;
	int j = 0;
	public int clickx;
	int clicky;
	public boolean addCrab;
	Crab grabbed;
	boolean grabbing;

	public ScreenButton(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	    setBorderPainted(false);
	    setFocusPainted(false);
	    setContentAreaFilled(false);
	
	
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	if((e.getX() > 0 && e.getX() < 100) && (e.getY() > 625 && e.getX() < 750)){
        		addCrab = true;
        	}
        	grabbing = false;
            clickx = e.getX();
            clicky = e.getY();
   			 
        }
        
        public void mouseReleased(MouseEvent e){
        	grabbed = null;
        	grabbing = false;
        	x = -1;
        	y = -1;
        	j = -1;
        }
	});
	
	addMouseMotionListener(new MouseMotionAdapter(){
    	//If mouse is being dragged whilst holding the button
        public void mouseDragged(MouseEvent e){
        	x = e.getX()-165/2;
        	y = e.getY()-165/2;
        }
    });
	}
	public void checkPos(CrabControl c){
		
		if(!grabbing){
			for(int i = 0; i < c.crabs.size(); i++){
				if(((x-c.crabs.get(i).sizeX/2) < c.crabs.get(i).getX()) && (c.crabs.get(i).getX() < (x+c.crabs.get(i).sizeX/2))){
					if(((y-c.crabs.get(i).sizeY/2) < c.crabs.get(i).getY()) && (c.crabs.get(i).getY() < (y+c.crabs.get(i).sizeY/2))){
						grabbed = c.crabs.get(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		if((j > -1 && j < c.crabs.size()) && c.crabs.get(j).equals(grabbed)){
			c.crabs.get(j).setX(x);
			c.crabs.get(j).setY(y);	
		}
	}
}
	

