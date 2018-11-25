package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Load {
	private Player loadedPlayer;
	private Integer curIndex;
	private List<Integer> randOrderList;
	
	public void loadSaveFile(String filepath){
		Scanner lineScan;
		String playerClass = null;
		Integer intel = null, charis = null, hp = null, mp = null, score = null;
		randOrderList = new ArrayList<>();
		
		try {
			lineScan = new Scanner(new File(filepath));
			System.out.println(filepath);
			//lineScan.useDelimiter("\n");
			int lineCounter = 0;
			while(lineScan.hasNext()) {
				System.out.println(lineCounter);
				if (lineCounter == 0) {
					playerClass = lineScan.next().replace("\n", "");
				}
				else if (lineCounter == 1) {
					intel = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else if (lineCounter == 2) {
					charis = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else if (lineCounter == 3) {
					hp = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else if (lineCounter == 4) {
					mp = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else if (lineCounter == 5) {
					score = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else if (lineCounter == 6) {
					curIndex = Integer.parseInt(lineScan.next().replace("\n", ""));
				}
				else {
					Integer curInt = Integer.parseInt(lineScan.next().replace("\n", ""));
					randOrderList.add(curInt);
				}
				lineCounter++;
			}
			lineScan.close();
			
			if (playerClass == null || 
					intel == null ||
					charis == null ||
					hp == null ||
					mp == null ||
					score == null) {
				System.err.println(playerClass);
				System.err.println(intel);
				System.err.println(charis);
				System.err.println(hp);
				System.err.println(mp);
				System.err.println(score);
				System.err.println("Missing a field in loaded file");
			}
			
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

