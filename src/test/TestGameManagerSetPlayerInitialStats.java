package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Player;
import logic.GameManager;

public class TestGameManagerSetPlayerInitialStats {

	@Test
	public void testSetPlayerInitialStats_HP() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats("Coding Wizard");
		
		// Get player
		Player player = gameManager.player;
		
		assertEquals(Integer.valueOf(100), player.getHP());
    }
	
	@Test
	public void testSetPlayerInitialStats_MP() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats("Coding Wizard");
		
		// Get player
		Player player = gameManager.player;

		assertEquals(Integer.valueOf(100), player.getMP());
    }
	
	@Test
	public void testSetPlayerInitialStats_Int() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats("Coding Wizard");
		
		// Get player
		Player player = gameManager.player;
		
		assertEquals(Integer.valueOf(5), player.getInt());
    }
	
	@Test
	public void testSetPlayerInitialStats_Char() {
    	// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		gameManager.setPlayerInitialStats("Coding Wizard");
		
		// Get player
		Player player = gameManager.player;
		
		assertEquals(Integer.valueOf(1), player.getChar());
    }

}
