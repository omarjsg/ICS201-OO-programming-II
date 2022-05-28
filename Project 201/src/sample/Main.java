package sample;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Main extends Application {
    BorderPane[] pane = { new BorderPane(), new BorderPane(), new BorderPane(), new BorderPane() };
    StackPane[] fields = { new StackPane(), new StackPane(), new StackPane(), new StackPane() };
    HBox timerBox = new HBox(), menuBar = new HBox();;
    VBox scoreBar = new VBox();
    FlowPane mainMenu = new FlowPane(), scoreBoardFlowPane = new FlowPane();
    Button btNext = new Button("Next round"), btStart = new Button("Start"), btExit = new Button("Give up"),
            btQuit = new Button("Quit Game"), btCredit = new Button("Credits"), btScores = new Button("Score board"),
            btCreditBack = new Button("Back"), btScoreBack = new Button("Back");
    Scene scene = new Scene(pane[0]);
    Scores score = new Scores();
    Timer timer = new Timer(score);


    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Scores.dat"));
        score.setScoreList((ArrayList<Integer>) inputStream.readObject());
        CardPane cardPane = new CardPane(score); // Where the cards will be displayed
        Text[] texts = { timer.getTimerText(), score.getTotalScoreText(), score.getMovesText(), score.getRoundsText() };
        Label[] labels = { new Label("Time:"), new Label("Score:"), new Label("Moves:"), new Label("Rounds") };
        scoreBoardFlowPane.setOrientation(Orientation.VERTICAL);
        scoreBoardFlowPane.setVgap(20);
        btStart.setPrefWidth(300);
        btQuit.setPrefWidth(300);
        btCredit.setPrefWidth(140);
        btScores.setPrefWidth(140);
        HBox CrScBox = new HBox(btCredit, btScores);
        CrScBox.setSpacing(20);
        btNext.setPrefWidth(150);
        btExit.setPrefWidth(150);
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setOrientation(Orientation.VERTICAL);
        mainMenu.setVgap(15);
        menuBar.setAlignment(Pos.CENTER);
        menuBar.setSpacing(50);
        menuBar.setPadding(new Insets(15));
        timerBox.setAlignment(Pos.CENTER);
        timerBox.setSpacing(30);
        scoreBar.setAlignment(Pos.BASELINE_LEFT);
        scoreBar.setSpacing(15);
        scoreBar.setPadding(new Insets(10));
        for (int i = 0; i < fields.length; i++) { // to add the timer, total scores, round moves, total rounds to the
            // game screen.
            Rectangle rectangle = new Rectangle(150, 30, Color.WHITE);
            fields[i].getChildren().addAll(rectangle, texts[i]);
            rectangle.setArcHeight(20);
            rectangle.setArcWidth(20);
            scoreBar.getChildren().addAll(labels[i], fields[i]);

        }
        mainMenu.getChildren().addAll(btStart, CrScBox, btQuit); // To add the main menu buttons.
        menuBar.getChildren().addAll(btExit, btNext);
        pane[0].setCenter(mainMenu); // To put the main menu buttons to the center of the main menu.
        pane[0].setPrefSize(500, 500);
        btStart.setOnAction(e -> { // to start the game.
            scene.setRoot(pane[1]);
            primaryStage.setWidth(650);
            primaryStage.setHeight(560);
            timer.StartingButton();
            score.StartingButton();
        });
        btNext.setOnAction(e -> { // to flip all the cards.
            if (score.getMatchedCounter() == score.getMaxMatched()) {
                cardPane.resetAll();
                score.nextButton();
                timer.nextButton();
            }
        });
        btScores.setOnAction(e -> {


            score.getScoreList().sort(null);
            String str = "" ;
            for (int i = 0 ; i < score.getScoreList().size()  ; i ++)
            {

                System.out.println("Score#" + (i+1) +": "+ score.getScoreList().get(i));
                str+="Score#" + (i+1) + ": "+ score.getScoreList().get(i) + "\n" ;

            }
            Text text = new Text(str);
            scoreBoardFlowPane.getChildren().add(text);
            btScoreBack.setPrefWidth(150);

            HBox btBackPane = new HBox(btScoreBack);

            btBackPane.setPadding(new Insets(15));

            btBackPane.setAlignment(Pos.CENTER);

            pane[3].setCenter(scoreBoardFlowPane);

            pane[3].setBottom(btBackPane);
            scene.setRoot(pane[3]);
        });
        btExit.setOnAction(e -> { // to exit the cards screen (switching panes).
            scene.setRoot(pane[0]);
            try {
                score.giveUpButton();
            } catch (IOException e1) {
                System.err.println("File does not exist.");
            }
            cardPane.resetAll();
            primaryStage.setWidth(500);
            primaryStage.setHeight(500);
            timer.giveUpButton();
        });
        btScoreBack.setOnAction( e -> {

            scene.setRoot(pane[0]);

        });
        btCredit.setOnAction(e -> {
            scene.setRoot(pane[2]);
            primaryStage.setWidth(500);
            primaryStage.setHeight(300);
        });
        btCreditBack.setOnAction(e -> {
            scene.setRoot(pane[0]);
            primaryStage.setWidth(500);
            primaryStage.setHeight(500);
        });
        btQuit.setOnAction(e -> {
            primaryStage.close();
        });
        pane[1].setTop(menuBar); // adding the menuBar to the game screen.
        pane[1].setLeft(cardPane); // adding the cards to the game screen.
        pane[1].setCenter(scoreBar); // adding the scorBar to the game screen.
        pane[2].setBottom(btCreditBack);
        primaryStage.setResizable(false); // to prevent resizing the window.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
