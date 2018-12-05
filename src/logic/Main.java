package logic;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private static final int screenWidth = 960;
	private static final int screenHeight = 540;

	@Override
	public void start(Stage primaryStage) {
		Menu mainMenu = new Menu();

		mainMenu.initMenu(primaryStage, screenWidth, screenHeight, mainMenu.mMenu(primaryStage));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
