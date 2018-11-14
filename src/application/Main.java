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
		
		//Use this section to test player methods
		/*Player me = new Player();
		Player me2 = new Player("Coding Wizard");
		
		System.out.println(me.getPlayerInfo());
		System.out.println(me2.getPlayerInfo());
		
		me.adjCha(12);
		me.adjInt(15);
		me.adjScore(1337);
		me.adjHP(-70);
		
		me2.adjMP(1000);
		
		System.out.println(me.getPlayerInfo());
		System.out.println(me2.getPlayerInfo());*/
	}
}
