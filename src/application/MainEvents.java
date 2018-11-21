package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainEvents {
	
	private ArrayList<TypingScene> list;
	
//	public void initMainEvents(GameManager GameManager){
//		Scanner lineScan;
//		list = new ArrayList <TypingScene>();
//		try {
//			lineScan = new Scanner(new File("MainEvents.txt"));
//			Scanner wordScan;
//			int numTexts,numButtons;
//			String[] strArray;
//			TypingScene typeSc;
//			while(lineScan.hasNext()) {
//				typeSc = new TypingScene(GameManager);
//				wordScan = new Scanner(lineScan.next());
//				wordScan.useDelimiter(",");
//				
//				numTexts = wordScan.nextInt();
//				strArray = new String[numTexts];
//				for(int i = 0; i < numTexts; i++) {
//					strArray[i] = wordScan.next();
//				}
//				typeSc.setStrArray(strArray);
//				
//				numButtons = wordScan.nextInt();
//				typeSc.setOptionsNum(numButtons);
//				if(numButtons > 0) {
//					typeSc.setOption1(wordScan.next(), 
//							new Stats(wordScan.nextInt(), wordScan.nextInt(),
//							wordScan.nextInt(), wordScan.nextInt()));
//				}
//				if(numButtons > 1) {
//					typeSc.setOption2(wordScan.next(), 
//							new Stats(wordScan.nextInt(), wordScan.nextInt(),
//							wordScan.nextInt(), wordScan.nextInt()));
//				}
//				if(numButtons > 2) {
//					typeSc.setOption3(wordScan.next(), 
//							new Stats(wordScan.nextInt(), wordScan.nextInt(),
//							wordScan.nextInt(), wordScan.nextInt()));
//				}
//				list.add(typeSc);
//				wordScan.close();
//			}
//			lineScan.close();
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
	public ArrayList<TypingScene> getMainEventsArrayList(){
		return list;
	}
	
	public void initMainEvents(GameManager GameManager){
		Scanner lineScan;
		list = new ArrayList <TypingScene>();
		try {
			lineScan = new Scanner(new File("MainEvents.txt"));
			lineScan.useDelimiter("\n");
			Scanner wordScan;
			int numTexts,numButtons;
			String[] strArray;
			TypingScene typeSc;
			while(lineScan.hasNext()) {
				typeSc = new TypingScene(GameManager);
				wordScan = new Scanner(lineScan.next());
				wordScan.useDelimiter(",");
				
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
}
