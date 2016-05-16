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
	private BackgroundView BGV;
	private CrabView CV;
	private TurtleView TV;
	private BlueCrabView BCV;
	private PhragmitesView PV;
	private PollutionView PUV;
	private CordGrassView CGV;
	private HealthView HV;
	private MagView MV;
	private ResearchView RV;
	private ToolView TLV;
	public ScreenControl S;
	private CountdownView CDV;
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
		frame.setUndecorated(true);
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
      
        
        for(int i = 0; i < G.getHealthHandler().check(G.calculateHealth()); i++){
        	g.drawImage(HV.getImage(0), ((int)screenSize.getWidth()-((int)screenSize.getWidth()/11)*(i+1)), (int)screenSize.getHeight()-(int)screenSize.getWidth()/10, null);
        }
        
        for(int i = 0; i < G.getToolControl().getTools().size(); i++){
        	g.drawImage(TLV.getImage(i), G.getToolControl().getTools().get(i).getX(), 
        			G.getToolControl().getTools().get(i).getY(), null);
        }
    
       
        for(int i = 0; i < G.getCordGrassHandler().getCordGrass().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CGV.getImage(G.getCordGrassHandler().getCordGrass(i).getLife()), G.getCordGrassHandler().getCordGrass(i).getX(), 
        			G.getCordGrassHandler().getCordGrass(i).getY(), null); // see javadoc for more info on the parameters  
       
        for(int i = 0; i < G.getPhragmitesHandler().getPhragmites().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PV.getImage(G.getPhragmitesHandler().getPhragmites(i).getLife()), G.getPhragmitesHandler().getPhragmites(i).getX(), 
        			G.getPhragmitesHandler().getPhragmites(i).getY(), null); // see javadoc for more info on the parameters  
      
        for(int i = 0; i < G.getPollutionHandler().getPollution().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(PUV.getImage(G.getPollutionHandler().getPollution(i).type), G.getPollutionHandler().getPollution().get(i).getX(), 
        			G.getPollutionHandler().getPollution().get(i).getY(), null); // see javadoc for more info on the parameters  
      
        
        
        
        for(int i = 0; i < G.getTurtleHandler().getTurtles().size(); i++)
    	//Made the default get Image 0 here, a movement may need to be called instead
    	g.drawImage(TV.getImage(G.getTurtleHandler().getTurtle(i).getMove()), G.getTurtleHandler().getTurtle(i).getX(), 
    			G.getTurtleHandler().getTurtle(i).getY(), null); // see javadoc for more info on the parameters
        
        for(int i = 0; i < G.getCrabHandler().getCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(CV.getImage(G.getCrabHandler().getCrab(i).move), G.getCrabHandler().getCrab(i).getX(), 
        			G.getCrabHandler().getCrab(i).getY(), null); // see javadoc for more info on the parameters            
       
        for(int i = 0; i < G.getBlueCrabHandler().getBlueCrabs().size(); i++)
        	//Made the default get Image 0 here, a movement may need to be called instead
        	g.drawImage(BCV.getImage(G.getBlueCrabHandler().getBlueCrab(i).move), G.getBlueCrabHandler().getBlueCrabs().get(i).getX(), 
        			G.getBlueCrabHandler().getBlueCrabs().get(i).getY(), null); // see javadoc for more info on the parameters
        
       
	
 
        g.drawImage(CDV.getImage(G.getCountdownControl().getImage()), 0, (int)(screenSize.getHeight() - screenSize.getWidth()/10), null);
        
 
        
        if(S.getMagGlass()) {
        	g.drawImage(MV.getImage(0), (int)(S.getMagX()-screenSize.getWidth()/24)+25, (int)(S.getMagY()-screenSize.getWidth()/24)+25, null);
        	frame.setCursor(frame.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));
        }
        if(S.getShears()) {
        	if(S.getShearsOpen()) 
        		g.drawImage(TLV.getShearsOpen(), (int)(S.getShearX()-screenSize.getWidth()/24)+25, (int)(S.getShearY()-screenSize.getWidth()/24)+35, null);
        	else 
        		g.drawImage(TLV.getShearsClose(), (int)(S.getShearX()-screenSize.getWidth()/24)+25, (int)(S.getShearY()-screenSize.getWidth()/24)+35, null);
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
