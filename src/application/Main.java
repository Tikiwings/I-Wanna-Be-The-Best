package application;
	
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	
	// ScreenWidth and screenHeight
	final private int screenWidth = 640, screenHeight = 360;
	
	// All TypingScenes
	private TypingScene[] allTypingScenes;
	
	// Current TypingScene index
	private int currentTypingSceneIndex = -1;
	
	// Scroll speed in seconds
	private double scrollSpeed = 1;
	
	// Space key listener
	private boolean spaceKeyPressed = false;
	
	@Override
	public void start(Stage primaryStage) {
		// Set allTypingScenes
		setAllTypingScenes();
		
		// Show next typingScene
        showNextTypingScene(primaryStage);
	}
	
	private void listenToKey(Stage primaryStage, Scene scene) {
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
                    	showNextTypingScene(primaryStage);
                    }
                }
            }
        }.start();
	}
	
	private void setAllTypingScenes() {
		// Initialize how many scenes
		allTypingScenes = new TypingScene[2];
		
		// Initialize what scene to include and in what order
		allTypingScenes[0] = new FirstScene();
		allTypingScenes[1] = new SecondScene();
	}
	
	private void showNextTypingScene(Stage primaryStage) {
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
	        listenToKey(primaryStage, scene);
	        
	        // Show stage
	        primaryStage.show();
		} else {
			// Not first time, only change the root of the scene
			primaryStage.getScene().setRoot(thisTypingScene.init_scene(screenWidth, screenHeight));
		}
		
        
        // Play scene text
        if(thisTypingScene.playText(scrollSpeed) == false) showNextTypingScene(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
