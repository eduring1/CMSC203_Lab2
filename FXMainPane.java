import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {

	private Button helloButton;
	private Button howdyButton;
	private Button chineseButton;
	private Button clearButton;
	private Button exitButton;

	private Label feedbackLabel;
	private TextField feedbackField;

	private HBox buttonBox;
	private HBox textBox;

	FXMainPane() {

		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");

		feedbackLabel = new Label("Feedback:");
		feedbackField = new TextField();

		buttonBox = new HBox();
		textBox = new HBox();

		ButtonHandler handler = new ButtonHandler();

		helloButton.setOnAction(handler);
		howdyButton.setOnAction(handler);
		chineseButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		exitButton.setOnAction(handler);

		textBox.getChildren().addAll(feedbackLabel, feedbackField);

		buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);

		textBox.setAlignment(Pos.CENTER);
		buttonBox.setAlignment(Pos.CENTER);

		HBox.setMargin(feedbackLabel, new Insets(10));
		HBox.setMargin(feedbackField, new Insets(10));
		HBox.setMargin(helloButton, new Insets(10));
		HBox.setMargin(howdyButton, new Insets(10));
		HBox.setMargin(chineseButton, new Insets(10));
		HBox.setMargin(clearButton, new Insets(10));
		HBox.setMargin(exitButton, new Insets(10));

		getChildren().addAll(textBox, buttonBox);
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (event.getSource() == helloButton) {
				feedbackField.setText("Hello");
			} else if (event.getSource() == howdyButton) {
				feedbackField.setText("Howdy");
			} else if (event.getSource() == chineseButton) {
				feedbackField.setText("Ni Hao");
			} else if (event.getSource() == clearButton) {
				feedbackField.clear();
			} else if (event.getSource() == exitButton) {
				Platform.exit();
			}
		}
	}
}