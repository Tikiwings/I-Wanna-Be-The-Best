// Written by Daniel Tseng (integration test 2)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.Stats;
import logic.TypingScene;

public class TestTypingSceneSetOptions {

	@Test
	public void testSetOptions_OptionNum() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = "option1 title";
		String option2Title = "option2 title";
		String option3Title = "option3 title";
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals(optionNum, typingScene.totalOptionsNum);
	}

	@Test
	public void testSetOptions_Option1() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = "option1 title";
		String option2Title = "option2 title";
		String option3Title = "option3 title";
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("1. " + option1Title, typingScene.option1Title);
	}
	
	@Test
	public void testSetOptions_Option2() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = "option1 title";
		String option2Title = "option2 title";
		String option3Title = "option3 title";
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("2. " + option2Title, typingScene.option2Title);
	}
	
	@Test
	public void testSetOptions_Option3() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = "option1 title";
		String option2Title = "option2 title";
		String option3Title = "option3 title";
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("3. " + option3Title, typingScene.option3Title);
	}
}
