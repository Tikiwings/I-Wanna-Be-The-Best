// testing
package test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import logic.Events;
import logic.GameManager;
import logic.MainEvents;
import logic.RandomEvents;

public class TestEvents {

	@Test
	public void testRandomEvents() {
		GameManager gm = new GameManager(null);
		RandomEvents rand = new RandomEvents();
		rand.initRandomEvents(gm);
		assertEquals("catcall.mp3",rand.getRandomEventsArrayList().get(0).getSound());
	}
	@Test
	public void testMainEvents() {
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gm);
		assertEquals("YeaPoly.mp3",main.getMainEventsArrayList().get(0).getSound());
	}
	@Test
	public void testEvents() {
		GameManager gm = new GameManager(null);
		Events eve = new Events();
		assertEquals("YeaPoly.mp3",eve.getEventsArrayList(gm).get(0).getSound());
	}
}
