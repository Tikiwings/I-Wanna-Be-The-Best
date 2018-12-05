// Written by Daniel Tseng (integration test 2)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.Stats;
import logic.TypingScene;

public class TestTypingSceneSetOptions {

	final static String optionOneStr = "option1 title";
	final static String optionTwoStr = "option2 title";
	final static String optionThreeStr = "option3 title";
	@Test
	public void testSetOptionsOptionNum() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = optionOneStr;
		String option2Title = optionTwoStr;
		String option3Title = optionThreeStr;
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals(optionNum, typingScene.getOptionNum());
	}

	@Test
	public void testSetOptionsOption1() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = optionOneStr;
		String option2Title = optionTwoStr;
		String option3Title = optionThreeStr;
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("1. " + option1Title, typingScene.getOptionTitleOne());
	}
	
	@Test
	public void testSetOptionsOption2() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = optionOneStr;
		String option2Title = optionTwoStr;
		String option3Title = optionThreeStr;
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("2. " + option2Title, typingScene.getOptionTitleTwo());
	}
	
	@Test
	public void testSetOptionsOption3() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		Stats stats = new Stats(0, 0, 0, 0);
		String option1Title = optionOneStr;
		String option2Title = optionTwoStr;
		String option3Title = optionThreeStr;
		
		typingScene.setOptions(optionNum, 
				option1Title, stats, 
				option2Title, stats, 
				option3Title, stats);
		
		assertEquals("3. " + option3Title, typingScene.getOptionTitleThree());
	}
}
