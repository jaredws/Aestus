package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
	static TurtleView TV;
	static BlueCrabView BCV;
	static PhragmitesView PV;
	static PollutionView PUV;
	static CordGrassView CGV;
	static HealthView HV;
	static MagView MV;
	static ResearchView RV;
	static ToolView TLV;
	public ScreenControl S;
	static CountdownView CDV;
	Background background;
	Dimension screenSize;
	JFrame frame;
 	
	
	public TotalView(ScreenControl s){
		BGV = new BackgroundView();
		CV = new CrabView();
		TV = new TurtleView();
		BCV = new BlueCrabView();
		PV = new PhragmitesView();
		CGV = new CordGrassView();
		HV = new HealthView();
		MV = new MagView();
		RV = new ResearchView();
		TLV = new ToolView();
		CDV = new CountdownView();
		PUV = new PollutionView();
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
        
        for(int i = 0; i < Game.getToolControl().getTools().size(); i++){
        	g.drawImage(TLV.getImage(i), Game.getToolControl().getTools().get(i).getX(), 
        			Game.getToolControl().getTools().get(i).getY(), null);
        }
        for(int i = 0; i < Game.getPollutionControl().getPollution().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PUV.getImage(Game.getPollutionControl().getPollution(i).type), Game.getPollutionControl().getPollution().get(i).getX(), 
        			Game.getPollutionControl().getPollution().get(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < Game.getCordGrassControl().getCordGrass().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CGV.getImage(Game.getCordGrassControl().getCordGrass(i).getLife()), Game.getCordGrassControl().getCordGrass(i).getX(), 
        			Game.getCordGrassControl().getCordGrass(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < Game.getPhragmitesControl().getPhragmites().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PV.getImage(Game.getPhragmitesControl().getPhragmites(i).getLife()), Game.getPhragmitesControl().getPhragmites(i).getX(), 
        			Game.getPhragmitesControl().getPhragmites(i).getY(), null); // see javadoc for more info on the parameters  
        
        
        for(int i = 0; i < Game.getTurtleControl().getTurtles().size(); i++)
    	//Made the default get Image 0 here, a movement may need to be called instead
    	g.drawImage(TV.getImage(Game.getTurtleControl().getTurtle(i).getMove()), Game.getTurtleControl().getTurtle(i).getX(), 
    			Game.getTurtleControl().getTurtle(i).getY(), null); // see javadoc for more info on the parameters
        
        for(int i = 0; i < Game.getCrabControl().getCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CV.getImage(Game.getCrabControl().getCrab(i).move), Game.getCrabControl().getCrab(i).getX(), 
        			Game.getCrabControl().getCrab(i).getY(), null); // see javadoc for more info on the parameters            
       
        for(int i = 0; i < Game.getBlueCrabControl().getBlueCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(BCV.getImage(Game.getBlueCrabControl().getBlueCrab(i).move), Game.getBlueCrabControl().getBlueCrabs().get(i).getX(), 
        			Game.getBlueCrabControl().getBlueCrabs().get(i).getY(), null); // see javadoc for more info on the parameters
        
      
	
        //Draw Countdown
        g.drawImage(CDV.getFinish(), Game.getCountdownControl().getWidth(), Game.getCountdownControl().getImageY()+CDV.getImage().getHeight(null)-CDV.getFinish().getHeight(null), null);
        g.drawImage(CDV.getFinish(), 0, Game.getCountdownControl().getImageY()+CDV.getImage().getHeight(null)-CDV.getFinish().getHeight(null), null);
        g.drawImage(CDV.getImage(), Game.getCountdownControl().getImageX(), Game.getCountdownControl().getImageY(), null);
        
//        for(int i = 0; i < Game.getCountdownControl().getImageX(); i+= 50) {
//        	g.drawImage(CDV.getPellet(), i-CDV.getPellet().getWidth(null), Game.getCountdownControl().getImageY()+CDV.getImage().getHeight(null)-CDV.getPellet().getHeight(null), null);
//        }
        
        if(S.getMagGlass()) {
        	g.drawImage(MV.getImage(0), (int)(S.getMagX()-screenSize.getWidth()/24)+25, (int)(S.getMagY()-screenSize.getWidth()/24)+25, null);
        	frame.setCursor(frame.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));
        }
        if(S.getShears()) {
        	g.drawImage(TLV.getShears(), (int)(S.getShearX()-screenSize.getWidth()/24)+25, (int)(S.getShearY()-screenSize.getWidth()/24)+35, null);
        	frame.setCursor(frame.getToolkit().createCustomCursor(
                    new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                    "null"));
        }
        if(S.getPauseB()){
        	g.drawImage(TLV.getPauseB(),(int)screenSize.getWidth()/2 - 100, 
        			(int)screenSize.getHeight()/2-100, null);
        }
        if(S.getPause()){
        	if(S.getResearch() > -1){
        		g.drawImage(RV.getImage(S.getResearch()),300, 
        				75, null);
        		
    			}
        }
        if(!S.getMagGlass() && !S.getShears()) frame.setCursor(Cursor.getDefaultCursor());
	
	}
	
	public void dispose(){
		frame.dispose();
	}
}
