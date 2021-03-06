package application;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * Results Display Page, no user interaction until very end.
 * @author Matt
 *
 */

@java.lang.SuppressWarnings("squid:S1604")
public class ResultsCreator extends SceneCreator {

	private Lobby l;
	private TableView resultsTable = new TableView();
	private ArrayList<Player> playerList = new ArrayList<>();
	
	public ResultsCreator(Observer o, Lobby l) {
		super(o);
		this.l = l;
		playerList = l.getPlayerList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override 
	public Scene createScene(Stage stage) {
		AnchorPane anchor = new AnchorPane();
		ObservableList<Person> players = FXCollections.observableArrayList();
		
		anchor.setPadding(new Insets(10, 10, 10, 10));
		
		//Screen Title displayed and anchored at top
		Label titleText = new Label("Results");
		titleText.getStyleClass().add("label-title");
		titleText.setAlignment(Pos.CENTER);
		HBox titleBox = new HBox();
		titleBox.setPadding(new Insets(15, 10, 10, 10));
		titleBox.getChildren().add(titleText);
		titleBox.setAlignment(Pos.TOP_CENTER);
		
		AnchorPane.setTopAnchor(titleBox, null);
		
		for(int i = 0; i < playerList.size(); i++) {
			players.add(new Person(playerList.get(i).getName(), playerList.get(i).getScore()));
		}
		
		
		// The Results Table, non Editable, automatically updated with each reveal
		resultsTable.setEditable(false);
		
		resultsTable.setPrefSize(300.0, 300.0);
		
		TableColumn playerColumn = new TableColumn("Players");
		playerColumn.setMinWidth(100.0);
		playerColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("playerName"));
		TableColumn scoreColumn = new TableColumn("Score");
		scoreColumn.setMinWidth(100.0);
		scoreColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("score"));

		
		
		

		Button resetBtn = new Button("Back to Home");
		resetBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				notifyObserver("return");
			}
		});
		
		
		
		resultsTable.setItems(players);
		resultsTable.getColumns().addAll(playerColumn, scoreColumn);

		HBox rBox = new HBox();
		HBox bottomHBox = new HBox();
		rBox.setSpacing(50.0);
		rBox.getChildren().add(resultsTable);
		
		
		bottomHBox.getChildren().add(resetBtn);
		AnchorPane.setBottomAnchor(bottomHBox, 100.0);
		AnchorPane.setRightAnchor(bottomHBox, 50.0);
		
		AnchorPane.setBottomAnchor(rBox, 100.0);		
		AnchorPane.setTopAnchor(rBox, 100.0);
		AnchorPane.setLeftAnchor(rBox, 100.0);		
		AnchorPane.setRightAnchor(rBox, 100.0);
		
		anchor.getChildren().addAll(titleBox, rBox, bottomHBox);
		Scene resultScene = new Scene(anchor, 800, 800);
		resultScene.getStylesheets().add("application/application.css");
		return resultScene;
	}
	
	
	
	// Helper class to display the table
    public static class Person {
    	 
        private final SimpleStringProperty playerName;
        private final SimpleStringProperty score;
 
        private Person(String name, Integer score) {
            playerName = new SimpleStringProperty(name);
            this.score = new SimpleStringProperty(score.toString());
        }
 
        public String getPlayerName() {
            return playerName.get();
        }
 
        public void setPlayerName(String nName) {
            playerName.set(nName);
        }

        public String getScore() {
        	return score.get();
        }
        
        
        public void setScore(Integer value) {
        	score.set(value.toString());
        }
    }
}
