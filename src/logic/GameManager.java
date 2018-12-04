package logic;

import java.util.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {

	// Stage reference
	Stage primaryStage = null;
	
	Menu menu;
	
	private int screenWidth = 640, screenHeight = 360;
	private double scrollSpeed = 1;
	
	private List<TypingScene> mainStoryTypingScenes;
	private TypingScene currentTypingScene = null;
	private int currentTypingSceneIndex = -1;
		
	// Player properties
	public Player player;
	public int volume;

	protected List<Integer> randEventOrder;
		
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public void setCurSceneIndex(Integer currentTypingSceneIndex) {
		this.currentTypingSceneIndex = currentTypingSceneIndex - 1;
	}
	
	// Game Settings
	public void setScreenSize(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	public void setScrollSpeed(double scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void showCurrentTypingScene() {
		if (currentTypingSceneIndex >= mainStoryTypingScenes.size()) {
			System.out.println("Warning: run out of TypingScene to play");
			return;
		}
		
		// Reset
		if (mainStoryTypingScenes.get(currentTypingSceneIndex).strIndex > 0)
			mainStoryTypingScenes.get(currentTypingSceneIndex).strIndex--;
		 
		else if (mainStoryTypingScenes.get(currentTypingSceneIndex).strIndex < 0) {
			mainStoryTypingScenes.get(currentTypingSceneIndex).strIndex = 0;
		}	
		showCurrentTypingScene(mainStoryTypingScenes.get(currentTypingSceneIndex));
	}
	
	private void showCurrentTypingScene(TypingScene typingScene) {
		// Set currentTypingScene
		currentTypingScene = typingScene;
		primaryStage.getScene().setRoot(typingScene.init_scene(screenWidth, screenHeight));
	
        // Play scene text
		typingScene.playText(scrollSpeed);
	}
	
	public void startGame() {
		// Show class selection screen
		ClassSelection classSelection = new ClassSelection(this);
		
		Scene scene = new Scene(classSelection.init_scene(screenWidth, screenHeight), screenWidth, screenHeight, Color.WHITE);
		scene.getStylesheets().add(getClass().getResource("/resources/css/application.css").toExternalForm());
        primaryStage.setScene(scene);
       
        // Listen to key
        listenToKey(scene);
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
		// Set currentTypingScene
		currentTypingScene = typingScene;
		primaryStage.getScene().setRoot(typingScene.init_scene(screenWidth, screenHeight));
	
        // Play scene text
        typingScene.playText(scrollSpeed);
	}
	
	private void listenToKey(Scene scene) {
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
            	if (currentTypingScene != null) {
            		currentTypingScene.playText(scrollSpeed);
            	}
            	event.consume();
            }
            else if (event.getCode() == KeyCode.S) {
            	saveFile();
            }
            else if ((event.getCode() == KeyCode.ESCAPE || event.getCode() == KeyCode.P) && currentTypingSceneIndex != -1) {
            	// pause menu
            	scene.setRoot(menu.pauseMenu(primaryStage));
            }
        });
	}
	
	// Player Stats
	public void setPlayerInitialStats(String classChoice) {
		this.player = new Player(classChoice);
	}
	
	public void loadPlayerStats(Player player) {
		this.player = player;
	}
	
	public void updateStats(Stats statsChange) {
		player.setHP(player.getHP() + statsChange.hp > 0 ? player.getHP() + statsChange.hp : 0);
		player.setMP(player.getMP() + statsChange.mp > 0 ? player.getMP() + statsChange.mp : 0);
		player.setInt(player.getInt() + statsChange.intelligence > 0 ? player.getInt() + statsChange.intelligence : 0);
		player.setChar(player.getChar() + statsChange.charisma > 0 ? player.getChar() + statsChange.charisma : 0);
	}
	
	public void saveFile() {
		Save.saveProgress(player, randEventOrder, currentTypingSceneIndex);
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
		if(currentTypingScene != null) {
			currentTypingScene.setVolume(volume);
		} 
	}
}