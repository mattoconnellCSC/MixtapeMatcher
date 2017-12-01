package test.Jordan;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;
import application.Playlist;

public class TestPlayerPlaylistIntegration {

	@Test
	public void testPlaylistAcquired() {
		Player player = new Player("Jordan");
		Playlist playlist = new Playlist("Playlist Title");
		
		player.setPlaylist(playlist);
		
		assertSame(player.getPlaylist(), playlist);
	}
}
