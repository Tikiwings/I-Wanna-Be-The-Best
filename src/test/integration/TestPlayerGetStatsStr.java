// Written by Chanye Jung (integration test)

package test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.GameManager;
import logic.Player;

public class TestPlayerGetStatsStr {

	@Test
	public void testGetPlayerStatsStr() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		gameManager.setPlayerInitialStats("Coding Wizard");
		
		Player player = new Player("Coding Wizard");
		
		assertEquals(player.getStatStr(), gameManager.getPlayer().getStatStr());
	}
}
