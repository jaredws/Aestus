package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controller.ToolControl;

public class CrabHandler {
	Random rand;
	List<Crab> crabs;
	Dimension screenSize;
	private boolean Researched;
	int Removed;

	public void addCrab(int x, int y){
		crabs.add(new Crab(x,y,screenSize));
	}
	
	public List<Crab> getCrabs() {
		return this.crabs;
	}
	
	public CrabHandler(){
		rand  = new Random();
		crabs = new ArrayList<Crab>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResearched(false);
		Removed = 0;
	}
	
	public void moveCrabs(){
		for(int i = 0; i < crabs.size(); i++){
			crabs.get(i).moveCrab(rand.nextInt(),screenSize);
		}
	}
	
	public void deleteCrabs(ToolControl tc){
		for(int i = 0; i < crabs.size(); i++){
			if(crabs.get(i).getX() > tc.getCrabTrap().getX() - tc.getCrabTrap().getSizeX()/2 && crabs.get(i).getX() < tc.getCrabTrap().getX() + tc.getCrabTrap().getSizeX()/4){
				if((crabs.get(i).getY() > tc.getCrabTrap().getY()-tc.getCrabTrap().getSizeY()) && (crabs.get(i).getY() < tc.getCrabTrap().getY() + tc.getCrabTrap().getSizeY()/2)){
					crabs.remove(i);
					Removed++;
					i--;
					playSound();
				}
			}
		}
	}
	
	protected void removeCrab(int i){
		crabs.remove(i);
	}
	
	public Crab getCrab(int i){
		return crabs.get(i);
	}
	
	public boolean getResearched() {
		return this.isResearched();
	}
	
	public int getRemoved(){
		return Removed;
	}

	public boolean isResearched() {
		return Researched;
	}

	public void setResearched(boolean researched) {
		Researched = researched;
	}
public void playSound(){
		
		String soundName = "./sounds/crabtrap.wav";     
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip;
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
