package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main Menu for everything! 
 * @author Jordan & Matt
 *
 */
public class MainMenuCreator extends SceneCreator {

	public MainMenuCreator(Observer o) {
		super(o);
	}

	@Override
	public Scene createScene(Stage stage) {
		GridPane titlegrid = new GridPane();
		titlegrid.setPadding(new Insets(10, 10, 10, 10));
		titlegrid.setVgap(10.0);
		titlegrid.setHgap(5.0);
		titlegrid.setAlignment(Pos.CENTER);
		Label title = new Label("MixtapeMatcher");
		Button startbtn = new Button();
		startbtn.setAlignment(Pos.TOP_CENTER);
		startbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				notifyObserver("lobby"); //send next scene to UIDriver
			}
		});
		
		Button helpbtn = new Button();
		helpbtn.setAlignment(Pos.TOP_CENTER);
		Button loginbtn = new Button();
		loginbtn.setAlignment(Pos.TOP_CENTER);
		startbtn.setText("START");
		helpbtn.setText("HELP");
		loginbtn.setText("LOGIN");
		
		
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(startbtn, 0, 1);
		GridPane.setConstraints(helpbtn, 0, 2);
		GridPane.setConstraints(loginbtn, 0, 3);
		titlegrid.getChildren().add(title);
		titlegrid.getChildren().add(startbtn);
		titlegrid.getChildren().add(helpbtn);
		titlegrid.getChildren().add(loginbtn);
		
		StackPane root = new StackPane();
		root.getChildren().add(titlegrid);
		
		return new Scene(root, 275, 250);
	}	
}
