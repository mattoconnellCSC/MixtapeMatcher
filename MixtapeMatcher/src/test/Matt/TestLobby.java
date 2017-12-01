package test.Matt;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Lobby;
import application.Playlist;

public class TestLobby {

	@Test
	public void testGetMaxSongs() {
		Lobby lobby = new Lobby();
		lobby.setMaxSongs(100);
		
		assertEquals(lobby.getMaxSongs(), 100);
	}
	
	@Test
	public void testGetTheme() {
		Lobby lobby = new Lobby();
		lobby.setTheme("spooky");
		
		assertEquals(lobby.getTheme(), "spooky");
	}
	
	@Test
	public void testGetNumPlayers() {
		Lobby lobby = new Lobby();
		lobby.setNumPlayers(1000);
		
		assertEquals(lobby.getNumPlayers(), 1000);
	}
	
	@Test
	public void testGetCurrentPlaylist() {
		Lobby lobby = new Lobby();
		Playlist p = new Playlist("zz");
		lobby.setCurrentPlaylist(p);
		
		assertEquals(lobby.getCurrentPlaylist(), p);
	}

}
