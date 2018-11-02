package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomEvent {
	private int numEvents = 0;
	private ArrayList<Integer> pastEvents = new ArrayList<Integer>(numEvents);
	private static int currentEvent = 0;
	private Menu m = new Menu();
	private int randNum;
	private ArrayList<aRandomEvent> Events = new ArrayList<aRandomEvent>(numEvents);
	private static int counter = 0;
	
	public RandomEvent(){
		File file  = new File("RandomEvents.txt");
		Scanner fileScan, lineScan;
		int numBut;
		String images[];
		try {
			fileScan = new Scanner(file);
			fileScan.useDelimiter("\n");
			while(fileScan.hasNext()) {
				lineScan = new Scanner(fileScan.next());
				lineScan.useDelimiter(",");
				numBut = lineScan.nextInt();
				images = new String[numBut*2];
				for(int i = 0; i < numBut * 2; i++) {
					images[i] = lineScan.next();
				}
				this.Events.add(new aRandomEvent(lineScan.next(),images,numBut));
				lineScan.close();
				this.numEvents++;
			}
			fileScan.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
	}
			
	private class aRandomEvent{
		private String title;
		private aButton buttons[];
		private int numBut;
		private int j = 0;
		public aRandomEvent(String title, String images[], int numBut) {
			this.title = title;
			this.numBut = numBut;
			this.buttons = new aButton[numBut];
			for(int i = 0; i < numBut; i++) {
				this.buttons[i] = new aButton(images[j], images[j+1]);
				j = j + 2;
			} 
		}
	}
	
	private class aButton{
		private String image1,image2;
		public aButton(String image1, String image2) {
			this.image1 = image1;
			this.image2 = image2;
		}
	}
	
	public void initRandomEvent(Stage primaryStage, int screenWidth, int screenHeight, VBox randomEvent){
		Scene home = new Scene(randomEvent, screenWidth, screenHeight);
		
		primaryStage.setTitle(Events.get(randNum).title);
    	primaryStage.setScene(home);
    	primaryStage.show();
	}
	
	public VBox mRandomEvent(){
		randNum = getRandomNum();
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
    	Text title = new Text(Events.get(randNum).title);
    	title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
    	space.setFont(Font.font("Tahoma", FontWeight.NORMAL, 120));

    	/* Initializing buttons */
    	aRandomEvent E = Events.get(randNum);
    	Button buttons[] = new Button[E.numBut];
    	int j = 1;
    	for(int i = 0; i < E.numBut; i++) {
    		buttons[i] = new Button();
    		System.out.println(E.buttons[i].image1);
    		System.out.println(E.buttons[i].image2);
    		m.setButton(buttons[i], E.buttons[i].image1, E.buttons[i].image2);
    		grid.add(buttons[i], 0, j);
    		j++;
    	}

        /* Add buttons and text to the grid */
		titleGrid.add(space, 0, 0);
		titleGrid.add(title, 0, 0);

        stackPane.getChildren().addAll(menuImage, titleGrid, grid);
        wholeScreen.getChildren().addAll(stackPane);

        /* button actions */
    	for(int counter = 0; counter < E.numBut; counter++) {
    		buttons[counter].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                	int j = RandomEvent.counter;
                	buttons[j].getScene().setRoot(mRandomEvent());
                }
            });
    	}

    	return wholeScreen;
    }
	
	public int getRandomNum() {
		Random rand = new Random();
		int newEvent;
		if(currentEvent == numEvents) {
			pastEvents.clear();
			currentEvent = 0;
		}
		newEvent = rand.nextInt(numEvents);
		while(pastEvents.contains(newEvent))
			newEvent = rand.nextInt(numEvents);
		pastEvents.add(newEvent);
		currentEvent++;
		return newEvent;
	}
	
}
