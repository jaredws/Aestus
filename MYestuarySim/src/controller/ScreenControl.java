package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import javax.swing.JPanel;
import model.BlueCrab;
import model.CordGrass;
import model.Crab;
import model.Grabbable;
import model.Phragmites;
import model.Turtle;

public class ScreenControl extends JPanel {

	private static final long serialVersionUID = 481321254387509732L;

	// Implement listener on the frame??? -JS
	private int x, y, magX, magY, shearX, shearY, research, j, clickx, clicky, cTrapX, cTrapY;
	boolean grabbing, clicked, magGlass, pauseB, pause, shears, crabTrap;
	Grabbable grabbed;
	Random rand;
	Dimension screenSize;

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
				pause = false;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				grabbed = null;
				grabbing = false;
				x = -1;
				y = -1;
				j = -1;
				clicked = false;
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
				if (magGlass == true) {
					magX = e.getX();
					magY = e.getY();
				} else if (shears == true) {
					shearX = e.getX();
					shearY = e.getY();
				} else if (crabTrap == true) {
					cTrapX = e.getX();
					cTrapY = e.getY();
				}
			}
		});
	}

	public void checkPos(CrabControl c, TurtleControl t, BlueCrabControl bc, CordGrassControl cgc, PhragmitesControl pc,
			ToolControl tc) {
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

			for (int i = 0; i < c.crabs.size(); i++) {
				if ((clickx > c.getCrab(i).getX()) && (clickx < (c.getCrab(i).getX() + Crab.sizeX))
						&& ((clicky > c.getCrab(i).getY()) && (clicky < c.getCrab(i).getY() + Crab.sizeY))) {
					if (magGlass) {
						research = 0;
						c.Researched=true;
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
						bc.Researched = true;
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

			for (int i = 0; i < t.turtles.size(); i++) {
				if ((clickx > t.getTurtle(i).getX()) && (clickx < (t.getTurtle(i).getX() + Turtle.sizeX))
						&& ((clicky > t.getTurtle(i).getY()) && (clicky < t.getTurtle(i).getY() + Turtle.sizeY))) {
					if (magGlass) {
						research = 3;
						t.Researched = true;
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
			for (int i = 0; i < pc.Phragmites.size(); i++) {
				if ((clickx > pc.getPhragmites(i).getX()) && (clickx < (pc.getPhragmites(i).getX() + Phragmites.sizeX))
						&& ((clicky > pc.getPhragmites(i).getY()) && (clicky < pc.getPhragmites(i).getY() + Phragmites.sizeY))) {
					if (magGlass) {
						research = 1;
						pc.Researched = true;
						magGlass = false;
						pause = true;
						clicked = false;
					} else if (shears) {
						pc.removePhragmites(i);
						clicked = false;
					} else if (!magGlass && !shears && !grabbing) {
						grabbed = pc.getPhragmites(i);
						grabbing = true;
						j = i;
						break;
					}

				}
			}

			for (int i = 0; i < cgc.CordGrass.size(); i++) {
				if ((clickx > cgc.getCordGrass(i).getX()) && (clickx < (cgc.getCordGrass(i).getX() + CordGrass.sizeX)) 
						&& ((clicky > cgc.getCordGrass(i).getY()) && (clicky < cgc.getCordGrass(i).getY() + CordGrass.sizeY))) {
					if (!magGlass && !shears && !grabbing) {
						grabbed = cgc.getCordGrass(i);
						grabbing = true;
						j = i;
						break;
					} else if (magGlass) {
						research = 4;
						cgc.Researched = true;
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

		if ((j > -1 && j < c.crabs.size()) && c.getCrab(j).equals(grabbed)) {
			c.getCrab(j).setX(x - Crab.sizeX / 2);
			c.getCrab(j).setY(y - Crab.sizeY / 2);
		}
		if ((j > -1 && j < bc.BlueCrabs.size()) && bc.getBlueCrab(j).equals(grabbed)) {
			bc.getBlueCrab(j).setX(x - BlueCrab.sizeX / 2);
			bc.getBlueCrab(j).setY(y - BlueCrab.sizeY / 2);
		}
		if ((j > -1 && j < t.turtles.size()) && t.getTurtle(j).equals(grabbed)) {
			t.getTurtle(j).setX(x - Turtle.sizeX / 2);
			t.getTurtle(j).setY(y - Turtle.sizeY / 2);
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
}
