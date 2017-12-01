package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestPlaylistAddSong {

	@Test
	public void testAddSongByTitleArtist() {
		Playlist mine = new Playlist("Bridget");
		Song s = new Song("A", "B");
		mine.addSong(s);
		
		assertEquals(mine.getSongs().get(0).getArtist(), "B");
	}
	
	@Test
	public void testAddSongObjectByTitleArtist() {
		Playlist mine = new Playlist("Bridget");
		Song s = new Song("A", "B");
		mine.addSong(s);
		
		assertEquals(mine.getSongs().get(0).getTitle(), "A");
	}

	@Test
	public void testAddSongObjectByTitleArtistLength() {
		Playlist mine = new Playlist("Bridget");
		Song s = new Song("A", "B", (float)120.5);
		mine.addSong(s);
		
		assertEquals(mine.getSongs().get(0).getLength(), (float)120.5, 0.00001);
	}
	
}
