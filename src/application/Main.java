package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	final private int screenWidth = 640, screenHeight = 360;
	
	@Override
	public void start(Stage primaryStage) {
		GameManager gameManager = new GameManager(primaryStage);
		
		gameManager.setScreenSize(screenWidth, screenHeight);
		gameManager.setScrollSpeed(1);
		gameManager.startGame(); // Probably change it to show the game menu instead
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
