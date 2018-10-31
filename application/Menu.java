package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu {

	public void initMenu(Stage primaryStage, int screenWidth, int screenHeight, VBox menu){
		Scene home = new Scene(menu, screenWidth, screenHeight);
		primaryStage.setTitle("I Wanna Be The Best");
    	primaryStage.setScene(home);
    	primaryStage.show();
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

	public VBox mMenu(){
		/* for background */
		Image image = new Image("bg.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

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

    	 /* Initializing title text */
    	Text space = new Text(" ");
    	Text title = new Text("I Wanna Be The Best");
    	title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
    	space.setFont(Font.font("Tahoma", FontWeight.NORMAL, 120));

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
		titleGrid.add(space, 0, 0);
		titleGrid.add(title, 1, 0);
        grid.add(startButton, 1, 1);
        grid.add(loadButton, 2, 1);
        grid.add(optionButton, 1, 2);
        grid.add(exitButton, 2, 2);

        stackPane.getChildren().addAll(menuImage, titleGrid, grid);
        wholeScreen.getChildren().addAll(stackPane);

        /* button actions */
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	startButton.getScene().setRoot(playMenu());
            }
        });

        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadButton.getScene().setRoot(loadMenu());
            }
        });

        optionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	optionButton.getScene().setRoot(optionMenu());
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.exit(0);
            }
        });

    	return wholeScreen;
    }

    public VBox playMenu(){
    	VBox vBox = new VBox();
    	vBox.setAlignment(Pos.CENTER);

        Button btn = new Button();
        btn.setText("Play");

        vBox.getChildren().addAll(btn);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	btn.getScene().setRoot(mMenu());
            }
        });

        return vBox;
    }

    public VBox loadMenu(){
    	VBox vBox = new VBox();
    	vBox.setAlignment(Pos.CENTER);

        Button btn = new Button();
        btn.setText("Load");

        vBox.getChildren().addAll(btn);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	btn.getScene().setRoot(mMenu());
            }
        });

        return vBox;
    }

    public VBox optionMenu(){
    	VBox vBox = new VBox();
    	vBox.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");

        vBox.getChildren().addAll(backBtn);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	backBtn.getScene().setRoot(mMenu());
            }
        });

        return vBox;
    }
}