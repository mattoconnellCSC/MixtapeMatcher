package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Abstract class to create each different UI screen.
 * Concrete children (e.g. MainMenu) will fill implement createScene(), and
 * call setScene to display their screen.
 * @author Jordan
 *
 */
public abstract class SceneCreator {
	public abstract Scene createScene();
	
	public void setScene(Stage stage) {
		Scene scene = createScene();
		
		stage.setScene(scene);
	}
}
