package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;
import application.Playlist;

public class TestPlayerPlaylistIntegration {

	@Test
	public void testGetPlaylist() {
		Player p = new Player("Natalie");
		Playlist PL = new Playlist("my pl");
		
		p.setPlaylist(PL);
		assertEquals(p.getPlaylist().getName(), PL.getName());
	}
	
}
