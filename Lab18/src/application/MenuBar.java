package application;

import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

public class MenuBar extends HBox {
	int fontSize = 20;
	String fontType = "Times New Roman";

	public MenuBar(SceneLabel label) {
		setPadding(new Insets(5, 5, 5, 5));
		setSpacing(10);
		setAlignment(Pos.CENTER);
		TextField tf = new TextField();
		label.setFont(Font.font(fontType, fontSize));
		tf.setOnAction(e -> {
			label.setText(tf.getText());
		});
		ComboBox<String> sizeComboBox = new ComboBox<>();
		ComboBox<String> fontComboBox = new ComboBox<>();
		CheckBox chkBold = new CheckBox("Bold");
		CheckBox chkItalic = new CheckBox("Italic");
		fontComboBox.setPrefWidth(150);
		String[] sizeArray = getSize();
		ObservableList<String> sizes = FXCollections.observableArrayList(sizeArray);
		ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFontNames());
		sizeComboBox.getItems().addAll(sizes);
		fontComboBox.getItems().addAll(fonts);
		sizeComboBox.setOnAction(e -> {
			fontSize = Integer.parseInt(sizeComboBox.getValue());
			label.setFont(new Font(fontType, fontSize));

		});
		fontComboBox.setOnAction(e -> {
			fontType = fontComboBox.getValue();
			label.setFont(new Font(fontType, fontSize));

		});

		EventHandler<ActionEvent> handler = e -> {
			if (chkBold.isSelected() && chkItalic.isSelected()) {
				label.setFont(Font.font(fontType, FontWeight.BOLD, FontPosture.ITALIC, fontSize));
			} else if (chkBold.isSelected()) {
				label.setFont(Font.font(fontType, FontWeight.BOLD, fontSize));
			} else if (chkItalic.isSelected()) {
				label.setFont(Font.font(fontType, FontWeight.MEDIUM, FontPosture.ITALIC, fontSize));
			} else {
				label.setFont(Font.font(fontType, fontSize));

			}
		};
		chkBold.setOnAction(handler);
		chkItalic.setOnAction(handler);
		getChildren().addAll(new Label("Enter any text: "), tf, new Label("Size: "), sizeComboBox, new Label("Font: "),
				fontComboBox, chkBold, chkItalic);
	}

	private String[] getSize() {
		String[] size = new String[100];
		for (int i = 0; i < size.length; i++) {
			size[i] = "" + (i + 1);
		}
		return size;
	}
}
