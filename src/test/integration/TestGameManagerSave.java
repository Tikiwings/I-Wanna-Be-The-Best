// Written by John Luu (integration test)

package test.integration;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import logic.GameManager;
import test.integration.resources.FileSameChecker;

public class TestGameManagerSave {

	@Test
	public void testSaveCurrentPlayer() {
		// Initialize GameManager
		GameManager gameManager = new GameManager(null);
		
		gameManager.setPlayerInitialStats("Coding Wizard");

		ArrayList<Integer> randEventOrder = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			randEventOrder.add(i);
		}
		
		String filePath = new File("").getAbsolutePath();
		filePath += "/src/test/integration/resources/test";
		
		String filePath1 = new File("").getAbsolutePath();
		filePath1 += "/src/test/integration/resources/test.txt";
		
		String filePath2 = new File("").getAbsolutePath();
		filePath2 += "/src/test/integration/resources/testSave.txt";
	
		gameManager.saveFile(filePath, randEventOrder);
		
		boolean areEqual = FileSameChecker.checkIfSameFile(filePath1, filePath2);

		assertEquals(true, areEqual);
	}
}
