package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11, 11, 11, 11));
        pane.setHgap(11);
        pane.setVgap(11);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(new Label("" + (int) (Math.random() * 9)), i, j);
            }

        }
        primaryStage.setTitle("Lab13 Application");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
