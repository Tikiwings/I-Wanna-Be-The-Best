// Written by Daniel Tseng (unit test for integration test 2)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.Stats;
import logic.TypingScene;

public class TestTypingSceneSetOption123 {

	@Test
	public void testSetOption1() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		String option1Title = "option1 title";
		typingScene.setOption1(option1Title, new Stats(0, 0, 0, 0));
		
		assertEquals("1. " + option1Title, typingScene.getOptionTitleOne());
	}
	
	@Test
	public void testSetOption2() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		String option2Title = "option2 title";
		typingScene.setOption2(option2Title, new Stats(0, 0, 0, 0));
		
		assertEquals("2. " + option2Title, typingScene.getOptionTitleTwo());
	}
	
	@Test
	public void testSetOption3() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		String option3Title = "option3 title";
		typingScene.setOption3(option3Title, new Stats(0, 0, 0, 0));
		
		assertEquals("3. " + option3Title, typingScene.getOptionTitleThree());
	}

}
