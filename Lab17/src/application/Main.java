package application;

import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	int index = 1;

	public void start(Stage primaryStage) throws FileNotFoundException {
		BorderPane bpane = new BorderPane();
		Image[] images = { new Image("1.jpg"), new Image("2.jpg"), new Image("3.jpg"), new Image("4.jpg") };
		ImageView imageView = new ImageView(images[0]);
		imageView.setFitHeight(400);
		imageView.setFitWidth(600);
		bpane.setCenter(imageView);
		EventHandler<ActionEvent> eventHandler = e -> {
			if (index < images.length) {
				imageView.setImage(images[index++]);
				if (index == images.length) {
					index = 0;
				}
			}
		};

		Timeline animation = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		imageView.setOnMouseClicked(e -> {
	        if (animation.getStatus() == Animation.Status.PAUSED) {
	          animation.play();
	        }
	        else {
	          animation.pause();
	        }
	      });
		Scene scene = new Scene(bpane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Animated image");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
