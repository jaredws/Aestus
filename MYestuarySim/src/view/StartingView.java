package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Game;
import controller.ScreenButtonStart;


public class StartingView extends JPanel {
	
	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static ButtonView BV;
	public ScreenButtonStart S;
	public Image BG;
 	public boolean Showing;
 	public JFrame frame;
 	Dimension screenSize;
	
	public StartingView(ScreenButtonStart s){
		Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		
		try {                
			BG = ImageIO.read(new File("./img/startscreen1.png"));
			System.out.println((int)screenSize.getWidth());
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,1);
	       } catch (IOException ex) {
	    	   System.out.println("Crab Image read error");
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
        
	}

	public void checkStart() {
		if(S.clickx > 0 && S.clickx < 1600){
			Showing = false;
		}
		
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	 


}
