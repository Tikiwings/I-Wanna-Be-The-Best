package application;

import java.util.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu {
	int volume = 1;
	int scrollSpeed = 1;

	public void initMenu(Stage primaryStage, int screenWidth, int screenHeight, VBox menu){
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
		Image image = new Image("mainMenu.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

		GameManager gameManager = new GameManager(primaryStage);

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
		setButton(startButton, "StartPressed.png", "StartNormal.png");
		setButton(optionButton, "OptionsPressed.png", "OptionsNormal.png");
		setButton(loadButton, "LoadPressed.png", "LoadNormal.png");
		setButton(exitButton, "ExitPressed.png", "ExitNormal.png");

        /* Add buttons and text to the grid */
        grid.add(startButton, 1, 1);
        grid.add(loadButton, 2, 1);
        grid.add(optionButton, 1, 2);
        grid.add(exitButton, 2, 2);

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
        		
        		// Player initial stats
        		Stats stats = new Stats(100, 100, 100, 100); // hp, mp, intelligence, charisma in order
        		
        		gameManager.setMainStoryTypingScenes(mainStoryTypingScenesArrayList);
        		gameManager.setPlayerInitialStats(stats);
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
		/* for background */
		Image image = new Image("bg.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

    	VBox vBox = new VBox();
    	vBox.setAlignment(Pos.CENTER);

        Button btn = new Button();
        btn.setText("Load");

        stackPane.getChildren().addAll(menuImage, btn);
        vBox.getChildren().addAll(stackPane);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	btn.getScene().setRoot(mMenu(primaryStage));
            }
        });

        return vBox;
    }

    public VBox optionMenu(Stage primaryStage){
		/* for background */
		Image image = new Image("bg.png");
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

    	/* back button setup */
        Button backBtn = new Button();
        setButton(backBtn, "BackPressed.png", "BackNormal.png");
        Button saveBtn = new Button();
        setButton(saveBtn, "SavePressed.png", "SaveNormal.png");
        Button TutBtn = new Button();
        setButton(TutBtn, "TutorialPressed.png", "TutorialNormal.png");

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
            	backBtn.getScene().setRoot(mMenu(primaryStage));
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
            public void handle(ActionEvent event) {}
        });

        // Adding Listener to volume property.
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
        	@Override
        	public void changed(ObservableValue<? extends Number> observable, //
        		Number oldValue, Number newValue) {
        		volume = newValue.intValue();
        		volumePercentage.setText(newValue.intValue() + "%");
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
		Image image = new Image("tm.png");
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
        setButton(btn, "BackPressed.png", "BackNormal.png");

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
}