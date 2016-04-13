package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {
	
	List<Crab> crabs = new ArrayList<Crab>();
	List<Button> buttons = new ArrayList<Button>();
	Estuary background;
	boolean grabbed = false;
	Random rand = new Random();
	

	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(background.check(crabs.size()),background.x, background.y, null);
        for(int i = 0; i < buttons.size(); i++)
        	g.drawImage(buttons.get(i).image, buttons.get(i).x, buttons.get(i).y, null);
        for(int i = 0; i < crabs.size(); i++)
        	g.drawImage(crabs.get(i).image, crabs.get(i).x, crabs.get(i).y, null); // see javadoc for more info on the parameters            
        
	}
	
	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y));
	}
	
	public void addButton(int x, int y,int type){
		buttons.add(new Button(x,y,type));
	}
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			if(rand.nextInt()%25 == 5){
					crabs.get(i).x = crabs.get(i).x + rand.nextInt()%6 - 3;
					crabs.get(i).y = crabs.get(i).y + rand.nextInt()%6 - 3;
			}
		}
	}
	
	public void deleteCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).x > buttons.get(0).x - buttons.get(0).sizeX/2 && crabs.get(i).x < buttons.get(0).x + buttons.get(0).sizeX/4){
				if((crabs.get(i).y > buttons.get(0).y-buttons.get(0).sizeY) && (crabs.get(i).y < buttons.get(0).y + buttons.get(0).sizeY/2)){
					crabs.remove(i);
					i--;
				}
			}
		}
	}
	
	public void clickAddCrab(ScreenButton s){
		
		if(s.clickx > 0 && s.addCrab){
			addCrab(rand.nextInt(1350),rand.nextInt(100)+500);
			s.addCrab = false;
		}
	}
	
	public static void main(String[] args){
		PaintingPanel P = new PaintingPanel();
		P.background = new Estuary(0,0);
		/*P.addCrab(600, 600);
		P.addCrab(200, 400);
		P.addCrab(700, 500);
		P.addCrab(400, 400);
		P.addButton(0, 500, 0);
		P.addButton(0, 625, 1);*/
		ScreenButton s = new ScreenButton();
		JFrame frame = new JFrame();
		frame.setLayout(null);
		P.setSize(1600,900);
		frame.add(P);
		frame.add(s);
		frame.setSize(1600,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		while(true){
			P.clickAddCrab(s);
			s.checkPos(P);
			P.moveCrabs();
			P.deleteCrabs();
			P.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
	}
}
