package application;

import javafx.stage.Stage;

public class UIDriver implements Observer {
	private Stage stage;
	private GameDriver parent;
	
	public UIDriver(Stage stage, GameDriver parent) {
		this.stage = stage;
		this.parent = parent;
	}
	
	public void setMainMenu(Stage stage) {
		MainMenuCreator menu = new MainMenuCreator(this);
		menu.setScene(stage, "Mixtape Matcher");
	}
	
	public void setLobby(Stage stage) {
		LobbyCreator lobby = new LobbyCreator(this, parent);
		lobby.setScene(stage, "Game Setup");
	}

	@Override
	public void update(Object data) {
		String nextSceneName = (String) data;
		
		switch (nextSceneName) {
		case "lobby":
			setLobby(stage);
			break;
		default:
			System.out.println("uh oh");
		}
		
	}
}
