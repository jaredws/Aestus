package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.EndScreenControl;
import controller.Game;
import controller.StartScreenControl;
import model.PopulationHandler;

public class EndingView extends JPanel {
	
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	public EndScreenControl S;
 	public boolean Showing;
 	public JFrame frame;
 	static Dimension screenSize;
 	public static Image researcher,researcherMad;
	public Image clipboard,BG,star,check,x;
 	private int health;
 	private PopulationHandler PC;
 	private HealthView HV;
 	JLabel species,died,rsch,end,remove;
	
	public EndingView(EndScreenControl s2, PopulationHandler PC, int health){
		Showing = true;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s2;
		this.PC = PC;
		this.health = health;
		HV = new HealthView();
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH);
			researcher = ImageIO.read(new File("./img/researcher.png"));
			researcher = researcher.getScaledInstance((int)screenSize.getWidth()/2, -1,Image.SCALE_SMOOTH);
//			researcherMad = ImageIO.read(new File("./img/researcherMad.png"));
//			researcherMad = researcherMad.getScaledInstance((int)screenSize.getWidth()/2, -1,Image.SCALE_SMOOTH);
			clipboard = ImageIO.read(new File("./img/clipboard.png"));
			star = ImageIO.read(new File("./img/Star.png"));
			star = star.getScaledInstance((int)screenSize.getWidth()/14, -1,Image.SCALE_SMOOTH);
			check = ImageIO.read(new File("./img/check.png"));
			check = check.getScaledInstance((int)screenSize.getWidth()/50, -1,Image.SCALE_SMOOTH);
			x = ImageIO.read(new File("./img/x.png"));
			x = x.getScaledInstance((int)screenSize.getWidth()/50, -1,Image.SCALE_SMOOTH);
			
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
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);
        
        g.drawImage(researcher, getResearcherX(), getResearcherY(), null);
        g.drawImage(clipboard, getClipBoardX(), getClipBoardY(), null); 
        for(int i = 0; i < Game.getHealthControl().check(health); i++){
        	g.drawImage(star, getStarX(i), getStarY(), null);
        }
        for(int i=1; i < getSpeciesLabels().size(); i++) {
        	if(Game.getCrabControl().getResearched() && i==1)
        		g.drawImage(check, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth(), getSpeciesLabels().get(i).getY(),null);
        	else if(Game.getBlueCrabControl().getResearched() && i == 2)
        		g.drawImage(check, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth(), getSpeciesLabels().get(i).getY(),null);
        	else if(Game.getTurtleControl().getResearched() && i==3)
        		g.drawImage(check, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth(), getSpeciesLabels().get(i).getY(),null);
        	else if(Game.getPhragmitesControl().getResearched() && i==4)
        		g.drawImage(check, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth(), getSpeciesLabels().get(i).getY(),null);
        	else if(Game.getCordGrassControl().getResearched() && i==5)
        		g.drawImage(check, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth()+getResearchedLabel().getWidth()/2-check.getWidth(null)/2, getSpeciesLabels().get(i).getY(),null);
        	else 
        		g.drawImage(x, getSpeciesLabels().get(1).getX()+getSpeciesLabels().get(1).getWidth()+getResearchedLabel().getWidth()/2-x.getWidth(null)/2, getSpeciesLabels().get(i).getY(),null);
        }
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public Game getGame() {
		return this.G;
	}

	public ArrayList<JLabel> getSpeciesLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		species = new JLabel("Species");
		JLabel mittenCrabs = new JLabel("Mitten Crabs");
		JLabel blueCrabs = new JLabel("Blue Crabs");
		JLabel turtle = new JLabel("Turtle");
		JLabel phrag = new JLabel("Phragmites");
		JLabel cordGrass = new JLabel("Cord Grass");
		
		species.setBounds(getStarX(0)+10, getStarY()+star.getHeight(null), 100, 20);
		mittenCrabs.setBounds(species.getX(),species.getY()+species.getHeight(),species.getWidth(),species.getHeight());
		blueCrabs.setBounds(species.getX(),mittenCrabs.getY()+mittenCrabs.getHeight(),species.getWidth(),species.getHeight());
		turtle.setBounds(species.getX(),blueCrabs.getY()+blueCrabs.getHeight(),species.getWidth(),species.getHeight());
		phrag.setBounds(species.getX(),turtle.getY()+turtle.getHeight(),species.getWidth(),species.getHeight());
		cordGrass.setBounds(species.getX(),phrag.getY()+phrag.getHeight(),species.getWidth(),species.getHeight());
		labels.add(species);
		labels.add(mittenCrabs);
		labels.add(blueCrabs);
		labels.add(turtle);
		labels.add(phrag);
		labels.add(cordGrass);
		return labels;
	}
	
	public JLabel getResearchedLabel() {
		rsch = new JLabel("Researched");
		rsch.setBounds(species.getX()+species.getWidth(), getStarY()+star.getHeight(null), 100, 20);
		rsch.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		return rsch;
	}
	
	public ArrayList<JLabel> getDiedLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		died = new JLabel("Died");
		JLabel mittenCrabs = new JLabel(Integer.toString(PC.getMittenDie()));
		JLabel blueCrabs = new JLabel(Integer.toString(PC.getBlueCrabDie()));
		JLabel turtle = new JLabel(Integer.toString(PC.getTurtleDie()));
		JLabel phrag = new JLabel(Integer.toString(PC.getPhragDie()));
		JLabel cordGrass = new JLabel(Integer.toString(PC.getCordDie()));
		
		died.setBounds(remove.getX()+remove.getWidth(), getStarY()+star.getHeight(null), 100, 20);
		mittenCrabs.setBounds(died.getX(),died.getY()+died.getHeight(),died.getWidth(),died.getHeight());
		blueCrabs.setBounds(died.getX(),mittenCrabs.getY()+mittenCrabs.getHeight(),died.getWidth(),died.getHeight());
		turtle.setBounds(died.getX(),blueCrabs.getY()+blueCrabs.getHeight(),died.getWidth(),died.getHeight());
		phrag.setBounds(died.getX(),turtle.getY()+turtle.getHeight(),died.getWidth(),died.getHeight());
		cordGrass.setBounds(died.getX(),phrag.getY()+phrag.getHeight(),died.getWidth(),died.getHeight());
		labels.add(died);
		labels.add(mittenCrabs);
		labels.add(blueCrabs);
		labels.add(turtle);
		labels.add(phrag);
		labels.add(cordGrass);
		return labels;
	}
	
	public ArrayList<JLabel> getRemoveLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		remove = new JLabel("Removed");
		JLabel mittenCrabs = new JLabel(Integer.toString(PC.getMittenDie()));
		JLabel blueCrabs = new JLabel(Integer.toString(PC.getBlueCrabDie()));
		JLabel turtle = new JLabel(Integer.toString(PC.getTurtleDie()));
		JLabel phrag = new JLabel(Integer.toString(PC.getPhragDie()));
		JLabel cordGrass = new JLabel(Integer.toString(PC.getCordDie()));
		
		remove.setBounds(rsch.getX()+rsch.getWidth(), getStarY()+star.getHeight(null), 100, 20);
		mittenCrabs.setBounds(remove.getX(),remove.getY()+remove.getHeight(),remove.getWidth(),remove.getHeight());
		blueCrabs.setBounds(remove.getX(),mittenCrabs.getY()+mittenCrabs.getHeight(),remove.getWidth(),remove.getHeight());
		turtle.setBounds(remove.getX(),blueCrabs.getY()+blueCrabs.getHeight(),remove.getWidth(),remove.getHeight());
		phrag.setBounds(remove.getX(),turtle.getY()+turtle.getHeight(),remove.getWidth(),remove.getHeight());
		cordGrass.setBounds(remove.getX(),phrag.getY()+phrag.getHeight(),remove.getWidth(),remove.getHeight());
		labels.add(remove);
		labels.add(mittenCrabs);
		labels.add(blueCrabs);
		labels.add(turtle);
		labels.add(phrag);
		labels.add(cordGrass);
		return labels;
	}
	
	public ArrayList<JLabel> getEndLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		end = new JLabel("End");
		JLabel mittenCrabs = new JLabel(Integer.toString(Game.getCrabControl().getCrabs().size()));
		JLabel blueCrabs = new JLabel(Integer.toString(Game.getBlueCrabControl().getBlueCrabs().size()));
		JLabel turtle = new JLabel(Integer.toString(Game.getTurtleControl().getTurtles().size()));
		JLabel phrag = new JLabel(Integer.toString(Game.getPhragmitesControl().getPhragmites().size()));
		JLabel cordGrass = new JLabel(Integer.toString(Game.getCordGrassControl().getCordGrass().size()));
		
		end.setBounds(died.getX()+died.getWidth(), getStarY()+star.getHeight(null), 100, 20);
		mittenCrabs.setBounds(end.getX(),end.getY()+end.getHeight(),end.getWidth(),end.getHeight());
		blueCrabs.setBounds(end.getX(),mittenCrabs.getY()+mittenCrabs.getHeight(),end.getWidth(),end.getHeight());
		turtle.setBounds(end.getX(),blueCrabs.getY()+blueCrabs.getHeight(),end.getWidth(),end.getHeight());
		phrag.setBounds(end.getX(),turtle.getY()+turtle.getHeight(),end.getWidth(),end.getHeight());
		cordGrass.setBounds(end.getX(),phrag.getY()+phrag.getHeight(),end.getWidth(),end.getHeight());
		labels.add(end);
		labels.add(mittenCrabs);
		labels.add(blueCrabs);
		labels.add(turtle);
		labels.add(phrag);
		labels.add(cordGrass);
		return labels;
	}
	
	public JLabel getScoreLabel() {
		JLabel score = new JLabel("Score");
		score.setBounds(getClipBoardX()+clipboard.getWidth(null)/2-75, getClipBoardY()+100,200,100);
		score.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		return score;
	}
	
	public int getClipBoardX() {
		return (int)screenSize.getWidth()/2;
	}
	
	public int getClipBoardY() {
		return (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2;
	}
	
	public int getStarX(int i) {
		return (getClipBoardX()+star.getWidth(null)*(i) + 25);
	}
	
	public int getStarY() {
		return (int)(getScoreLabel().getBounds().getY()+getScoreLabel().getBounds().getHeight()-20);
	}
	
	public static int getResearcherX() {
		return 100;
	}
	
	public static int getResearcherY() {
		return (int)screenSize.getHeight()/4;
	}
	
	public static Image getResearcher() {
		return researcher;
	}
}
