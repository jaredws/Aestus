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
	public boolean intro,settings;
	public boolean Showing,main;
	public boolean timeInc,timeDec;
	Dimension screenSize;

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
        }
	});
	
	addMouseMotionListener(new MouseMotionAdapter(){
    	//If mouse is being dragged whilst holding the button
        public void mouseDragged(MouseEvent e){
     
        }
    });
	}
	public void check(){
		if(!settings) {
			if((clickx > StartingView.getPlayX()) 
					&& (clickx < StartingView.getPlayX()+StartingView.getPlay().getWidth(null))
					&& (clicky > StartingView.getPlayY())
					&& (clicky < StartingView.getPlayY()+StartingView.getPlay().getHeight(null))){
				intro = true;
				clickx =0;
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
			} else if(clickx > StartingView.getClipboardX()+StartingView.getClipboard().getWidth(null)) {
				main = true;
				settings = false;
			}
		}
		StartingView.settingsL.setBounds((int)screenSize.getWidth()/2-StartingView.settingsL.getWidth()/2, StartingView.getClipboardY()+200, 300, 100);
		StartingView.timeL.setBounds((int)screenSize.getWidth()/2, StartingView.getTimeUpX()+StartingView.getTimeUp().getWidth(null)-StartingView.getTimeDownX(), 200, 100);
		
		if(settings) {
			
			StartingView.settingsL.setVisible(true);
			StartingView.timeL.setVisible(true);
		} else {
			StartingView.settingsL.setVisible(false);
			StartingView.timeL.setVisible(false);
		}
	}
	
	public boolean getShowing() {
		return this.Showing;
	}
	
	public boolean getIntro() {
		return this.intro;
	}
	
	public boolean getSettings() {
		return this.settings;
	}
	
	public boolean getMain() {
		return this.main;
	}


}
