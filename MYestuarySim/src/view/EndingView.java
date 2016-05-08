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
import controller.PopulationControl;
import controller.StartScreenControl;

public class EndingView extends JPanel {
	
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static ButtonView BV;
	public EndScreenControl S;
 	public boolean Showing;
 	public JFrame frame;
 	static Dimension screenSize;
 	public static Image researcher;
	public Image clipboard;
	public Image BG;
 	private int health;
 	private PopulationControl PC;
 	private HealthView HV;
 	private ArrayList<JLabel> labels;
	
	public EndingView(EndScreenControl s2, PopulationControl PC, int health){
		Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s2;
		this.PC = PC;
		this.health = health;
		HV = new HealthView();
		labels = new ArrayList<JLabel>();
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,Image.SCALE_SMOOTH);
			researcher = ImageIO.read(new File("./img/researcher.png"));
			clipboard = ImageIO.read(new File("./img/clipboard.png"));
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
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
        g.drawImage(BG,0,0, null);
        g.drawImage(researcher, getResearcherX(), getResearcherY(), null);
        g.drawImage(clipboard, getClipBoardX(), getClipBoardY(), null); 
        for(int i = 0; i < Game.getHealthControl().check(health); i++){
        	g.drawImage(HV.getImage(0), (getClipBoardX()+HV.getImage(0).getWidth(null)*(i)), (int)(getScoreLabel().getBounds().getY()+getScoreLabel().getBounds().getHeight()), null);
        }
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public Game getGame() {
		return this.G;
	}

	public ArrayList<JLabel> getLabels() {
		JLabel score = new JLabel("Score");
		score.setBounds(getClipBoardX()+clipboard.getWidth(null)/2-75, getClipBoardY()+100,200,100);
		score.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		labels.add(score);
		
		JLabel species = new JLabel("Species");
		JLabel mittenCrabs = new JLabel("Mitten Crabs: "/* + PC.getMittenCrabs()*/);
		JLabel blueCrabs = new JLabel("Blue Crabs: "/* + PC.getBlueCrabs()*/);
		JLabel turtle = new JLabel("Turtle: "/* + PC.getTurtles()*/);
		JLabel phrag = new JLabel("Phragmites: "/* + PC.getPhragmites()*/);
		JLabel cordGrass = new JLabel("Cord Grass: "/* + PC.getTurtles()*/);
		
		species.setBounds(getClipBoardX()+40, score.getY()+100, 100, 20);
		mittenCrabs.setBounds(species.getX(),species.getY()+species.getHeight(),species.getWidth(),species.getHeight());
		blueCrabs.setBounds(species.getX(),mittenCrabs.getY()+mittenCrabs.getHeight(),species.getWidth(),species.getHeight());
		labels.add(species);
		labels.add(mittenCrabs);
		labels.add(blueCrabs);
		
		return labels;
	}
	
	public JLabel getScoreLabel() {
		return labels.get(0);
	}
	
	public int getClipBoardX() {
		return (int)screenSize.getWidth()/2;
	}
	
	public int getClipBoardY() {
		return (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2;
	}
	
	public static int getResearcherX() {
		return 300;
	}
	
	public static int getResearcherY() {
		return (int)screenSize.getHeight()/2-researcher.getHeight(null)/2;
	}
	
	public static Image getResearcher() {
		return researcher;
	}
}
