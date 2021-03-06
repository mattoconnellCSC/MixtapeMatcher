package application;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * UI Screen for the Create Playlist part of the game 
 * @author Matt, Natalie, Tanay
 *
 */

@java.lang.SuppressWarnings({"squid:S1604", "squid:S3776"})

public class CreatePlaylistCreator extends SceneCreator{

	private ObservableList<Song> allSongs = FXCollections.observableArrayList();
	
	
	private ObservableList<Song> songs = FXCollections.observableArrayList();
	private ObservableList<Song> mySongs = FXCollections.observableArrayList();

	private ListView<Song> searchResults = new ListView<>(songs);
	private ListView<Song> playlist = new ListView<>(mySongs);
	
	private TextField playerNameField;
	private TextField playlistNameField;
	
	private GameDriver gd;
	
	Button saveButton;
	private int playlistLength;
	private String playerName;
	private String playlistName;
		
	// change to be an input box, save input
	private String currentPlayerName = "Player Name";
	private String playlistTitle = "Playlist Title";
	private int maxSongs = 0;
	private int numSongs=0;
	
	public CreatePlaylistCreator(Observer o, GameDriver gd) {
		super(o);
		maxSongs = gd.getLobby().getMaxSongs();
		this.gd = gd;
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
		VBox titleBox = new VBox();
		titleBox.setPadding(new Insets(15, 10, 10, 10));
		titleBox.getChildren().add(titleText);
		titleBox.setAlignment(Pos.CENTER_LEFT);
		//set theme, if applicable
		String theme = gd.getLobby().getTheme();
		if (!theme.equals("")) {
			Label themeLabel = new Label("Theme: " + theme);
			themeLabel.setAlignment(Pos.CENTER_LEFT);
			themeLabel.setPadding(new Insets(0, 10, 10, 10));
			titleBox.getChildren().add(themeLabel);
		}
		
		
		AnchorPane.setTopAnchor(titleBox, null);
		
		//Get names of all mp3s
		File folder = new File(System.getProperty("user.dir") + "/bin/resources/Songs");
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".mp3")) {
	        String[] parts = listOfFiles[i].getName().split("-");
	        Song s = new Song(parts[0].substring(0,parts[0].length()-1), parts[1].substring(1, parts[1].length()-4));
	        allSongs.add(s);
	      }
	    }
		
		//Search Box and Results displayed in Center anchor with Playlist and Add Button
		VBox leftVBox = addLeftVBox(songs);
		VBox rightVBox = addRightVBox();
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
				if (selectedSong != null)
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
				playerName = playerNameField.getText();
				playlistName = playlistNameField.getText();
				if (!playerName.equals("") && !playlistName.equals("")) { //if the player name AND playlist name field is filled
					notifyObserver("listen");
					
					Playlist p = new Playlist(playlistNameField.getText());
					for (Song s : mySongs) {
						p.addSong(s);
					}
					
					Player player = new Player(playerNameField.getText());
					player.setPlaylist(p);
					
					// send playlist to another class
					gd.update(player);
					notifyObserver("listen");
				}
				else if (playerName.equals("") && playlistName.equals("")) { //no player name and no playlist name
					String msg = "You are missing the player name and playlist name. Please fill them out before moving forward.";
					informPlayerOfMissingFields(msg);
				}
				else if (playerName.equals("")) { //no player name
					String msg = "You are missing the player name. Please fill it out before moving forward.";
					informPlayerOfMissingFields(msg);
				}
				else { //no playlist name
					String msg = "You are missing the playlist name. Please fill it out before moving forward.";
					informPlayerOfMissingFields(msg);
				}
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
				searchForSongs(searchInput.getText());
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
	
	public void informPlayerOfMissingFields(String msg) {
		Alert missingInfoAlert = new Alert(AlertType.INFORMATION);
		missingInfoAlert.setTitle("");
		missingInfoAlert.setHeaderText("Missing Information");
		missingInfoAlert.setContentText(msg);
		missingInfoAlert.setGraphic(null);
		
		DialogPane dialogPane = missingInfoAlert.getDialogPane();
		dialogPane.setStyle("-fx-background-color: #666666; -fx-text-fill: aliceblue;"); //maintext
		
		dialogPane.getStyleClass().remove("alert");
		GridPane grid = (GridPane)dialogPane.lookup(".header-panel"); 
	    grid.setStyle("-fx-background-color: #AAAAAA; -fx-text-fill: aliceblue; -fx-font-size: 17px; -fx-font-weight: bold;"); //top
	    
	    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../resources/Warning.png")));
	    imageView.setFitHeight(25);
	    imageView.setFitWidth(25);
	    StackPane stackPane = new StackPane(imageView);
	    stackPane.setPrefSize(24, 24);
	    stackPane.setAlignment(Pos.CENTER);
	    dialogPane.setGraphic(stackPane);

	    dialogPane.lookup(".content.label").setStyle("-fx-font-size: 15px; -fx-text-fill: aliceblue;");
	    
	    ButtonBar buttonBar = (ButtonBar)missingInfoAlert.getDialogPane().lookup(".button-bar");
	    buttonBar.getButtons().forEach(b->b.setStyle("-fx-background-color: linear-gradient(#0ba4ea, #0b34ea);"
	    		+ "-fx-text-fill: aliceblue;"));
		
		missingInfoAlert.showAndWait();
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
	
	public VBox addRightVBox() {
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
	
	public void searchForSongs(String s) {
		for (int i = 0; i < allSongs.size(); i++) {
			if (allSongs.get(i).getTitle().toLowerCase().contains(s.toLowerCase()) || allSongs.get(i).getArtist().toLowerCase().contains(s.toLowerCase())) {
				songs.add(allSongs.get(i));
			}
		}
	}
	
	public ObservableList<Song> getSongs(){
		return songs;
	}
	
	public ObservableList<Song> getMySongs(){
		return mySongs;
	}
	
	// This method Not currently used
	 	public VBox addButton(ObservableList<Song> searchResults, ObservableList<Song> playlist) {
	 		VBox vbox = new VBox();
	 		searchResults = searchResults;
	 		playlist = playlist;
	 		vbox.setPadding(new Insets(350, 100, 350, 10));
	 		Button addSongBtn = new Button();
	 		addSongBtn.setText("Add Song");
	 		addSongBtn.setPrefSize(25.0, 15);
	 		addSongBtn.setAlignment(Pos.CENTER_LEFT);
	 		
	 		vbox.getChildren().addAll(addSongBtn);
	 		
	 		return vbox;
	 	}
	
}


