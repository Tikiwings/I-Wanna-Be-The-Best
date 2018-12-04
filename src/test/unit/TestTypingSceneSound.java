package test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.GameManager;
import logic.MainEvents;

class TestTypingSceneAttributes {

	@Test
	void testSound() {
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("YeaPoly.mp3",main.getMainEventsArrayList().get(0).setSound("YeaPoly.mp3"));
	}
	@Test
	void testPause() {
		String[] strArray = {"hello"};
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("hello",main.getMainEventsArrayList().get(0).setStrArray(strArray)[0]);
	}
}
