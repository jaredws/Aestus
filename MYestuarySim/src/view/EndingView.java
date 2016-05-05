package view;

import java.awt.Dimension;
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
	
	public EndingView(EndScreenControl s2){
		Showing = true;
		BV = new ButtonView();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s2;
		
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
        frame.add(new JLabel("Score"));
	}
	
	public void update(Game g){
		G=g;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BG,0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        g.drawImage(researcher, 200, (int)screenSize.getHeight()/2-researcher.getHeight(null)/2, null);
        g.drawImage(clipboard, (int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2-clipboard.getHeight(null)/2, null);        
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public Game getGame() {
		return this.G;
	}
	
	public JLabel getScoreLabel() {
		JLabel score = new JLabel("Score");
		
		return score;
	}


}
