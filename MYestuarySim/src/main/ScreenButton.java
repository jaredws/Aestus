package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

public class ScreenButton extends JButton {
	int x;
	int y;
	int j = 0;
	int clickx;
	int clicky;
	boolean addCrab;
	Crab grabbed;
	boolean grabbing;

	ScreenButton(){
		setSize(1500,1000);
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
	public void checkPos(PaintingPanel c){
		
		if(!grabbing){
			for(int i = 0; i < c.crabs.size(); i++){
				if(((x-c.crabs.get(i).sizeX/2) < c.crabs.get(i).x) && (c.crabs.get(i).x < (x+c.crabs.get(i).sizeX/2))){
					if(((y-c.crabs.get(i).sizeY/2) < c.crabs.get(i).y) && (c.crabs.get(i).y < (y+c.crabs.get(i).sizeY/2))){
						grabbed = c.crabs.get(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		if((j > -1 && j < c.crabs.size()) && c.crabs.get(j).equals(grabbed)){
			c.crabs.get(j).x = x;
			c.crabs.get(j).y = y;	
		}
	}
}
	

