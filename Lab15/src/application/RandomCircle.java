package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class RandomCircle extends Application {
	Circle circle = new Circle(10);
	Pane pane = new Pane();
	Scene scene = new Scene(pane, 400, 400);

	@Override
	public void start(Stage primaryStage) {
		circle.setStrokeWidth(2);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		circle.setCenterX(pane.getWidth() / 2);
		circle.setCenterY(pane.getHeight() / 2);
		pane.getChildren().add(circle);
		circle.setOnMouseClicked(new RCircleHandler());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lab15");
		primaryStage.show();

	}

	class RCircleHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent arg0) {
			circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			circle.setCenterX(Math.random() * (pane.getWidth() - 25) + 25);
			circle.setCenterY(Math.random() * (pane.getHeight() - 25) + 25);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
