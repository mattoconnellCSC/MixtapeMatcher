package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.stage.Stage;

/**
 * Driver class for UI screens.
 * @author Jordan, Natalie, Matt
 *
 */
public class UIDriver implements Observer {
	private Stage stage;
	private GameDriver parent;
	private Lobby lobby;
	private int playlistsCreated = 0;
	private int playersGuessed = 0;
	private int playlistsPlayed = 0;
	private ArrayList<Player> randomizedPlayerList;
	private int playerCounter = 0;
	private boolean randomized = false;
	
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
		LobbyCreator lobbyCreator = new LobbyCreator(this, parent);
		lobbyCreator.setScene(stage, "Game Setup");
	}
	
	public void setCreate() {
		CreatePlaylistCreator createPlaylist = new CreatePlaylistCreator(this, parent);
		createPlaylist.setScene(stage, "Create Your Playlist");
	}
	
	public void setListen() {
		if(!randomized) {
			randomizedPlayerList = new ArrayList<>(lobby.getPlayerList());
			Collections.shuffle(randomizedPlayerList);
			randomized = true;
		}
		ListenCreator listenScreen = new ListenCreator(this, randomizedPlayerList.get(playerCounter++)); //empty constructor
		listenScreen.setScene(stage, "Listen to the Playlist"); //empty function
	}
	public void setGuess() {
		GuessCreator guessScreen = new GuessCreator(this, lobby);
		guessScreen.setScene(stage,  "Make your Guess!");
	}
	
	public void setResults() {
		ResultsCreator resultsScreen = new ResultsCreator(this, lobby);
		resultsScreen.setScene(stage, "Let's see the results...");
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
			if (playlistsCreated <= lobby.getNumPlayers()+1) {
				setCreate();
				break;
			}
			else {
				setListen();
				break;
			}
		case "guess":
			setGuess();
			break;
		case "results":
			if(playersGuessed++ < lobby.getNumPlayers() - 1) {
				setGuess();
				break;
			}
			else if(playlistsPlayed++ < lobby.getNumPlayers() - 1) {
				playersGuessed = 0;
				setListen();
				break;
			}
			else {
				setResults();
				break;
			}
		default:
			break;
		}
		
	}
	public Stage getStage() {
		return this.stage;
	}
	
	public Lobby getLobby() {
		return this.lobby;
	}
	
	
	//This is how the Game Driver will pass the Lobby object to the UI Driver
	public void giveLobby(Lobby l) {
		this.lobby = l;
	}
	
}
