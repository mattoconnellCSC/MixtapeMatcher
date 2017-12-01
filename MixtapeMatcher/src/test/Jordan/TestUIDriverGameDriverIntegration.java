package test.Jordan;

import static org.junit.Assert.*;

import org.junit.Test;

import application.GameDriver;
import application.Lobby;
import application.UIDriver;
import javafx.stage.Stage;

/**
 * Test (basic) integration between UIDriver and GameDriver
 * @author Jordan
 *
 */
public class TestUIDriverGameDriverIntegration {

	@Test
	public void testGiveLobby() {
		GameDriver gd = new GameDriver();
		UIDriver ui = new UIDriver(null, gd);
				
		ui.giveLobby(gd.getLobby());
		
		assertSame(ui.getLobby(), gd.getLobby());
	}

}
