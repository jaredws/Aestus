package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Game;
import controller.StartScreenControl;

public class StartingView extends JPanel {
	
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static ButtonView BV;
	public StartScreenControl S;
	public Image BG;
 	public boolean Showing;
 	public JFrame frame;
 	Dimension screenSize;
 	public Image title;
 	public Image play;
 	public Image settings;
 	public Image exit;
	
	public StartingView(StartScreenControl s){
		Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,1);
			title = ImageIO.read(new File("./img/title.png"));
			play = ImageIO.read(new File("./img/playButton.png"));
			settings = ImageIO.read(new File("./img/settingsButton.png"));
			exit = ImageIO.read(new File("./img/exitButton.png"));
			
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
		frame = new JFrame();
		frame.setLayout(null);
		frame.add(S);
		frame.add(this);
		frame.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        g.drawImage(title, (int)screenSize.getWidth()/2-title.getWidth(null)/2, 125, null);
        g.drawImage(play, (int)screenSize.getWidth()/2-play.getWidth(null)/2, 300, null);
        g.drawImage(settings, (int)screenSize.getWidth()/2-settings.getWidth(null)/2, 400, null);
        g.drawImage(exit, (int)screenSize.getWidth()/2-exit.getWidth(null)/2, 500, null);
        
	}

	public void checkStart() {
		if((S.clickx > (int)screenSize.getWidth()/2-play.getWidth(null)/2) && (S.clickx < ((int)screenSize.getWidth()/2-play.getWidth(null)/2 + 600))){
			if(S.clicky > 300 && S.clicky < 400)
			Showing = false;
		}
		
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public Game getGame() {
		return this.G;
	}


}
