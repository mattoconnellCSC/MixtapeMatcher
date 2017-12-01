package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Creates the help screen
 * @author Natalie
 *
 */

public class HelpScreenCreator extends SceneCreator {
	
	public HelpScreenCreator(Observer o) {
		super(o);
	}
	
	Button back;


@java.lang.SuppressWarnings("squid:S1604")
	@Override
	public Scene createScene(Stage stage)
	{
		AnchorPane anchor = new AnchorPane();
		HBox header = new HBox();
		GridPane lobbygrid = new GridPane();
		lobbygrid.setPadding(new Insets(10, 10, 10, 10));
		lobbygrid.setVgap(10.0);
		lobbygrid.setHgap(5.0);
		lobbygrid.setAlignment(Pos.CENTER);
		Label title = new Label("Help");
		title.setFont(Font.font(null, FontWeight.BOLD, 36));
		
		header.setAlignment(Pos.BASELINE_LEFT);
		header.getChildren().add(title);
		AnchorPane.setTopAnchor(header, 10.0);
		AnchorPane.setLeftAnchor(header, 10.0);
		AnchorPane.setRightAnchor(header, 10.0);
		
		Label intructionsTitle = new Label("Game Instructions:");
		intructionsTitle.setAlignment(Pos.TOP_CENTER);
		
		Label instructions = new Label("1. Click start.\n"
				+ "2. Select number of players, select the maximum number of songs each player can add, and add\n"
				+ "     a theme (if desired).\n"
				+ "\t• There can be 3-6 players.\n"
				+ "\t• The maximum selection for number of songs in a playlist is 4.\n"
				+ "3. Each player then must input their name and select their songs (don't let the other players\n"
				+ "     see what you chose!).\n"
				+ "4. Listen to each playlist.\n"
				+ "5. Each player takes their turn guessing which player created each playlist.\n"
				+ "6. Points are awarded to each player for their correct guesses.\n");
		instructions.setAlignment(Pos.TOP_CENTER);

		back = new Button();
		back.setAlignment(Pos.TOP_LEFT);
		back.setText("Back");
		
		back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    		notifyObserver("mainmenu"); //tell UI Driver to move to next Scene
		    }
		});
		
		GridPane.setConstraints(intructionsTitle, 0, 1);
		GridPane.setConstraints(instructions, 0, 3);
		GridPane.setConstraints(back, 0, 8);
		lobbygrid.getChildren().add(intructionsTitle);
		lobbygrid.getChildren().add(instructions);
		lobbygrid.getChildren().add(back);
		
		StackPane root = new StackPane();
		root.getChildren().add(lobbygrid);
		AnchorPane.setTopAnchor(root, 10.0);
		AnchorPane.setRightAnchor(root, 10.0);
		AnchorPane.setBottomAnchor(root, 10.0);
		AnchorPane.setLeftAnchor(root, 10.0);
		anchor.getChildren().addAll(header, root);
		
		Scene helpScene = new Scene(anchor, 800, 800);
		helpScene.getStylesheets().add("application/application.css");
		
		return helpScene;
	}

}
