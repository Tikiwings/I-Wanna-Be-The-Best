//Written by Donald Sanchez
package test;

import static org.junit.Assert.*;

import javafx.scene.text.Text;


import org.junit.Test;

import logic.GameManager;
import logic.EndingScreen;
import logic.Player;


public class TestIntegrationGetFinalScoreToGetFinalGrade {

	@Test
	public void testIntegration()
	{
		GameManager testingGame = new GameManager(null);
		Player testingPlayer = new Player("Brogrammer");
		testingPlayer.setChar(11);
		testingPlayer.setInt(15);
		testingGame.loadPlayerStats(testingPlayer);
		
		EndingScreen endScreen = new EndingScreen(testingGame);
		
		Double [] finalGrades = endScreen.getFinalScore(testingGame);
		
		Text eduScore = endScreen.getFinalGrade(finalGrades[0]);
		Text socScore = endScreen.getFinalGrade(finalGrades[1]);
		
		assertEquals("C", eduScore.getText());
		assertEquals("F", socScore.getText());
		
		
	}
}
