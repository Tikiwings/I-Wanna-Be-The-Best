// written by Thinh Luu
package test.integration;

import static org.junit.Assert.*;
import logic.Player;

import org.junit.Test;

public class TestPlayerIntelligence {

	@Test
	public void testIntelligence() {
		Player bro = new Player("Brogrammer");
		Player athlete = new Player("Athlete");
		
		Integer difference = bro.getInt() - athlete.getInt();
		
		assertEquals(Integer.valueOf(1), difference);
	}

}
