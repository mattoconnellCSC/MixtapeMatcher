package application;

import java.net.URL;
import java.util.ArrayList;

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
	MediaPlayer mediaPlayer, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5, mediaPlayer6;
	Button button1, button2, button3, button4;
	Button button21, button22, button23, button24;
	Button button31, button32, button33, button34;
	Button button41, button42, button43, button44;
	Button button51, button52, button53, button54;
	Button button61, button62, button63, button64;
	ArrayList<Player> players;
	ChoiceBox<String> dropdown, dropdown2, dropdown3, dropdown4, dropdown5, dropdown6;
	ChoiceBox<String> guess, guess2, guess3, guess4, guess5, guess6;
	Button makeGuess;
	
	
	public ListenCreator(UIDriver uiDriver) {
		super(uiDriver);
		players = uiDriver.getLobby().getPlayerList();
		guess = new ChoiceBox<String>();
		guess2 = new ChoiceBox<String>();
		guess3 = new ChoiceBox<String>();
		guess4 = new ChoiceBox<String>();
		guess5 = new ChoiceBox<String>();
		guess6 = new ChoiceBox<String>();
		System.out.println(players.size());
		for (int i = 0; i < players.size(); i++) {
			guess.getItems().add(players.get(i).getName());
			guess2.getItems().add(players.get(i).getName());
			guess3.getItems().add(players.get(i).getName());
			guess4.getItems().add(players.get(i).getName());
			guess5.getItems().add(players.get(i).getName());
			guess6.getItems().add(players.get(i).getName());
		}
	}
	
	public Scene createScene(Stage stage) {
		VBox root = new VBox();
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
		songs = players.get(0).getPlaylist().getSongs();
		dropdown = new ChoiceBox<String>();
		for (int s = 0; s < songs.size(); s++) {
			dropdown.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
		}
		dropdown.getSelectionModel().selectFirst();
		
		String songName = "../resources/Songs/" + dropdown.getSelectionModel().getSelectedItem();
	    resource = getClass().getResource(songName);
	    media = new Media(resource.toString());
	    mediaPlayer = new MediaPlayer(media);
	    
	    dropdown.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		        mediaPlayer.stop();
		        URL resource = getClass().getResource("../resources/Songs/" + dropdown.getItems().get((Integer) number2));
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

		buttons.getChildren().addAll(dropdown, button4, button1, button2, button3, guess);
		root.getChildren().addAll(buttons);
	    
		
		
	    //Player 2
		buttons = new HBox();
		songs = players.get(1).getPlaylist().getSongs();
		dropdown2 = new ChoiceBox<String>();
		for (int s = 0; s < songs.size(); s++) {
			dropdown2.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
		}
		dropdown2.getSelectionModel().selectFirst();
		
		songName = "../resources/Songs/" + dropdown2.getSelectionModel().getSelectedItem();
	    resource = getClass().getResource(songName);
	    media = new Media(resource.toString());
	    mediaPlayer2 = new MediaPlayer(media);
	    
	    dropdown2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	  mediaPlayer2.stop();
		        URL resource = getClass().getResource("../resources/Songs/" + dropdown2.getItems().get((Integer) number2));
		        Media media = new Media(resource.toString());
		        mediaPlayer2 = new MediaPlayer(media);
		      }
		    });
	    
	    button1 = new Button();
	    button1.setGraphic(new ImageView(playImg));
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer2.play();
			}
		});
		button2 = new Button();
	    button2.setGraphic(new ImageView(pauseImg));
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer2.pause();
			}
		});
		button3 = new Button();
	    button3.setGraphic(new ImageView(forwardImg));
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer2.seek(mediaPlayer2.getCurrentTime().add(new Duration(10000.0)));
			}
		});
		button4 = new Button();
	    button4.setGraphic(new ImageView(backwardImg));
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer2.seek(mediaPlayer2.getCurrentTime().subtract(new Duration(10000.0)));
			}
		});

		buttons.getChildren().addAll(dropdown2, button4, button1, button2, button3, guess2);
		root.getChildren().addAll(buttons);
		
		
		
		//Player 3
		if (players.size() >= 4)
		{
			buttons = new HBox();
			songs = players.get(2).getPlaylist().getSongs();
			dropdown3 = new ChoiceBox<String>();
			for (int s = 0; s < songs.size(); s++) {
				dropdown3.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
			}
			dropdown3.getSelectionModel().selectFirst();
			
			songName = "../resources/Songs/" + dropdown3.getSelectionModel().getSelectedItem();
		    resource = getClass().getResource(songName);
		    media = new Media(resource.toString());
		    mediaPlayer3 = new MediaPlayer(media);
		    
		    dropdown3.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			    	  mediaPlayer3.stop();
			        URL resource = getClass().getResource("../resources/Songs/" + dropdown3.getItems().get((Integer) number2));
			        Media media = new Media(resource.toString());
			        mediaPlayer3 = new MediaPlayer(media);
			      }
			    });
		    
		    button1 = new Button();
		    button1.setGraphic(new ImageView(playImg));
			button1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer3.play();
				}
			});
			button2 = new Button();
		    button2.setGraphic(new ImageView(pauseImg));
			button2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer3.pause();
				}
			});
			button3 = new Button();
		    button3.setGraphic(new ImageView(forwardImg));
			button3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer3.seek(mediaPlayer3.getCurrentTime().add(new Duration(10000.0)));
				}
			});
			button4 = new Button();
		    button4.setGraphic(new ImageView(backwardImg));
			button4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer3.seek(mediaPlayer3.getCurrentTime().subtract(new Duration(10000.0)));
				}
			});
	
			buttons.getChildren().addAll(dropdown3, button4, button1, button2, button3, guess3);
			root.getChildren().addAll(buttons);
		}
		
		
		// Player 4
		if (players.size() >= 4)
		{
			buttons = new HBox();
			songs = players.get(3).getPlaylist().getSongs();
			dropdown4 = new ChoiceBox<String>();
			for (int s = 0; s < songs.size(); s++) {
				dropdown4.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
			}
			dropdown4.getSelectionModel().selectFirst();
			
			songName = "../resources/Songs/" + dropdown4.getSelectionModel().getSelectedItem();
		    resource = getClass().getResource(songName);
		    media = new Media(resource.toString());
		    mediaPlayer4 = new MediaPlayer(media);
		    
		    dropdown4.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			    	  mediaPlayer4.stop();
			        URL resource = getClass().getResource("../resources/Songs/" + dropdown4.getItems().get((Integer) number2));
			        Media media = new Media(resource.toString());
			        mediaPlayer4 = new MediaPlayer(media);
			      }
			    });
		    
		    button1 = new Button();
		    button1.setGraphic(new ImageView(playImg));
			button1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer4.play();
				}
			});
			button2 = new Button();
		    button2.setGraphic(new ImageView(pauseImg));
			button2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer4.pause();
				}
			});
			button3 = new Button();
		    button3.setGraphic(new ImageView(forwardImg));
			button3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer4.seek(mediaPlayer4.getCurrentTime().add(new Duration(10000.0)));
				}
			});
			button4 = new Button();
		    button4.setGraphic(new ImageView(backwardImg));
			button4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer4.seek(mediaPlayer4.getCurrentTime().subtract(new Duration(10000.0)));
				}
			});

			buttons.getChildren().addAll(dropdown4, button4, button1, button2, button3, guess4);
			root.getChildren().addAll(buttons);
		}
		
		
		// Player 5
		if (players.size() >= 5)
		{
			buttons = new HBox();
			songs = players.get(4).getPlaylist().getSongs();
			dropdown5 = new ChoiceBox<String>();
			for (int s = 0; s < songs.size(); s++) {
				dropdown5.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
			}
			dropdown5.getSelectionModel().selectFirst();
			
			songName = "../resources/Songs/" + dropdown5.getSelectionModel().getSelectedItem();
		    resource = getClass().getResource(songName);
		    media = new Media(resource.toString());
		    mediaPlayer5 = new MediaPlayer(media);
		    
		    dropdown5.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			    	  mediaPlayer5.stop();
			        URL resource = getClass().getResource("../resources/Songs/" + dropdown5.getItems().get((Integer) number2));
			        Media media = new Media(resource.toString());
			        mediaPlayer5 = new MediaPlayer(media);
			      }
			    });
		    
		    button1 = new Button();
		    button1.setGraphic(new ImageView(playImg));
			button1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer5.play();
				}
			});
			button2 = new Button();
		    button2.setGraphic(new ImageView(pauseImg));
			button2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer5.pause();
				}
			});
			button3 = new Button();
		    button3.setGraphic(new ImageView(forwardImg));
			button3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer5.seek(mediaPlayer5.getCurrentTime().add(new Duration(10000.0)));
				}
			});
			button4 = new Button();
		    button4.setGraphic(new ImageView(backwardImg));
			button4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer5.seek(mediaPlayer5.getCurrentTime().subtract(new Duration(10000.0)));
				}
			});

			buttons.getChildren().addAll(dropdown5, button4, button1, button2, button3, guess5);
			root.getChildren().addAll(buttons);
		}
		
		
		// Player 6
		if (players.size() >= 6)
		{
			buttons = new HBox();
			songs = players.get(5).getPlaylist().getSongs();
			dropdown6 = new ChoiceBox<String>();
			for (int s = 0; s < songs.size(); s++) {
				dropdown6.getItems().add(songs.get(s).getTitle() + " - " + songs.get(s).getArtist() + ".mp3");
			}
			dropdown6.getSelectionModel().selectFirst();
			
			songName = "../resources/Songs/" + dropdown6.getSelectionModel().getSelectedItem();
		    resource = getClass().getResource(songName);
		    media = new Media(resource.toString());
		    mediaPlayer6 = new MediaPlayer(media);
		    
		    dropdown6.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			    	  mediaPlayer6.stop();
			        URL resource = getClass().getResource("../resources/Songs/" + dropdown6.getItems().get((Integer) number2));
			        Media media = new Media(resource.toString());
			        mediaPlayer6 = new MediaPlayer(media);
			      }
			    });
		    
		    button1 = new Button();
		    button1.setGraphic(new ImageView(playImg));
			button1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer6.play();
				}
			});
			button2 = new Button();
		    button2.setGraphic(new ImageView(pauseImg));
			button2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer6.pause();
				}
			});
			button3 = new Button();
		    button3.setGraphic(new ImageView(forwardImg));
			button3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer6.seek(mediaPlayer6.getCurrentTime().add(new Duration(10000.0)));
				}
			});
			button4 = new Button();
		    button4.setGraphic(new ImageView(backwardImg));
			button4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					mediaPlayer6.seek(mediaPlayer6.getCurrentTime().subtract(new Duration(10000.0)));
				}
			});

			buttons.getChildren().addAll(dropdown6, button4, button1, button2, button3, guess6);
			root.getChildren().addAll(buttons);
		}
		makeGuess = new Button("Make Guess");
		root.getChildren().add(makeGuess);
		
		return scene;
	}
	

}
