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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreatePlaylistCreator extends SceneCreator{

	public ObservableList<Song> songs = FXCollections.observableArrayList();
	
	public ObservableList<Song> mySongs = FXCollections.observableArrayList();
	
	public String currentPlayerName = "Matt";
	
	public CreatePlaylistCreator(Observer o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene createScene(Stage stage) {
		
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));
		
		
				
		//Screen Title displayed and anchored at top
		Label titleText = new Label("Create Your Playlist");
		titleText.setStyle("-fx-text-fill: aliceblue");
		titleText.setStyle("-fx-font-size: 36");
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
		
		AnchorPane.setTopAnchor(playerStatus, 10.0);
		AnchorPane.setRightAnchor(playerStatus, 10.0);
		
		
		//Search Box and Results displayed in Center anchor with Playlist and Add Button
		VBox leftVBox = addLeftVBox(songs);
		VBox rightVBox = addRightVBox(mySongs);
		Button addButton = new Button();
		addButton.setText("Add Song");
		//Add Song Button Functionality
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				mySongs.addAll(songs);
				System.out.print("Added song!");
			}
		});
		GridPane inputGrid = new GridPane();
		inputGrid.setHgap(20.0);
		inputGrid.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setConstraints(leftVBox, 0, 0, 3, 4, null, null, null, null, null);
		GridPane.setConstraints(addButton, 3, 3, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(rightVBox, 6, 0, 3, 4, null, null, null, null, null);
		
		inputGrid.getChildren().addAll(leftVBox, addButton, rightVBox);
		
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
	
		ListView<Song> searchResults = new ListView<Song>(songs);
		searchResults.setPrefSize(300, 400);
		searchResults.setEditable(true);
		
		GridPane.setConstraints(searchInput, 0, 0, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(searchBtn, 2, 0);
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
	
		ListView<Song> playlist = new ListView<Song>(mySongs);
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
	
}


