// written by Thinh Luu (unit tests)
package test.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import logic.GameManager;

public class TestingScreenSize {

	@Test
	public void testScreenWidth() {
		GameManager gm = new GameManager(null);
		int screenWidth = gm.getScreenWidth();
		
		assertEquals(640, screenWidth);

	}
	
	@Test
	public void testScreenSetting() {
		GameManager gm = new GameManager(null);
		gm.setGameSettings(1, 1, 1);
		
		int screenHeight = gm.getScreenHeight();
		
		assertEquals(1, screenHeight);
	}
}
