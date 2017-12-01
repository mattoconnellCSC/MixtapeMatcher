package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;

public class TestSong {

	@Test
	public void testGetTitleConstructor1() {
		Song song1 = new Song("Happy Hour", "The Housemartins");
		
		assertEquals(song1.getTitle(), "Happy Hour");
	}
	
	@Test
	public void testGetTitleConstructor2() {
		Song song1 = new Song("Where Did Our Love Go?", "Soft Cell", 193);
		
		assertEquals(song1.getTitle(), "Where Did Our Love Go?");
	}

	
	@Test
	public void testGetArtistConstructor1() {
		Song song1 = new Song("It's Not Unusual", "Tom Jones");
		
		assertEquals(song1.getArtist(), "Tom Jones");
	}
	
	@Test
	public void testGetArtistConstructor2() {
		Song song1 = new Song("Sympathy for the Devil", "The Rolling Stones", 377);
		
		assertEquals(song1.getArtist(), "The Rolling Stones");
	}
	
	@Test
	public void testGetLength() {
		Song song1 = new Song("Tongue Tied", "Grouplove", 218);
		
		assertEquals(song1.getLength(), 218, 0.001);
	}

}
