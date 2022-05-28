package application;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;

public class Main extends Application {
	BorderPane pane = new BorderPane();
	TextField url = new TextField();
	MediaPlayer mediaPlayer;
	boolean clicked;
	MediaView mediaView;
	HBox hBoxBottom = new HBox(10);
	HBox hBoxTop = new HBox(10);
	Button playButton = new Button(">");
	Button rewindButton = new Button("<<");
	Slider slVolume = new Slider();

	@Override
	public void start(Stage primaryStage) {
		url.prefWidthProperty().bind(pane.widthProperty().subtract(390));
		RadioButton rbURL = new RadioButton("URL");
		RadioButton rbDirectory = new RadioButton("Directory");
		ToggleGroup group = new ToggleGroup();
		rbURL.setToggleGroup(group);
		rbDirectory.setToggleGroup(group);
		Button btLoad = new Button("Load");
		btLoad.setOnAction(e -> {
			if (url.getText().length() != 0) {
				if (rbURL.isSelected()) {
					Media media = new Media(url.getText());
					mediaPlayer = new MediaPlayer(media);
					mediaView = new MediaView(mediaPlayer);
					mediaPlayer.stop();
					playButton.setText(">");
					mediaView.fitWidthProperty().bind(hBoxBottom.widthProperty());
					mediaView.fitHeightProperty().bind(pane.heightProperty().subtract(200));
					mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));
					pane.setCenter(mediaView);
					clicked = true;
				} else if (rbDirectory.isSelected()) {
					File file = new File(url.getText());
					if (file.exists()) {
						String MEDIA_URL = file.toURI().toString();
						Media media = new Media(MEDIA_URL);
						mediaPlayer = new MediaPlayer(media);
						mediaView = new MediaView(mediaPlayer);
						mediaPlayer.stop();
						playButton.setText(">");
						mediaView.fitWidthProperty().bind(hBoxBottom.widthProperty());
						mediaView.fitHeightProperty().bind(pane.heightProperty().subtract(200));
						mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));
						pane.setCenter(mediaView);
						clicked = true;
					} else {
						notification(3);
					}
				} else if (!rbDirectory.isSelected() && !rbURL.isSelected()) {
					notification(2);
				}
			} else {
				notification(1);
			}
		});
		playButton.setOnAction(e -> {
			if (clicked) {
				if (playButton.getText().equals(">")) {
					mediaPlayer.play();
					playButton.setText("||");
				} else {
					mediaPlayer.pause();
					playButton.setText(">");
				}
			} else {
				notification(1);
			}
		});

		rewindButton.setOnAction(e -> {
			if (clicked) {
				mediaPlayer.seek(Duration.ZERO);
			} else {
				notification(1);
			}
		});
		slVolume.setPrefWidth(150);
		slVolume.setMaxWidth(Region.USE_PREF_SIZE);
		slVolume.setMinWidth(30);
		slVolume.setValue(50);
		hBoxTop.setAlignment(Pos.CENTER);
		hBoxTop.getChildren().addAll(new Label("Inseert Directory or URL: "), url, rbURL, rbDirectory, btLoad);
		hBoxBottom.setAlignment(Pos.CENTER);
		hBoxBottom.getChildren().addAll(playButton, rewindButton, new Label("Volume"), slVolume);
		pane.setTop(hBoxTop);
		pane.setPadding(new Insets(10));
		pane.setCenter(new Pane());
		pane.setBottom(hBoxBottom);
		primaryStage.setMinWidth(500);
		primaryStage.setMinHeight(130);
		Scene scene = new Scene(pane, 650, 400);
		primaryStage.setTitle("Lab19");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void notification(int number) {
		BorderPane pane = new BorderPane();
		pane.setPrefWidth(300);
		pane.setPrefHeight(100);
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Notification");
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		pane.setPadding(new Insets(10));
		Button btOk = new Button("Ok");
		btOk.setPrefWidth(100);
		pane.setBottom(btOk);
		btOk.setOnAction(e -> {
			stage.close();
		});
		BorderPane.setAlignment(btOk, Pos.CENTER);
		Label label = new Label();
		BorderPane.setAlignment(label, Pos.CENTER_LEFT);
		if (number == 1) {
			label.setText("Please insert a URL or a directory.");
		} else if (number == 2) {
			label.setText("Please choose URL or Directory.");
		} else if (number == 3) {
			label.setText("Error: File does not exist.\nPlease insert a valid Directory.");
		}
		pane.setCenter(label);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
