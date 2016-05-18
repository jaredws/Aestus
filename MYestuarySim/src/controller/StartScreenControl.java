package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;

import view.StartingView;


/**
 * The Class StartScreenControl.
 * Handles the functionality of the screen that appears just before the game begins.
 * @author Team 0 
 */
public class StartScreenControl extends JButton {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9042772411806531339L;
	
	/** The coordinate of a clickx. */
	public int clickx;
	
	/** The coordinate of a clicky. */
	public int clicky;
	
	/** The states of a click on the play or settings menu button */
	public boolean intro,settings;
	
	/** Showing keeps track of whether the start screen is still showing or the game has started
	 *  main keeps track of what screen (main or settings) the user is currently at */
	public boolean Showing,main;
	
	/** The time increment and decrement states, used for setting the length of the game */
	public boolean timeInc,timeDec;
	
	/** The screen size. */
	Dimension screenSize;

	/**
	 * Constructor
	 * Instantiates a new start screen control with default values for attributes.
	 * Adds a mouse listener for the class to accept client clicks on the screen.
	 */
	public StartScreenControl(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
	    setBorderPainted(false);
	    setFocusPainted(false);
	    setContentAreaFilled(false);
	    Showing = true;
	    intro = false;
	    timeInc = false;
	    timeDec = false;
	    main = true;
	    settings = false;
	
	
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	clickx = e.getX();
        	clicky = e.getY();
        	if(timeInc) {
        		StartingView.incTime();
        		timeInc = false;
        	} else if(timeDec) {
        		StartingView.decTime();
        		timeDec = false;
        	}
        	
        	
        }
        
        public void mouseReleased(MouseEvent e){
        	if(timeInc) {
        		StartingView.incTime();
        		timeInc = false;
        	} else if(timeDec) {
        		StartingView.decTime();
        		timeDec = false;
        	}
        }
	});
	
	addMouseMotionListener(new MouseMotionAdapter(){
    	//If mouse is being dragged whilst holding the button
        public void mouseDragged(MouseEvent e){
     
        }
    });
	}
	
	/**
	 * Handles all functionality of a the start screen, from handling what button was clicked
	 * based on the location of the mouse pointer, setting menu states based on where the user is, and controlling
	 * states of the settings screen that are handed off to the game once it starts
	 */
	public void check(){
		if(!settings) {
			if((clickx > StartingView.getPlayX()) 
					&& (clickx < StartingView.getPlayX()+StartingView.getPlay().getWidth(null))
					&& (clicky > StartingView.getPlayY())
					&& (clicky < StartingView.getPlayY()+StartingView.getPlay().getHeight(null))){
				Showing = false;
				intro = true;
				clickx =0;
			}
			else if((clickx > StartingView.getExitX()) 
					&& (clickx < StartingView.getExitX()+StartingView.getExit().getWidth(null))
					&& (clicky > StartingView.getExitY())
					&& (clicky < StartingView.getExitY()+StartingView.getExit().getHeight(null))){
				Showing = false;
				intro = false;
				clickx =0;
				System.exit(0);
			}
			else if(clickx > 0 && intro == true)
				Showing = false;
		}
		
		if(main) {
			if((clickx > StartingView.getSettingsX())
				&& (clickx < StartingView.getSettingsX()+StartingView.getSettings().getWidth(null))
				&& (clicky > StartingView.getSettingsY())
				&& (clicky < StartingView.getSettingsY()+StartingView.getSettings().getHeight(null))){
				settings = true;
			}
		}
		
		if(settings){
			if((clickx > StartingView.getTimeUpX())
					&& (clickx < StartingView.getTimeUpX()+StartingView.getTimeUp().getWidth(null))
					&& (clicky > StartingView.getTimeUpY())
					&& (clicky < StartingView.getTimeUpY()+StartingView.getTimeUp().getHeight(null))){
					timeInc = true;
			} else if((clickx > StartingView.getTimeDownX())
					&& (clickx < StartingView.getTimeDownX()+StartingView.getTimeDown().getWidth(null))
					&& (clicky > StartingView.getTimeDownY())
					&& (clicky < StartingView.getTimeDownY()+StartingView.getTimeDown().getHeight(null))){
					timeDec = true;
			} else if((clickx > StartingView.getSoundX())
					&& (clickx < StartingView.getSoundX()+StartingView.getSoundOn().getWidth(null))
					&& (clicky > StartingView.getSoundY())
					&& (clicky < StartingView.getSoundY()+StartingView.getSoundOn().getHeight(null))){
					SoundController.toggleSound();
			} 
			
			else if(clickx > StartingView.getClipboardX()+StartingView.getClipboard().getWidth(null)) {
				main = true;
				settings = false;
			}
		}
		
		StartingView.settingsL.setBounds((int)screenSize.getWidth()/2-StartingView.settingsL.getWidth()/2, StartingView.getClipboardY()+100, 300, 100);
		StartingView.timeL.setBounds((StartingView.getTimeDownX()-StartingView.getTimeUpX()+StartingView.getTimeUp().getWidth(null))/2+StartingView.getTimeUpX()-StartingView.timeL.getWidth()/2, StartingView.getTimeDownY(), 200, 50);
		
		if(settings) {
			StartingView.settingsL.setVisible(true);
			StartingView.timeL.setVisible(true);
		} else {
			StartingView.settingsL.setVisible(false);
			StartingView.timeL.setVisible(false);
		}
		
		clickx = -1;
		clicky = -1;
	}
	
	/**
	 * Gets the showing.
	 *
	 * @return the showing
	 */
	public boolean getShowing() {
		return this.Showing;
	}
	
	/**
	 * Gets the intro.
	 *
	 * @return the intro
	 */
	public boolean getIntro() {
		return this.intro;
	}
	
	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public boolean getSettings() {
		return this.settings;
	}
	
	/**
	 * Gets the main.
	 *
	 * @return the main
	 */
	public boolean getMain() {
		return this.main;
	}
	
	/**
	 * Gets the timeInc.
	 *
	 * @return the timeInc
	 */
	public boolean getTimeInc() {
		return this.timeInc;
	}
	
	/**
	 * Gets the timeDec.
	 *
	 * @return the timeDec
	 */
	public boolean getTimeDec() {
		return this.timeDec;
	}


}
