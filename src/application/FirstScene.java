package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FirstScene extends TypingScene {
	
	public FirstScene(GameManager gameManager) {
		super(gameManager);
		
		totalOptionsNum = 3;
	}


	@Override
	protected void setStrArray() {
		// TODO: Customize your story here
		
		strArray = new String[3];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "First Scene! Number: " + i;
		}
		strArray[2] = "Google's string of Easter eggs hidden within Search have proved its developers love gaming. And its latest pays tribute to a classic type of game played only with text.";
	} 
	
	@Override
	protected BorderPane setOption1(Button option1Button, double optionHeight) {
		BorderPane option1Pane = super.setOption1(option1Button, optionHeight);
		
		option1Button.setText("1. Go to second scene");
		option1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.showNextTypingScene(new SecondScene(gameManager));
			}
		});
		
		return option1Pane;
	}
	
	@Override
	protected BorderPane setOption2(Button option2Button, double optionHeight) {
		BorderPane option1Pane = super.setOption1(option2Button, optionHeight);
		
		option2Button.setText("2. First Scene Option2");
		option2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("First Scene Option2 Clicked");
			}
		});
		
		return option1Pane;
	}
	
	@Override
	protected BorderPane setOption3(Button option3Button, double optionHeight) {
		BorderPane option1Pane = super.setOption1(option3Button, optionHeight);
		
		option3Button.setText("3. First Scene Option3");
		option3Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("First Scene Option3 Clicked");
			}
		});
		
		return option1Pane;
	}
}
