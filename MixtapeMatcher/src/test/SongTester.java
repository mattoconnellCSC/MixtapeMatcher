package test;
import static org.junit.Assert.*;

import org.junit.Test;

import application.CreatePlaylistCreator;
import application.Player;
import application.Song;

/**
 * Test Song Object
 * @author Matt
 *
 */

public class SongTester {
	
	@Test
	public void testSongTitle() {
		Song s1 = new Song("Hello", "Adele");
		
		assert((s1.getTitle()).equals("Hello"));
	}
	
	@Test
	public void testSongArtist() {
		Song s1 = new Song("Hello", "Adele");
		
		assert((s1.getArtist()).equals("Adele"));
	}
	
}