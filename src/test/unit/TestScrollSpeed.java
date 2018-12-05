// written by Thinh Luu (unit test)
package test.unit;

import static org.junit.Assert.*;
import logic.GameManager;

import org.junit.Test;

public class TestScrollSpeed {

	@Test
	public void testScrollSpeedd() {
		GameManager gm = new GameManager(null);
		double scrollSpeed = gm.getScrollSpeed();
		
		assertEquals(1.0, scrollSpeed, .1); 
	}
	
	@Test
	public void testSetScrollSpeedd() {
		GameManager gm = new GameManager(null);
		gm.setGameSettings(1, 1, 100);
		double scrollSpeed = gm.getScrollSpeed();
		
		assertEquals(100.0, scrollSpeed, .1); 
	}

}
