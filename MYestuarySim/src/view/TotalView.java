package view;

import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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

import controller.Game;
import controller.ScreenButton;
import model.Background;
import model.Button;
import model.Crab;

public class TotalView extends JPanel{

	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static BackgroundView BGV;
	static CrabView CV;
	static ButtonView BV;
	public ScreenButton S;
	Background background;
 	
	
	public TotalView(ScreenButton s){
		BGV = new BackgroundView();
		CV = new CrabView();
		BV = new ButtonView();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		background = new Background((int) screenSize.getWidth(), (int)screenSize.getHeight());
		S=s;
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.add(S);
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
        
        g.drawImage(BGV.switchImage(background.check(G.getCrabControl().getCrabs().size())),
        		background.getX(), background.getY(), null);
        for(int i = 0; i < G.getButtonControl().getButtons().size(); i++)
        	g.drawImage(BV.getImage(i), G.getButtonControl().getButtons().get(i).getX(), 
        			G.getButtonControl().getButtons().get(i).getY(), null);
        
        for(int i = 0; i < G.getCrabControl().getCrabs().size(); i++)
        	g.drawImage(CV.getImage(i), G.getCrabControl().getCrabs().get(i).getX(), 
        			G.getCrabControl().getCrabs().get(i).getY(), null); // see javadoc for more info on the parameters            
        
	}
	

}
