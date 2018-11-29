package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;



public class EndingScreen {

	private final Double EDU_MAX = 20.0, SOC_MAX = 20.0;
	
	private GameManager gameManager;
	
	public EndingScreen(GameManager gameManager) {
		// Set gameManager
		this.gameManager = gameManager;
	}
	
	/*Calculates final score and returns an array with the scores; 
	 * [0] = Education Score
	 * [1] = Social Score
	 */
	private Double[] getFinalScore(GameManager gameManager)
	{
		Double [] finalScore = new Double [2];
		
		finalScore[0] = gameManager.player.getInt() / EDU_MAX * 100.0;
		finalScore[1] = gameManager.player.getChar() / SOC_MAX * 100.0;
		
		
		return finalScore;
		
	}
	
	private Text getFinalGrade(Double score)
	{
		Text finalGrade  = new Text();
		finalGrade.setTextAlignment(TextAlignment.CENTER);
		finalGrade.setStyle("-fx-font: 35px Tahoma; -fx-fill: #FFFFFF;");
		finalGrade.setText("This isn't working");
		
		if(score > 90.0)
		{
			finalGrade.setText("A");
		}
		else if(score > 80.0)
		{
			finalGrade.setText("B");
		}
		else if(score > 70.0)
		{
			finalGrade.setText("C");
		}
		else if (score > 60.0)
		{
			finalGrade.setText("D");
		}
		else
		{
			finalGrade.setText("F");
		}
		
		return finalGrade;
	}
	
	public VBox init_scene(int screenWidth, int screenHeight) {
		// Set VBox
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #035642");
        
        /* configuration for grid holding title and buttons */
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);
        
        // Title
        Text titleText = new Text();
        titleText.setText("Final Scores");
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setStyle("-fx-font: 35px Tahoma; -fx-fill: #FFFFFF;");

		HBox titleHBox = new HBox();
		titleHBox.getChildren().add(titleText);
		titleHBox.setMinHeight(screenHeight/4);
		titleHBox.setAlignment(Pos.CENTER);
		
		//Calculate Scores
		Double [] finalScores = new Double [2];
		finalScores = getFinalScore(gameManager);
		
		//Create boxes for grade text and set final grade
		HBox eduGrade = new HBox();
		HBox socGrade = new HBox();
		
		HBox eduScoreTextBox = new HBox();
		Text eduScoreText = new Text();
		eduScoreText.setText("Education Score:");
		eduScoreText.setTextAlignment(TextAlignment.CENTER);
		eduScoreText.setStyle("-fx-font: 35px Tahoma; -fx-fill: #FFFFFF;");
		
		HBox socScoreTextBox = new HBox();
		Text socScoreText = new Text();
		socScoreText.setText("Social Score:");
		socScoreText.setTextAlignment(TextAlignment.CENTER);
		socScoreText.setStyle("-fx-font: 35px Tahoma; -fx-fill: #FFFFFF;");

		
		eduScoreTextBox.getChildren().add(eduScoreText);
		socScoreTextBox.getChildren().add(socScoreText);
		
		
		eduGrade.getChildren().add(getFinalGrade(finalScores[0]));
		socGrade.getChildren().add(getFinalGrade(finalScores[1]));
		
		
		grid.add(eduScoreText, 1, 1);
		grid.add(eduGrade, 2, 1);
		grid.add(socScoreText, 1, 2);
		grid.add(socGrade, 2, 2);
		
		// Buttons
		Button mainMenuButton= new Button();
		mainMenuButton.setText("Main Menu");
		mainMenuButton.setId("optionButton");
		mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				gameManager.setPlayerInitialStats(codingWizardButton.getText());
//				gameManager.showNextTypingScene();
				new Main().start(gameManager.primaryStage);
			}
		});
		
		
		
		root.getChildren().addAll(titleHBox,
				grid,
				mainMenuButton);
        root.setAlignment(Pos.CENTER);
		
        return root;
	}
}
