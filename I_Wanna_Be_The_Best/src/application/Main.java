package IWannaBeTheBest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	Screen screen = Screen.getPrimary();
    	Rectangle2D bounds = screen.getVisualBounds();
    	MainMenu mainMenu = new MainMenu();


    	Scene home = new Scene(mainMenu.mMenu(), 800, 600);

    	primaryStage.setWidth(bounds.getHeight() / 1.5);
    	primaryStage.setHeight(bounds.getHeight() / 1.5);

    	primaryStage.setTitle("Relationships");
    	primaryStage.setScene(home);
    	primaryStage.show();
    }
}