package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TypingScene {

	private Text text;
	private String str;
	
	public TypingScene() {
		text = new Text();
		
		// Playing text content
		str = "Hello World!";
		
	}
	
	public VBox init_scene(){
        VBox root = new VBox(text);
        root.setAlignment(Pos.CENTER);
        
        return root;
	}
	
	public void playText(double scrollSpeed) {
		// Given each char 0.01 seconds to play initially,xw
		// the larger the scrollSpeed is, the faster it plays
		double animate_duration = 0.01*str.length()/scrollSpeed;
		
		final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(animate_duration),
                event -> {
                    if (i.get() > str.length()) {
                        timeline.stop();
                    } else {
                        text.setText(str.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
	}
}
