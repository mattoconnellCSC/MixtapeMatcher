package application;

import javafx.stage.Stage;

/**
 * Driver class for UI screens.
 * @author Jordan, Natalie
 *
 */
public class UIDriver implements Observer {
	private Stage stage;
	private GameDriver parent;
	private Lobby lobby;
	private int playlistsCreated = 0;
	
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
		CreatePlaylistCreator createPlaylist = new CreatePlaylistCreator(this, parent);
		createPlaylist.setScene(stage, "Create Your Playlist");
	}
	
	public void setListen() {
		ListenCreator listenScreen = new ListenCreator(this); //empty constructor
		listenScreen.setScene(stage, "Listen to the Playlist"); //empty function
	}
	
	public void setHelp() {
		HelpScreenCreator helpScreen = new HelpScreenCreator(this);
		helpScreen.setScene(stage, "Help Screen");
	}

	@Override
	public void update(Object data) {
		String nextSceneName = (String) data;
		
		switch (nextSceneName) {
		case "help":
			setHelp();
			break;
		case "mainmenu":
			setMainMenu();
			break;
		case "lobby":
			setLobby();
			break;
		case "create":
			setCreate();
			break;
		case "listen":
			playlistsCreated++;
			System.out.printf("Created %d/%d playlists!\n", playlistsCreated, lobby.getNumPlayers());
			if (playlistsCreated < lobby.getNumPlayers()) {
				setCreate();
			}
			else {
				setListen();
			}

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
