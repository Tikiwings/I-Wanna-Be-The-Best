package logic;

import java.io.File;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logic.Events;
import logic.GameManager;
import logic.Load;
import logic.TypingScene;

public class Menu {
	public int volume = 50;
	int scrollSpeed = 1;
	GameManager gameManager;

	private int screenWidth, screenHeight;
	
	MediaPlayer player;

	public void initMenu(Stage primaryStage, int screenWidth, int screenHeight, VBox menu){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		Scene home = new Scene(menu, screenWidth, screenHeight);
		primaryStage.setTitle("I Wanna Be The Best");
    	primaryStage.setScene(home);
    	primaryStage.show();
	}

	/*
	 * creates a button that has 2 modes, hovered and not hovered, changing the image
	 * depending on the mode it is on
	 */
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

	public VBox mMenu(Stage primaryStage){
		/* for background */
		Image image = new Image("resources/images/mainMenu.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);
		
		/* Music */
		if(player == null) {
			Media media = new Media(new File("src/resources/songs/YeaPoly.mp3").toURI().toString());
			player = new MediaPlayer(media);
			player.setVolume(((float)volume)/100);
			player.play();
		}
		
		gameManager = new GameManager(primaryStage);
		gameManager.setVolume(volume);
		gameManager.setMenu(this);
		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

		/*
		 * wholeScreen: entire screen which will contain a grid holding
		 * 			    a VBox of buttons
		 *
		 * buttons:		a VBox that holds 4 buttons - play, load, options, and exit
		 */
		VBox wholeScreen = new VBox();

    	/* configuration for wholescreen VBox */
    	wholeScreen.setAlignment(Pos.CENTER);

    	/* configuration for grid holding title and buttons */
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);

    	GridPane titleGrid = new GridPane();
    	titleGrid.setAlignment(Pos.TOP_CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);

    	/* Initializing buttons */
		Button startButton = new Button();
		Button loadButton = new Button();
		Button optionButton = new Button();
		Button exitButton = new Button();
		setButton(startButton, "resources/images/StartPressed.png", "resources/images/StartNormal.png");
		setButton(optionButton, "resources/images/OptionsPressed.png", "resources/images/OptionsNormal.png");
		setButton(loadButton, "resources/images/LoadPressed.png", "resources/images/LoadNormal.png");
		setButton(exitButton, "resources/images/ExitPressed.png", "resources/images/ExitNormal.png");

        /* Add buttons and text to the grid */
        grid.add(startButton, 1, 1);
        grid.add(loadButton, 2, 1);
        grid.add(optionButton, 3, 1);
        grid.add(exitButton, 4, 1);

        stackPane.getChildren().addAll(menuImage, titleGrid, grid);
        wholeScreen.getChildren().addAll(stackPane);

        /* start button action */
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		gameManager.setScrollSpeed(scrollSpeed);

        		// Example (only 2 TypingScenes is this example)
        		Events events = new Events();

        		ArrayList<TypingScene> mainStoryTypingScenesArrayList = events.getEventsArrayList(gameManager);
        		player.pause();
        		gameManager.randEventOrder = events.getRandEventOrder();
        		gameManager.setMainStoryTypingScenes(mainStoryTypingScenesArrayList);
        		gameManager.setScreenSize(screenWidth, screenHeight);
        		gameManager.startGame(); // Probably change it to show the game menu instead
            }
        });

        /* load button action */
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadButton.getScene().setRoot(loadMenu(primaryStage));
            }
        });

        /* option button action */
        optionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	optionButton.getScene().setRoot(optionMenu(primaryStage));
            }
        });

        /* exit button action */
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.exit(0);
            }
        });

    	return wholeScreen;
    }

    public VBox loadMenu(Stage primaryStage){
		Image image = new Image("resources/images/bg.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

    	/* button location */
    	HBox buttonBox = new HBox();
    	BorderPane root = new BorderPane();

    	root.setBottom(buttonBox);

		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

    	VBox vBox = new VBox();
    	vBox.setAlignment(Pos.CENTER);

    	/* button setup */
        Button backBtn = new Button();
        Button btn = new Button();
        setButton(btn, "resources/images/LoadPressed.png", "resources/images/LoadNormal.png");
        setButton(backBtn, "resources/images/BackPressed.png", "resources/images/BackNormal.png");

        buttonBox.getChildren().add(backBtn);
        stackPane.getChildren().addAll(menuImage, root, btn);
        vBox.getChildren().addAll(stackPane);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	backBtn.getScene().setRoot(mMenu(primaryStage));
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	FileChooser fileChooser = new FileChooser();
            	fileChooser.setTitle("Open Save File");
            	File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    String fileName = file.getAbsolutePath();
                    Load loadedSave = new Load();
                    loadedSave.loadSaveFile(fileName);

                    GameManager gameManager = new GameManager(primaryStage);
                    Events events = new Events();

            		ArrayList<TypingScene> mainStoryTypingScenesArrayList = events.loadEventsArrayList(gameManager, loadedSave.getRandOrderList());

            		gameManager.randEventOrder = loadedSave.getRandOrderList();
            		gameManager.loadPlayerStats(loadedSave.getPlayer());
            		gameManager.setCurSceneIndex(loadedSave.getIndex());
            		gameManager.setMainStoryTypingScenes(mainStoryTypingScenesArrayList);
            		gameManager.setScreenSize(screenWidth, screenHeight);
            		gameManager.showNextTypingScene();

                }
                else {
                	System.err.println("User did not choose file");
                }
            }
        });

        return vBox;
    }

    public VBox optionMenu(Stage primaryStage){
		/* for background */
		Image image = new Image("resources/images/bg.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

		/* text for options */
		Text volumeTitle = new Text("Volume");
		volumeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		volumeTitle.setFill(Color.WHITE);
		Text scrolTitle = new Text("Scroll Speed");
		scrolTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		scrolTitle.setFill(Color.WHITE);

    	/* configuration for grid holding slider and percentages */
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);

		/* label for scroll speed percentage */
		Label scrollSpeedPercentage = new Label("" + (scrollSpeed * 10) + "%");
		scrollSpeedPercentage.setTextFill(Color.WHITE);
		Label volumePercentage = new Label("" + volume + "%");
		volumePercentage.setTextFill(Color.WHITE);

		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

		/* vbox to be outputted */
    	VBox wholeScreen = new VBox();
    	wholeScreen.setAlignment(Pos.CENTER);

    	/* slider for scroll speed */
    	Slider scrollSpeedSlider = new Slider();
    	scrollSpeedSlider.setMin(0);
    	scrollSpeedSlider.setMax(10);
    	scrollSpeedSlider.setBlockIncrement(1);

    	/* slider for scroll speed */
    	Slider volumeSlider = new Slider();
    	volumeSlider.setMin(0);
    	volumeSlider.setMax(100);
    	volumeSlider.setBlockIncrement(1);

    	/* sets the slider position on startup */
		volumeSlider.setValue(volume);
		scrollSpeedSlider.setValue(scrollSpeed);

    	/* button setup */
        Button backBtn = new Button();
        setButton(backBtn, "resources/images/BackPressed.png", "resources/images/BackNormal.png");
        Button TutBtn = new Button();
        setButton(TutBtn, "resources/images/TutorialPressed.png", "resources/images/TutorialNormal.png");

        /* add components to grid */
        grid.add(scrolTitle, 0, 0);
        grid.add(scrollSpeedSlider, 1, 0);
        grid.add(scrollSpeedPercentage, 4, 0);
        grid.add(volumeTitle, 0, 1);
        grid.add(volumeSlider, 1, 1);
        grid.add(volumePercentage, 4, 1);
        grid.add(TutBtn, 0, 2);
        grid.add(backBtn, 0, 3);

        stackPane.getChildren().addAll(menuImage, grid);
        wholeScreen.getChildren().addAll(stackPane);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	backBtn.getScene().setRoot(mMenu(primaryStage));
            }
        });

        TutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	TutBtn.getScene().setRoot(tutorialMenu(primaryStage));
            }
        });


        // Adding Listener to volume property.
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable, //
        		Number oldValue, Number newValue) {
        		volume = newValue.intValue();
        		volumePercentage.setText(newValue.intValue() + "%");
        		player.setVolume(((float)volume)/100);
        		gameManager.setVolume(volume);
        	}
        });

        // Adding Listener to scroll speed property.
        scrollSpeedSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable, //
        		Number oldValue, Number newValue) {
        		scrollSpeed = newValue.intValue();
        		scrollSpeedPercentage.setText((newValue.intValue() * 10) + "%");
        	}
        });

        return wholeScreen;
    }

    public VBox tutorialMenu(Stage primaryStage){
		/* for background */
		Image image = new Image("resources/images/tm.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

		/* vbox to be outputted */
    	VBox wholeScreen = new VBox();
    	wholeScreen.setAlignment(Pos.BOTTOM_CENTER);

    	/* button location */
    	HBox buttonBox = new HBox();
    	BorderPane root = new BorderPane();

    	root.setBottom(buttonBox);

        Button btn = new Button();
        setButton(btn, "resources/images/BackPressed.png", "resources/images/BackNormal.png");

        buttonBox.getChildren().add(btn);
        stackPane.getChildren().addAll(menuImage, root);
        wholeScreen.getChildren().addAll(stackPane);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	btn.getScene().setRoot(optionMenu(primaryStage));
            }
        });
        return wholeScreen;
    }

    public VBox pauseMenu(Stage primaryStage){
		/* for background */
		Image image = new Image("resources/images/bg.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);
 		/* text for options */
		Text volumeTitle = new Text("Volume");
		volumeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		volumeTitle.setFill(Color.WHITE);
		Text scrolTitle = new Text("Scroll Speed");
		scrolTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		scrolTitle.setFill(Color.WHITE);
     	/* configuration for grid holding slider and percentages */
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);
 		/* label for scroll speed percentage */
		Label scrollSpeedPercentage = new Label("" + (scrollSpeed * 10) + "%");
		scrollSpeedPercentage.setTextFill(Color.WHITE);
		Label volumePercentage = new Label("" + volume + "%");
		volumePercentage.setTextFill(Color.WHITE);
 		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();
 		/* vbox to be outputted */
    	VBox wholeScreen = new VBox();
    	wholeScreen.setAlignment(Pos.CENTER);
     	/* slider for scroll speed */
    	Slider scrollSpeedSlider = new Slider();
    	scrollSpeedSlider.setMin(0);
    	scrollSpeedSlider.setMax(10);
    	scrollSpeedSlider.setBlockIncrement(1);
     	/* slider for scroll speed */
    	Slider volumeSlider = new Slider();
    	volumeSlider.setMin(0);
    	volumeSlider.setMax(100);
    	volumeSlider.setBlockIncrement(1);
     	/* sets the slider position on startup */
		volumeSlider.setValue(volume);
		scrollSpeedSlider.setValue(scrollSpeed);
     	/* button setup */
        Button backBtn = new Button();
        setButton(backBtn, "resources/images/BackPressed.png", "resources/images/BackNormal.png");
        Button saveBtn = new Button();
        setButton(saveBtn, "resources/images/SavePressed.png", "resources/images/SaveNormal.png");
        Button TutBtn = new Button();
        setButton(TutBtn, "resources/images/TutorialPressed.png", "resources/images/TutorialNormal.png");
        /* add components to grid */
        grid.add(scrolTitle, 0, 0);
        grid.add(scrollSpeedSlider, 1, 0);
        grid.add(scrollSpeedPercentage, 4, 0);
        grid.add(volumeTitle, 0, 1);
        grid.add(volumeSlider, 1, 1);
        grid.add(volumePercentage, 4, 1);
        grid.add(TutBtn, 0, 2);
        grid.add(backBtn, 0, 3);
        grid.add(saveBtn, 1, 3);
        stackPane.getChildren().addAll(menuImage, grid);
        wholeScreen.getChildren().addAll(stackPane);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//backBtn.getScene().setRoot(mMenu(primaryStage));
            	gameManager.showCurrentTypingScene();
            }
        });
        TutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	TutBtn.getScene().setRoot(tutorialMenu(primaryStage));
            }
        });
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	gameManager.saveFile();
            }
        });
        // Adding Listener to volume property.
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable, //
        		Number oldValue, Number newValue) {
        		volume = newValue.intValue();
        		volumePercentage.setText(newValue.intValue() + "%");
        		player.setVolume(volume);
        		gameManager.setVolume(volume);
        	}
        });
        // Adding Listener to scroll speed property.
        scrollSpeedSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable, //
        		Number oldValue, Number newValue) {
        		scrollSpeed = newValue.intValue();
        		scrollSpeedPercentage.setText((newValue.intValue() * 10) + "%");
        	}
        });
        return wholeScreen;
    }
        
}