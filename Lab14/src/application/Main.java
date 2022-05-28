package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create a scene and place it in the stage
			StackPane pane = new StackPane();
			Scene scene = new Scene(pane, 400, 400);
			pane.setPadding(new Insets(5, 5, 5, 5));
			pane.setAlignment(Pos.CENTER);
			Polygon polygon = new Polygon();
			polygon.setFill(Color.RED);
			polygon.setStroke(Color.BLACK);
			polygon.setStrokeWidth(10);
			
			ObservableList<Double> list = polygon.getPoints();
			double centerX = pane.getWidth() / 2;
			double centerY = pane.getHeight() / 2;
			double radius = Math.min(pane.getWidth(), pane.getHeight()) * 0.4;
			// Add points to the polygon list
			for (int i = 0; i < 8; i++) {
				list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
				list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
			}
			polygon.setRotate(22.5);
			pane.getChildren().add(polygon);
			
			Text text = new Text("STOP");
			text.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 90));
			text.setFill(Color.WHITE);
			pane.getChildren().add(text);
			System.out.println(pane.getWidth());

			primaryStage.setTitle("ShowPolygon"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
