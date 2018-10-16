package application;
	
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	
	// Scroll speed in seconds
	private double scrollSpeed = 1;
	
	@Override
	public void start(Stage primaryStage) {
		// First scene
		TypingScene typingScene = new TypingScene();
		
        Scene scene = new Scene(typingScene.init_scene(), 330, 120, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        typingScene.playText(scrollSpeed);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
