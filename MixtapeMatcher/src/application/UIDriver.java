package application;

import javafx.stage.Stage;

public class UIDriver {
	private Stage stage;
	
	public UIDriver() {
		stage = new Stage();
	}
	
	public UIDriver(Stage stage) {
		this.stage = stage;
	}
	
	public void setMainMenu() {
		MainMenuCreator menu = new MainMenuCreator();
		menu.setScene(stage, "Mixtape Matcher");
	}
}
