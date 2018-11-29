package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ClassSelection {
	
	private GameManager gameManager;
	
	public ClassSelection(GameManager gameManager) {
		// Set gameManager
		this.gameManager = gameManager;
	}
	
	public VBox init_scene(int screenWidth, int screenHeight) {
		// Set VBox
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #035642");
        
        // Title
        Text titleText = new Text();
        titleText.setText("Select a class");
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setStyle("-fx-font: 35px Tahoma; -fx-fill: #FFFFFF;");

		HBox titleHBox = new HBox();
		titleHBox.getChildren().add(titleText);
		titleHBox.setMinHeight(screenHeight/4);
		titleHBox.setAlignment(Pos.CENTER);
		
		// Buttons
		Button codingWizardButton = new Button();
		codingWizardButton.setText("Coding Wizard");
		codingWizardButton.setId("optionButton");
		codingWizardButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(codingWizardButton.getText());
				gameManager.showNextTypingScene();
			}
		});
		
		Button codingMonkeyButton = new Button();
		codingMonkeyButton.setText("Coding Monkey");
		codingMonkeyButton.setId("optionButton");
		codingMonkeyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(codingMonkeyButton.getText());
				gameManager.showNextTypingScene();
			}
		});

		Button brogrammerButton = new Button();
		brogrammerButton.setText("Brogrammer");
		brogrammerButton.setId("optionButton");
		brogrammerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(brogrammerButton.getText());
				gameManager.showNextTypingScene();
			}
		});
		
		Button athleteButton = new Button();
		athleteButton.setText("Athlete");
		athleteButton.setId("optionButton");
		athleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(athleteButton.getText());
				gameManager.showNextTypingScene();
			}
		});
		
		Button networkKingButton = new Button();
		networkKingButton.setText("Network King");
		networkKingButton.setId("optionButton");
		networkKingButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(networkKingButton.getText());
				gameManager.showNextTypingScene();
			}
		});
		
		Button degenerateButton = new Button();
		degenerateButton.setText("Degenerate");
		degenerateButton.setId("optionButton");
		degenerateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.setPlayerInitialStats(degenerateButton.getText());
				gameManager.showNextTypingScene();
			}
		});
		
		root.getChildren().addAll(titleHBox, 
				codingWizardButton, 
				codingMonkeyButton, 
				brogrammerButton,
				athleteButton,
				networkKingButton,
				degenerateButton);
        root.setAlignment(Pos.CENTER);
		
        return root;
	}
}
