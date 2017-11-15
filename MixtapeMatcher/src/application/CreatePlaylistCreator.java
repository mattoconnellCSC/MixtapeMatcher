package application;

import javafx.beans.property.StringProperty;
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
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * UI Screen for the Create Playlist part of the game 
 * @author Matt
 *
 */

public class CreatePlaylistCreator extends SceneCreator{

	public ObservableList<Song> songs = FXCollections.observableArrayList();
	public ObservableList<String> songsNames = FXCollections.observableArrayList();
	
	public ObservableList<Song> mySongs = FXCollections.observableArrayList();
	public ObservableList<String> mySongsNames = FXCollections.observableArrayList();
	

	public ListView<String> searchResults = new ListView<String>(songsNames);
	public ListView<String> playlist = new ListView<String>(mySongsNames);
	
	public String currentPlayerName = "Matt";
	
	public CreatePlaylistCreator(Observer o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene createScene(Stage stage) {
		
		
		// Using an Anchor Pane as the root pane in this screen
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));
		
		
				
		//Screen Title displayed and anchored at top
		Label titleText = new Label("Create Your Playlist");
		titleText.setStyle("-fx-text-fill: aliceblue");
		titleText.setFont(Font.font(null, FontWeight.BOLD, 36));
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
				mySongsNames.add(searchResults.getSelectionModel().getSelectedItem());
				for(Song s : mySongs) {
					mySongs.add(s);
				}
			}
		});
		
		Button delButton = new Button();
		delButton.setText("Delete Song");
		delButton.setPrefWidth(150.0);
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String delTitle = playlist.getSelectionModel().getSelectedItem();
				mySongsNames.remove(playlist.getSelectionModel().getSelectedIndex());
				for(Song s : mySongs)
				{
					if(s.getTitle().equals(delTitle))
						mySongs.remove(s);
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
				for(Song s : songs) {
					songsNames.add(s.getTitle());
				}
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
		title.setPromptText("Playlist Title");
	
		playlist.setPrefSize(300, 400);
		playlist.setEditable(true);
		
		GridPane.setConstraints(title, 0, 0, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(playlist, 0, 1, 2, 4, null, null, null, null, null);
		
		playlistGrid.getChildren().addAll(title, playlist);
		vbox.getChildren().add(playlistGrid);
		
		return vbox;	
		
	}
	
	public VBox addButton(ObservableList<Song> searchResults, ObservableList<Song> playlist) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(350, 100, 350, 10));
		Button addSongBtn = new Button();
		addSongBtn.setText("Add Song");
		addSongBtn.setPrefSize(25.0, 15);
		addSongBtn.setAlignment(Pos.CENTER_LEFT);
		// TODO: ADD Song Button functionality
		
		Text arrow = new Text("-->");
		
		vbox.getChildren().addAll(addSongBtn, arrow);
		
		return vbox;
	}
	
	public void makeFakeSong(String songName) {
		Song fake = new Song(songName);
		songs.add(fake);
	}
	
}


