package controller;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Steven Sell
 * @Test Tests all functions of SoundController
 */

public class SoundControllerTest {

	static SoundController SC;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SC = new SoundController();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SC = null;
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the ToggleSound function
	 */
	@Test
	public void toggleSoundTest() {
		if(!SoundController.getSound()) SoundController.toggleSound();
		SoundController.toggleSound();
		assertFalse("Sound should be false",SoundController.getSound());
		SoundController.toggleSound();
		assertTrue("Sound should be true",SoundController.getSound());
		
	}
	
	/**
	 * @author Steven
	 * @Tests Tests the Sounds of SoundController
	 */
	@Test
	public void soundsTest() {
		if(!SoundController.getSound()) SoundController.toggleSound();
		SoundController.playIntro();
		SoundController.playBackground();
		SoundController.playShears();
		SoundController.playTrap();
		SoundController.playTrash();
	}

}
