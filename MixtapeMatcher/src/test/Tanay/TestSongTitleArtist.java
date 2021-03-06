package test.Tanay;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;

public class TestSongTitleArtist {

	@Test
	public void testSongTitle() {
		String title = "Hello";
		String artist = "Adele";
		
		Song s1 = new Song(title, artist);
		String retreivedTitle = s1.getTitle();
		
		assertSame(title, retreivedTitle);
	}
	
	@Test
	public void testSongArtist() {
		String title = "Hello";
		String artist = "Adele";
		
		Song s1 = new Song(title, artist);
		String retreivedArtist = s1.getArtist();
		
		assertSame(artist, retreivedArtist);
	}
	
}
