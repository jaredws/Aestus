package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
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
	public Image BG;
 	public boolean Showing;
 	public JFrame frame;
 	Dimension screenSize;
 	public Image researcher;
 	public Image clipboard;
 	private int health;
 	private PopulationControl PC;
 	private HealthView HV;
	
	public EndingView(EndScreenControl s2, PopulationControl PC, int health){
		Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s2;
		this.PC = PC;
		this.health = health;
		HV = new HealthView();
		
		try {                
			BG = ImageIO.read(new File("./img/bg.png"));
			BG = BG.getScaledInstance((int)screenSize.getWidth(), -1,1);
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
        frame.add(getScoreLabel());
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);
        g.drawImage(researcher, 300, (int)screenSize.getHeight()/2-researcher.getHeight(null)/2, null);
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
	
	public JLabel getScoreLabel() {
		JLabel score = new JLabel("Score");
		score.setOpaque(true);
		score.setBounds(getClipBoardX()+clipboard.getWidth(null)/2-50, getClipBoardY()+50,200,100);
		score.setAlignmentX(CENTER_ALIGNMENT);
		score.setFont(new Font("Serif", Font.PLAIN, 50));
		return score;
	}
	
	public int getClipBoardX() {
		return (int)screenSize.getWidth()/2;
	}
	
	public int getClipBoardY() {
		return (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2;
	}


}
