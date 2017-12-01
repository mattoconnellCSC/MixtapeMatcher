package test.Will;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestPlaylist {

	@Test
	public void testGetName() {
		String name = "My playlist";
		Playlist playlist = new Playlist("My playlist");
		assertEquals(playlist.getName(), name);
	}
	
	@Test
	public void testIsEmpty() {
		Playlist playlist = new Playlist("Will's playlist");
		playlist.addSong("Help", "Beatles");
		assertEquals(playlist.isEmpty(), false);
	}
	
	public void testIsEmptyTwo() {
		Playlist playlist = new Playlist("Will's playlist");
		playlist.addSong(new Song("Yellow Submarine", "Beatles"));
		assertEquals(playlist.isEmpty(), false);
	}

}
