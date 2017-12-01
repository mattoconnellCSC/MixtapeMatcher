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
	public void testAddPlayer() {
		Lobby lobby = new Lobby();
		lobby.addPlayer(new Player("Natalie"));
		ArrayList<Player> retrievedPlayers = lobby.getPlayerList();
		String retrievedPlayerName = retrievedPlayers.remove(0).getName();

		assertSame("Natalie", retrievedPlayerName);
	}
	
	@Test
	public void testSetGetMaxSongs() {
		int maxSongs = 3;
		Lobby lobby = new Lobby();
		
		lobby.setMaxSongs(maxSongs);
		int retreivedMaxSongs = lobby.getMaxSongs();

		assertEquals(maxSongs, retreivedMaxSongs);
	}
	
	@Test
	public void testSetGetNumPlayers() {
		int numPlayers = 3;
		Lobby lobby = new Lobby();
		
		lobby.setNumPlayers(numPlayers);
		int retreivedNumPlayers = lobby.getNumPlayers();

		assertEquals(numPlayers, retreivedNumPlayers);
	}
	
	@Test
	public void testSetGetTheme() {
		String theme = "faketheme";
		Lobby lobby = new Lobby();
		
		lobby.setTheme(theme);
		String retreivedTheme = lobby.getTheme();

		assertEquals(theme, retreivedTheme);
	}

}
