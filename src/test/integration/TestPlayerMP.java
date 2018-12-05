// written by Donald Sanchez (integration test)
package test.integration;

import static org.junit.Assert.*;
import logic.Player;

import org.junit.Test;

public class TestPlayerMP {

	@Test
	public void testPlayerMP() {
		Player wiz = new Player("Coding Wizard");
		Player monkey = new Player("Coding Monkey");
		
		Integer difference = wiz.getHP() - monkey.getHP();
		
		assertEquals(Integer.valueOf(0), difference);
	}

}
