package application;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {

	// Stage reference
	Stage primaryStage = null;
	
	private int screenWidth = 640, screenHeight = 360;
	private double scrollSpeed = 1;
	
	private TypingScene[] allTypingScenes;
	private int currentTypingSceneIndex = -1;
	
	// Space key listener
	private boolean spaceKeyPressed = false;
	
	
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		// Set allTypingScenes
		setAllTypingScenes();
	}
	
	public void setScreenSize(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void setScrollSpeed(double scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	// Private Methods
	private void setAllTypingScenes() {
		// Initialize how many scenes
		allTypingScenes = new TypingScene[2];
		
		// Initialize what scene to include and in what order
		allTypingScenes[0] = new FirstScene();
		allTypingScenes[1] = new SecondScene();
	}
	
	public void startGame() {
		// Show next (first) typingScene
        showNextTypingScene();
	}
	
	private void showNextTypingScene() {
		// Check if run out of TypingScene
		if(currentTypingSceneIndex+1 >= allTypingScenes.length) {
			System.out.println("Warning: run out of TypingScene to play");
			return;
		}
		
		// Get current TypingScene
		TypingScene thisTypingScene = allTypingScenes[++currentTypingSceneIndex];
		
		if(currentTypingSceneIndex == 0) {
			// First time, init scene
			
			// Init scene
			Scene scene = new Scene(thisTypingScene.init_scene(screenWidth, screenHeight), screenWidth, screenHeight, Color.WHITE);
	        primaryStage.setScene(scene);
	        
	        // Listen to key
	        listenToKey(scene);
	        
	        // Show stage
	        primaryStage.show();
		} else {
			// Not first time, only change the root of the scene
			primaryStage.getScene().setRoot(thisTypingScene.init_scene(screenWidth, screenHeight));
		}
		
        
        // Play scene text
        if(thisTypingScene.playText(scrollSpeed) == false) showNextTypingScene();
	}
	
	private void listenToKey(Scene scene) {
		scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.SPACE) spaceKeyPressed = true;
        });
		
        scene.setOnKeyReleased(event -> {
        	if(event.getCode() == KeyCode.SPACE) spaceKeyPressed = false;
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(spaceKeyPressed) {
                    spaceKeyPressed = false; // So no longer trigger multiple times when only pressed once
 
                    if(allTypingScenes[currentTypingSceneIndex].playText(scrollSpeed) == false) {
                    	showNextTypingScene();
                    }
                }
            }
        }.start();
	}
}
