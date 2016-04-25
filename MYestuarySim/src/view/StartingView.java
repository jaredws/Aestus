package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Game;
import controller.ScreenButton;
import controller.ScreenButtonStart;
import model.Background;

public class StartingView extends JPanel {
	
	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -3728339469941254427L;
	
	private Game G;
	static ButtonView BV;
	public ScreenButtonStart S;
	private BufferedImage BG;
 	
	
	public StartingView(ScreenButtonStart s){
		BV = new ButtonView();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		S=s;
		//BG = import background for start screen
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
        g.drawImage(BG,0,0, null);//Due to background always being stationed at North-West Corner (0,0)
        
	}
	


}
