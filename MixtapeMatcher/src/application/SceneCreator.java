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
	public abstract Scene createScene(Stage stage);
	
	public void setScene(Stage stage, String title) {
		Scene scene = createScene(stage);
		
		stage.setScene(scene);
		stage.setTitle(title);
		stage.show();
	}
}
