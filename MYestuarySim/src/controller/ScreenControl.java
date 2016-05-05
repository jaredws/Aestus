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
	private int x, y, magX, magY, shearX, shearY, research, j, clickx, clicky;
	boolean grabbing, clicked, magGlass, menu, pause, shears;
	Grabbable grabbed;
	Random rand;
	Dimension screenSize;

	public ScreenControl() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		// setBorderPainted(false);
		// setFocusPainted(false);
		// setContentAreaFilled(false);
		rand = new Random();
		menu = false;
		research = -1;
		pause = false;
		shears = false;
		magGlass = false;

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
				}
			}
		});
	}

	public void checkPos(CrabControl c, TurtleControl t, BlueCrabControl bc, CordGrassControl cgc, PhragmitesControl pc,
			ButtonControl b) {
		if (clicked) {
			if (clickx > b.getButtons().get(4).getX()
					&& clickx < b.getButtons().get(4).getSizeX() + b.getButtons().get(4).getX()
					&& clicky > b.getButtons().get(4).getY()
					&& clicky < b.getButtons().get(4).getSizeY() + b.getButtons().get(4).getY()) {
				if (!magGlass)
					magGlass = true;
				else
					magGlass = false;
				clicked = false;
			}

			if (clickx > b.getButtons().get(3).getX()
					&& clickx < b.getButtons().get(3).getSizeX() + b.getButtons().get(3).getX()
					&& clicky > b.getButtons().get(3).getY()
					&& clicky < b.getButtons().get(3).getSizeY() + b.getButtons().get(3).getY()) {
				if (!menu) {
					menu = true;
				} else {
					menu = false;
				}
				clicked = false;
			}

			if (clickx > b.getButtons().get(1).getX()
					&& clickx < b.getButtons().get(1).getSizeX() + b.getButtons().get(1).getX()
					&& clicky > b.getButtons().get(1).getY()
					&& clicky < b.getButtons().get(1).getSizeY() + b.getButtons().get(1).getY()) {
				if (!shears) {
					shears = true;
				} else {
					shears = false;
				}
				clicked = false;
			}

			for (int i = 0; i < c.crabs.size(); i++) {
				if ((clickx > c.getCrab(i).getX()) && (clickx < (c.getCrab(i).getX() + Crab.sizeX))
						&& ((clicky > c.getCrab(i).getY()) && (clicky < c.getCrab(i).getY() + Crab.sizeY))) {
					if (magGlass) {
						research = 0;
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
		if ((j > -1 && j < pc.Phragmites.size()) && pc.getPhragmites(j).equals(grabbed)) {
			pc.getPhragmites(j).setX(x - Phragmites.sizeX / 2);
			pc.getPhragmites(j).setY(y - Phragmites.sizeY / 2);
		}
		if ((j > -1 && j < bc.BlueCrabs.size()) && bc.getBlueCrab(j).equals(grabbed)) {
			bc.getBlueCrab(j).setX(x - BlueCrab.sizeX / 2);
			bc.getBlueCrab(j).setY(y - BlueCrab.sizeY / 2);
		}
		if ((j > -1 && j < t.turtles.size()) && t.getTurtle(j).equals(grabbed)) {
			t.getTurtle(j).setX(x - Turtle.sizeX / 2);
			t.getTurtle(j).setY(y - Turtle.sizeY / 2);
		}
		if ((j > -1 && j < cgc.CordGrass.size()) && cgc.CordGrass.get(j).equals(grabbed)) {
			cgc.getCordGrass(j).setX(x - CordGrass.sizeX / 2);
			cgc.getCordGrass(j).setY(y - CordGrass.sizeY / 2);
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

	public boolean getMenu() {
		return this.menu;
	}

	public int getResearch() {
		return this.research;
	}

	public boolean getPause() {
		return this.pause;
	}
}
