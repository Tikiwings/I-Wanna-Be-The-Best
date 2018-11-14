package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class TypingScene {

	private Text text = null;
	protected String[] strArray = null;
	
	// Current string index
	protected int strIndex = 0;
	
	// Play text timeline
	protected Timeline textTimeline = null;
	
	public TypingScene() {
		// Set strArray
		setStrArray();
	}
	
	public VBox init_scene(int screenWidth, int screenHeight){
		// Set Text
		text = new Text();
		text.setTextAlignment(TextAlignment.CENTER);
		text.wrappingWidthProperty().set(screenWidth - 200 > 150 ? screenWidth - 200 : screenWidth);
		
		// Set VBox
        VBox root = new VBox(text);
        root.setAlignment(Pos.CENTER);
        
        return root;
	}
	
	// Return false when running out of strings (possibly means should go to next scene)
	public boolean playText(double scrollSpeed) {
		// check if has previous string playing
		if(textTimeline != null) {
			// Show entire string immediately
			text.setText(strArray[strIndex-1]);
			
			// Stop timeline
			textTimeline.stop();
			textTimeline = null;
			
			// Return so player can have time to look at the string
			return true;
		}
		
		// Check if run out of strings
		if(strIndex >= strArray.length) {
			System.out.println("Warning: run out of strings to play");
			return false;
		}
		
		// Go to the new string
		String thisString = strArray[strIndex++];
		
		// Given each char 0.05 seconds to play by default,
		// the larger the scrollSpeed is, the faster it plays
		double animate_duration = 0.05/scrollSpeed;
		
		// Play string
		final IntegerProperty i = new SimpleIntegerProperty(0);
		textTimeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(animate_duration),
                event -> {
                    if (i.get() > thisString.length()) {
                    	textTimeline.stop();
                    	textTimeline = null;
                    } else {
                        text.setText(thisString.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        textTimeline.getKeyFrames().add(keyFrame);
        textTimeline.setCycleCount(Animation.INDEFINITE);
        textTimeline.play();
        
        return true;
	}
	
	protected void setStrArray() {
		strArray = new String[5];
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = "Override setStrArray() to customize strings. Number: " + i;
		}
	}
}
