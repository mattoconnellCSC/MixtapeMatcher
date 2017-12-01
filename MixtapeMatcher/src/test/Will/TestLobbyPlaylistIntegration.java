package test.Will;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Lobby;
import application.Playlist;

public class TestLobbyPlaylistIntegration {

	private Playlist pl = new Playlist("name");
	@Test
	public void testLobbyPlaylist() {
		Lobby l = new Lobby();
		l.setCurrentPlaylist(pl);
		assert(l.getCurrentPlaylist().getName().equals(pl.getName()));
	}

}
