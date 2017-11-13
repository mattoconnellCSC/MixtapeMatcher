package test;

import static org.junit.Assert.*;
import application.Lobby;
import org.junit.Test;

/**
 * 
 * @author Natalie Wagner
 *
 */

public class TestLobby {

	@Test
	public void test() {
		String lobbyName = "dummy lobby";
		Lobby lobby = new Lobby(lobbyName);
		String retrievedLobbyName = lobby.getName();
		
		assertSame(lobbyName, retrievedLobbyName);
	}

}
