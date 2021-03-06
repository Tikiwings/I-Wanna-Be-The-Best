package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Load {
	
	// fields that hold the parsed save file information
	private Player loadedPlayer;
	private Integer curIndex;
	private List<Integer> randOrderList;
	
	
	
	// loads a save file for the game
	public void loadSaveFile(String filepath){
		Scanner lineScan;
		String playerClass = null;
		Integer intel = null;
		Integer charis = null; 
		Integer hp = null;
		Integer mp = null;
		Integer score = null;
		randOrderList = new ArrayList<>();
		
		try {
			lineScan = new Scanner(new File(filepath));
			int lineCounter = 0;
			
			// parses the file
			while(lineScan.hasNextLine()) {
				if (lineCounter == 0) {
					playerClass = lineScan.nextLine().replace("\n", "");
				}
				else if (lineCounter == 1) {
					intel = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else if (lineCounter == 2) {
					charis = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else if (lineCounter == 3) {
					hp = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else if (lineCounter == 4) {
					mp = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else if (lineCounter == 5) {
					score = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else if (lineCounter == 6) {
					curIndex = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
				}
				else {
					Integer curInt = Integer.parseInt(lineScan.nextLine().replace("\n", ""));
					randOrderList.add(curInt);
				}
				lineCounter++;
			}
			
			lineScan.close();
			
			// creates the new player from the loaded file
			Stats loadedStats = new Stats(hp, mp, intel, charis);
			loadedPlayer = new Player(playerClass, loadedStats, score);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Player getPlayer() {
		return loadedPlayer;
	}
	
	public Integer getIndex() {
		return curIndex;
	}
	
	public List<Integer> getRandOrderList() {
		return randOrderList;
	}
}

