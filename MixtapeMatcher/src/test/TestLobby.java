package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import application.Lobby;
import application.Player;

import org.junit.Test;

/**
 * 
 * @author Natalie Wagner
 *
 */

public class TestLobby {

	@Test
	public void test() {
		Lobby lobby = new Lobby();
		lobby.addPlayer(new Player("Natalie"));
		ArrayList<Player> retrievedPlayers = lobby.getPlayerList();
		String retrievedPlayerName = retrievedPlayers.remove(0).getName();

		assertSame("Natalie", retrievedPlayerName);
	}

}
