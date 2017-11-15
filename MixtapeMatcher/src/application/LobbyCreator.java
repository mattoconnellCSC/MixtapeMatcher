package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Creates the scene for the lobby
 * @author Natalie, Matt
 *
 */


public class LobbyCreator extends SceneCreator {

	public LobbyCreator(Observer o, GameDriver gameDriver) {
		super(o);
		this.gameDriver = gameDriver;
	}
	
	private GameDriver gameDriver;
	public boolean isNumPlayersSelected;
	public boolean isNumSongsSelected;
	public int numPlayers, numSongs;
	public String theme;
	Button submit;
	String playerNames[];
	
	public Scene createScene(Stage stagename)
	{
		AnchorPane anchor = new AnchorPane();
		HBox header = new HBox();
		GridPane lobbygrid = new GridPane();
		lobbygrid.setPadding(new Insets(10, 10, 10, 10));
		lobbygrid.setVgap(10.0);
		lobbygrid.setHgap(5.0);
		lobbygrid.setAlignment(Pos.CENTER);
		Label title = new Label("Lobby");
		title.setFont(Font.font(null, FontWeight.BOLD, 36));
		
		header.setAlignment(Pos.BASELINE_LEFT);
		header.getChildren().add(title);
		AnchorPane.setTopAnchor(header, 10.0);
		AnchorPane.setLeftAnchor(header, 10.0);
		AnchorPane.setRightAnchor(header, 10.0);
		
		
		Label numPlayersLabel = new Label("Number of Players");
		numPlayersLabel.setAlignment(Pos.TOP_CENTER);
		ComboBox<Integer> playersComboBox = new ComboBox<Integer>();
		playersComboBox.getItems().setAll(3,4,5,6);
		playersComboBox.setOnAction(e -> setPlayersSelected());
		
		Label maxSongsLabel = new Label("Max Songs Per Player");
		maxSongsLabel.setAlignment(Pos.TOP_CENTER);
		ComboBox<Integer> songsComboBox = new ComboBox<Integer>();
		songsComboBox.getItems().setAll(1,2,3,4);
		songsComboBox.setOnAction(e -> setNumSongsSelected());
		
		Label themeLabel = new Label("Theme (optional)");
		themeLabel.setAlignment(Pos.TOP_CENTER);
		TextField themeInput = new TextField();
		themeInput.setAlignment(Pos.TOP_CENTER);
		
		submit = new Button();
		submit.setAlignment(Pos.TOP_CENTER);
		submit.setText("Submit");
		submit.setDisable(true);
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		        //set #players, #songs, theme on submit action, then ask each player for name
		    		numPlayers = Integer.parseInt(playersComboBox.getValue().toString());
		    		numSongs = Integer.parseInt(songsComboBox.getValue().toString());
		    		theme = themeInput.getText();
		    		getPlayerNames(numPlayers, stagename);
		    		//submit.setText("cool " + numPlayers + " " + numSongs + " " + theme);
		    }
		});
		
		
		GridPane.setConstraints(numPlayersLabel, 0, 1);
		GridPane.setConstraints(playersComboBox, 1, 1);
		GridPane.setConstraints(maxSongsLabel, 0, 2);
		GridPane.setConstraints(songsComboBox, 1, 2);
		GridPane.setConstraints(themeLabel, 0, 3);
		GridPane.setConstraints(themeInput, 1, 3);
		GridPane.setConstraints(submit, 1, 4);
		lobbygrid.getChildren().add(numPlayersLabel);
		lobbygrid.getChildren().add(playersComboBox);
		lobbygrid.getChildren().add(maxSongsLabel);
		lobbygrid.getChildren().add(songsComboBox);
		lobbygrid.getChildren().add(themeLabel);
		lobbygrid.getChildren().add(themeInput);
		lobbygrid.getChildren().add(submit);
		
		StackPane root = new StackPane();
		root.getChildren().add(lobbygrid);
		AnchorPane.setTopAnchor(root, 10.0);
		AnchorPane.setRightAnchor(root, 10.0);
		AnchorPane.setBottomAnchor(root, 10.0);
		AnchorPane.setLeftAnchor(root, 10.0);
		anchor.getChildren().addAll(header, root);
		
		Scene lobbyScene = new Scene(anchor, 800, 800);
		lobbyScene.getStylesheets().add("application/application.css");
		
		return lobbyScene;
	}
	
	public void notifyGameDriver(Object data) {
		gameDriver.update(data); //pass shit (Lobby object?) to game driver gd
	}
	
	public void setPlayersSelected() {
		isNumPlayersSelected = true;
		if (isNumSongsSelected == true) {
			submit.setDisable(false);
		}
	}
	
	public void setNumSongsSelected() {
		isNumSongsSelected = true;
		if (isNumPlayersSelected == true) {
			submit.setDisable(false);
		}
	}
	
	public void getPlayerNames(int numPlayers, Stage stagename) {
		//popup to get players' names
		TextInputDialog dialog = new TextInputDialog(null);
		dialog.setTitle("Player Names");
		
		playerNames = new String[numPlayers];

		for (int i=0; i<numPlayers; i++) {
			dialog.setHeaderText("Player " + (i+1) + "'s Name:");
			Optional<String> result = dialog.showAndWait();
			playerNames[i] = result.toString();
			playerNames[i] = playerNames[i].substring(9, playerNames[i].length()-1);
			dialog = new TextInputDialog(null);
		}
		
		Lobby lob = new Lobby("");
		for(int i=0; i < playerNames.length; i++) {
			Player newPlayer = new Player(playerNames[i]);
			lob.addPlayer(newPlayer);
		}
		notifyGameDriver(lob); //someone else (Matt) create the Lobby object from the data here and put it in this function 
		notifyObserver("create"); //send next scene to UIDriver
	}
}
