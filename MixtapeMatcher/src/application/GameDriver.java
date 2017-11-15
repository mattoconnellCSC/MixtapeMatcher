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
	private Lobby lobby;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
	    	UIDriver driver = new UIDriver(primaryStage, this);	    	
	    	driver.setMainMenu();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Object data) {
		Lobby l = (Lobby) data;
		this.lobby = l;
	}
}
