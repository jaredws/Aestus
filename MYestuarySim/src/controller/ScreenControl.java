package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import javax.swing.JPanel;
import model.BlueCrab;
import model.BlueCrabControl;
import model.CordGrass;
import model.CordGrassControl;
import model.Crab;
import model.CrabControl;
import model.Grabbable;
import model.Phragmites;
import model.PhragmitesControl;
import model.Pollution;
import model.PollutionControl;
import model.Turtle;
import model.TurtleControl;

public class ScreenControl extends JPanel {

	private static final long serialVersionUID = 481321254387509732L;

	// Implement listener on the frame??? -JS
	private int x, y, magX, magY, shearX, shearY;
	public int research;
	private int j;
	private int clickx,clicky;
	boolean grabbing, clicked, magGlass, pauseB, pause, shears, crabTrap, shearsOpen;
	Grabbable grabbed;
	Random rand;
	Dimension screenSize;
	public boolean researchPause;

	public ScreenControl() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

		rand = new Random();
		pauseB = false;
		research = -1;
		pause = false;
		shears = false;
		magGlass = false;
		crabTrap = false;
		shearsOpen = true;

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
				if(researchPause)
					pause = false;
				if(shears)
					shearsOpen = false;
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

	public void checkPos(CrabControl c, TurtleControl t, BlueCrabControl bc, CordGrassControl cgc, PhragmitesControl pc,
			ToolControl tc,PollutionControl puc) {
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
			
			if (clickx > tc.getCrabTrap().getX()
					&& clickx < tc.getCrabTrap().getSizeX() + tc.getCrabTrap().getX()
					&& clicky > tc.getCrabTrap().getY()
					&& clicky < tc.getCrabTrap().getSizeY() + tc.getCrabTrap().getY()) {
				if (!crabTrap) {
					crabTrap = true;
				} else {
					crabTrap = false;
				}
				clicked = false;
			}
			for (int i = 0; i < puc.getPollution().size(); i++) {
				if ((clickx > puc.getPollution(i).getX()) && (clickx < (puc.getPollution(i).getX() + Pollution.sizeX))
						&& ((clicky > puc.getPollution(i).getY()) && (clicky < puc.getPollution(i).getY() + Pollution.sizeY))) {
					if (magGlass) {
						research = 0;
						magGlass = false;
						pause = true;
						clicked = false;
					} else if (!magGlass && !shears && !grabbing) {
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
						research = 0;
						c.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
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
						research = 2;
						bc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
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
						research = 3;
						t.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
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
						research = 1;
						pc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
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
						research = 4;
						cgc.setResearched(true);
						magGlass = false;
						pause = true;
						clicked = false;
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

	public int getMagX() {
		return this.magX;
	}

	public int getMagY() {
		return this.magY;
	}

	public int getShearX() {
		return this.shearX;
	}

	public int getShearY() {
		return this.shearY;
	}

	public boolean getMagGlass() {
		return this.magGlass;
	}

	public boolean getShears() {
		return this.shears;
	}

	public boolean getPauseB() {
		return this.pauseB;
	}

	public int getResearch() {
		return this.research;
	}

	public boolean getPause() {
		return this.pause;
	}
	
	public int getClickx() {
		return clickx;
	}

	public void setClickx(int clickx) {
		this.clickx = clickx;
	}

	public int getClicky() {
		return clicky;
	}

	public void setClicky(int clicky) {
		this.clicky = clicky;
	}
	public boolean getClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public boolean getShearsOpen() {
		return this.shearsOpen;
	}
}
