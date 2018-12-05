// Written by Chanye Jung (integration test)

package test.integration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import logic.Events;
import logic.GameManager;
import logic.MainEvents;
import logic.RandomEvents;
import logic.TypingScene;

public class TestEventListGenerator {

	@Test
	public void testEventsGenerator() {
		GameManager gameManager = new GameManager(null);
		
		ArrayList<TypingScene> randList;
		RandomEvents randEvents = new RandomEvents();
		randEvents.initRandomEvents(gameManager);
		randList = (ArrayList<TypingScene>) randEvents.getRandomEventsArrayList();
		
		ArrayList<TypingScene> mainList;
		MainEvents mainEvents = new MainEvents();
		mainEvents.initMainEvents(gameManager);
		mainList = (ArrayList<TypingScene>) mainEvents.getMainEventsArrayList();
		
		ArrayList<TypingScene> list = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		
		for(int i = 0; i < mainList.size(); i++) {
			intList.add(i);
		}
		
		for(int i = 0; i < mainList.size(); i++) {
			list.add(mainList.get(i));
			list.add(randList.get(intList.get(i)));
		}
	 
		Events events = new Events();
		ArrayList<TypingScene> generateList = (ArrayList<TypingScene>) events.loadEventsArrayList(gameManager, intList);
		
		assertEquals(list.size(), generateList.size());
	}
}
