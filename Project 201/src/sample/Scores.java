package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Scores implements Comparable<Scores>, Cloneable {

    private  int previousTime, matchedTime, roundMoves, previousMoves, roundsCounter = 0;
    private int totalMoves, totalScore;
    private Timeline timeline;
    private Text totalScoreText = new Text("" + totalScore), movesText = new Text("" + roundMoves),
            roundsText = new Text("" + roundsCounter), scoreMessage = new Text("");
    private  ArrayList<Integer> scoreList = new ArrayList<>();
    private AnimationTimer timerAnimation;
    private static int maxMatched;
    private int matchedCounter;
    private Date dateCreated;
    File score = new File("Scores.dat");

    Scores() {
        dateCreated = new Date();
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        timerAnimation = new AnimationTimer() {
            @Override
            public void handle(long l) {
            }
        };
        Duration duration = Duration.millis(500);
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                totalScoreText.setText("" + totalScore);
                roundsText.setText("" + roundsCounter);
                movesText.setText("" + roundMoves);
            }
        };
        KeyFrame keyFrame = new KeyFrame(duration, onFinished);
        timeline.getKeyFrames().add(keyFrame);

    }

    public void calculateScore() {
        matchedTime = calcMatchedTime();
        int matchPeriod = matchedTime - previousTime;
        int matchMoves = roundMoves - previousMoves;
        System.out.println("match period: " + matchPeriod + " seconds");
        if (matchMoves <= 1) {
            totalScore += 10;
        } else if (matchMoves > 1 && matchMoves <= 2) {
            totalScore += 7;
        } else if (matchMoves > 2 && matchMoves <= 3) {
            totalScore += 5;
        } else if (matchMoves > 3 && matchMoves <= 5) {
            totalScore += 3;
        } else {
            totalScore++;
        }
        previousMoves = roundMoves;
        if (matchPeriod < 3 && matchPeriod >= 0) {
            totalScore += 10;
            System.out.println("Bonus: " + 10 + " points");
        } else if (matchPeriod >= 3 && matchPeriod < 5) {
            totalScore += 7;
            System.out.println("Bonus: " + 7 + " points");
        } else if (matchPeriod >= 5 && matchPeriod < 7) {
            totalScore += 5;
            System.out.println("Bonus: " + 5 + " points");
        } else if (matchPeriod >= 7 && matchPeriod < 10) {
            totalScore += 3;
            System.out.println("Bonus: " + 3 + " points");
        } else if (matchPeriod >= 10) {
            totalScore++;
            System.out.println("Bonus: " + 1 + " points");
        }
        previousTime = matchedTime;
    }
    // to calculate the time when two cards are matched.
    private int calcMatchedTime() {
        return Timer.getMinutes() * 60 + Timer.getSeconds();
    }

    @Override

    public int compareTo(Scores pastScore) {
        if (totalScore  < pastScore.getTotalScore()  ) {
            return 1;
        } else if (totalScore  > pastScore.getTotalScore() ) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Scores copy = (Scores) super.clone();
        copy.dateCreated = (Date) dateCreated.clone();
        return copy;
    }

    public void StartingButton() {
        timerAnimation.start();
        System.out.println("Started...");
        timeline.play();
    }

    public void nextButton() {
        System.out.println("Started a next round...");
        matchedCounter = 0;
        roundsCounter++;
        totalMoves += roundMoves;
        roundMoves = 0;

    }

    public void giveUpButton() throws IOException {
        timerAnimation.stop();
        System.out.println("Ended!");
        timeline.pause();
        if (matchedCounter == maxMatched) {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(score));
            scoreList.add(totalScore);
            scoreList.sort(null);
            outputStream.writeObject(scoreList);
            outputStream.close();
            totalScore = 0;
            roundMoves = 0;
            roundsCounter = 0;
            matchedCounter = 0;
            System.out.println("All counters have been reseted, game points have been added.");
        } else {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(score));
            scoreList.add(totalScore);
            scoreList.sort(null);
            outputStream.writeObject(scoreList);
            outputStream.close();
            Stage stage = new Stage();
            stage.setHeight(200);
            stage.setWidth(500);
            Button btOk = new Button("OK");
            btOk.setPrefWidth(100);
            btOk.setOnAction(e -> {
                stage.close();
            });
            HBox hbox = new HBox(btOk);
            hbox.setPadding(new Insets(5));
            hbox.setAlignment(Pos.CENTER);
            VBox vbox = new VBox(new StackPane(scoreMessage), hbox);
            vbox.setAlignment(Pos.CENTER);
            scoreMessage.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
            scoreMessage.setText("High score:   " + scoreList.get(scoreList.size() - 1)
                    + "\nYour score:   " + getTotalScore());
            stage.setScene(new Scene(vbox));
            stage.setTitle("Notification");
            stage.show();
            totalScore = 0;
            roundMoves = 0;
            roundsCounter = 0;
            matchedCounter = 0;
            System.out.println("All counters have been reseted, game points have been added.");
        }

    }

    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public int getRoundMoves() {
        return roundMoves;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getPreviousTime() {
        return previousTime;
    }

    public void setPreviousTime(int previousTime) {
        this.previousTime = previousTime;
    }

    public int getMatchedTime() {
        return matchedTime;
    }

    public void setMatchedTime(int matchedTime) {
        this.matchedTime = matchedTime;
    }

    public int getMatchedCounter() {
        return matchedCounter;
    }

    public void setMatchedCounter(int matchedCounter) {
        this.matchedCounter = matchedCounter;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRoundsCounter() {
        return roundsCounter;
    }

    public void setRoundsCounter(int roundsCounter) {
        this.roundsCounter = roundsCounter;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Text getTotalScoreText() {
        return totalScoreText;
    }

    public void setTotalScoreText(Text totalScoreText) {
        this.totalScoreText = totalScoreText;
    }

    public Text getMovesText() {
        return movesText;
    }

    public void setMovesText(Text movesText) {
        this.movesText = movesText;
    }

    public Text getRoundsText() {
        return roundsText;
    }

    public void setRoundsText(Text roundsText) {
        this.roundsText = roundsText;
    }

    public AnimationTimer getTimerAnimation() {
        return timerAnimation;
    }

    public void setTimerAnimation(AnimationTimer timerAnimation) {
        this.timerAnimation = timerAnimation;
    }

    public int getMaxMatched() {
        return maxMatched;
    }

    public void setMaxMatched(int maxMatched) {
        Scores.maxMatched = maxMatched;
    }

    public void setRoundMoves(int moves) {
        this.roundMoves = moves;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return String.format("Score: %d, moves: ", totalScore, totalMoves);
    }
}
