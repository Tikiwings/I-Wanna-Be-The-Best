package application;

import java.util.ArrayList;

public class Events {
	
	private ArrayList<TypingScene> list;

	public ArrayList<TypingScene> getEventsArrayList(GameManager GameManager){
		ArrayList<TypingScene> randList;
		ArrayList<TypingScene> mainList;
		list = new ArrayList<TypingScene>();
		
		
		RandomEvents randEvents = new RandomEvents();
		MainEvents mainEvents = new MainEvents();
		
		randEvents.initRandomEvents(GameManager);
		mainEvents.initMainEvents(GameManager);
		
		randList = randEvents.getRandomEventsArrayList();
		mainList = mainEvents.getMainEventsArrayList();
		
		for(int i = 0; i < mainList.size(); i++) {
			list.add(mainList.get(i));
			list.add(randList.get(randEvents.NonRepeatRandNum()));
		}
		
		return list;
	}
}
