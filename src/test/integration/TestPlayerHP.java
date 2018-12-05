package test.integration;

import static org.junit.Assert.*;
import logic.Player;

import org.junit.Test;

public class TestPlayerHP {

	@Test
	public void testHP() {
		Player bro = new Player("Brogrammer");
		Player athlete = new Player("Athlete");
		
		Integer difference = bro.getHP() - athlete.getHP();
		
		assertEquals(Integer.valueOf(0), difference);
	}

}
