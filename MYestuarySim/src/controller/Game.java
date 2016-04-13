package controller;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Background;

public class Game extends JPanel {
	//List<Button> buttons = new ArrayList<Button>();
	Background background;
	Random rand = new Random();

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
	}
	
	public static void main(String[] args){
		Game P = new Game();
		P.background = new Background(0,0);
		//ScreenButton s = new ScreenButton();
		JFrame frame = new JFrame();
		frame.setLayout(null);
		P.setSize(1600,900);
		frame.add(P);
		//frame.add(s);
		frame.setSize(1600,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		while(true){
			P.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
	}
}
