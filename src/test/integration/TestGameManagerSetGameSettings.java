// Written by Daniel Tseng (integration test 1)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;

public class TestGameManagerSetGameSettings {

	@Test
	public void testSetGameSettingsWidth() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		int screenWidth = 150;
		int screenHeight = 100;
		double scrollSpeed = 1.5;
		gameManager.setGameSettings(screenWidth, screenHeight, scrollSpeed);
		
		assertEquals(screenWidth, gameManager.getScreenWidth());
	}
	
	@Test
	public void testSetGameSettingsHeight() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		int screenWidth = 150;
		int screenHeight = 100;
		double scrollSpeed = 1.5;
		gameManager.setGameSettings(screenWidth, screenHeight, scrollSpeed);
		
		assertEquals(screenHeight, gameManager.getScreenHeight());
	}
	
	@Test
	public void testSetGameSettingsScrollSpeed() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		int screenWidth = 150;
		int screenHeight = 100;
		double scrollSpeed = 1.5;
		gameManager.setGameSettings(screenWidth, screenHeight, scrollSpeed);
		
		assertEquals(scrollSpeed, gameManager.getScrollSpeed(), 0.01);
	}

}
