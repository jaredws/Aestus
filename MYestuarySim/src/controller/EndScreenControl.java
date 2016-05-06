package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

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
			/*if (clickx > tc.getMag().getX()
					&& clickx < tc.getMag().getSizeX() + tc.getMag().getX()
					&& clicky > tc.getMag().getY()
					&& clicky < tc.getMag().getSizeY() + tc.getMag().getY()) {
				if (!magGlass)
					magGlass = true;
				else
					magGlass = false;
				clicked = false;
			}*/
		}
	}
}
