package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	final private int screenWidth = 640, screenHeight = 360;

	@Override
	public void start(Stage primaryStage) {
		Menu mainMenu = new Menu();

		mainMenu.initMenu(primaryStage, screenWidth, screenHeight, mainMenu.mMenu(primaryStage));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
