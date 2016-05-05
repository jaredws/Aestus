package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;

public class EndScreenControl extends JButton {

	//Implament listener on the frame??? -JS

	private static final long serialVersionUID = 9042772411806531339L;
	public int clickx;
	public int clicky;


	public EndScreenControl(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	    setBorderPainted(false);
	    setFocusPainted(false);
	    setContentAreaFilled(false);
	
	
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	clickx = e.getX();
        	clicky = e.getY();
        }
        
        public void mouseReleased(MouseEvent e){
        }
	});
	
	addMouseMotionListener(new MouseMotionAdapter(){
    	//If mouse is being dragged whilst holding the button
        public void mouseDragged(MouseEvent e){
     
        }
    });
	}
	public void checkPos(CrabControl c){
		//The trash can deletes if the crab is 'grabbed' and you drag it over the can
		//do we want this? or should we wait for release
		
//		if(!grabbing){
//			for(int i = 0; i < c.crabs.size(); i++){
//				if(((x-c.crabs.get(i).sizeX/2) < c.crabs.get(i).getX()) && (c.crabs.get(i).getX() < (x+c.crabs.get(i).sizeX/2))){
//					if(((y-c.crabs.get(i).sizeY/2) < c.crabs.get(i).getY()) && (c.crabs.get(i).getY() < (y+c.crabs.get(i).sizeY/2))){
//						grabbed = c.crabs.get(i);
//						grabbing = true;
//						j = i;
//						break;
//						}
//					}
//			}
//		}
//		if((j > -1 && j < c.crabs.size()) && c.crabs.get(j).equals(grabbed)){
//			c.crabs.get(j).setX(x);
//			c.crabs.get(j).setY(y);	
//		}
//	}
}
	



}
