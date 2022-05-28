package application;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ColorBar extends VBox {

	public ColorBar(SceneLabel label) {
		setSpacing(10);
		ScrollBar red = new ScrollBar();
		Label redLabel = new Label("0");
		HBox redBox = new HBox(red, redLabel);
		redBox.setSpacing(10);
		red.setMin(0);
		red.setMax(255);
		red.setPrefWidth(400);
		ScrollBar green = new ScrollBar();
		Label greenLabel = new Label("0");
		HBox greenBox = new HBox(green, greenLabel);
		greenBox.setSpacing(10);
		green.setMin(0);
		green.setMax(255);
		green.setPrefWidth(400);
		ScrollBar blue = new ScrollBar();
		Label blueLabel = new Label("0");
		HBox blueBox = new HBox(blue, blueLabel);
		blueBox.setSpacing(10);
		blue.setMin(0);
		blue.setMax(255);
		blue.setPrefWidth(400);
		ScrollBar opacity = new ScrollBar();
		Label opacityLabel = new Label("0");
		HBox opacityBox = new HBox(opacity, opacityLabel);
		opacityBox.setSpacing(10);
		opacity.setMin(0);
		opacity.setMax(100);
		opacity.setPrefWidth(400);
		red.valueProperty().addListener(ov -> {

			label.setTextFill(Color.rgb(((int) red.getValue()), ((int) green.getValue()), ((int) blue.getValue()),
					opacity.getValue() / 100));
			redLabel.setText("" + (int) red.getValue());
		});
		green.valueProperty().addListener(ov -> {

			label.setTextFill(Color.rgb(((int) red.getValue()), ((int) green.getValue()), ((int) blue.getValue()),
					opacity.getValue() / 100));
			greenLabel.setText("" + (int) green.getValue());
		});
		blue.valueProperty().addListener(ov -> {
			label.setTextFill(Color.rgb(((int) red.getValue()), ((int) green.getValue()), ((int) blue.getValue()),
					opacity.getValue() / 100));
			blueLabel.setText("" + (int) blue.getValue());
		});
		opacity.valueProperty().addListener(ov -> {
			label.setTextFill(Color.rgb(((int) red.getValue()), ((int) green.getValue()), ((int) blue.getValue()),
					opacity.getValue() / 100));
			opacityLabel.setText("" + (int) opacity.getValue());
		});
		getChildren().addAll(new Label("Red:"), redBox, new Label("Green:"), greenBox, new Label("Blue"), blueBox,
				new Label("Opacity"), opacityBox);
	}

}
