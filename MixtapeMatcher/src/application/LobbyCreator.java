package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LobbyCreator extends SceneCreator {

	public LobbyCreator(Observer o, GameDriver gameDriver) {
		super(o);
		this.gameDriver = gameDriver;
	}
	
	private GameDriver gameDriver;
	
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
		TextField numPlayersInput = new TextField();
		numPlayersInput.setAlignment(Pos.TOP_CENTER);
		Label maxSongsLabel = new Label("Max Songs");
		maxSongsLabel.setAlignment(Pos.TOP_CENTER);;
		TextField maxSongsInput = new TextField();
		maxSongsInput.setAlignment(Pos.TOP_CENTER);
		

		Label themeLabel = new Label("Theme (optional)");
		themeLabel.setAlignment(Pos.TOP_CENTER);;
		TextField themeInput = new TextField();
		themeInput.setAlignment(Pos.TOP_CENTER);
		
		Button submit = new Button();
		submit.setAlignment(Pos.TOP_CENTER);
		submit.setText("Submit");
		
		
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(numPlayersLabel, 0, 1);
		GridPane.setConstraints(numPlayersInput, 1, 1);
		GridPane.setConstraints(maxSongsLabel, 0, 2);
		GridPane.setConstraints(maxSongsInput, 1, 2);
		GridPane.setConstraints(themeLabel, 0, 3);
		GridPane.setConstraints(themeInput, 1, 3);
		GridPane.setConstraints(submit, 1, 4);
		lobbygrid.getChildren().add(title);
		lobbygrid.getChildren().add(numPlayersLabel);
		lobbygrid.getChildren().add(numPlayersInput);
		lobbygrid.getChildren().add(maxSongsLabel);
		lobbygrid.getChildren().add(maxSongsInput);
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
}
