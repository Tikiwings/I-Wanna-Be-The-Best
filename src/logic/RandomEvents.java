package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEvents {
	
	private ArrayList<TypingScene> list;
												//ArrayList<Integer>
	private ArrayList<Integer> randomList = new ArrayList<>();

	public void initRandomEvents(GameManager gameManager, String file){
		MainEvents main = new MainEvents();
		list = (ArrayList<TypingScene>)main.initEvents(gameManager, file);
	}
	//ArrayList<TypingScene>
	public List<TypingScene> getRandomEventsArrayList(){
		return list;
	}
	
	public int nonRepeatRandNum() {
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
