package application;

public class SecondScene extends TypingScene {

	@Override
	protected void setStrArray() {
		// TODO: Customize your story here
		
		strArray = new String[5];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "Second Scene! Number: " + i;
		}
	} 
}
