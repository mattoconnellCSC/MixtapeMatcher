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
	private Lobby lobby;
	private int playerCount = -1;
	
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
	}
	
	public void setLobby() {
		LobbyCreator lobby = new LobbyCreator(this, parent);
		lobby.setScene(stage, "Game Setup");
	}
	
	public void setCreate() {
		CreatePlaylistCreator createPlaylist = new CreatePlaylistCreator(this);
		createPlaylist.setScene(stage, "Create Your Playlist");
	}
	
	public void setListen() {
		ListenCreator listenScreen = new ListenCreator(this);
		listenScreen.setScene(stage, "Listen to the Playlist");
	}

	@Override
	public void update(Object data) {
		String nextSceneName = (String) data;
		
		switch (nextSceneName) {
		case "lobby":
			setLobby();
			break;
		case "create":
			setCreate();
			break;
		case "listen":
			if(playerCount < 0) {
				playerCount = lobby.getPlayerList().size();
				setCreate();
				playerCount--;
				break;
			}
			else if(playerCount > 0) {
				setCreate();
				playerCount--;
			}
			else
				setListen();
			break;
		default:
			System.err.println("uh oh");
		}
		
	}
	public Stage getStage() {
		return this.stage;
	}
	
	
	//This is how the Game Driver will pass the Lobby object to the UI Driver
	public void giveLobby(Lobby l) {
		this.lobby = l;
	}
	
}
