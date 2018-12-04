// Written by Daniel Tseng (unit test for integration test 1)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;

public class TestGameManagerSetScreenSize {

	@Test
	public void testSetScreenSize_Width() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		int screenWidth = 150;
		int screenHeight = 100;
		gameManager.setScreenSize(screenWidth, screenHeight);
		
		assertEquals(screenWidth, gameManager.getScreenWidth());
	}

	@Test
	public void testSetScreenSize_Height() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		int screenWidth = 150;
		int screenHeight = 100;
		gameManager.setScreenSize(screenWidth, screenHeight);
		
		assertEquals(screenHeight, gameManager.getScreenHeight());
	}
}
