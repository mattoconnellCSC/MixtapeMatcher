package application;

import java.net.URL;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	
	
	public ListenCreator(UIDriver uiDriver) {
		super(uiDriver);
	}
	
	public Scene createScene(Stage stage) {
		VBox root = new VBox();
		HBox buttons = new HBox();
		Scene scene = new Scene(root);
	  
		Image playImg = new Image(getClass().getResourceAsStream("Play.png"));
		Image pauseImg = new Image(getClass().getResourceAsStream("Pause.png"));
		Image forwardImg = new Image(getClass().getResourceAsStream("Forward.png"));
		Image backwardImg = new Image(getClass().getResourceAsStream("Backward.png"));
		
		
	
		ChoiceBox<String> dropdown = new ChoiceBox<String>();
		dropdown.getItems().addAll(
				"Tennis Court (Flume Remix) - Lorde.mp3",
				"Core - RL Grime.mp3",
				"Disarm You (Illenium Remix) - Kaskade ft. Ilsey.mp3",
				"Late Night - ODESZA.mp3",
				"Leaving - Illenium.mp3");
		dropdown.getSelectionModel().selectFirst();
		
		String songName = "Tennis Court (Flume Remix) - Lorde.mp3";
	    URL resource = getClass().getResource(songName);
	    Media media = new Media(resource.toString());
	    mediaPlayer = new MediaPlayer(media);
	    
	    dropdown.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		        mediaPlayer.stop();
		        URL resource = getClass().getResource(dropdown.getItems().get((Integer) number2));
		        Media media = new Media(resource.toString());
		        mediaPlayer = new MediaPlayer(media);
		      }
		    });
	    
	    button1 = new Button();
	    button1.setGraphic(new ImageView(playImg));
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.play();
			}
		});
		button2 = new Button();
	    button2.setGraphic(new ImageView(pauseImg));
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.pause();
			}
		});
		
		button3 = new Button();
	    button3.setGraphic(new ImageView(forwardImg));
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(mediaPlayer.getCurrentTime().add(new Duration(10000.0)));
			}
		});
		button4 = new Button();
	    button4.setGraphic(new ImageView(backwardImg));
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(new Duration(10000.0)));
			}
		});
		
		
		buttons.getChildren().addAll(dropdown, button4, button1, button2, button3);
		
		root.getChildren().addAll(buttons);
		return scene;
	}

}
