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

public class EndScreenControl extends JPanel {

	private static final long serialVersionUID = 9042772411806531339L;
	private int clickx, clicky;
	private boolean clicked;

	public EndScreenControl(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		clicked = false;
		
	addMouseListener(new MouseAdapter(){
    	//If mouse button is pressed
        public void mousePressed(MouseEvent e){
        	clickx = e.getX();
        	clicky = e.getY();
        	clicked = true;
        }
        
        public void mouseReleased(MouseEvent e){
        }
	});
	}
	
	public void checkPos() {
		if (clicked) {
			if (clickx > EndingView.getResearcherX()
					&& clickx < EndingView.getResearcherX() + EndingView.getResearcher().getWidth(null)
					&& clicky > EndingView.getResearcherY()
					&& clicky < EndingView.getResearcherY() + EndingView.getResearcher().getHeight(null)) {
				try {
					openWebpage(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				clicked = false;
			}
		}
	}
	
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

	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
}
