package logic;

import java.util.ArrayList;
import java.util.List;

public class Events {
	
	private ArrayList<TypingScene> list;
	private ArrayList<Integer> randEventOrder = new ArrayList<>();
	
	// creates a random new game's event order
	public List<TypingScene> getEventsArrayList(GameManager gameManager){
		ArrayList<TypingScene> randList;
		ArrayList<TypingScene> mainList;
//		list = new ArrayList<TypingScene>();
		list = new ArrayList<>();
		
		RandomEvents randEvents = new RandomEvents();
		MainEvents mainEvents = new MainEvents();
		
		randEvents.initRandomEvents(gameManager);
		mainEvents.initMainEvents(gameManager);
		
		randList = (ArrayList<TypingScene>) randEvents.getRandomEventsArrayList();
		mainList = (ArrayList<TypingScene>)mainEvents.getMainEventsArrayList();
		
		for (int i = 0; i < mainList.size(); i++) {
			randEventOrder.add(randEvents.nonRepeatRandNum());
		}
		
		for(int i = 0; i < mainList.size(); i++) {
			list.add(mainList.get(i));
			if(i != mainList.size() - 1)
			{
				list.add(randList.get(randEventOrder.get(i)));
			}
		}
		
		
		return list;
	}
	
	// returns the saved random order generated when first creating the new game
	public List<Integer> getRandEventOrder(){
		return randEventOrder;
	}
	
	// loads the event order using an existing order
	public List<TypingScene> loadEventsArrayList(GameManager gameManager, List<Integer> randEventOrd){
		ArrayList<TypingScene> randList;
		ArrayList<TypingScene> mainList;
//		list = new ArrayList<TypingScene>();
		list = new ArrayList<>();
		
		RandomEvents randEvents = new RandomEvents();
		MainEvents mainEvents = new MainEvents();
		
		randEvents.initRandomEvents(gameManager);
		mainEvents.initMainEvents(gameManager);
		
		randList = (ArrayList<TypingScene>) randEvents.getRandomEventsArrayList();
		mainList = (ArrayList<TypingScene>) mainEvents.getMainEventsArrayList();
		
		for(int i = 0; i < mainList.size(); i++) {
			list.add(mainList.get(i));
			list.add(randList.get(randEventOrd.get(i)));
		}
		
		return list;
	}
}
