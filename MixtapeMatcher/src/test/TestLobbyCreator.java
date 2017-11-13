package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.LobbyCreator;
import application.UIDriver;

/**
 * 
 * @author Natalie Wagner
 *
 */

public class TestLobbyCreator {

	@Test
	public void testSetPlayersSelected() {
		LobbyCreator lobby = new LobbyCreator(new UIDriver(null, null), null);
		lobby.setPlayersSelected();
		boolean isNumPlayersSelected = lobby.isNumPlayersSelected;
		
		assertEquals(true, isNumPlayersSelected);
	}
	
	@Test
	public void testSetNumSongsSelected() {
		LobbyCreator lobby = new LobbyCreator(new UIDriver(null, null), null);
		lobby.setNumSongsSelected();
		boolean isNumSongsSelected = lobby.isNumSongsSelected;
		
		assertEquals(true, isNumSongsSelected);
	}

}
