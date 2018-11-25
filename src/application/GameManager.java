package application;

import java.util.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {

	// Stage reference
	Stage primaryStage = null;
	
	private int screenWidth = 640, screenHeight = 360;
	private double scrollSpeed = 1;
	
	private List<TypingScene> mainStoryTypingScenes;
	private TypingScene currentTypingScene = null;
	private int currentTypingSceneIndex = -1;
	
	private boolean firstSetup = true;
	
	// Player properties
	public Stats stats;
		
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	// Game Settings
	public void setScreenSize(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void setScrollSpeed(double scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	public void startGame() {
		// Show next (first) typingScene
        showNextTypingScene();
	}
	
	public void setMainStoryTypingScenes(List<TypingScene> mainStoryTypingScenes) {
		this.mainStoryTypingScenes = mainStoryTypingScenes;
	}
	
	public void showNextTypingScene() {
		if (++currentTypingSceneIndex >= mainStoryTypingScenes.size()) {
			System.out.println("Warning: run out of TypingScene to play");
			return;
		}
		
		// Reset
		mainStoryTypingScenes.get(currentTypingSceneIndex).strIndex = 0;
		
		showNextTypingScene(mainStoryTypingScenes.get(currentTypingSceneIndex));
	}
	
	private void showNextTypingScene(TypingScene typingScene) {
		currentTypingScene = typingScene;
		
		if (firstSetup) {
			// First time, init scene
			Scene scene = new Scene(typingScene.init_scene(screenWidth, screenHeight), screenWidth, screenHeight, Color.WHITE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	       
	        // Listen to key
	        listenToKey(scene);
	        
	        // Show stage
	        primaryStage.show();
	        
	        firstSetup = false;
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
            	currentTypingScene.playText(scrollSpeed);
            	event.consume();
            }
        });
	}
	
	// Player Stats
	public void setPlayerInitialStats(Stats stats) {
		this.stats = stats;
	}
	
	public void updateStats(Stats statsChange) {
		stats.hp = stats.hp+statsChange.hp > 0 ? stats.hp+statsChange.hp : 0;
		stats.mp = stats.mp+statsChange.mp > 0 ? stats.mp+statsChange.mp : 0;
		stats.intelligence = stats.intelligence+statsChange.intelligence > 0 ? stats.intelligence+statsChange.intelligence : 0;
		stats.charisma = stats.charisma+statsChange.charisma > 0 ? stats.charisma+statsChange.charisma : 0;
		
//		System.out.println("Stats Display:");
//		System.out.println("hp: " + stats.hp);
//		System.out.println("mp: " + stats.mp);
//		System.out.println("intelligence: " + stats.intelligence);
//		System.out.println("charisma: " + stats.charisma);
//		System.out.println();
	}
	
}
