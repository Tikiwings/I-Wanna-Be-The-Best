package test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.GameManager;
import logic.MainEvents;
import logic.Menu;

public class TestImageSettings {

	@Test
	public void testSettingInitialVolume() {
		String image = "test1.png";

		GameManager gameManager = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gameManager);

		String setImage = main.getMainEventsArrayList().get(0).setImage(image);

		assertEquals("test1.png", setImage);
	}

	@Test
	public void testSettingChangedVolume() {
		String image = "test2.png";

		GameManager gameManager = new GameManager(null);
		MainEvents main = new MainEvents();
		main.initMainEvents(gameManager);

		String setImage = main.getMainEventsArrayList().get(0).setImage(image);

		assertEquals("test2.png", setImage);
	}

}
