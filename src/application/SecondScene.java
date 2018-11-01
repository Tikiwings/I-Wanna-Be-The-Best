package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class SecondScene extends TypingScene {

	public SecondScene(GameManager gameManager) {
		super(gameManager);
		
		totalOptionsNum = 2;
	}
	
	@Override
	protected void setStrArray() {
		// TODO: Customize your story here
		
		strArray = new String[5];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "Second Scene! Number: " + i;
		}
	} 
	
	@Override
	protected BorderPane setOption1(Button option1Button, double optionHeight) {
		BorderPane option1Pane = super.setOption1(option1Button, optionHeight);
		
		option1Button.setText("1. Second Scene Option1");
		option1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Second Scene Option1 Clicked");
			}
		});
		
		return option1Pane;
	}
	
	@Override
	protected BorderPane setOption2(Button option2Button, double optionHeight) {
		BorderPane option1Pane = super.setOption1(option2Button, optionHeight);
		
		option2Button.setText("2. Second Scene Option2");
		option2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Second Scene Option2 Clicked");
			}
		});
		
		return option1Pane;
	}
}
