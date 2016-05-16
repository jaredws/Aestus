package controller;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JPanel;
import view.EndingView;


/**
 * The class EndScreenControl
 *
 * @author Team 0
 * A controller that manages the functionality of the ending screen.
 */
public class EndScreenControl extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9042772411806531339L;
	
	/** Integers that store the location of a click. */
	private int clickx, clicky;
	
	/** True if the client mouse is clicked, false otherwise. */
	private boolean clicked;
	
	/** Easter egg boolean.  */
	public boolean ee;
	
	/**
	 * Constructor
	 * Sets default values for the screen size, clicked boolean and positions, and easter egg boolean.
	 */
	public EndScreenControl(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		clicked = false;
		ee = false;
		clickx = 0; clicky = 0;
		
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	clickx = e.getX();
        	clicky = e.getY();
        	clicked = true;	
        	ee = false;
        }
        
        public void mouseReleased(MouseEvent e){
        	
        }
	});
	}
	
	/**
	 * Check pos. If the position is in a set range, open easter egg
	 */
	public void checkPos() {
		if (clicked) {
			if (clickx > EndingView.getResearcherX()
					&& clickx < EndingView.getResearcherX() + EndingView.getResearcher().getWidth(null)
					&& clicky > EndingView.getResearcherY()
					&& clicky < EndingView.getResearcherY() + EndingView.getResearcher().getHeight(null)) {
//				try {
//					//openWebpage(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
//				//openWebpage(new URL("https://www.facebook.com/photo.php?fbid=10201243457583317&set=a.1469968144012.2067814.1077863802&type=3&theater"));
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
//				}
				ee = true;
				clicked = false;
			}
		}
	}
	
	/**
	 * Open webpage. Uses clients default web browser to open given URI
	 *
	 * @param uri the uri of the page to open
	 */
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	/**
	 * Open webpage. Wrapper for the function that takes a URI instead.
	 *
	 * @param url the url of the page to open
	 */
	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
}
