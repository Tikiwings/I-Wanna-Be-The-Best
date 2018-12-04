// Written by Daniel Tseng (unit test for integration test 2)

package test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.TypingScene;

public class TestTypingSceneSetOptionNum {

	@Test
	public void testSetOptionNum() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		// Initialize TypingScene
		TypingScene typingScene = new TypingScene(gameManager);
		
		int optionNum = 3;
		typingScene.setOptionsNum(optionNum);
		
		assertEquals(optionNum, typingScene.totalOptionsNum);
	}

}
