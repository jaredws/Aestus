package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

	
	public Game(boolean test){
		testing = test;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static void main(String[] args){
		Game G = new Game(false);
		while(true){
				G.start(G);
				G.run(G);
				G.end(G);
		}
	}


	public int calculateHealth(){
		int c,bc,t,p,cg;
		//Crabs are worth double plants right now
		c = 2*CH.getCrabs().size();
		bc = 2*BCH.getBlueCrabs().size();
		t = TH.getTurtles().size();
		p = PH.getPhragmites().size();
		cg = CGH.getCordGrass().size();
		return (bc+t+cg-p-c);
	}
	
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
			if(testing)break;
		}
		return;
	}
	
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
		    		  if(trash > 6000){
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
		    			Thread.sleep(5000);
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
			if(run > 500)break;
		}
		EV.close();
	}
	
	public Random getRand() {
		return rand;
	}

	public static CrabHandler getCrabHandler() {
		return CH;
	}

	public static ToolControl getToolControl() {
		return TLC;
	}

	public static TotalView getTotalView() {
		return TV;
	}
	
	public static TurtleHandler getTurtleHandler() {
		return TH;
	}
	
	public static BlueCrabHandler getBlueCrabHandler() {
		return BCH;
	}
	
	public static PhragmitesHandler getPhragmitesHandler(){
		return PH;
	}
	
	public static CordGrassHandler getCordGrassHandler(){
		return CGH;
	}
	
	public static HealthHandler getHealthHandler(){
		return HH;
	}
	
	public static PollutionHandler getPollutionHandler(){
		return PolH;
	}
	
	public static CountdownControl getCountdownControl(){
		return CDC;
	}
	
	public static PopulationHandler getPopulationHandler() {
		return PopH;
	}
	
	public boolean getTesting() {
		return testing;
	}
	
	public void setTesting(boolean t) {
		this.testing = t;
	}
	
	public void spawnTrash(){
		PolH.spawnTrash();
	}
}

