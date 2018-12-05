// Written by Daniel Tseng (unit test)

package test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Player;
import logic.GameManager;

public class TestGameManagerSetPlayerInitialStats {
	
	static final String CODEWIZARD = "Coding Wizard";

	@Test
	public void testSetPlayerInitialStatsHP() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats(CODEWIZARD);
		
		// Get player
		Player player = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(100), player.getHP());
    }
	
	@Test
	public void testSetPlayerInitialStatsMP() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats(CODEWIZARD);
		
		// Get player
		Player player = gameManager.getPlayer();

		assertEquals(Integer.valueOf(100), player.getMP());
    }
	
	@Test
	public void testSetPlayerInitialStatsInt() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats(CODEWIZARD);
		
		// Get player
		Player player = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(5), player.getInt());
    }
	
	@Test
	public void testSetPlayerInitialStatsChar() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats(CODEWIZARD);
		
		// Get player
		Player player = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(1), player.getChar());
    }

}
