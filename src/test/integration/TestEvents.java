// Zachary Barram
package test.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

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
		try {
			rand.initRandomEvents(gm,"RandomEvents.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("catcall.mp3",rand.getRandomEventsArrayList().get(0).getSound());
	}
	@Test
	public void testMainEvents() {
		GameManager gm = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initEvents(gm, "MainEvents.txt");
		assertEquals("YeaPoly.mp3",main.getMainEventsArrayList().get(0).getSound());
	}
	@Test
	public void testEvents() {
		GameManager gm = new GameManager(null);
		Events eve = new Events();
		assertEquals("YeaPoly.mp3",eve.getEventsArrayList(gm).get(0).getSound());
	}
}
