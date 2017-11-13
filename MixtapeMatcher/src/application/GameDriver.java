package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class GameDriver extends Application implements Observer {
	@Override
	public void start(Stage primaryStage) {
	    	UIDriver driver = new UIDriver(primaryStage, this);
	    	driver.setMainMenu();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Object data) {
		// get text input of numPlayers, numSongs, and optional theme
	}
}
