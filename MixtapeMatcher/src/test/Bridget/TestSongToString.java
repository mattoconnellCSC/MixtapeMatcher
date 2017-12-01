package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;


/**
 * Test Song toString
 * @author Matt
 *
 */

public class TestSongToString {

	@Test
	public void testToString() {
		Song s = new Song("A", "B");
		String tostring = "Title: A\nArtist: B";
		
		assertEquals(s.toString(), tostring);
	}
	
	@Test
	public void testToStringEmpty() {
		Song s = new Song("", "");
		String tostring = "Title: \nArtist: ";
		
		assertEquals(s.toString(), tostring);
	}

}
