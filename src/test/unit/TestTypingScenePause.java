// Zachary Barram
package test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import logic.GameManager;
import logic.MainEvents;

public class TestTypingScenePause{

	@Test
	public void testPause() {
		String[] strArray = {"hello"};
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("hello",main.getMainEventsArrayList().get(0).setStrArray(strArray)[0]);
	}
}
