package application;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * UI Screen for the Create Playlist part of the game 
 * @author Matt
 *
 */

public class CreatePlaylistCreator extends SceneCreator{

	public ObservableList<Song> songs = FXCollections.observableArrayList();
	public ObservableList<Song> mySongs = FXCollections.observableArrayList();

	public ListView<Song> searchResults = new ListView<Song>(songs);
	public ListView<Song> playlist = new ListView<Song>(mySongs);
	
	// change to be an input box, save input
	public String currentPlayerName = "Player Name";
	public String playlistTitle = "Playlist Title";
	public int maxSongs, numSongs=0;
	
	public CreatePlaylistCreator(Observer o, Lobby lobby) {
		super(o);
		maxSongs = lobby.getMaxSongs();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene createScene(Stage stage) {
		
		
		// Using an Anchor Pane as the root pane in this screen
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));
		
		
				
		//Screen Title displayed and anchored at top
		Label titleText = new Label("Create Your Playlist");
		titleText.getStyleClass().add("label-title");
		titleText.setAlignment(Pos.CENTER);
		HBox titleBox = new HBox();
		titleBox.setPadding(new Insets(15, 10, 10, 10));
		titleBox.getChildren().add(titleText);
		titleBox.setAlignment(Pos.TOP_CENTER);
		
		AnchorPane.setTopAnchor(titleBox, null);
		
		//Horizontal Box (anchored to top right) with a variable text denoting current player
		
		HBox playerStatus = new HBox();
		playerStatus.setPadding(new Insets(15, 10, 10, 10));
		playerStatus.setSpacing(15);
		
		Label currentPlayerText = new Label("Current Player:");
		Label playerName = new Label(currentPlayerName);
		playerStatus.getChildren().addAll(currentPlayerText, playerName);
		
		AnchorPane.setTopAnchor(playerStatus, 7.5);
		AnchorPane.setRightAnchor(playerStatus, 10.0);
		
		
		//Search Box and Results displayed in Center anchor with Playlist and Add Button
		VBox leftVBox = addLeftVBox(songs);
		VBox rightVBox = addRightVBox(mySongs);
		VBox centerVBox = new VBox();
		Button addButton = new Button();
		addButton.setText("Add Song");
		addButton.setPrefWidth(150.0);
			//Add Song Button Functionality
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Song selectedSong = searchResults.getSelectionModel().getSelectedItem();
				if (selectedSong != null && numSongs < maxSongs) {
					mySongs.add(selectedSong);
					numSongs++;
				}
			}
		});
		//Delete Song button and Functionality
		Button delButton = new Button();
		delButton.setText("Delete Song");
		delButton.setPrefWidth(150.0);
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				mySongs.remove(playlist.getSelectionModel().getSelectedIndex());
				numSongs--;
			}
		});
		centerVBox.getChildren().addAll(addButton, delButton);
		centerVBox.setSpacing(10.0);
		centerVBox.setAlignment(Pos.CENTER);
		GridPane inputGrid = new GridPane();
		inputGrid.setHgap(20.0);
		inputGrid.setVgap(10.0);
		inputGrid.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setConstraints(leftVBox, 0, 0, 3, 4, null, null, null, null, null);
		GridPane.setConstraints(centerVBox, 3, 3, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(rightVBox, 6, 0, 3, 4, null, null, null, null, null);
		
		inputGrid.getChildren().addAll(leftVBox, centerVBox, rightVBox);
		
		AnchorPane.setLeftAnchor(inputGrid, 10.0);
		AnchorPane.setRightAnchor(inputGrid, 10.0);
		AnchorPane.setTopAnchor(inputGrid, 100.0);
		AnchorPane.setBottomAnchor(inputGrid, 100.0);
		
		
		// Button to Save playlist anchored to bottom right of page
		Button saveButton = new Button();
		saveButton.setText("Save Playlist");
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				notifyObserver("listen");
				
				Playlist playlist = new Playlist(playlistTitle);
				for (Song s : mySongs) {
					playlist.addSong(s);
				}
				
				Player player = new Player(currentPlayerName);
				player.setPlaylist(playlist);
				
				// send playlist to another class
			}
		});
		AnchorPane.setBottomAnchor(saveButton, 20.0);
		AnchorPane.setRightAnchor(saveButton, 20.0);
		
		
		anchor.getChildren().addAll(titleBox, inputGrid, playerStatus, saveButton);
		
		Scene cpScene = new Scene(anchor, 275, 250);

		cpScene.getStylesheets().add("application/application.css");
		return cpScene;
	}
	//This is the Left grouping of boxes
	public VBox addLeftVBox(ObservableList<Song> songs) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane searchGrid = new GridPane();
		searchGrid.setPadding(new Insets(10, 10, 10, 10));
		searchGrid.setVgap(10.0);
		
		TextField searchInput = new TextField();
		searchInput.setPromptText("Search Songs");
		searchInput.setPrefWidth(200);
		Button searchBtn = new Button();
		searchBtn.setText("Go");
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				songs.clear();
				makeFakeSong(searchInput.getText());
			}
		});
	
		searchResults.setPrefSize(300, 400);
		searchResults.setEditable(true);
		
		GridPane.setConstraints(searchInput, 0, 0, 3, 1, null, null, null, null, null);
		GridPane.setConstraints(searchBtn, 3, 0);
		GridPane.setConstraints(searchResults, 0, 1, 3, 4, null, null, null, null, null);
		
		searchGrid.getChildren().addAll(searchInput, searchBtn, searchResults);
		vbox.getChildren().add(searchGrid);
		
		return vbox;	
		
	}
	
	public VBox addRightVBox(ObservableList<Song> mySongs) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane playlistGrid = new GridPane();
		playlistGrid.setPadding(new Insets(10, 10, 10, 10));
		playlistGrid.setVgap(10.0);
		playlistGrid.setAlignment(Pos.CENTER_LEFT);
		
		TextField title = new TextField();
		title.setPromptText(playlistTitle);
	
		playlist.setPrefSize(300, 400);
		playlist.setEditable(true);
		
		GridPane.setConstraints(title, 0, 0, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(playlist, 0, 1, 2, 4, null, null, null, null, null);
		
		playlistGrid.getChildren().addAll(title, playlist);
		vbox.getChildren().add(playlistGrid);
		
		return vbox;	
		
	}
	
	
	// This method Not currently used
	public VBox addButton(ObservableList<Song> searchResults, ObservableList<Song> playlist) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(350, 100, 350, 10));
		Button addSongBtn = new Button();
		addSongBtn.setText("Add Song");
		addSongBtn.setPrefSize(25.0, 15);
		addSongBtn.setAlignment(Pos.CENTER_LEFT);
		
		vbox.getChildren().addAll(addSongBtn);
		
		return vbox;
	}
	
	
	//Temporary Method to test add and delete song buttons
	public void makeFakeSong(String songName) {
		Song fake = new Song(songName, "Matthew");
		
		songs.add(fake);
	}
	
}


