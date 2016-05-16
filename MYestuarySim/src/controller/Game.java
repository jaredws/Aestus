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
	Random rand = new Random();
	static Random r = new Random();
	static StartingView SV;
	static CrabHandler CC;
	static TurtleHandler TC;
	static BlueCrabHandler BCC;
	static ToolControl TLC;
	static TotalView TV;
	static PopulationHandler PopC;
	static CordGrassHandler CGC;
	static PhragmitesHandler PC;
	static HealthHandler HC;
	static PollutionHandler PolC;
	static EndingView EV;
	static EndScreenControl ESC;
	static CountdownControl CDC;
	static int threeSec = 0;
	static int sec = 0;
	static Timer timer;
	static boolean researchPause = false;
	
	public static void main(String[] args){
		Game G = new Game();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		StartScreenControl s = new StartScreenControl();
		SV = new StartingView(s);
		SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		SV.add(StartingView.timeL);
		SV.add(StartingView.settingsL);
		
		SoundController.playIntro();
	
		while(s.getShowing()){
			s.check();
			
			StartingView.timeL.setText(Integer.toString(StartingView.getTime()));
			SV.update(G);
			SV.repaint();
			try {
    			Thread.sleep(1);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
		ScreenControl S = new ScreenControl();
		TV = new TotalView(S);
		CC = new CrabHandler();
		TLC = new ToolControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		TC = new TurtleHandler();
		BCC = new BlueCrabHandler();
		PopC = new PopulationHandler(G);
		PC = new PhragmitesHandler();
		CGC = new CordGrassHandler();
		HC = new HealthHandler();
		PolC = new PollutionHandler();
		CDC = new CountdownControl();
	
		TV.update(G);
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		SV.dispose(); 
		for(int i = 0; i<5; i++){
			PC.addPhragmites(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			CC.addCrab(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
		}
		for(int j = 0; j < 5; j++){
			BCC.addBlueCrab(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			CGC.addCordGrass(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			TC.addTurtle(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			PolC.addPollution(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
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
		    		  PopC.update(G);
		    		  threeSec=0;
		    		  
		    	}
		    	if(!S.pause  && !researchPause){
					CC.moveCrabs();
					TC.moveTurtles();
					BCC.moveBlueCrabs();
					PC.age();
					CGC.age();
					PolC.age();
					sec+=t;
				    threeSec+=t;
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
			S.checkPos(CC,TC,BCC,CGC,PC,TLC,PolC);
			TV.update(G);
			TV.repaint();
			if(CDC.getTime() == 0) break;
			counter++;
			if(S.pause) {
				TV.repaint();
				if(S.getResearch() > -1 && !S.researchPause){
//	        		try {
//	        			Thread.sleep(10000);
//	        		} catch (InterruptedException e) {
//	        			e.printStackTrace();
//	        			}
	        		S.researchPause = true;
	        	}
				continue;
			}
			S.researchPause = false;
			CC.deleteCrabs(TLC);
			TC.deleteTurtles(TLC);
			BCC.deleteBlueCrabs(TLC);
			PolC.deletePollution(TLC);
			
		}
		int health = G.calculateHealth();
		EndScreenControl esc = new EndScreenControl();
		EV = new EndingView(esc, PopC, health);
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
        	
		while(EV.Showing){
			esc.checkPos();
			EV.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
	}

	public Random getRand() {
		return rand;
	}

	public static CrabHandler getCrabControl() {
		return CC;
	}

	public static ToolControl getToolControl() {
		return TLC;
	}

	public static TotalView getTotalView() {
		return TV;
	}
	
	public static TurtleHandler getTurtleControl() {
		return TC;
	}
	
	public static BlueCrabHandler getBlueCrabControl() {
		return BCC;
	}
	
	public static PhragmitesHandler getPhragmitesControl(){
		return PC;
	}
	
	public static CordGrassHandler getCordGrassControl(){
		return CGC;
	}
	
	public static HealthHandler getHealthControl(){
		return HC;
	}
	
	public static PollutionHandler getPollutionControl(){
		return PolC;
	}
	
	public static CountdownControl getCountdownControl(){
		return CDC;
	}
	
	//Is this still necessary? 
	//does the HealthHandler deal with this?- JS
	public int calculateHealth(){
		int c,bc,t,p,cg;
		//Crabs are worth double plants right now
		c = 2*CC.getCrabs().size();
		bc = 2*BCC.getBlueCrabs().size();
		t = TC.getTurtles().size();
		p = PC.getPhragmites().size();
		cg = CGC.getCordGrass().size();
		return (bc+t+cg-p-c);
	}
	
	
}

