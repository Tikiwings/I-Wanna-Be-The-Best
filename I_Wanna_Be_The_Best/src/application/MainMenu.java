package IWannaBeTheBest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainMenu {

	public MainMenu() {
		// TODO Auto-generated constructor stub
	}

	public VBox mMenu(){
		/* for background */
		Image image = new Image("big_header.png");
		ImageView menuImage = new ImageView();
		menuImage.setImage(image);

		/* To stack buttons and text over image */
		StackPane stackPane = new StackPane();

		/*
		 * wholeScreen: entire screen which will contain a grid holding
		 * 			    a VBox of buttons and a title screen
		 *
		 * buttons:		a VBox that holds 3 buttons - play, load, and options
		 */
		VBox wholeScreen = new VBox();
    	VBox buttons = new VBox();

    	/* configuration for buttons Vbox */
    	buttons.setAlignment(Pos.CENTER);
    	buttons.setSpacing(15);

    	/* configuration for wholescreen VBox */
    	wholeScreen.setAlignment(Pos.CENTER);

    	/* configuration for grid holding title and buttons */
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);

    	 /* Initializing title text */
    	Text title = new Text("I Wanna Be The Best");
    	title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

    	/* Initializing buttons */
        Button btnPlay = new Button("Start New Game");
        Button btnLoad = new Button("Load");
        Button btnOption = new Button("Options");

        /* Add grid to the scene */
        buttons.getChildren().addAll(btnPlay, btnLoad, btnOption);

        /* Add buttons and text to the grid */
        grid.add(title, 0, 0);
        grid.add(buttons, 0, 2);


        stackPane.getChildren().addAll(menuImage, grid);
        wholeScreen.getChildren().add(stackPane);

        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	btnPlay.getScene().setRoot(playMenu());
            }
        });

        btnLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	btnLoad.getScene().setRoot(loadMenu());
            }
        });

        btnOption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	btnOption.getScene().setRoot(optionMenu());
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
