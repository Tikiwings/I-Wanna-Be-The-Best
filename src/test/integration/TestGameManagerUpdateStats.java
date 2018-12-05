// Written by John Luu (integration test)

package test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.GameManager;
import logic.Player;
import logic.Stats;

public class TestGameManagerUpdateStats {

	@Test
	public void testUpdatePlayerStats() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		gameManager.setPlayerInitialStats("Coding Wizard");

		gameManager.updateStats(new Stats(0, 0, -2, 2));
		
		Player player = new Player();
		
		assertEquals(player.getStatStr(), gameManager.getPlayer().getStatStr());
	}
	
}
