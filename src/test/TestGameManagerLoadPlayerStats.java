// Written by Daniel Tseng

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.Player;

public class TestGameManagerLoadPlayerStats {

	@Test
	public void testLoadPlayerStats_HP() {
		// Initialize player
		Player player = new Player("Coding Wizard");
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.player;
		
		assertEquals(Integer.valueOf(100), thisPlayer.getHP());
	}
	
	@Test
	public void testLoadPlayerStats_MP() {
		// Initialize player
		Player player = new Player("Coding Wizard");
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.player;
		
		assertEquals(Integer.valueOf(100), thisPlayer.getMP());
	}
	
	@Test
	public void testLoadPlayerStats_Int() {
		// Initialize player
		Player player = new Player("Coding Wizard");
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.player;
		
		assertEquals(Integer.valueOf(5), thisPlayer.getInt());
	}
	
	@Test
	public void testLoadPlayerStats_Char() {
		// Initialize player
		Player player = new Player("Coding Wizard");
		
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.loadPlayerStats(player);
		
		// Get player
		Player thisPlayer = gameManager.player;
		
		assertEquals(Integer.valueOf(1), thisPlayer.getChar());
	}

}
