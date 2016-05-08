package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Game;
import controller.StartScreenControl;

public class StartingView extends JPanel {
	
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static ButtonView BV;
	public StartScreenControl S;
	public Image BG;
 	//public boolean Showing;
 	public JFrame frame;
 	static Dimension screenSize;
 	public Image title;
 	public static Image play;
 	public static Image settings;
 	public Image exit;
 	public Image clipboard;
	
	public StartingView(StartScreenControl s){
		//Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH);
			title = ImageIO.read(new File("./img/title.png"));
			play = ImageIO.read(new File("./img/playButton.png"));
			settings = ImageIO.read(new File("./img/settingsButton.png"));
			exit = ImageIO.read(new File("./img/exitButton.png"));
			clipboard = ImageIO.read(new File("./img/clipboard.png"));
			
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
        if(s.getSettings()) frame.add(getSettingsLabel());
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        
        if(S.getSettings()) {
        	g.drawImage(clipboard, (int)screenSize.getWidth()/2-clipboard.getWidth(null)/2, (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2, null);
        } else {
        	g.drawImage(title, (int)screenSize.getWidth()/2-title.getWidth(null)/2, 125, null);
	        g.drawImage(play, getPlayX(), getPlayY(), null);
	        g.drawImage(settings, getSettingsX(), getSettingsY(), null);
	        g.drawImage(exit, (int)screenSize.getWidth()/2-exit.getWidth(null)/2, 500, null);
        }
        
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public Game getGame() {
		return this.G;
	}
	
	public static Image getPlay() {
		return play;
	}
	
	public static int getPlayX() {
		return (int)screenSize.getWidth()/2-play.getWidth(null)/2;
	}
	
	public static int getPlayY() {
		return 300;
	}
	
	public static Image getSettings() {
		return settings;
	}
	
	public static int getSettingsX() {
		return (int)screenSize.getWidth()/2-settings.getWidth(null)/2;
	}
	
	public static int getSettingsY() {
		return 400;
	}
	
	public JLabel getSettingsLabel() {
		JLabel settingsL = new JLabel("Settings");
		settingsL.setOpaque(false);
		settingsL.setBounds((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2+clipboard.getHeight(null)/2, 200, 100);
		settingsL.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		return settingsL;
	}


}
