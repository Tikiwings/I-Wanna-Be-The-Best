package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class TypingScene {

	protected GameManager gameManager;
	
	private Text text = null;
	protected String[] strArray = null;
	
	// Current string index
	protected int strIndex = 0;
	
	// Play text timeline
	protected Timeline textTimeline = null;
	
	// Options
	protected double totalOptionsNum = 0;
	private BorderPane option1Pane, option2Pane, option3Pane;
	
	public TypingScene(GameManager gameManager) {
		// Set gameManager
		this.gameManager = gameManager;
		
		// Set strArray
		setStrArray();
	}
	
	public VBox init_scene(int screenWidth, int screenHeight){
		// Set VBox
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #035642");
		
		// Display (Text, settings...)
		double displayHeight = screenHeight/2;
		
		BorderPane displayPane = new BorderPane();

		text = new Text();
		text.setTextAlignment(TextAlignment.CENTER);
		text.wrappingWidthProperty().set(screenWidth - 200 > 150 ? screenWidth - 200 : screenWidth);
		text.setStyle("-fx-font: 15px Tahoma; -fx-fill: #FFFFFF");
		
		displayPane.setCenter(text);
		displayPane.setMinHeight(displayHeight);
		displayPane.setStyle("-fx-background-color: #035642; ");
		root.getChildren().add(displayPane);

		// Set options
		double totalOptionsHeight = screenHeight - displayHeight;
		double optionHeight = totalOptionsHeight/(totalOptionsNum+1.5);
		
		if(totalOptionsNum >= 1) {
			Button option1Button = new Button();
			option1Pane = setOption1(option1Button, optionHeight);
			root.getChildren().add(option1Pane);
		}
		if(totalOptionsNum >= 2) {
			Button option2Button = new Button();
			option2Pane = setOption2(option2Button, optionHeight);
			root.getChildren().add(option2Pane);
		}
		if(totalOptionsNum >= 3) {
			Button option3Button = new Button();
			option3Pane = setOption3(option3Button, optionHeight);
			root.getChildren().add(option3Pane);
		}
		
		HBox emptyBox = new HBox();
		emptyBox.setMinHeight(optionHeight*1.5);
		root.getChildren().add(emptyBox);
		        
        return root;
	}
	
	// Return false when running out of strings (possibly means should go to next scene)
	public boolean playText(double scrollSpeed) {		
		// check if has previous string playing
		if(textTimeline != null) {
			// Show entire string immediately
			text.setText(strArray[strIndex-1]);
			
			// Show options
			if(strIndex >= strArray.length) showOptions();
			
			// Stop timeline
			textTimeline.stop();
			textTimeline = null;
			
			// Return so player can have time to look at the string
			return true;
		}
		
		// Check if run out of strings
		if(strIndex >= strArray.length) {
			System.out.println("Warning: run out of strings to play");
			return false;
		}
		
		// Go to the new string
		String thisString = strArray[strIndex++];
		
		// Given each char 0.05 seconds to play by default,
		// the larger the scrollSpeed is, the faster it plays
		double animate_duration = 0.05/scrollSpeed;
		
		// Play string
		final IntegerProperty i = new SimpleIntegerProperty(0);
		textTimeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(animate_duration),
                event -> {
                    if (i.get() > thisString.length()) {
                    	// Show options
                    	if(strIndex >= strArray.length) showOptions();
                    	
                    	// Stop timeline
                    	textTimeline.stop();
                    	textTimeline = null;
                    } else {
                        text.setText(thisString.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        textTimeline.getKeyFrames().add(keyFrame);
        textTimeline.setCycleCount(Animation.INDEFINITE);
        textTimeline.play();
        
        return true;
	}
	
	protected void setStrArray() {
		strArray = new String[5];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "Override setStrArray() to customize strings. Number: " + i;
		}
	}
	
	// Options
	protected BorderPane setOption1(Button option1Button, double optionHeight) {
		option1Button.setText("1. Option1");
		option1Button.setMinHeight(optionHeight);
		option1Button.setId("optionButton");
		option1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Override setOption1 to replace your action");
			}
		});
		
		BorderPane option1Pane = new BorderPane();
		option1Pane.setCenter(option1Button);
		option1Pane.setVisible(false);
		return option1Pane;
	}
	
	protected BorderPane setOption2(Button option2Button, double optionHeight) {
		option2Button.setText("2. Option2");
		option2Button.setMinHeight(optionHeight);
		option2Button.setId("optionButton");
		option2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Override setOption2 to replace your action");
			}
		});
		
		BorderPane option2Pane = new BorderPane();
		option2Pane.setCenter(option2Button);
		option2Pane.setVisible(false);
		return option2Pane;
	}
	
	protected BorderPane setOption3(Button option3Button, double optionHeight) {
		option3Button.setText("3. Option3");
		option3Button.setMinHeight(optionHeight);
		option3Button.setId("optionButton");
		option3Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Override setOption3 to replace your action");
			}
		});
		
		BorderPane option3Pane = new BorderPane();
		option3Pane.setCenter(option3Button);
		option3Pane.setVisible(false);
		return option3Pane;
	}
	
	private void showOptions() {
		if(option1Pane != null) option1Pane.setVisible(true);
		if(option2Pane != null) option2Pane.setVisible(true);
		if(option3Pane != null) option3Pane.setVisible(true);
	}
}