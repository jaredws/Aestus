package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import javax.swing.JPanel;
import model.BlueCrab;
import model.BlueCrabHandler;
import model.CordGrass;
import model.CordGrassHandler;
import model.Crab;
import model.CrabHandler;
import model.Grabbable;
import model.Phragmites;
import model.PhragmitesHandler;
import model.Pollution;
import model.PollutionHandler;
import model.Turtle;
import model.TurtleHandler;

/**
 * The Class ScreenControl. Manages the interface of the client mouse with positions on the screen, 
 * and distributes appropriate actions to objects accordingly 
 * @author Team 0
 */
public class ScreenControl extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 481321254387509732L;

	/** The integers representing coordinates of various objects and mouse clicks */
	// Implement listener on the frame??? -JS
	private int x, y, magX, magY, shearX, shearY;
	
	/** The int Research, a metric for scoring the game */
	public int research;
	
	/** The index of a grabbed object */
	private int j;
	
	/** The coordinates of a click */
	private int clickx,clicky;
	
	/** The individual metrics for the research score */
	private int turtleResearch,phragResearch,bluecrabResearch,mittenCrabResearch,cordResearch;
	
	/** The state booleans for various tools and functions of the game */
	boolean grabbing, clicked, magGlass, pauseB, pause, shears, shearsOpen;
	
	/** The currently grabbed object */
	Grabbable grabbed;
	
	/** The Random object for use in various parts of the game's functionality */
	Random rand;
	
	/** The screen size. */
	Dimension screenSize;
	
	/** The research pause state. */
	public boolean researchPause;

	/**
	 * Constructor
	 * Instantiates a new screen control with default attribute values
	 * Also defines a mouse listener for the class
	 * 
	 */
	public ScreenControl() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

		rand = new Random();
		pauseB = false;
		research = -1;
		pause = false;
		shears = false;
		magGlass = false;
		shearsOpen = true;
		turtleResearch= 0;
		phragResearch=0;
		bluecrabResearch=0;
		mittenCrabResearch=0;
		cordResearch=0;
		
		addMouseListener(new MouseAdapter() {
			// If mouse button is pressed
			@Override
			public void mousePressed(MouseEvent e) {
				grabbing = false;
				clickx = e.getX();
				clicky = e.getY();
				x = e.getX();
				y = e.getY();
				clicked = true;
				if(researchPause){
					pause = false;
					research = -1;
				}
				if(shears){
					shearsOpen = false;
					SoundController.playShears();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				grabbed = null;
				grabbing = false;
				x = -1;
				y = -1;
				j = -1;
				clicked = false;
				if(shears)
					shearsOpen = true;
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			// If mouse is being dragged whilst holding the button
			@Override
			public void mouseDragged(MouseEvent e) {
				// must be replaced by image height and width /2
				clicked = false;
				if (grabbing) {
					x = e.getX();
					y = e.getY();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				if (magGlass) {
					magX = e.getX();
					magY = e.getY();
				} else if (shears) {
					shearX = e.getX();
					shearY = e.getY();
				}
			}
		});
	}

	/**
	 * Based on a mouse click, handles the movement of all given objects as parameters
	 * Also tracks the research metric based on if an object was researched
	 * When a tool is clicked, manages the functionality and outcome of the use of that tool
	 * 
	 *
	 * *parameter objects are given from their instances in the game class*
	 * @param Crabhandler c 
	 * @param TurtleHandler t
	 * @param BlueCrabHandler bc
	 * @param CordGrassHandler cgc
	 * @param PhragmitesHandler pc
	 * @param ToolControl tc
	 * @param PollutionHandler puc
	 */
	public void checkPos(CrabHandler c, TurtleHandler t, BlueCrabHandler bc, CordGrassHandler cgc, PhragmitesHandler pc,
			ToolControl tc,PollutionHandler puc) {
		if (clicked) {
			if (clickx > tc.getMag().getX()
					&& clickx < tc.getMag().getSizeX() + tc.getMag().getX()
					&& clicky > tc.getMag().getY()
					&& clicky < tc.getMag().getSizeY() + tc.getMag().getY()) {
				if (!magGlass)
					magGlass = true;
				else
					magGlass = false;
				clicked = false;
			}

			if (clickx > tc.getPauseB().getX()
					&& clickx < tc.getPauseB().getSizeX() + tc.getPauseB().getX()
					&& clicky > tc.getPauseB().getY()
					&& clicky < tc.getPauseB().getSizeY() + tc.getPauseB().getY()) {
				if (!pauseB) {
					pauseB = true;
					pause = true;
				} else {
					pauseB = false;
					pause = false;
				}
				clicked = false;
			}

			if (clickx > tc.getShears().getX()
					&& clickx < tc.getShears().getSizeX() + tc.getShears().getX()
					&& clicky > tc.getShears().getY()
					&& clicky < tc.getShears().getSizeY() + tc.getShears().getY()) {
				if (!shears) {
					shears = true;
				} else {
					shears = false;
				}
				clicked = false;
			}
			
			for (int i = 0; i < puc.getPollution().size(); i++) {
				if ((clickx > puc.getPollution(i).getX()) && (clickx < (puc.getPollution(i).getX() + Pollution.sizeX))
						&& ((clicky > puc.getPollution(i).getY()) && (clicky < puc.getPollution(i).getY() + Pollution.sizeY))) {
					if (!magGlass && !shears && !grabbing) {
						grabbed = puc.getPollution(i);
						grabbing = true;
						j = i;
						break;
					}
				}
			}
			for (int i = 0; i < c.getCrabs().size(); i++) {
				if ((clickx > c.getCrab(i).getX()) && (clickx < (c.getCrab(i).getX() + Crab.sizeX))
						&& ((clicky > c.getCrab(i).getY()) && (clicky < c.getCrab(i).getY() + Crab.sizeY))) {
					if (magGlass) {
						research = 0 + mittenCrabResearch%3;
						c.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
						mittenCrabResearch++;
					} else if (!magGlass && !shears && !grabbing) {
						grabbed = c.getCrab(i);
						grabbing = true;
						j = i;
						break;
					}
				}
			}
			for (int i = 0; i < bc.BlueCrabs.size(); i++) {
				if ((clickx > bc.getBlueCrab(i).getX()) && (clickx < (bc.getBlueCrab(i).getX() + BlueCrab.sizeX))
						&& ((clicky > bc.getBlueCrab(i).getY()) && (clicky < bc.getBlueCrab(i).getY() + BlueCrab.sizeY))) {
					if (magGlass) {
						research = 6 + bluecrabResearch%3;
						bc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
						bluecrabResearch++;
					} else if (!magGlass && !shears && !grabbing) {
						grabbed = bc.getBlueCrab(i);
						grabbing = true;
						j = i;
						break;
					}
				}
			}

			for (int i = 0; i < t.getTurtles().size(); i++) {
				if ((clickx > t.getTurtle(i).getX()) && (clickx < (t.getTurtle(i).getX() + Turtle.sizeX))
						&& ((clicky > t.getTurtle(i).getY()) && (clicky < t.getTurtle(i).getY() + Turtle.sizeY))) {
					if (magGlass) {
						research = 9 + turtleResearch%3;
						t.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
						turtleResearch++;
					} else if (!magGlass && !shears && !grabbing) {
						grabbed = t.getTurtle(i);
						grabbing = true;
						j = i;
						break;
					}
				}
			}
			for (int i = 0; i < pc.getPhragmites().size(); i++) {
				if ((clickx > pc.getPhragmites(i).getX()) && (clickx < (pc.getPhragmites(i).getX() + Phragmites.sizeX))
						&& ((clicky > pc.getPhragmites(i).getY()) && (clicky < pc.getPhragmites(i).getY() + Phragmites.sizeY))) {
					if (magGlass) {
						research = 3 + phragResearch%3;
						pc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
						phragResearch++;
					} else if (shears) {
						pc.removePhragmites(i);
						clicked = false;
					} 

				}
			}

			for (int i = 0; i < cgc.getCordGrass().size(); i++) {
				if ((clickx > cgc.getCordGrass(i).getX()) && (clickx < (cgc.getCordGrass(i).getX() + CordGrass.sizeX)) 
						&& ((clicky > cgc.getCordGrass(i).getY()) && (clicky < cgc.getCordGrass(i).getY() + CordGrass.sizeY))) {
					if (!magGlass && !shears && !grabbing) {
						grabbed = cgc.getCordGrass(i);
						grabbing = true;
						j = i;
						break;
					} else if (magGlass) {
						research = 12 + cordResearch%3;
						cgc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false; 
						cordResearch++;
					} else if (shears) {
						cgc.removeCordGrass(i);
						clicked = false;
					}

				}
			}
			
		}

		if ((j > -1 && j < c.getCrabs().size()) && c.getCrab(j).equals(grabbed)) {
			c.getCrab(j).setX(x - Crab.sizeX / 2);
			c.getCrab(j).setY(y - Crab.sizeY / 2);
		}
		if ((j > -1 && j < bc.BlueCrabs.size()) && bc.getBlueCrab(j).equals(grabbed)) {
			bc.getBlueCrab(j).setX(x - BlueCrab.sizeX / 2);
			bc.getBlueCrab(j).setY(y - BlueCrab.sizeY / 2);
		}
		if ((j > -1 && j < t.getTurtles().size()) && t.getTurtle(j).equals(grabbed)) {
			t.getTurtle(j).setX(x - Turtle.sizeX / 2);
			t.getTurtle(j).setY(y - Turtle.sizeY / 2);
		}
		if ((j > -1 && j < puc.getPollution().size()) && puc.getPollution(j).equals(grabbed)) {
			puc.getPollution(j).setX(x - Pollution.sizeX / 2);
			puc.getPollution(j).setY(y - Pollution.sizeY / 2);
		}

	}

	/**
	 * Gets the mag x.
	 *
	 * @return the mag x
	 */
	public int getMagX() {
		return this.magX;
	}

	/**
	 * Gets the mag y.
	 *
	 * @return the mag y
	 */
	public int getMagY() {
		return this.magY;
	}

	/**
	 * Gets the shear x.
	 *
	 * @return the shear x
	 */
	public int getShearX() {
		return this.shearX;
	}

	/**
	 * Gets the shear y.
	 *
	 * @return the shear y
	 */
	public int getShearY() {
		return this.shearY;
	}

	/**
	 * Gets the mag glass active boolean.
	 *
	 * @return the mag glass active boolean
	 */
	public boolean getMagGlass() {
		return this.magGlass;
	}

	/**
	 * Gets the shears active boolean
	 *
	 * @return the shears active boolean
	 */
	public boolean getShears() {
		return this.shears;
	}

	/**
	 * Gets the pause b.
	 *
	 * @return the pause b
	 */
	public boolean getPauseB() {
		return this.pauseB;
	}

	/**
	 * Gets the research.
	 *
	 * @return the research
	 */
	public int getResearch() {
		return this.research;
	}

	/**
	 * Gets the pause.
	 *
	 * @return the pause
	 */
	public boolean getPause() {
		return this.pause;
	}
	
	/**
	 * Gets the clickx.
	 *
	 * @return the clickx
	 */
	public int getClickx() {
		return clickx;
	}

	/**
	 * Sets the clickx.
	 *
	 * @param clickx the new clickx
	 */
	public void setClickx(int clickx) {
		this.clickx = clickx;
	}

	/**
	 * Gets the clicky.
	 *
	 * @return the clicky
	 */
	public int getClicky() {
		return clicky;
	}

	/**
	 * Sets the clicky.
	 *
	 * @param clicky the new clicky
	 */
	public void setClicky(int clicky) {
		this.clicky = clicky;
	}
	
	/**
	 * Gets the clicked.
	 *
	 * @return the clicked
	 */
	public boolean getClicked() {
		return clicked;
	}

	/**
	 * Sets the clicked.
	 *
	 * @param clicked the new clicked
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	/**
	 * Gets the shears open.
	 *
	 * @return the shears open
	 */
	public boolean getShearsOpen() {
		return this.shearsOpen;
	}

}
