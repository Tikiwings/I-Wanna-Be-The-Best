package application;

import java.util.ArrayList;
import java.util.List;

public class Events {
	
	private ArrayList<TypingScene> list;
	private ArrayList<Integer> randEventOrder = new ArrayList<>();
	
	// creates a random new game's event order
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
			if(i != mainList.size() - 1)
			{
				list.add(randList.get(randEventOrder.get(i)));
			}
		}
		
		//list.add(endEvent);
		
		return list;
	}
	
	// returns the saved random order generated when first creating the new game
	public List<Integer> getRandEventOrder(){
		return randEventOrder;
	}
	
	// loads the event order using an existing order
	public ArrayList<TypingScene> loadEventsArrayList(GameManager GameManager, List<Integer> randEventOrd){
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
