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
public abstract class SceneCreator implements Subject {	
	protected Observer o;
	
	public SceneCreator(Observer o) {
		this.o = o;
	}
	
	public abstract Scene createScene(Stage stage);
	
	public void notifyObserver(Object data) {
		o.update(data);
	}
	
	public void setScene(Stage stage, String title) {
		Scene scene = createScene(stage);
		
		stage.setScene(scene);
		stage.setTitle(title);
		stage.show();
	}
}
