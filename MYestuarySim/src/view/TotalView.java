package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Game;
import controller.ScreenControl;
import model.Background;

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
	public ScreenControl S;
	Background background;
	Dimension screenSize;
	JFrame frame;
 	
	
	public TotalView(ScreenControl s){
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
		frame = new JFrame();
		frame.setLayout(null);
		frame.add(S);
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
      
        
        for(int i = 0; i < Game.getHealthControl().check(G.calculateHealth()); i++){
        	g.drawImage(HV.getImage(0), ((int)screenSize.getWidth()-((int)screenSize.getWidth()/11)*(i+1)), (int)screenSize.getHeight()-(int)screenSize.getWidth()/10, null);
        }
        
        for(int i = 0; i < Game.getButtonControl().getButtons().size(); i++){
        	if(i == 5){
        		continue;
        	}
        	g.drawImage(BV.getImage(i), Game.getButtonControl().getButtons().get(i).getX(), 
        			Game.getButtonControl().getButtons().get(i).getY(), null);
        }
       
        for(int i = 0; i < Game.getCordGrassControl().getCordGrass().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CGV.getImage(Game.getCordGrassControl().getCordGrass(i).life), Game.getCordGrassControl().getCordGrass(i).getX(), 
        			Game.getCordGrassControl().getCordGrass(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < Game.getPhragmitesControl().getPhragmites().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PV.getImage(Game.getPhragmitesControl().getPhragmites(i).life), Game.getPhragmitesControl().getPhragmites(i).getX(), 
        			Game.getPhragmitesControl().getPhragmites(i).getY(), null); // see javadoc for more info on the parameters  
        
        
        for(int i = 0; i < Game.getTurtleControl().getTurtles().size(); i++)
    	//Made the default get Image 0 here, a movement may need to be called instead
    	g.drawImage(TV.getImage(Game.getTurtleControl().getTurtle(i).move), Game.getTurtleControl().getTurtle(i).getX(), 
    			Game.getTurtleControl().getTurtle(i).getY(), null); // see javadoc for more info on the parameters
        
        for(int i = 0; i < Game.getCrabControl().getCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CV.getImage(Game.getCrabControl().getCrab(i).move), Game.getCrabControl().getCrab(i).getX(), 
        			Game.getCrabControl().getCrab(i).getY(), null); // see javadoc for more info on the parameters            
       
        for(int i = 0; i < Game.getBlueCrabControl().getBlueCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(BCV.getImage(Game.getBlueCrabControl().getBlueCrab(i).move), Game.getBlueCrabControl().getBlueCrabs().get(i).getX(), 
        			Game.getBlueCrabControl().getBlueCrabs().get(i).getY(), null); // see javadoc for more info on the parameters  
	
        if(S.getMagGlass()) 
        	g.drawImage(MV.getImage(0), (int)(S.getMagX()-screenSize.getWidth()/24)+25, (int)(S.getMagY()-screenSize.getWidth()/24)+25, null);
        if(S.getShears()) 
        	g.drawImage(TLV.getImage(0), (int)(S.getShearX()-screenSize.getWidth()/24)+25, (int)(S.getShearY()-screenSize.getWidth()/24)+35, null);
        if(S.getMenu()){
        	g.drawImage(BV.getImage(5),(int)screenSize.getWidth()/2 - 100, 
        			(int)screenSize.getHeight()/2-100, null);
        }
        if(S.getPause()){
        	g.drawImage(RV.getImage(S.getResearch()),0, 
        			-75, null);
        }
	
	}
	
	public void dispose(){
		frame.dispose();
	}
}
