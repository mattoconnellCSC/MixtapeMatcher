package application;

import javafx.stage.Stage;

public class UIDriver implements Observer {
	private Stage stage;
	
	public UIDriver(Stage stage) {
		this.stage = stage;
	}
	
	public void setMainMenu(Stage stage) {
		MainMenuCreator menu = new MainMenuCreator(this);
		menu.setScene(stage, "Mixtape Matcher");
	}
	
	public void setLobby(Stage stage) {
		LobbyCreator lobby = new LobbyCreator(this);
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
