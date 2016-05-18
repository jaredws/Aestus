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
import javax.swing.SwingConstants;

import controller.CountdownControl;
import controller.Game;
import controller.SoundController;
import controller.StartScreenControl;

public class StartingView extends JPanel {
	
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	public StartScreenControl S;
 	//public boolean Showing;
 	public JFrame frame;
 	static Dimension screenSize;
 	public Image BG,title,intro;

	public static Image timeUp;

	public static Image timeDown, soundOn, soundOff;
	public static JLabel settingsL,timeL;
	public static Image clipboard;
 	public static Image play,settings, exit;
 	private static int time = CountdownControl.getDefaultTime();
	
	public StartingView(StartScreenControl s){
		//Showing = true;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH);
			title = ImageIO.read(new File("./img/title.png"));
			play = ImageIO.read(new File("./img/playButton.png"));
			settings = ImageIO.read(new File("./img/settingsButton.png"));
			exit = ImageIO.read(new File("./img/exitButton.png"));
			intro = ImageIO.read(new File("./img/Intro.png"));
			clipboard = ImageIO.read(new File("./img/clipboard.png"));
			timeUp = ImageIO.read(new File("./img/plus.png"));
			timeDown = ImageIO.read(new File("./img/minus.png"));
			soundOn = ImageIO.read(new File("./img/soundOn.png"));
			soundOff = ImageIO.read(new File("./img/soundOff.png"));
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.add(S);
		frame.add(this);
		frame.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

		settingsL = new JLabel("Settings");
		settingsL.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		settingsL.setHorizontalAlignment(SwingConstants.CENTER);

		timeL = new JLabel(Integer.toString(StartingView.getTime()));
		timeL.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		timeL.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        
        if(S.getIntro()) {
        	//g.drawImage(intro, (int)screenSize.getWidth()/2-intro.getWidth(null)/2, (int)screenSize.getHeight()/2-intro.getHeight(null)/2, null);
        } else if(S.getSettings()) {
        	g.drawImage(clipboard, getClipboardX(), getClipboardY(), null);
        	g.drawImage(timeUp, getTimeUpX(), getTimeUpY(), null);
        	g.drawImage(timeDown, getTimeDownX(), getTimeDownY(), null);
        	if(SoundController.sound)
        		g.drawImage(soundOn, getSoundX(), getSoundY(), null);
        	else
        		g.drawImage(soundOff, getSoundX(), getSoundY(), null);
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
	
	public static Image getClipboard() {
		return clipboard;
	}
	
	public static int getClipboardX() {
		return (int)screenSize.getWidth()/2-clipboard.getWidth(null)/2;
	}
	
	public static int getClipboardY() {
		return (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2;
	}
	
	public static Image getTimeUp() {
		return timeUp;
	}
	
	public static Image getTimeDown() {
		return timeDown;
	}
	
	public static int getTimeUpX() {
		return (int)screenSize.getWidth()/2-timeUp.getWidth(null)/2+100;
	}
	
	public static int getTimeUpY() {
		return (int)screenSize.getHeight()/2-timeUp.getHeight(null)/2;
	}
	
	public static int getTimeDownX() {
		return (int)screenSize.getWidth()/2-timeDown.getWidth(null)/2-100;
	}
	
	public static int getTimeDownY() {
		return (int)screenSize.getHeight()/2-timeDown.getHeight(null)/2;
	}
	
	public static int getTime() {
		return time;
	}
	
	public static void incTime() {
		time+=12;
	}
	public static void decTime() {
		if(time != 0)
		time-=12;
	}
	public static int getSoundX() {
		return 100;
	}
	
	public static Image getSound() {
		return soundOn;
	}
	
	public static int getSoundY() {
		return 100;
	}
	
	public static Image getSoundOn() {
		return soundOn;
	}
	
	public static Image getSoundOff() {
		return soundOff;
	}
	
	public static Image getExit(){
		return exit;
	}
	
	public static int getExitX(){
		return (int)screenSize.getWidth()/2-exit.getWidth(null)/2;
	}
	
	public static int getExitY(){
		return 500;
	}
	
}
