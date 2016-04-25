package view;

import java.awt.Dimension;
import java.awt.Graphics;
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
	public BufferedImage BG;
 	public boolean Showing;
 	public JFrame frame;
	
	public StartingView(ScreenButtonStart s){
		Showing = true;
		BV = new ButtonView();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		
		try {                
			BG = ImageIO.read(new File("./img/startscreen1.png"));
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
        if(!Showing){
        	frame.dispose();
        }
	}

	public void checkStart() {
		if(S.clickx > 0 && S.clickx < 1600){
			Showing = false;
		}
		
	}
	


}
