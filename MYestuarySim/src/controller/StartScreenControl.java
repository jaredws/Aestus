package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;

import view.StartingView;

public class StartScreenControl extends JButton {

	//Implament listener on the frame??? -JS

	private static final long serialVersionUID = 9042772411806531339L;
	public int clickx;
	public int clicky;
	public boolean Settings;
	public boolean Showing;
	Dimension screenSize;

	public StartScreenControl(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	    setBorderPainted(false);
	    setFocusPainted(false);
	    setContentAreaFilled(false);
	    Showing = true;
	    Settings = false;
	
	
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
	public void check(){
		if((clickx > StartingView.getPlayX()) 
				&& (clickx < StartingView.getPlayX()+StartingView.getPlay().getWidth(null))
				&& (clicky > StartingView.getPlayY())
				&& (clicky < StartingView.getPlayY()+StartingView.getPlay().getHeight(null))){
			Settings = true;
			clickx =0;
		}
		if(clickx > 0)
			Showing = false;
	}
	
	public boolean getShowing() {
		return this.Showing;
	}
	
	public boolean getSettings() {
		return this.Settings;
	}


}
