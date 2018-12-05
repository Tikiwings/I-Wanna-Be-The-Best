// Written by: Chanye Jung

package test.unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import logic.GameManager;
import logic.MainEvents;
import logic.Menu;

public class TestVolumeSetting {

	@Test
	public void testSettingInitialVolume() {
		Menu menu = new Menu();
		int originalVolume = menu.getVolume();

		GameManager gameManager = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gameManager);

		int setVolume = main.getMainEventsArrayList().get(0).setVolumeTest(originalVolume);

		assertEquals(50, setVolume);
	}

	@Test
	public void testSettingChangedVolume() {
		Menu menu = new Menu();
		menu.setVolume(59);
		int originalVolume = menu.getVolume();

		GameManager gameManager = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gameManager);

		int setVolume = main.getMainEventsArrayList().get(0).setVolumeTest(originalVolume);

		assertEquals(59, setVolume);
	}

}
