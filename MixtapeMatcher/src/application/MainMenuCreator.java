package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main Menu for everything! 
 * @author Jordan, Matt, Natalie
 *
 */
public class MainMenuCreator extends SceneCreator {

	public MainMenuCreator(Observer o) {
		super(o);
	}

	@Override
	public Scene createScene(Stage stage) {
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(15, 15, 15, 15));
		
		GridPane titlegrid = new GridPane();
		titlegrid.setPadding(new Insets(10, 10, 10, 10));
		titlegrid.setVgap(10.0);
		titlegrid.setHgap(5.0);
		titlegrid.setAlignment(Pos.CENTER);
		HBox topBox = new HBox();
		Label title = new Label("Mixtape Matcher");
		title.setStyle("-fx-font-size: 75");
		title.setEffect(neonBlend());
		topBox.setMaxWidth(Double.MAX_VALUE);
		topBox.setPrefHeight(250.0);
		topBox.setAlignment(Pos.BOTTOM_CENTER);
		topBox.getChildren().add(title);
		AnchorPane.setRightAnchor(topBox, 25.0);
		AnchorPane.setLeftAnchor(topBox, 25.0);
		AnchorPane.setTopAnchor(topBox, 25.0);
		
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
		helpbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				notifyObserver("help"); //send next scene to UIDriver
			}
		});
		
		Button exitButton = new Button();
		exitButton.setAlignment(Pos.TOP_CENTER);
		helpbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				//exit
			}
		});
		
		startbtn.setText("START");
		helpbtn.setText("HELP");
		exitButton.setText("EXIT");
		
		GridPane.setConstraints(startbtn, 0, 1);
		GridPane.setConstraints(helpbtn, 0, 2);
		GridPane.setConstraints(exitButton, 0, 3);
		titlegrid.getChildren().add(startbtn);
		titlegrid.getChildren().add(helpbtn);
		titlegrid.getChildren().add(exitButton);
		
		StackPane root = new StackPane();
		root.getChildren().add(titlegrid);
		
		AnchorPane.setBottomAnchor(root, 10.0);
		AnchorPane.setLeftAnchor(root, 10.0);
		AnchorPane.setTopAnchor(root, 10.0);
		AnchorPane.setRightAnchor(root, 10.0);
		anchor.getChildren().addAll(topBox, root);
		Scene mainmenuScene = new Scene(anchor, 275, 250);
		mainmenuScene.getStylesheets().add("application/application.css");
		
		return mainmenuScene;
	}
	
	public Blend neonBlend() {
		//Develop Neon effects for Title
				Blend blend = new Blend(null, null, null);
				blend.setMode(BlendMode.MULTIPLY);
				DropShadow ds = new DropShadow();
				ds.setColor(Color.rgb(254, 235, 66, 0.3));
				ds.setOffsetX(5);
				ds.setOffsetY(5);
				ds.setRadius(5);
				ds.setSpread(0.2);
				
				blend.setBottomInput(ds);
				
				DropShadow ds1 = new DropShadow();
				ds1.setColor(Color.web("#f13a00"));
				ds1.setRadius(20);
				ds1.setSpread(0.2);
				
				Blend blend2 = new Blend();
				blend2.setMode(BlendMode.MULTIPLY);

				InnerShadow is = new InnerShadow();
				is.setColor(Color.web("#feeb42"));
				is.setRadius(9);
				is.setChoke(0.8);
				blend2.setBottomInput(is);

				InnerShadow is1 = new InnerShadow();
				is1.setColor(Color.web("#f13a00"));
				is1.setRadius(5);
				is1.setChoke(0.4);
				blend2.setTopInput(is1);

				Blend blend1 = new Blend();
				blend1.setMode(BlendMode.MULTIPLY);
				blend1.setBottomInput(ds1);
				blend1.setTopInput(blend2);

				blend.setTopInput(blend1);
				
			return blend;
	}
}
	
