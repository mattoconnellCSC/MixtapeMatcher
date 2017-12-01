package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestPlaylistGetters {
	
	@Test
	public void testGetName() {
		Playlist mine = new Playlist("Bridget");
		
		assertEquals(mine.getName(), "Bridget");
	}

	@Test
	public void testIsEmptyTrue() {
		Playlist mine = new Playlist("Bridget");
		
		assertEquals(mine.isEmpty(), true);
	}
	
	@Test
	public void testIsEmptyFalse() {
		Playlist mine = new Playlist("Bridget");
		Song s = new Song("A", "B");
		mine.addSong(s);
		
		assertEquals(mine.isEmpty(), false);
	}
	
}
