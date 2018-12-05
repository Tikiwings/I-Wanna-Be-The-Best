// Written by John Luu (unit test)

package test.unit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import logic.Load;
import logic.Player;

public class TestLoadFile {

	static final String TESTSAVEPATH = "/src/test/unit/resources/testSave.txt";
	@Test
	public void testLoadFileClass() {
		// Initialize Loader
		Load loader = new Load();
		
		String filePath = new File("").getAbsolutePath();
		filePath += TESTSAVEPATH;
		
		loader.loadSaveFile(filePath);
		
		assertEquals("Coding Wizard", loader.getPlayer().getCurClass());
	}
	
	@Test
	public void testLoadFileStats() {
		// Initialize Loader
		Load loader = new Load();
		
		String filePath = new File("").getAbsolutePath();
		filePath += TESTSAVEPATH;
		
		loader.loadSaveFile(filePath);
		
		Player player = new Player("Coding Wizard");
		
		assertEquals(player.getHP(), loader.getPlayer().getHP());
		assertEquals(player.getMP(), loader.getPlayer().getMP());
		assertEquals(player.getChar(), loader.getPlayer().getChar());
		assertEquals(player.getInt(), loader.getPlayer().getInt());
	}
	
	@Test
	public void testLoadFileIndex() {
		// Initialize Loader
		Load loader = new Load();
		
		String filePath = new File("").getAbsolutePath();
		filePath += TESTSAVEPATH;
		
		loader.loadSaveFile(filePath);
		
		assertEquals(Integer.valueOf(0), loader.getIndex());
	}
	
	@Test
	public void testLoadFileOrder() {
		// Initialize Loader
		Load loader = new Load();
		
		String filePath = new File("").getAbsolutePath();
		filePath += TESTSAVEPATH;
		
		loader.loadSaveFile(filePath);
		
		ArrayList<Integer> randEventOrder = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			randEventOrder.add(i);
		}
		
		assertEquals(randEventOrder, loader.getRandOrderList());
	}
}
