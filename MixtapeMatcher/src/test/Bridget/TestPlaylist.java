package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestPlaylist {

	@Test
	public void testGetName() {
		Playlist mine = new Playlist("My Playlist");
		
		assertEquals(mine.getName(), "My Playlist");
	}
	
	@Test
	public void testGetSongs() {
		Playlist mine = new Playlist("My Playlist");

		mine.addSong("Help", "Beatles");
		mine.addSong("Waves",  "Electric Guest");
		
		assertEquals(mine.isEmpty(), false);
	}
	
	@Test
	public void testDeleteSong() {
		Playlist mine = new Playlist("My Playlist");

		mine.addSong("Help", "Beatles");
		mine.deleteSong("Help",  "Beatles");
		
		assertEquals(mine.isEmpty(), true);
	}

	
	@Test
	public void testGetCurrentSong() {
		Playlist mine = new Playlist("My Playlist");
		Song song1 = new Song("Stayin' Alive", "Bee Gees");
		mine.addSong(song1);
		
		assertEquals(mine.getCurrentSong(), song1);
	}
}
