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
	static HealthView HV;
	static MagView MV;
	static ResearchView RV;
	static ToolView TLV;
	public ScreenButton S;
	Background background;
	Dimension screenSize;
 	
	
	public TotalView(ScreenButton s){
		BGV = new BackgroundView();
		CV = new CrabView();
		BV = new ButtonView();
		TV = new TurtleView();
		BCV = new BlueCrabView();
		PV = new PhragmitesView();
		CGV = new CordGrassView();
		HV = new HealthView();
		MV = new MagView();
		RV = new ResearchView();
		TLV = new ToolView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		background = new Background((int) screenSize.getWidth(), (int)screenSize.getHeight());
		S=s;
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.add(S);
		frame.getContentPane().add(Game.Time);
		frame.add(this);
		frame.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(0,0);
        frame.setTitle("AESTUS");
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.drawImage(BGV.switchImage(background.check(G.calculateHealth())),
        		0,0, null);//Due to background always being stationed at North-West Corner (0,0)
      
        
        for(int i = 0; i < G.getHealthControl().check(G.calculateHealth()); i++){
        	g.drawImage(HV.getImage(0), ((int)screenSize.getWidth()-((int)screenSize.getWidth()/11)*(i+1)), (int)screenSize.getHeight()-(int)screenSize.getWidth()/10, null);
        }
        
        for(int i = 0; i < G.getButtonControl().getButtons().size(); i++){
        	if(i == 5){
        		continue;
        	}
        	g.drawImage(BV.getImage(i), G.getButtonControl().getButtons().get(i).getX(), 
        			G.getButtonControl().getButtons().get(i).getY(), null);
        }
       
        for(int i = 0; i < G.getCordGrassControl().getCordGrass().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CGV.getImage(G.getCordGrassControl().getCordGrass(i).life), G.getCordGrassControl().getCordGrass(i).getX(), 
        			G.getCordGrassControl().getCordGrass(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < G.getPhragmitesControl().getPhragmites().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PV.getImage(G.getPhragmitesControl().getPhragmites(i).life), G.getPhragmitesControl().getPhragmites(i).getX(), 
        			G.getPhragmitesControl().getPhragmites(i).getY(), null); // see javadoc for more info on the parameters  
        
        
        for(int i = 0; i < G.getTurtleControl().getTurtles().size(); i++)
    	//Made the default get Image 0 here, a movement may need to be called instead
    	g.drawImage(TV.getImage(G.getTurtleControl().getTurtle(i).move), G.getTurtleControl().getTurtle(i).getX(), 
    			G.getTurtleControl().getTurtle(i).getY(), null); // see javadoc for more info on the parameters
        
        for(int i = 0; i < G.getCrabControl().getCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CV.getImage(G.getCrabControl().getCrab(i).move), G.getCrabControl().getCrab(i).getX(), 
        			G.getCrabControl().getCrab(i).getY(), null); // see javadoc for more info on the parameters            
       
        for(int i = 0; i < G.getBlueCrabControl().getBlueCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(BCV.getImage(G.getBlueCrabControl().getBlueCrab(i).move), G.getBlueCrabControl().getBlueCrabs().get(i).getX(), 
        			G.getBlueCrabControl().getBlueCrabs().get(i).getY(), null); // see javadoc for more info on the parameters  
	
        if(S.getMagGlass()) 
        	g.drawImage(MV.getImage(0), (int)(S.getMagX()-screenSize.getWidth()/24)+25, (int)(S.getMagY()-screenSize.getWidth()/24)+25, null);
        if(S.getShears()) 
        	g.drawImage(TLV.getImage(0), (int)(S.getShearX()-screenSize.getWidth()/24)+25, (int)(S.getShearY()-screenSize.getWidth()/24)+35, null);
        if(S.menu){
        	g.drawImage(BV.getImage(5),(int)screenSize.getWidth()/2 - 100, 
        			(int)screenSize.getHeight()/2-100, null);
        }
        if(S.pause){
        	g.drawImage(RV.getImage(S.research),(int)screenSize.getWidth()/2 - 100, 
        			(int)screenSize.getHeight()/2-100, null);
        }
	
	}
	

}
