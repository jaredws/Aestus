package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import model.BlueCrabHandler;
import model.CordGrassHandler;
import model.CrabHandler;
import model.HealthHandler;
import model.PhragmitesHandler;
import model.PollutionHandler;
import model.PopulationHandler;
import model.TurtleHandler;
import view.EndingView;
import view.StartingView;
import view.TotalView;


/**
 * The Game Class
 * The main function contained herein will run an instance of the game.
 * @author Team0
 *
 */
public class Game {
	public boolean testing;
	Random rand = new Random();
	static Random r = new Random();
	static StartingView SV;
	static CrabHandler CH;
	static TurtleHandler TH;
	static BlueCrabHandler BCH;
	static ToolControl TLC;
	static TotalView TV;
	static PopulationHandler PopH;
	static CordGrassHandler CGH;
	static PhragmitesHandler PH;
	static HealthHandler HH;
	static PollutionHandler PolH;
	static EndingView EV;
	static EndScreenControl ESC;
	static CountdownControl CDC;
	static int threeSec = 0;
	static int sec = 0;
	static int trash = 0;
	static Timer timer;
	static boolean researchPause = false;
	private Dimension screenSize;

	/**
	 * Boolean for testing the game class.
	 * @param test
	 */
	public Game(boolean test){
		testing = test;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	/**
	 * The main function to run Aestus
	 * @param args
	 */
	public static void main(String[] args){
		Game G = new Game(false);
		while(true){
			G.start(G);
			if(G.testing)break;
			G.run(G);
			if(G.testing)break;
			G.end(G);
		}
	}

	/**
	 * Calculate health manages the user's score.
	 */
	public int calculateHealth(){
			int score = 0;
			score -= 10*Game.getCrabHandler().getCrabs().size();
			score += 10*Game.getBlueCrabHandler().getBlueCrabs().size();
			score += 7*Game.getTurtleHandler().getTurtles().size();
			score -= 5*Game.getPhragmitesHandler().getPhragmites().size();
			score += 5*Game.getCordGrassHandler().getCordGrass().size();
			score -= 20*Game.getPollutionHandler().getPollution().size();
			if(Game.getCrabHandler().getResearched())
				score += 10;
			if(Game.getBlueCrabHandler().getResearched())
				score += 10;
			if(Game.getTurtleHandler().getResearched())
				score += 10;
			if(Game.getPhragmitesHandler().getResearched())
				score += 10;
			if(Game.getCordGrassHandler().getResearched())
				score += 10;
			if(score < 0)return 0;
			else return score;
		}
	
	/**
	 * Helper function to run a game.
	 * Run the start screen.
	 * @param G
	 */
	public void start(Game G) {
		StartScreenControl s = new StartScreenControl();
		SV = new StartingView(s);
		SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		SV.add(StartingView.timeL);
		SV.add(StartingView.settingsL);
		SoundController.playIntro();

		while(s.getShowing()){
			s.check();
			StartingView.timeL.setText(Integer.toString(StartingView.getTime()));
			SV.update(this);
			SV.repaint();
			try {
    			Thread.sleep(1);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
			if(G.getTesting()) break;
			
		}
		return;
	}
	/**
	 * Run the entirety of a game. 
	 * The simulator and game play. 
	 * @param G
	 */
	public void run(Game G){
		ScreenControl S = new ScreenControl();
		TV = new TotalView(S);
		CH = new CrabHandler();
		TLC = new ToolControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		TH = new TurtleHandler();
		BCH = new BlueCrabHandler();
		PopH = new PopulationHandler(this);
		PH = new PhragmitesHandler();
		CGH = new CordGrassHandler();
		HH = new HealthHandler();
		PolH = new PollutionHandler();
		CDC = new CountdownControl();
	
		TV.update(this);
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		SV.dispose(); 
		for(int i = 0; i<5; i++){
			PH.addPhragmites(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			CH.addCrab(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
		}
		for(int j = 0; j < 5; j++){
			BCH.addBlueCrab(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			CGH.addCordGrass(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			TH.addTurtle(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			PolH.addPollution(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
		}
		
		/**
		 * Create a timer for updating the population.
		 * Since the population will naturally correct itself, we want to delay that to allow the player
		 * to mess with the estuary and see the effects.
		 */
		int t = 50;
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	if(sec/t == 5) {
		    		CDC.updateCountdown();
		    		sec = 0;
		    	}
		    	if(threeSec/t == 60 && !S.pause) {
		    		  PopH.update(G);
		    		  if(trash > 12000){
		    			  spawnTrash();
		    			  trash = 0;
		    		  }
		    		  threeSec=0;
		    	}
		    	if(!S.pause && !researchPause){
					CH.moveCrabs();
					TH.moveTurtles();
					BCH.moveBlueCrabs();
					PH.age();
					CGH.age();
					PolH.age();
					sec+=t;
				    threeSec+=t;
				    trash +=t;
				    S.research = -1;
				}
		    	if(CDC.getTime() <= 0) timer.stop();
		    }
        };
	    timer = new Timer(t, taskPerformer);
	    timer.start();
	    TV.repaint();
	    S.researchPause = false;
	    int counter = 0;
		while(true){
			try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
			if(counter%(100*11) == 0){
				SoundController.playBackground();
			}
			S.checkPos(CH,TH,BCH,CGH,PH,TLC,PolH);
			TV.update(this);
			TV.repaint();
			if(CDC.getTime() == 0) break;
			counter++;
			if(S.pause) {
				TV.repaint();
				if(S.getResearch() > -1 && !S.researchPause){
					try {
		    			Thread.sleep(2000);
		    		} catch (InterruptedException e) {
		    			e.printStackTrace();
		    		}
	        		S.researchPause = true;
	        	}
				continue;
			}
			S.researchPause = false;
			CH.deleteCrabs(TLC);
			TH.deleteTurtles(TLC);
			BCH.deleteBlueCrabs(TLC);
			PolH.deletePollution(TLC);
			if(testing)break;
		}
		return;
	}
	/**
	 * run the ending screen of a game
	 * Displays score and statistics about the game
	 * @param G
	 */
	public void end(Game G) {
		int health = this.calculateHealth();
		EndScreenControl esc = new EndScreenControl();
		EV = new EndingView(esc, PopH, health);
		EV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		TV.dispose();
		EV.add(EV.getScoreLabel());
		EV.add(EV.getResearchedLabel());
		for(JLabel l: EV.getSpeciesLabels()) {
			if(!l.getText().equals("Species")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		for(JLabel l: EV.getRemoveLabels()) {
			if(!l.getText().equals("Removed")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		for(JLabel l: EV.getDiedLabels()) {
			if(!l.getText().equals("Died")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
		
		for(JLabel l: EV.getEndLabels()) {
			if(!l.getText().equals("End")) l.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			else l.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			EV.add(l);
		}
        
		int run = 0;
		esc.checkPos();
		EV.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(EV.Showing){
			run++;
			esc.checkPos();
			EV.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(testing)break;
			if(run > 2000 || esc.getClicked())break;
		}
		EV.close();
	}
	
	/**
	 * Get the random number generator
	 * @return instance of random number generator
	 */
	public Random getRand() {
		return rand;
	}
/**
 * Get the instance of the CrabHandler
 * @return
 */
	public static CrabHandler getCrabHandler() {
		return CH;
	}
	/**
	 * Get the instance of the ToolControl
	 * @return
	 */

	public static ToolControl getToolControl() {
		return TLC;
	}
/**
 * Get the instance of TotalView
 * @return
 */
	public static TotalView getTotalView() {
		return TV;
	}
	/**
	 * Get the instance of the TurtleHanlder
	 * @return
	 */
	public static TurtleHandler getTurtleHandler() {
		return TH;
	}
	/**
	 * Get the instance of the BlueCrabHandler
	 * @return
	 */
	
	public static BlueCrabHandler getBlueCrabHandler() {
		return BCH;
	}
	/**
	 * Get the instance of the PhragmitesHandler
	 * @return
	 */
	public static PhragmitesHandler getPhragmitesHandler(){
		return PH;
	}
	/**
	 * Get the instance of the CordGrassHandler
	 * @return
	 */
	public static CordGrassHandler getCordGrassHandler(){
		return CGH;
	}
	/**
	 * Get the instance of the HealthHandler
	 * @return
	 */
	public static HealthHandler getHealthHandler(){
		return HH;
	}
	/**
	 * Get the instance of the PollutionHandler
	 * @return
	 */
	public static PollutionHandler getPollutionHandler(){
		return PolH;
	}
	/**
	 * Get the instance of the CountDownControl	
	 * @return
	 */
	public static CountdownControl getCountdownControl(){
		return CDC;
	}
	/**
	 * Get the instance of the PopulationHandler
	 * @return
	 */
	public static PopulationHandler getPopulationHandler() {
		return PopH;
	}
	/**
	 * Get the Testing boolean
	 * @return
	 */
	public boolean getTesting() {
		return testing;
	}
	/**
	 * Set the testing boolean
	 * @param t
	 */
	public void setTesting(boolean t) {
		this.testing = t;
	}
	/**
	 * Run spawnTrash() from the PollutionHandler
	 */
	public void spawnTrash(){
		PolH.spawnTrash();
	}
}

