// Written by Daniel Tseng (unit test)

package test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.Player;

public class TestGameManagerLoadPlayerStats {

	final static String codeWizard = "Coding Wizard";
	
	@Test
	public void testLoadPlayerStatsHP() {
		// Initialize player
		Player player = new Player(codeWizard);
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(100), thisPlayer.getHP());
	}
	
	@Test
	public void testLoadPlayerStatsMP() {
		// Initialize player
		Player player = new Player(codeWizard);
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(100), thisPlayer.getMP());
	}
	
	@Test
	public void testLoadPlayerStatsInt() {
		// Initialize player
		Player player = new Player(codeWizard);
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(5), thisPlayer.getInt());
	}
	
	@Test
	public void testLoadPlayerStatsChar() {
		// Initialize player
		Player player = new Player(codeWizard);
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.getPlayer();
		
		assertEquals(Integer.valueOf(1), thisPlayer.getChar());
	}

}
