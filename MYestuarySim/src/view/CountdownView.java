package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author Steven
 *
 */

public class CountdownView {
	
	private Image image;
	private Image pellet;
	private Image finish;
	Dimension screenSize;
	
	public CountdownView(){
		String name = "bogturtle";
		String p = "pellet";
		String fin = "flag";
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try { 
			image = ImageIO.read(new File("./img/"+name+".png"));
			image = image.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH);
			pellet = ImageIO.read(new File("./img/"+p+".png"));
			finish = ImageIO.read(new File("./img/"+fin+".png"));
			//pellet = pellet.getScaledInstance((int)screenSize.getWidth()/12, -1,Image.SCALE_SMOOTH);
	       } catch (IOException ex) {
	    	   System.out.println("Image read error");
	       }
	}

	public Image getImage(){
		return this.image;
	}
	
	public Image getPellet(){
		return this.pellet;
	}
	
	public Image getFinish() {
		return this.finish;
	}

}
