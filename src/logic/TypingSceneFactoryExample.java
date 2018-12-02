package logic;

import java.util.*;

public class TypingSceneFactoryExample {

	private List<TypingScene> typingSceneArrayList;
	
	public TypingSceneFactoryExample(GameManager gameManager) {
		typingSceneArrayList = new ArrayList<>();
		
		// Set example TypingScene
		String[] strArray = new String[3];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "First Scene! Number: " + i;
		}
		strArray[2] = "Google's string of Easter eggs hidden within Search have proved its developers love gaming. And its latest pays tribute to a classic type of game played only with text.";
		
		TypingScene typingScene = new TypingScene(gameManager);
		typingScene.setStrArray(strArray);
		typingScene.setOptionsNum(3);
		typingScene.setOption1("My Custom Option1 Title", new Stats(0, -1, 2, 0));
		typingScene.setOption2("My Custom Option2 Title", new Stats(0, 1, 3, 0));
		typingScene.setOption3("My Custom Option3 Title", new Stats(0, -1, 4, 2));
		typingSceneArrayList.add(typingScene);
		
		// Set example TypingScene2
		strArray = new String[3];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "Seond Scene! Number: " + i;
		}
		typingScene = new TypingScene(gameManager);
		typingScene.setStrArray(strArray);
		typingScene.setOptionsNum(3);
		typingScene.setOption1("My Custom Option1 Title", new Stats(-2, 0, 2, 1));
		typingScene.setOption2("My Custom Option2 Title", new Stats(1, 0, 3, -2));
		typingScene.setOption3("My Custom Option3 Title", new Stats(1, -1, 1, 0));
		typingSceneArrayList.add(typingScene);
	}
	
	//public List<TypingScene> getTypingSceneArrayList() {
	//	return typingSceneArrayList;
	//}
}
