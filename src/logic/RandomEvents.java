package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomEvents {
	
	private ArrayList<TypingScene> list;
	private ArrayList<Integer> randomList = new ArrayList<Integer>();

	public void initRandomEvents(GameManager GameManager){
		Scanner lineScan;
		list = new ArrayList <TypingScene>();
		try {
			lineScan = new Scanner(new File(System.getProperty("user.dir") + "/src/resources/events/RandomEvents.txt"));
			lineScan.useDelimiter("\n");
			Scanner wordScan;
			int numTexts,numButtons;
			String[] strArray;
			TypingScene typeSc;
			while(lineScan.hasNext()) {
				typeSc = new TypingScene(GameManager);
				wordScan = new Scanner(lineScan.next());
				wordScan.useDelimiter(";");
				
				numTexts = wordScan.nextInt();

				strArray = new String[numTexts];
				for(int i = 0; i < numTexts; i++) {
					strArray[i] = wordScan.next();
				}
				typeSc.setStrArray(strArray);
				
				numButtons = wordScan.nextInt();

				typeSc.setOptionsNum(numButtons);
				if(numButtons > 0) {
					typeSc.setOption1(wordScan.next(), 
							new Stats(wordScan.nextInt(), wordScan.nextInt(),
							wordScan.nextInt(), wordScan.nextInt()));
				}
				if(numButtons > 1) {
					typeSc.setOption2(wordScan.next(), 
							new Stats(wordScan.nextInt(), wordScan.nextInt(),
							wordScan.nextInt(), wordScan.nextInt()));
				}
				if(numButtons > 2) {
					typeSc.setOption3(wordScan.next(), 
							new Stats(wordScan.nextInt(), wordScan.nextInt(),
							wordScan.nextInt(), wordScan.nextInt()));
				}
				typeSc.setSound(wordScan.next());
				list.add(typeSc);
				wordScan.close();
			}
			lineScan.close();
		}
		catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}
	
	public ArrayList<TypingScene> getRandomEventsArrayList(){
		return list;
	}
	
	public int NonRepeatRandNum() {
		int randNum;
		int attempts = 0;
		Random rand = new Random();
		randNum = rand.nextInt(list.size());
		while(randomList.contains(randNum)) {
			randNum = rand.nextInt(list.size());
			attempts++;
			if(attempts == list.size()) {
				randomList.clear();
			}
		}
		randomList.add(randNum);
		return randNum;
	}
}
