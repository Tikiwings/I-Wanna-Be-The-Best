package application;

public class FirstScene extends TypingScene {

	@Override
	protected void setStrArray() {
		// TODO: Customize your story here
		
		strArray = new String[3];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "First Scene! Number: " + i;
		}
		strArray[2] = "Google's string of Easter eggs hidden within Search have proved its developers love gaming. And its latest pays tribute to a classic type of game played only with text.";
	} 
}
