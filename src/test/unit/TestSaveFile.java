// Written by John Luu (unit test)

package test.unit;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import logic.Player;
import logic.Save;
import test.integration.resources.FileSameChecker;

public class TestSaveFile {

	@Test
	public void testSaveFile() {
		// Initialize player
		Player player = new Player("Coding Wizard");
		
		ArrayList<Integer> randEventOrder = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			randEventOrder.add(i);
		}
		
		String filePath = new File("").getAbsolutePath();
		filePath += "/src/test/unit/resources/test";
		
		String filePath1 = new File("").getAbsolutePath();
		filePath1 += "/src/test/unit/resources/test.txt";
		
		String filePath2 = new File("").getAbsolutePath();
		filePath2 += "/src/test/unit/resources/testSave.txt";
		
		// Save
		Save.saveProgress(player, randEventOrder, 0, filePath);
		
		boolean areEqual = FileSameChecker.checkIfSameFile(filePath1, filePath2);

		assertEquals(true, areEqual);
	}
	
	

}
