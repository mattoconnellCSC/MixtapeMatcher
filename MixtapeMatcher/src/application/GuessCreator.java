package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@java.lang.SuppressWarnings("squid:S1604")

/**
 * UI Screen for the Guess part of the game 
 * @author Will
 *
 */

public class GuessCreator extends SceneCreator {
	private ObservableList<Song> songs = FXCollections.observableArrayList();
	private ListView<Song> playlist = new ListView<>(songs);
	public ToggleGroup tg = new ToggleGroup();

	private Lobby l;
	private ArrayList<Player> players;
	private Player currentPlayer;
	private Playlist currentPlaylist;
	private String answer;
	private int numPlayers;
	private int i = 0;
	private Label titleText = new Label();
		
	public GuessCreator(Observer o, Lobby l) {
		super(o);
		this.l = l;
		currentPlaylist = l.getCurrentPlaylist();
		players = l.getPlayerList();
		numPlayers = l.getNumPlayers();
		findAnswer();
		updateCurrentPlayer();
	}
	
	//determine which player is the correct guess
	public void findAnswer() {
		for (Player p : players) {
			if (p.getPlaylist().getName().compareTo(currentPlaylist.getName()) == 0) {
				answer  = p.getName();
				break;
			}
		}
	}
	
	//change the active player
	public void updateCurrentPlayer() {
		if (i < numPlayers) {
			currentPlayer = players.get(i);
			titleText.setText("Make Your Guess " + currentPlayer.getName());
		}
		
		
		i++;
	}

	@Override
	public Scene createScene(Stage stage) {
		
		Guess guessMaker = new Guess(currentPlayer, answer);
		
		// Using an Anchor Pane as the root pane in this screen
				AnchorPane anchor = new AnchorPane();
				anchor.setPadding(new Insets(10, 10, 10, 10));
						
				//Screen Title displayed and anchored at top
				titleText.getStyleClass().add("label-title");
				titleText.setAlignment(Pos.CENTER);
				HBox titleBox = new HBox();
				titleBox.setPadding(new Insets(15, 10, 10, 10));
				titleBox.getChildren().add(titleText);
				titleBox.setAlignment(Pos.TOP_CENTER);
				
				AnchorPane.setTopAnchor(titleBox, null);
				
				VBox rightVBox = new VBox();
				VBox leftVBox = addLeftVBox();
				VBox bottomVBox = new VBox();
				
				//Player Guess Button(s)
				for (int j=0; j < numPlayers; j++) {
					ToggleButton playerButton = new ToggleButton();	
					playerButton.setToggleGroup(tg);
					playerButton.setText(players.get(j).getName());
					playerButton.setPrefWidth(150.0);
				
					//Player Guess Button Functionality
					playerButton.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							currentPlayer.setGuess(playerButton.getText());
						}
					});
					
					rightVBox.getChildren().add(playerButton);
				}
				
				rightVBox.setSpacing(10.0);
				rightVBox.setAlignment(Pos.CENTER_RIGHT);
				
				//Confirm Guess Button
				Button confirmButton = new Button();
				confirmButton.setText("Confirm Guess");
				confirmButton.setPrefWidth(150.0);
				
				//Confirm Guess Button Functionality
				confirmButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (currentPlayer.getGuess() != null) {
							currentPlayer = guessMaker.setScore();
							//gamedriver.lobby.getplayers(index) = current playerS
							updateCurrentPlayer();
							guessMaker.setCurrentPlayer(currentPlayer);
						}
						
						notifyObserver("results");
					}
				});
				
				bottomVBox.getChildren().add(confirmButton);
				bottomVBox.setSpacing(10.0);
				bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
				
				leftVBox.setAlignment(Pos.TOP_LEFT);
				
				GridPane inputGrid = new GridPane();
				inputGrid.setHgap(20.0);
				inputGrid.setVgap(10.0);
				inputGrid.setPadding(new Insets(10, 10, 10, 10));
				GridPane.setConstraints(leftVBox, 0, 0, 10, 30, null, null, null, null, null);
				GridPane.setConstraints(rightVBox, 10, 5, 5, 5, null, null, null, null, null);
				GridPane.setConstraints(bottomVBox, 7, 30, 6, 5, null, null, null, null, null);
				inputGrid.getChildren().addAll(rightVBox, leftVBox, bottomVBox);
				
				AnchorPane.setLeftAnchor(inputGrid, 10.0);
				AnchorPane.setRightAnchor(inputGrid, 10.0);
				AnchorPane.setTopAnchor(inputGrid, 100.0);
				AnchorPane.setBottomAnchor(inputGrid, 100.0);
				
				anchor.getChildren().addAll(titleBox, inputGrid);
				
				//vbox for displaying current playlist
						
				
				Scene cgScene = new Scene(anchor, 500, 500);
				
		

		cgScene.getStylesheets().add("application/application.css");
		return cgScene;
	}
	
	public VBox addLeftVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane playlistGrid = new GridPane();
		playlistGrid.setPadding(new Insets(10, 10, 10, 10));
		playlistGrid.setVgap(10.0);
		
		Label playListTitle = new Label(currentPlaylist.getName());
		
		for (Song s : currentPlaylist.getSongs())
			songs.add(s);
		
		playlist.setPrefSize(300, 400);
		
		GridPane.setConstraints(playListTitle, 0, 0, 3, 1, null, null, null, null, null);
		GridPane.setConstraints(playlist, 0, 1, 3, 4, null, null, null, null, null);
		
		playlistGrid.getChildren().addAll(playListTitle, playlist);
		vbox.getChildren().add(playlistGrid);
		
		return vbox;
	}

}
