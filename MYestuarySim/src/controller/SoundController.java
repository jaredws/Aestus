package controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * The Class SoundController.
 * Contains functions that play various sounds/music to be used in game.
 * @author Team 0
 */
public class SoundController {
	
	/** The sound state */
	public static boolean sound = true;
	
	/**
	 * Toggle sound on or off.
	 */
	public static void toggleSound(){
		if(sound)sound = false;
		else sound = true;
	}
	
	/**
	 * Play trap sound effect.
	 * @exception UnsupportedAudioFileException - if the filetype of the audio file isn't supported
	 * @exception IOException - if the disk read to the audio file fails
	 * @exception LineUnavailableException - if the requested line is in use
	 */
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
	
	/**
	 * Play trash sound effect.
	 * @exception UnsupportedAudioFileException - if the filetype of the audio file isn't supported
	 * @exception IOException - if the disk read to the audio file fails
	 * @exception LineUnavailableException - if the requested line is in use
	 */
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
	
	/**
	 * Play background music.
	 * @exception UnsupportedAudioFileException - if the filetype of the audio file isn't supported
	 * @exception IOException - if the disk read to the audio file fails
	 * @exception LineUnavailableException - if the requested line is in use
	 */
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
	
	/**
	 * Play shears sound effect.
	 * @exception UnsupportedAudioFileException - if the filetype of the audio file isn't supported
	 * @exception IOException - if the disk read to the audio file fails
	 * @exception LineUnavailableException - if the requested line is in use
	 */
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
	
	/**
	 * Play intro music.
	 * @exception UnsupportedAudioFileException - if the filetype of the audio file isn't supported
	 * @exception IOException - if the disk read to the audio file fails
	 * @exception LineUnavailableException - if the requested line is in use
	 */
	public static void playIntro(){
		if(sound){
			String soundName = "./sounds/AESTUS.wav";     
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
	
	/**
	 * Gets the sound.
	 *
	 * @return the sound
	 */
	public static boolean getSound() {
		return sound;
	}

}
