package test.Natalie;

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
	public void testGetSetPlayers() {
		Lobby lobby = new Lobby();
		
		lobby.addPlayer(new Player("Natalie"));
		ArrayList<Player> retrievedPlayers = lobby.getPlayerList();
		String retrievedPlayerName = retrievedPlayers.remove(0).getName();

		assertSame("Natalie", retrievedPlayerName);
	}
	
	@Test
	public void testGetSetMaxSongs() {
		int maxSongs = 4;
		Lobby lobby = new Lobby();
		
		lobby.setMaxSongs(maxSongs);
		int retreivedMaxSongs = lobby.getMaxSongs();

		assertSame(maxSongs, retreivedMaxSongs);
	}
	
	@Test
	public void testGetSetNumPlayers() {
		int numPlayers = 3;
		Lobby lobby = new Lobby();
		
		lobby.setNumPlayers(numPlayers);
		int retreivedNumPlayers = lobby.getNumPlayers();

		assertSame(numPlayers, retreivedNumPlayers);
	}
	
	@Test
	public void testGetSetTheme() {
		String theme = "faketheme";
		Lobby lobby = new Lobby();
		
		lobby.setTheme(theme);
		String retreivedTheme = lobby.getTheme();

		assertSame(theme, retreivedTheme);
	}

}
