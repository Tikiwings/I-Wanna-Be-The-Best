package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEvents {
	
	private ArrayList<TypingScene> list;

	public List<TypingScene> getMainEventsArrayList(){
		return list;
	}
	
	public void initMainEvents(GameManager gameManager){
		Scanner lineScan;
//		list = new ArrayList<TypingScene>();
		list = new ArrayList<>();
		try {
			lineScan = new Scanner(new File(System.getProperty("user.dir") + "/src/resources/events/MainEvents.txt"));
			lineScan.useDelimiter("\n");
			Scanner wordScan;
			int numTexts;
			int numButtons;
			String[] strArray;
			TypingScene typeSc;
			while(lineScan.hasNext()) {
				typeSc = new TypingScene(gameManager);
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
}
