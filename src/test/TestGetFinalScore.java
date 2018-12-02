//Written by Donald Sanchez
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Player;
import logic.GameManager;
import logic.EndingScreen;

public class TestGetFinalScore {
	
	@Test
	public void testGetFinalScore() throws Exception
	{
		
		GameManager testingGame = new GameManager(null);
		Player testingPlayer = new Player("Brogrammer");
		testingPlayer.setChar(10);
		testingPlayer.setInt(19);
		testingGame.loadPlayerStats(testingPlayer);
		
		EndingScreen endScreen = new EndingScreen(testingGame);
		
		Double [] finalGrades = endScreen.getFinalScore(testingGame);
		assertEquals(finalGrades[0], 19.0/20.0*100.0, .01);
		assertEquals(finalGrades[1], 10.0/20.0*100.0, .01);
		
		
	}
}
