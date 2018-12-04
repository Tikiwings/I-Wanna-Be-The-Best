// Written by John Luu (integration test)

package test.integration;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

import logic.GameManager;

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
		
		boolean areEqual = true;
		
		try {
			System.out.println(filePath1);
			BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
	        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
	        
	        String line1 = reader1.readLine();
	        String line2 = reader2.readLine();

	        while (line1 != null || line2 != null)
	        {
	            if (line1 == null || line2 == null)
	            {
	                areEqual = false;   
	                break;
	            }
	            else if (!line1.equalsIgnoreCase(line2))
	            {
	                areEqual = false;
	                break;
	            }
	            line1 = reader1.readLine();
	            line2 = reader2.readLine();
	        }
	        reader1.close();
	        reader2.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(true, areEqual);
	}
}
