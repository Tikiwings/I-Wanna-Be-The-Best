package logic;

import java.io.File;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class TypingScene {

	private GameManager gameManager;

	private Label label = null;
	private String[] strArray = null;

	// Current string index
	public int strIndex = 0;

	//Sound effect
	public String sound = "YeaPoly.mp3";
	public MediaPlayer player;
	boolean soundPlaying = false;

	//Image
	private String imageName = "bg.png";

	// Play text timeline
	private Timeline textTimeline = null;

	// Options
	public int totalOptionsNum = 0;

	public String option1Title = "Empty", option2Title = "Empty", option3Title = "Empty";
	public Stats option1Stats, option2Stats, option3Stats;
	private BorderPane option1Pane, option2Pane, option3Pane;

	public TypingScene(GameManager gameManager) {
		// Set gameManager
		this.gameManager = gameManager;
	}

	public VBox init_scene(int screenWidth, int screenHeight) {
		 // For background image
		 System.out.println(imageName);
		 ImageView menuImage;
		 try {
			 Image image = new Image("resources/images/" + imageName);
			 menuImage = new ImageView();
			 menuImage.setImage(image);
		 }
		 catch(IllegalArgumentException e) {
			 Image image = new Image("resources/images/" + "Lab.jpg");
			 menuImage = new ImageView();
			 menuImage.setImage(image);
		 }

		 // To put texts over image
		 StackPane stackPane = new StackPane();

		 // Set VBox
		 VBox textBox = new VBox();

		 // Set VBox
		 VBox root = new VBox();
		 //root.setStyle("-fx-background-color: #035642");

		 // Display (Text, settings...)
		 double displayHeight = screenHeight/2;

		 BorderPane displayPane = new BorderPane();

		 label = new Label();
		 label.setText("Hello there");
		 label.setTextAlignment(TextAlignment.CENTER);
		 label.setWrapText(true);
		 label.setStyle("-fx-font: 20px Tahoma;"
		 		+ "-fx-text-fill: #FFFFFF;"
		 		+ "-fx-background-color: #035642;");
		 label.setPadding(new Insets(0, 50, 0, 50));

		 displayPane.setCenter(label);
		 displayPane.setMinHeight(displayHeight);
		 //displayPane.setStyle("-fx-background-color: #035642;");
		 textBox.getChildren().add(displayPane);
		 stackPane.getChildren().addAll(menuImage, textBox);
		 root.getChildren().add(stackPane);
		 //root.getChildren().addAll(displayPane, stackPane);


		 // Set options
		 if(totalOptionsNum >= 1) {
			 Button option1Button = new Button();
			 option1Pane = setOption1(option1Button);
			 option1Pane.setPadding(new Insets(10, 0, 0, 0));
			 textBox.getChildren().add(option1Pane);
		 }
		 if(totalOptionsNum >= 2) {
			 Button option2Button = new Button();
			 option2Pane = setOption2(option2Button);
			 option2Pane.setPadding(new Insets(10, 0, 0, 0));
			 textBox.getChildren().add(option2Pane);
		 }
		 if(totalOptionsNum >= 3) {
			 Button option3Button = new Button();
			 option3Pane = setOption3(option3Button);
			 option3Pane.setPadding(new Insets(10, 0, 0, 0));
			 textBox.getChildren().add(option3Pane);
		 }

		 //Sound
		 if (soundPlaying == false) {
		   	 soundPlaying = playSound(gameManager.volume);
		 }

		 // Stats
		 Label stats_label = new Label();
		 stats_label.setStyle("-fx-font: 15px Tahoma;"
		 		+ "-fx-text-fill: #FFFFFF;"
		 		+ "-fx-padding: 0px 0px 20px 20px;"
		 		+ "-fx-background-color: #035642;");
		 stats_label.setText(gameManager.player.getStatStr());

		 BorderPane stats_Pane = new BorderPane();
		 stats_Pane.setBottom(stats_label);
		 VBox.setVgrow(stats_Pane, Priority.ALWAYS);
		 textBox.getChildren().add(stats_Pane);

		 // TODO: save button here

		 return root;
	}

	public void setButton(Button button, String pressedImage, String normalImage){
		Image startNormal = new Image(normalImage);
		Image startPressed = new Image(pressedImage);
		button.setGraphic(new ImageView(startNormal));
        button.setStyle("-fx-background-color: #035642");
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
    		new EventHandler<MouseEvent>() {
    			@Override
    			public void handle(MouseEvent e) {
    				button.setGraphic(new ImageView(startPressed));
    			}
    		});
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
    		new EventHandler<MouseEvent>() {
    			@Override
    			public void handle(MouseEvent e) {
    				button.setGraphic(new ImageView(startNormal));
    			}
        	});
	}

	// Return false when running out of strings (possibly means should go to next scene)
	public boolean playText(double scrollSpeed) {
		// check if has previous string playing
		if(textTimeline != null) {
			if (strIndex < 1) {
				strIndex = 1;
			}
			// Show entire string immediately
			label.setText(strArray[strIndex-1]);

			// Show options
			if(strIndex >= strArray.length) showOptions();

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
                    	// Show options
                    	if(strIndex >= strArray.length) showOptions();

                    	// Stop timeline
                    	if (textTimeline != null) {
                    		textTimeline.stop();
                        	textTimeline = null;
                    	}
                    } else {
                    	label.setText(thisString.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        textTimeline.getKeyFrames().add(keyFrame);
        textTimeline.setCycleCount(Animation.INDEFINITE);
        textTimeline.play();

        return true;
	}

	public String setSound(String sound) {
		this.sound = sound;
		return this.sound;
	}

	public boolean playSound(int volume) {
		try {
			Media media = new Media(new File("src/resources/songs/"+sound).toURI().toString());
			player = new MediaPlayer(media);
			player.setVolume(volume);
			player.play();
			return true;
		}
		catch(MediaException e){
			Media media = new Media(new File("src/resources/songs/"+"YeaPoly.mp3").toURI().toString());
			player = new MediaPlayer(media);
			player.setVolume(volume);
			player.play();
			return true;
		}
	}

	public boolean pauseSound() {
		player.pause();
		return true;
	}

	public boolean setVolume(int volume) {
		player.setVolume(((float)volume)/100);
		return true;
	}

	public int setVolumeTest(int volume) {
		return volume;
	}

	public String setImage(String image) {
		this.imageName = image;
		return image;
	}

	public String[] setStrArray(String[] strArray) {
		this.strArray = strArray;
		return strArray;
	}

	public void setOptionsNum(int optionsNum) {
		totalOptionsNum = optionsNum;
	}

	public void setOption1(String title, Stats stats) {
		option1Title = "1. " + title;
		option1Stats = stats;
	}

	public void setOption2(String title, Stats stats) {
		option2Title = "2. " + title;
		option2Stats = stats;
	}

	public void setOption3(String title, Stats stats) {
		option3Title = "3. " + title;
		option3Stats = stats;
	}
	
	public void setOptions(int optionsNum, 
			String title1, Stats stats1,
			String title2, Stats stats2,
			String title3, Stats stats3) {
		totalOptionsNum = optionsNum;
		
		option1Title = "1. " + title1;
		option1Stats = stats1;
		
		option2Title = "2. " + title2;
		option2Stats = stats2;
		
		option3Title = "3. " + title3;
		option3Stats = stats3;
	}

	// Options
	private BorderPane setOption1(Button option1Button) {
		option1Button.setText(option1Title);
		option1Button.wrapTextProperty().setValue(true);
		option1Button.setPadding(new Insets(0, 50, 0, 50));
		option1Button.setId("optionButton");

		if(totalOptionsNum != 1) {
			option1Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					gameManager.updateStats(option1Stats);
					pauseSound();
					gameManager.showNextTypingScene();
				}
			});
		}
		else if( totalOptionsNum == 1) {
			option1Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// Show ending screen
					EndingScreen end = new EndingScreen(gameManager);
					pauseSound();
					Scene scene = new Scene(end.init_scene(gameManager.getScreenWidth(),
							gameManager.getScreenHeight()),
							gameManager.getScreenWidth(),
							gameManager.getScreenHeight(),
							Color.WHITE);

					scene.getStylesheets().add(getClass().getResource("/resources/css/application.css").toExternalForm());
			        gameManager.primaryStage.setScene(scene);

			        // Show stage
			        gameManager.primaryStage.show();
				}
			});
		}

		BorderPane option1Pane = new BorderPane();
		option1Pane.setCenter(option1Button);
		option1Pane.setVisible(false);
		return option1Pane;
	}

	private BorderPane setOption2(Button option2Button) {
		option2Button.setText(option2Title);
		option2Button.wrapTextProperty().setValue(true);
		option2Button.setPadding(new Insets(0, 50, 0, 50));
		option2Button.setId("optionButton");
		option2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.updateStats(option2Stats);
				pauseSound();
				gameManager.showNextTypingScene();
			}
		});

		BorderPane option2Pane = new BorderPane();
		option2Pane.setCenter(option2Button);
		option2Pane.setVisible(false);
		return option2Pane;
	}

	private BorderPane setOption3(Button option3Button) {
		option3Button.setText(option3Title);
		option3Button.wrapTextProperty().setValue(true);
		option3Button.setPadding(new Insets(0, 50, 0, 50));
		option3Button.setId("optionButton");
		option3Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameManager.updateStats(option3Stats);
				pauseSound();
				gameManager.showNextTypingScene();
			}
		});

		BorderPane option3Pane = new BorderPane();
		option3Pane.setCenter(option3Button);
		option3Pane.setVisible(false);
		return option3Pane;
	}

	private void showOptions() {
		if(option1Pane != null) option1Pane.setVisible(true);
		if(option2Pane != null) option2Pane.setVisible(true);
		if(option3Pane != null) option3Pane.setVisible(true);
	}
}
