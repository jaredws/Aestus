package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import view.EndingView;
import view.StartingView;
import view.TotalView;

public class Game {
	Random rand = new Random();
	static Random r = new Random();
	static StartingView SV;
	static CrabControl CC;
	static TurtleControl TC;
	static BlueCrabControl BCC;
	static ToolControl TLC;
	static TotalView TV;
	static PopulationControl PopC;
	static CordGrassControl CGC;
	static PhragmitesControl PC;
	static HealthControl HC;
	static PollutionControl PolC;
	static EndingView EV;
	static EndScreenControl ESC;
	static CountdownControl CDC;
	static int threeSec = 0;
	static int sec = 0;
	static Timer timer;
	
	public static void main(String[] args){
		Game G = new Game();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		StartScreenControl s = new StartScreenControl();
		SV = new StartingView(s);
		SV.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
		while(s.getShowing()){
			s.check();
			SV.repaint();
			try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}
		ScreenControl S = new ScreenControl();
		TV = new TotalView(S);
		CC = new CrabControl();
		TLC = new ToolControl((int)screenSize.getHeight(),(int)screenSize.getWidth());
		TC = new TurtleControl();
		BCC = new BlueCrabControl();
		PopC = new PopulationControl(G);
		PC = new PhragmitesControl();
		CGC = new CordGrassControl();
		HC = new HealthControl();
		PolC = new PollutionControl();
		CDC = new CountdownControl();
		TV.update(G);
		TV.setSize((int) screenSize.getWidth(), (int)screenSize.getHeight());
		SV.dispose(); 
		for(int i = 0; i<15; i++){
			PC.addPhragmites(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
			CC.addCrab(r.nextInt((int)screenSize.getWidth()*9/12)+(int)screenSize.getWidth()/12,r.nextInt((int)screenSize.getHeight()*8/12) + (int)screenSize.getHeight()/12);
		}
		for(int j = 0; j < 3; j++){
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
		    	if(sec/t == 20) {
		    		CDC.updateCountdown();
		    		sec = 0;
		    	}
		    	if(threeSec/t == 60 && !S.pause) {
		    		  PopC.update(G);
		    		  threeSec=0;
		    		  
		    	}
		    	if(!S.pause){
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
		while(true){
			S.checkPos(CC,TC,BCC,CGC,PC,TLC,PolC);
			TV.update(G);
			TV.repaint();
			if(CDC.getTime() == 0) break;
			if(S.pause) {
				TV.repaint();
				continue;
			}
			CC.deleteCrabs(TLC);
			TC.deleteTurtles(TLC);
			BCC.deleteBlueCrabs(TLC);
			PolC.deletePollution(TLC);
			try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
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

	public static CrabControl getCrabControl() {
		return CC;
	}

	public static ToolControl getToolControl() {
		return TLC;
	}

	public static TotalView getTotalView() {
		return TV;
	}
	
	public static TurtleControl getTurtleControl() {
		return TC;
	}
	
	public static BlueCrabControl getBlueCrabControl() {
		return BCC;
	}
	
	public static PhragmitesControl getPhragmitesControl(){
		return PC;
	}
	
	public static CordGrassControl getCordGrassControl(){
		return CGC;
	}
	
	public static HealthControl getHealthControl(){
		return HC;
	}
	
	public static PollutionControl getPollutionControl(){
		return PolC;
	}
	
	public static CountdownControl getCountdownControl(){
		return CDC;
	}
	
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

