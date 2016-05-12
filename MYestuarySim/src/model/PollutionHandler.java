package model;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
/**
 * @author karpybizman
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controller.ToolControl;

public class PollutionHandler {
	Random rand;
	List<Pollution> Pollution;

	Dimension screenSize;
	int Removed;
	

	public void addPollution(int x, int y){
		Pollution.add(new Pollution(x,y,screenSize,rand.nextInt(3)));
	}
	
	public List<Pollution> getPhragmites() {
		return this.Pollution;
	}
	
	public PollutionHandler(){
		rand  = new Random();
		Pollution = new ArrayList<Pollution>();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Removed = 0;
	}
	
	
	public void deletePollution(ToolControl tc){
		for(int i = 0; i < Pollution.size(); i++){
			if(Pollution.get(i).getX() > tc.getRecycle().getX() - tc.getRecycle().getSizeX()/2 && Pollution.get(i).getX() < tc.getRecycle().getX() + tc.getRecycle().getSizeX()/4){
				if((Pollution.get(i).getY() > tc.getRecycle().getY()-tc.getRecycle().getSizeY()) && (Pollution.get(i).getY() < tc.getRecycle().getY() + tc.getRecycle().getSizeY()/2)){
					Pollution.remove(i);
					Removed++;
					i--;
					playSound();
				}
			}
		}
	}
	
	protected void removePollution(int i){
		Pollution.remove(i);
	}
	public List<Pollution> getPollution(){
		return this.Pollution;
	}
	
	public Pollution getPollution(int i){
		return Pollution.get(i);
	}
	
	public int getPollutionSize(){
		return Pollution.size();
	}
	
	public void age(){
		for(int i = 0; i < Pollution.size(); i++){
			Pollution.get(i).live();
		}
	}
	
	public int getRemoved(){
		return Removed;
	}
	
	public void playSound(){
		
		String soundName = "./sounds/trash.wav";     
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
