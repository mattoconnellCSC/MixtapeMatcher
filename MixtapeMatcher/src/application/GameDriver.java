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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class GameDriver extends Application {
	@Override
	public void start(Stage primaryStage) {
	    	UIDriver driver = new UIDriver(primaryStage);
	    	setMainMenu(primaryStage);
	    	
	    	driver.start();
	}
	
	public void setMainMenu(Stage stage) {
		MainMenuCreator menu = new MainMenuCreator();
		menu.setScene(stage, "Mixtape Matcher");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
