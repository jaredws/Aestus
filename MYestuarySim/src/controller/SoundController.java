package controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundController {
	public static boolean sound = true;
	
	public static void toggleSound(){
		if(sound)sound = false;
		else sound = true;
	}
	
	public static void playTrap(){
		if(sound){
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
	
	public static void playTrash(){
		if(sound){
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
	
	public static void playBackground(){
		if(sound){
			String soundName = "./sounds/background.wav";     
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
	
	public static void playShears(){
		if(sound){
			String soundName = "./sounds/shears.wav";     
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
	
	public static void playIntro(){
		if(sound){
			String soundName = "./sounds/Intro.wav";     
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

}
