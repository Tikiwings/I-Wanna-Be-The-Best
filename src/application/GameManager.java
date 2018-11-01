package application;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {

	// Stage reference
	Stage primaryStage = null;
	
	private int screenWidth = 640, screenHeight = 360;
	private double scrollSpeed = 1;
	
	private TypingScene currentTypingScene = null;
		
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setScreenSize(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void setScrollSpeed(double scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	
	public void startGame() {
		// Show next (first) typingScene
        showNextTypingScene(new FirstScene(this));
	}
	
	public void showNextTypingScene(TypingScene typingScene) {
		currentTypingScene = typingScene;
		
		if(primaryStage.getScene() == null) {
			// First time, init scene
			Scene scene = new Scene(typingScene.init_scene(screenWidth, screenHeight), screenWidth, screenHeight, Color.WHITE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	       
	        // Listen to key
	        listenToKey(scene);
	        
	        // Show stage
	        primaryStage.show();
		} else {
			// Not first time, only change the root of the scene
			primaryStage.getScene().setRoot(typingScene.init_scene(screenWidth, screenHeight));
		}
		
        
        // Play scene text
        typingScene.playText(scrollSpeed);
	}
	
	private void listenToKey(Scene scene) {
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
            	if(currentTypingScene !=null && currentTypingScene.playText(scrollSpeed) == false) {
            		System.out.println("Warning: run out of TypingScene to play");
                	event.consume();
                }
            }
        });
	}
}
