// Written by Daniel Tseng (unit test for integration test 1)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;

public class TestGameManagerSetScrollSpeed {

	@Test
	public void testSetScrollSpeed() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		double scrollSpeed = 1.5;
		gameManager.setScrollSpeed(scrollSpeed);
		
		assertEquals(scrollSpeed, gameManager.getScrollSpeed(), 0.01);
	}

}
