package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.UIDriver;
import javafx.stage.Stage;

/**
 * Test UIDriver! :)
 * @author Jordan
 *
 */
public class UIDriverTester {

	@Test
	public void setMainMenuTest() {
		Stage stage = new Stage();
		UIDriver uid = new UIDriver(stage, null);
		uid.setMainMenu(stage);
		String title = stage.getTitle();
		
		assertSame(title, "Mixtape Matcher");
	}

}
