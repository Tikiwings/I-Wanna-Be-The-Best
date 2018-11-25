package application;

import java.util.ArrayList;
import java.util.List;

public class Events {
	
	private ArrayList<TypingScene> list;
	private ArrayList<Integer> randEventOrder = new ArrayList<>();
	
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
		
		for (int i = 0; i < mainList.size(); i++) {
			randEventOrder.add(randEvents.NonRepeatRandNum());
		}
		
		for(int i = 0; i < mainList.size(); i++) {
			list.add(mainList.get(i));
			list.add(randList.get(randEventOrder.get(i)));
		}
		
		return list;
	}
	
	public List<Integer> getRandEventOrder(){
		return randEventOrder;
	}
	
	public ArrayList<TypingScene> LoadEventsArrayList(GameManager GameManager, List<Integer> randEventOrd){
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
			list.add(randList.get(randEventOrd.get(i)));
		}
		
		return list;
	}
}
