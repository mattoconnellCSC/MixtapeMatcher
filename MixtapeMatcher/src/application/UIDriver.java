package application;

import javafx.stage.Stage;

/**
 * Driver class for UI screens.
 * @author Jordan
 *
 */
public class UIDriver implements Observer {
	private Stage stage;
	private GameDriver parent;
	
	/**
	 * Constructor :)
	 * @param stage: the stage the app is displayed on
	 * @param parent: GameDriver class, needed for LobbyCreator
	 */
	public UIDriver(Stage stage, GameDriver parent) {
		this.stage = stage;
		this.parent = parent;
	}
	
	public void setMainMenu() {
		MainMenuCreator menu = new MainMenuCreator(this);
		menu.setScene(stage, "Mixtape Matcher");
		stage.setWidth(1000.0);
		stage.setHeight(1000.0);
	}
	
	public void setLobby() {
		LobbyCreator lobby = new LobbyCreator(this, parent);
		lobby.setScene(stage, "Game Setup");
		stage.setWidth(1000.0);
		stage.setHeight(1000.0);
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public void setCreate(Stage stage) {
		CreatePlaylistCreator createPlaylist = new CreatePlaylistCreator(this);
		createPlaylist.setScene(stage, "Create Your Playlist");
		stage.setWidth(1000.0);
		stage.setHeight(1000.0);
	}

	@Override
	public void update(Object data) {
		String nextSceneName = (String) data;
		
		switch (nextSceneName) {
		case "lobby":
			setLobby();
			break;
		case "create":
			setCreate(stage);
			break;
		default:
			System.out.println("uh oh");
		}
		
	}
}
