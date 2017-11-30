package application;

import java.io.File;

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
import javafx.stage.Stage;

/**
 * UI Screen for the Create Playlist part of the game 
 * @author Matt, Natalie, Tanay
 *
 */

public class CreatePlaylistCreator extends SceneCreator{

	public ObservableList<Song> songs = FXCollections.observableArrayList();
	public ObservableList<Song> mySongs = FXCollections.observableArrayList();

	public ListView<Song> searchResults = new ListView<Song>(songs);
	public ListView<Song> playlist = new ListView<Song>(mySongs);
	
	private TextField playerNameField;
	private TextField playlistNameField;
	
	private GameDriver gd;
	
	Button saveButton;
	public int playlistLength;
	public boolean nameMade;
	
	// change to be an input box, save input
	public String currentPlayerName = "Player Name";
	public String playlistTitle = "Playlist Title";
	public int maxSongs, numSongs=0;
	
	public CreatePlaylistCreator(Observer o, GameDriver gd) {
		super(o);
		maxSongs = gd.getLobby().getMaxSongs();
		this.gd = gd;
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
		
		//Get names of all mp3s
		File folder = new File(System.getProperty("user.dir") + "/bin/resources/Songs");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println(listOfFiles[i].getName());
		      }
		    }
		
		//Search Box and Results displayed in Center anchor with Playlist and Add Button
		VBox leftVBox = addLeftVBox(songs);
		VBox rightVBox = addRightVBox(mySongs);
		VBox nameVBox = addNameVBox();
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
				setPlaylistMade();
			}
		});
		//Delete Song button and Functionality
		Button delButton = new Button();
		delButton.setText("Delete Song");
		delButton.setPrefWidth(150.0);
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (playlist.getSelectionModel().getSelectedIndex() != -1) {
					mySongs.remove(playlist.getSelectionModel().getSelectedIndex());
					numSongs--;
					decrementPlayistLength();
				}
			}
		});
		centerVBox.getChildren().addAll(addButton, delButton);
		centerVBox.setSpacing(10.0);
		centerVBox.setAlignment(Pos.CENTER);
		GridPane inputGrid = new GridPane();
		inputGrid.setHgap(20.0);
		inputGrid.setVgap(10.0);
		inputGrid.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setConstraints(leftVBox, 0, 1, 3, 4, null, null, null, null, null); // Bridget moved this down by 1
		GridPane.setConstraints(centerVBox, 3, 3, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(nameVBox, 6, 0, 3, 1, null, null, null, null, null);
		GridPane.setConstraints(rightVBox, 6, 1, 3, 4, null, null, null, null, null);
		inputGrid.getChildren().addAll(leftVBox, centerVBox, rightVBox, nameVBox);
		
		AnchorPane.setLeftAnchor(inputGrid, 10.0);
		AnchorPane.setRightAnchor(inputGrid, 10.0);
		AnchorPane.setTopAnchor(inputGrid, 100.0);
		AnchorPane.setBottomAnchor(inputGrid, 100.0);
		
		
		// Button to Save playlist anchored to bottom right of page
		saveButton = new Button();
		saveButton.setText("Save Playlist");
		saveButton.setDisable(true);
		
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
//				if () { //if the player name AND playlist name field is filled
					notifyObserver("listen");
					
					Playlist playlist = new Playlist(playlistNameField.getText());
					for (Song s : mySongs) {
						playlist.addSong(s);
					}
					
					Player player = new Player(playerNameField.getText());
					player.setPlaylist(playlist);
					
					// send playlist to another class
					System.out.println("player " + player.getName() + " created playlist " + playlist.getName());
					gd.update(player);
//				}
//				else { //if the name field is empty
//					//popup telling player to fill out his/her name or playlist name
//				}
			}
		});
		AnchorPane.setBottomAnchor(saveButton, 20.0);
		AnchorPane.setRightAnchor(saveButton, 20.0);
		
		anchor.getChildren().addAll(titleBox, inputGrid, saveButton);
		
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
	
	public void setPlaylistMade() {
		if (playlistLength < maxSongs)
			playlistLength += 1;
			saveButton.setDisable(false);
	}
	
	public void decrementPlayistLength() {
		if (playlistLength > 0)
			playlistLength--;
		if (playlistLength == 0)
			saveButton.setDisable(true);
	}
	
	public VBox addRightVBox(ObservableList<Song> mySongs) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane playlistGrid = new GridPane();
		playlistGrid.setPadding(new Insets(10, 10, 10, 10));
		playlistGrid.setVgap(10.0);
		playlistGrid.setAlignment(Pos.CENTER_LEFT);
		
		playlistNameField = new TextField();
		playlistNameField.setPromptText(playlistTitle);
			
		playlist.setPrefSize(300, 400);
		playlist.setEditable(true);
		
		GridPane.setConstraints(playlistNameField, 0, 0, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(playlist, 0, 1, 2, 4, null, null, null, null, null);
		
		playlistGrid.getChildren().addAll(playlistNameField, playlist);
		vbox.getChildren().add(playlistGrid);
				
		return vbox;	
	}
	
	public VBox addNameVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane playlistGrid = new GridPane();
		playlistGrid.setPadding(new Insets(10, 10, 10, 10));
		playlistGrid.setVgap(10.0);
		playlistGrid.setAlignment(Pos.CENTER_LEFT);
		
		playerNameField = new TextField();
		playerNameField.setPromptText(currentPlayerName);
		playerNameField.setEditable(true);
				
		GridPane.setConstraints(playerNameField, 0, 0, 2, 1, null, null, null, null, null);
		playlistGrid.getChildren().addAll(playerNameField);
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


