package test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import logic.GameManager;
import logic.MainEvents;

public class TestTypingSceneAttributes {

	@Test
	public void testSound() {
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("YeaPoly.mp3",main.getMainEventsArrayList().get(0).setSound("YeaPoly.mp3"));
	}
	@Test
	public void testPause() {
		String[] strArray = {"hello"};
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("hello",main.getMainEventsArrayList().get(0).setStrArray(strArray)[0]);
	}
}
