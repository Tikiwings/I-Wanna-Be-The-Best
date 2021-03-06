package logic;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameManager {

	// Stage reference
	Stage primaryStage = null;
	
	Menu menu;
	
	private int screenWidth = 640;
	private int screenHeight = 360;
	private double scrollSpeed = 1;
	
	private List<TypingScene> mainStoryTypingScenes;
	private TypingScene currentTypingScene = null;
	private int currentTypingSceneIndex = -1;
		
	// Player properties
	private Player player;
	private int volume;

	public List<Integer> randEventOrder;
		
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	// Getter
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public double getScrollSpeed() {
		return scrollSpeed;
	} 
	
	// Setter
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
	
	public void setGameSettings(int screenWidth, int screenHeight, double scrollSpeed) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.scrollSpeed = scrollSpeed;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public TypingScene showCurrentTypingScene() {
		if (currentTypingSceneIndex >= mainStoryTypingScenes.size()) {
//			Warning: run out of TypingScene to play

			return null; // ????
		}
		
		// Reset
		if (mainStoryTypingScenes.get(currentTypingSceneIndex).getStrIndex() > 0)
			mainStoryTypingScenes.get(currentTypingSceneIndex).incStrIndex(-1);
		 
		else if (mainStoryTypingScenes.get(currentTypingSceneIndex).getStrIndex() < 0) {
			mainStoryTypingScenes.get(currentTypingSceneIndex).setStrIndex(0);
		}	
		return showCurrentTypingScene(mainStoryTypingScenes.get(currentTypingSceneIndex));
	}
	
	private TypingScene showCurrentTypingScene(TypingScene typingScene) {
		// Set currentTypingScene
		currentTypingScene = typingScene;
	
		return typingScene;
	}
	
	public void startGame() {
		// Show class selection screen
		ClassSelection classSelection = new ClassSelection(this);
		
		Scene scene = new Scene(classSelection.initScene(screenWidth, screenHeight), screenWidth, screenHeight, Color.WHITE);
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
//			Warning: run out of TypingScene to play
			
			return;
		}
		
		// Reset
		mainStoryTypingScenes.get(currentTypingSceneIndex).setStrIndex(0);
		
		showNextTypingScene(mainStoryTypingScenes.get(currentTypingSceneIndex));
	}
	
	private void showNextTypingScene(TypingScene typingScene) {
		// Set currentTypingScene
		currentTypingScene = typingScene;
		primaryStage.getScene().setRoot(typingScene.initScene(screenWidth, screenHeight));
	
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
            	saveFile(null, randEventOrder);
            }
            else if ((event.getCode() == KeyCode.ESCAPE || event.getCode() == KeyCode.P) && currentTypingSceneIndex != -1) {
            	// pause menu
            	TypingScene curTS = showCurrentTypingScene();
            	scene.setRoot(menu.optionMenu(primaryStage, curTS.initScene(screenWidth, screenHeight), true));
            	curTS.playText(scrollSpeed);
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
	
	public void saveFile(String fileName, List<Integer> randEventOrder) {
		Save.saveProgress(player, randEventOrder, currentTypingSceneIndex, fileName);
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
		if(currentTypingScene != null) {
			currentTypingScene.setVolume(volume);
		} 
	}
	public Player getPlayer()
	{
		return this.player;
	}
	public int getVolume()
	{
		return this.volume;
	}
}
