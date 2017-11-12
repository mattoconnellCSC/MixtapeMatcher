package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneCreator {
	public abstract Scene createScene();
	
	public void setScene(Stage stage) {
		Scene scene = createScene();
		
		stage.setScene(scene);
	}
}
