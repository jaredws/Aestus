package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

import model.Crab;
import model.Grabbable;
import controller.Game;

public class ScreenButton extends JButton {
	
	//Implament listener on the frame??? -JS
	int x;
	int y;
	int j = 0;
	public int clickx;
	int clicky;
	public boolean addCrab;//Do we really need this?
	public boolean addTurtle;
	Grabbable grabbed;
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
        		addTurtle = true;
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
        	//must be replaced by image height and width /2
        	x = e.getX();
        	y = e.getY();
        }
    });
	}
	public void checkPos(CrabControl c, TurtleControl t){
		//The trash can deletes if the crab is 'grabbed' and you drag it over the can
		//do we want this? or should we wait for release
		
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
		if(!grabbing){
			for(int i = 0; i < t.turtles.size(); i++){
				if(((x-t.turtles.get(i).sizeX/2) < t.turtles.get(i).getX()) && (t.turtles.get(i).getX() < (x+t.turtles.get(i).sizeX/2))){
					if(((y-t.turtles.get(i).sizeY/2) < t.turtles.get(i).getY()) && (t.turtles.get(i).getY() < (y+t.turtles.get(i).sizeY/2))){
						grabbed = t.turtles.get(i);
						grabbing = true;
						j = i;
						break;
						}
					}
			}
		}
		
		if((j > -1 && j < c.crabs.size()) && c.crabs.get(j).equals(grabbed)){
			c.crabs.get(j).setX(x - 100/2);
			c.crabs.get(j).setY(y - 75/2);	
		}
		if((j > -1 && j < t.turtles.size()) && t.turtles.get(j).equals(grabbed)){
			t.turtles.get(j).setX(x - 100/2);
			t.turtles.get(j).setY(y - 75/2);	
		}
	}
}
	

