package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class Main extends Application {

	public void start(Stage primaryStage) {
		BorderPane paneForScene = new BorderPane();
		SceneLabel label = new SceneLabel();
		paneForScene.setPadding(new Insets(20));
		paneForScene.setTop(new MenuBar(label));
		StackPane paneForLabel = new StackPane();
		paneForLabel.setPrefSize(800, 200);
		paneForLabel.getChildren().add(label);
		paneForScene.setCenter(paneForLabel);
		paneForScene.setBottom(new ColorBar(label));
		Scene scene = new Scene(paneForScene);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Lab 18");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
