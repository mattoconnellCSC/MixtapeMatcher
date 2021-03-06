package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private boolean isNumPlayersSelected;
	private boolean isNumSongsSelected;
	private int numPlayers, numSongs;
	private String theme;
	Button submit;
	private String playerNames[];

@java.lang.SuppressWarnings("squid:S1604")
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
		ComboBox<Integer> playersComboBox = new ComboBox<>();
		playersComboBox.getItems().setAll(3,4,5,6);
		playersComboBox.setOnAction(e -> setPlayersSelected());
		
		Label maxSongsLabel = new Label("Max Songs Per Player");
		maxSongsLabel.setAlignment(Pos.TOP_CENTER);
		ComboBox<Integer> songsComboBox = new ComboBox<>();
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
		    		Lobby lobby = new Lobby();
		    		lobby.setNumPlayers(Integer.parseInt(playersComboBox.getValue().toString()));
		    		lobby.setMaxSongs(Integer.parseInt(songsComboBox.getValue().toString()));
		    		lobby.setTheme(themeInput.getText());
		    		
		    		gameDriver.update(lobby);
		    		
		    		notifyObserver("create"); //tell UI Driver to move to next Scene
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
		setNumPlayersSelected(true);
		if (isNumSongsSelected()) {
			submit.setDisable(false);
		}
	}
	
	public void setNumSongsSelected() {
		isNumSongsSelected = true;
		if (isNumPlayersSelected()) {
			submit.setDisable(false);
		}
	}

	public boolean isNumPlayersSelected() {
		return isNumPlayersSelected;
	}

	public void setNumPlayersSelected(boolean isNumPlayersSelected) {
		this.isNumPlayersSelected = isNumPlayersSelected;
	}

	public boolean isNumSongsSelected() {
		return isNumSongsSelected;
	}

	public void setNumSongsSelected(boolean isNumSongsSelected) {
		this.isNumSongsSelected = isNumSongsSelected;
	}
	
}
