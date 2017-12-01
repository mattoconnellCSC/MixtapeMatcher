package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListenCreator extends SceneCreator {

	public ListenCreator(Observer o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene createScene(Stage stage) {
		AnchorPane anchor = new AnchorPane();
		HBox header = new HBox();
		Label title = new Label("Now you're Listening");
		title.getStyleClass().add("label-title");
		header.getChildren().add(title);
		
		
		anchor.getChildren().addAll(header);
		Scene listenScene = new Scene(anchor, 800, 800);
		listenScene.getStylesheets().add("application/application.css");
		return listenScene;
	}

}
