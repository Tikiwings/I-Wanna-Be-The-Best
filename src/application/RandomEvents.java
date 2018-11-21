package application;

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
			lineScan = new Scanner(new File("RandomEvents.txt"));
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
				//System.out.println(numTexts);
				strArray = new String[numTexts];
				for(int i = 0; i < numTexts; i++) {
					strArray[i] = wordScan.next();
					//System.out.println(strArray[i]);
				}
				typeSc.setStrArray(strArray);
				
				numButtons = wordScan.nextInt();
				//System.out.println(numButtons);
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
		int listSize = list.size();
		int randNum;
		Random rand = new Random();
		if(listSize == list.size()) {
			randomList.clear();
		}
		randNum = rand.nextInt(listSize);
		while(randomList.contains(randNum)) {
			randNum = rand.nextInt(listSize);
		}
		randomList.add(randNum);
		return randNum;
	}
}
