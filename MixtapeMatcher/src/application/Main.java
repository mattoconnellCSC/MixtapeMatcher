package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane titlegrid = new GridPane();
		titlegrid.setPadding(new Insets(10, 10, 10, 10));
		Label title = new Label("MixtapeMatcher");
		Button startbtn = new Button();
		Button helpbtn = new Button();
		startbtn.setText("START");
		helpbtn.setText("HELP");
		
		
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(startbtn, 0, 1);
		GridPane.setConstraints(helpbtn, 0, 2);
		titlegrid.getChildren().add(title);
		titlegrid.getChildren().add(startbtn);
		titlegrid.getChildren().add(helpbtn);
		
		StackPane root = new StackPane();
		root.getChildren().add(titlegrid);
		
		 Scene scene = new Scene(root, 275, 250);

	     primaryStage.setTitle("Calc");
	     primaryStage.setScene(scene);
	     primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
