package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
	boolean isNumPlayersSelected;
	boolean isNumSongsSelected;
	Button submit;
	
	public Scene createScene(Stage stagename)
	{
		GridPane lobbygrid = new GridPane();
		lobbygrid.setPadding(new Insets(10, 10, 10, 10));
		lobbygrid.setVgap(10.0);
		lobbygrid.setHgap(5.0);
		lobbygrid.setAlignment(Pos.CENTER);
		Label title = new Label("Lobby");
		
		Label numPlayersLabel = new Label("Number of Players");
		numPlayersLabel.setAlignment(Pos.TOP_CENTER);
		ObservableList<Integer> numPlayersOptions = 
		    FXCollections.observableArrayList(
		        1,2,3,4,5,6
		    );
		final ComboBox playersComboBox = new ComboBox(numPlayersOptions);
		playersComboBox.setOnAction(e -> setPlayersSelected());
		
		Label maxSongsLabel = new Label("Max Songs Per Player");
		maxSongsLabel.setAlignment(Pos.TOP_CENTER);
		ObservableList<Integer> numSongsOptions = 
		    FXCollections.observableArrayList(
		    		1,2,3,4
		    );
		final ComboBox songsComboBox = new ComboBox(numSongsOptions);
		songsComboBox.setOnAction(e -> setNumSongsSelected());
		
		Label themeLabel = new Label("Theme (optional)");
		themeLabel.setAlignment(Pos.TOP_CENTER);
		TextField themeInput = new TextField();
		themeInput.setAlignment(Pos.TOP_CENTER);
		
		submit = new Button();
		submit.setAlignment(Pos.TOP_CENTER);
		submit.setText("Submit");
		submit.setDisable(true);
		
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(numPlayersLabel, 0, 1);
		GridPane.setConstraints(playersComboBox, 1, 1);
		GridPane.setConstraints(maxSongsLabel, 0, 2);
		GridPane.setConstraints(songsComboBox, 1, 2);
		GridPane.setConstraints(themeLabel, 0, 3);
		GridPane.setConstraints(themeInput, 1, 3);
		GridPane.setConstraints(submit, 1, 4);
		lobbygrid.getChildren().add(title);
		lobbygrid.getChildren().add(numPlayersLabel);
		lobbygrid.getChildren().add(playersComboBox);
		lobbygrid.getChildren().add(maxSongsLabel);
		lobbygrid.getChildren().add(songsComboBox);
		lobbygrid.getChildren().add(themeLabel);
		lobbygrid.getChildren().add(themeInput);
		lobbygrid.getChildren().add(submit);
		
		StackPane root = new StackPane();
		root.getChildren().add(lobbygrid);
		
		return new Scene(root, 275, 250);
	}
	
	public void notifyGameDriver(GameDriver gd, Object data) {
		gd.update(data);
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
}
