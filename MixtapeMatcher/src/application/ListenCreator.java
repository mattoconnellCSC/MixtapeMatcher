package application;

import java.net.URL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Listen Creator
 * @author Tanay
 *
 */

public class ListenCreator extends SceneCreator {
	MediaPlayer mediaPlayer;
	Button button1, button2, button3, button4;
	ArrayList<Player> players;
	ChoiceBox<String> dropdown;
	Button makeGuess;
	
	
	public ListenCreator(UIDriver uiDriver, Player p) {
		super(uiDriver);
		players = uiDriver.getLobby().getPlayerList();
		uiDriver.getLobby().setCurrentPlaylist(p.getPlaylist());
	}
	
	public Scene createScene(Stage stage) {
		VBox root = new VBox();
		
		Label titleText = new Label("Listen to Playlist");
		titleText.getStyleClass().add("label-title");
		titleText.setAlignment(Pos.CENTER);
		VBox titleBox = new VBox();
		titleBox.setPadding(new Insets(15, 10, 10, 10));
		titleBox.getChildren().add(titleText);
		titleBox.setAlignment(Pos.CENTER_LEFT);
		
		root.getChildren().add(titleText);
		
		Scene scene = new Scene(root);
	  
		Image playImg = new Image(getClass().getResourceAsStream("../resources/Play.png"));
		Image pauseImg = new Image(getClass().getResourceAsStream("../resources/Pause.png"));
		Image forwardImg = new Image(getClass().getResourceAsStream("../resources/Forward.png"));
		Image backwardImg = new Image(getClass().getResourceAsStream("../resources/Backward.png"));
		
		HBox buttons;
		ArrayList<Song> songs;
		URL resource;
		Media media;
		
		// Player 1
		buttons = new HBox();
		buttons.setTranslateY(100);
		songs = players.get(0).getPlaylist().getSongs();
		dropdown = new ChoiceBox<String>();
		dropdown.setTranslateX((150));
		dropdown.setTranslateY(15);
		for (int s = 0; s < songs.size(); s++) {
			dropdown.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
		}
		dropdown.getSelectionModel().selectFirst();
		
		String songName = "../resources/Songs/" + dropdown.getSelectionModel().getSelectedItem();
	    resource = getClass().getResource(songName);
	    media = new Media(resource.toString());
	    mediaPlayer = new MediaPlayer(media);
	    
	    
	    button1 = new Button();
	    button1.setTranslateX(205);
	    button1.setGraphic(new ImageView(playImg));
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.play();
			}
		});
		button2 = new Button();
	    button2.setTranslateX(210);
	    button2.setGraphic(new ImageView(pauseImg));
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.pause();
			}
		});
		button3 = new Button();
	    button3.setTranslateX(215);
	    button3.setGraphic(new ImageView(forwardImg));
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(mediaPlayer.getCurrentTime().add(new Duration(10000.0)));
			}
		});
		button4 = new Button();
	    button4.setTranslateX(200);
	    button4.setGraphic(new ImageView(backwardImg));
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(new Duration(10000.0)));
			}
		});

		buttons.getChildren().addAll(dropdown, button4, button1, button2, button3);
		root.getChildren().addAll(buttons);
	    

		makeGuess = new Button("Make Guess");
		makeGuess.setAlignment(Pos.CENTER);
		makeGuess.setTranslateX(350);
		makeGuess.setTranslateY(200);
		makeGuess.setOnAction(new EventHandler<ActionEvent>() {
				 public void handle(ActionEvent e) {
				        //set #players, #songs, theme on submit action, then ask each player for name
//				    		getPlayerNames(numPlayers, stagename);
					 
				    		
				    		notifyObserver("guess"); //tell UI Driver to move to next Scene
				    }
		});
		root.getChildren().add(makeGuess);
		scene.getStylesheets().add("application/application.css");
		return scene;
	}
	

}
