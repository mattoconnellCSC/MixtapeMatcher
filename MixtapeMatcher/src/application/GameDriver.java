package application;
import javafx.application.Application;
import javafx.stage.Stage;


public class GameDriver extends Application implements Observer {
	private Lobby lobby = new Lobby();
	private UIDriver driver;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
	    	driver = new UIDriver(primaryStage, this);	    	
	    	driver.setMainMenu();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	//this update is for the Lobby Object; updates different ways based on the data it is sent
	public void update(Object data) {
		if (data.getClass() == Lobby.class) {
			//initialize lobby; from LobbyCreator
			Lobby l = (Lobby) data;
			this.lobby = l;
		}
		
		else if (data.getClass() == Player.class) {
			//set Players and their Playlists; from CreatePlaylistCreator
			lobby.addPlayer((Player) data);
			
		}
		
		
		driver.giveLobby(this.lobby);
	}
	
	public Lobby getLobby() {
		return this.lobby;
	}
}
