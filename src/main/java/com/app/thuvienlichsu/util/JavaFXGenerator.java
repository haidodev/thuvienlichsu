package com.app.thuvienlichsu.util;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class JavaFXGenerator {
    public static Label createWrappedLabel(String text) {
        Label label = new Label();
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setWrapText(true);

        TextFlow textFlow = new TextFlow();
        Text textNode = new Text(text);
        textFlow.getChildren().add(textNode);
        label.setGraphic(textFlow);

        return label;
    }
    public static Label createWrappedTitle(String text) {
        Label label = new Label(text);
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(new Font(20));
        label.setPrefWidth(450);
        label.setWrapText(true);
        return label;
    }
}
