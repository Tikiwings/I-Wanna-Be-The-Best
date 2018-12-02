//Written by Donald Sanchez
package test;

import static org.junit.Assert.*;

import javafx.scene.text.Text;


import org.junit.Test;

import logic.GameManager;
import logic.EndingScreen;


public class TestGetFinalGrade {
	
	@Test
	public void testGetFinalGrade() throws Exception
	{
		Double aGrade = 95.2;
		Double bGrade = 89.9;
		Double cGrade = 70.0;
		Double dGrade = 69.9;
		Double fGrade = 54.1;
		
		GameManager testingGame = new GameManager(null);
		EndingScreen testEndScreen = new EndingScreen(testingGame);
		
		
		Text resultA = testEndScreen.getFinalGrade(aGrade);
		Text resultB = testEndScreen.getFinalGrade(bGrade);
		Text resultC = testEndScreen.getFinalGrade(cGrade);
		Text resultD = testEndScreen.getFinalGrade(dGrade);
		Text resultF = testEndScreen.getFinalGrade(fGrade);
		
		assertEquals("A", resultA.getText());
		assertEquals("B", resultB.getText());
		assertEquals("C", resultC.getText());
		assertEquals("D", resultD.getText());
		assertEquals("F", resultF.getText());
		
		
	}
}
