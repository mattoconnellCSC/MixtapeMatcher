package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreatePlaylistCreator extends SceneCreator{

	public CreatePlaylistCreator(Observer o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene createScene(Stage stage) {
		
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20, 0, 20, 0));
		VBox leftVBox = addLeftVBox();
		VBox rightVBox = addRightVBox();
		border.setLeft(leftVBox);
		border.setRight(rightVBox);
		border.setCenter(addButton());
		Text titleText = new Text("Create Your Playlist");
		titleText.setTextAlignment(TextAlignment.CENTER);
		HBox titleBox = new HBox();
		titleBox.getChildren().add(titleText);
		titleBox.setAlignment(Pos.TOP_CENTER);
		border.setTop(titleBox);
		
		
		
		return new Scene(border, 275, 250);
	}
	
	public VBox addLeftVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 0, 10, 100));
		
		GridPane searchGrid = new GridPane();
		searchGrid.setPadding(new Insets(300, 0, 300, 0));
		searchGrid.setVgap(10.0);
		
		TextField searchInput = new TextField();
		Button searchBtn = new Button();
		searchBtn.setText("Search");
		
		ObservableList<Song> songs = FXCollections.observableArrayList();
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
	
	public VBox addRightVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 0));
		
		GridPane searchGrid = new GridPane();
		searchGrid.setPadding(new Insets(300, 10, 300, 0));
		searchGrid.setVgap(10.0);
		searchGrid.setAlignment(Pos.CENTER_LEFT);
		
		TextField title = new TextField();
		
		ObservableList<Song> songs = FXCollections.observableArrayList();
		ListView<Song> searchResults = new ListView<Song>(songs);
		searchResults.setPrefSize(300, 400);
		searchResults.setEditable(true);
		
		GridPane.setConstraints(title, 0, 0, 2, 1, null, null, null, null, null);
		GridPane.setConstraints(searchResults, 0, 1, 2, 4, null, null, null, null, null);
		
		searchGrid.getChildren().addAll(title, searchResults);
		vbox.getChildren().add(searchGrid);
		
		return vbox;	
		
	}
	
	public VBox addButton() {
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


