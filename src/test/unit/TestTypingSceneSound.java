//Zachary Barram
package test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import logic.GameManager;
import logic.MainEvents;

public class TestTypingSceneSound {

	@Test
	public void testSound() {
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initEvents(gm,"MainEvents.txt");
		assertEquals("YeaPoly.mp3",main.getMainEventsArrayList().get(0).setSound("YeaPoly.mp3"));
	}

}
