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
	static TurtleView TV;
	static BlueCrabView BCV;
	static PhragmitesView PV;
	static CordGrassView CGV;
	public ScreenButton S;
	Background background;
 	
	
	public TotalView(ScreenButton s){
		BGV = new BackgroundView();
		CV = new CrabView();
		BV = new ButtonView();
		TV = new TurtleView();
		BCV = new BlueCrabView();
		PV = new PhragmitesView();
		CGV = new CordGrassView();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		background = new Background((int) screenSize.getWidth(), (int)screenSize.getHeight());
		S=s;
		JFrame frame = new JFrame();
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
        
        g.drawImage(BGV.switchImage(background.check((G.getCrabControl().getCrabs().size()) + (G.getBlueCrabControl().getBlueCrabs().size()) + (G.getTurtleControl().getTurtles().size()))),
        		0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        
        for(int i = 0; i < G.getButtonControl().getButtons().size(); i++)
        	g.drawImage(BV.getImage(i), G.getButtonControl().getButtons().get(i).getX(), 
        			G.getButtonControl().getButtons().get(i).getY(), null);
       
        for(int i = 0; i < G.getCordGrassControl().getCordGrass().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CGV.getImage(0), G.getCordGrassControl().getCordGrass().get(i).getX(), 
        			G.getCordGrassControl().getCordGrass().get(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < G.getPhragmitesControl().getPhragmites().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PV.getImage(0), G.getPhragmitesControl().getPhragmites().get(i).getX(), 
        			G.getPhragmitesControl().getPhragmites().get(i).getY(), null); // see javadoc for more info on the parameters  
        
        
        for(int i = 0; i < G.getTurtleControl().getTurtles().size(); i++)
    	//Made the default get Image 0 here, a movement may need to be called instead
    	g.drawImage(TV.getImage(0), G.getTurtleControl().getTurtles().get(i).getX(), 
    			G.getTurtleControl().getTurtles().get(i).getY(), null); // see javadoc for more info on the parameters
        
        for(int i = 0; i < G.getCrabControl().getCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CV.getImage(0), G.getCrabControl().getCrabs().get(i).getX(), 
        			G.getCrabControl().getCrabs().get(i).getY(), null); // see javadoc for more info on the parameters            
       
        for(int i = 0; i < G.getBlueCrabControl().getBlueCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(BCV.getImage(0), G.getBlueCrabControl().getBlueCrabs().get(i).getX(), 
        			G.getBlueCrabControl().getBlueCrabs().get(i).getY(), null); // see javadoc for more info on the parameters  
	}
	

}
