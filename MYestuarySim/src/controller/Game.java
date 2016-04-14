package controller;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Background;

public class Game extends JPanel {
	Background background;
	Random rand = new Random();

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.check(),background.getX(), background.getY(), null);
	}
	
	public static void main(String[] args){
		Game G = new Game();
		G.background = new Background(0,0);
		ScreenButton s = new ScreenButton();
		JFrame frame = new JFrame();
		frame.setLayout(null);
		G.setSize(1600,900);
		frame.add(G);
		frame.add(s);
		frame.setSize(1600,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		while(true){
			//G.clickAddCrab(s);
			//s.checkPos(G);
			//G.moveCrabs();
			//G.deleteCrabs();
			G.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
	}
}
