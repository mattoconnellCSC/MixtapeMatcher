package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;

public class TestSongCreator {

	@Test
	public void testCreateSong() {
		Song s1 = new Song("Fiction", "Kygo");
		String title = s1.getTitle();
		
		assertEquals("Fiction", title);
	}
	
	@Test
	public void testCreateSong2() {
		Song s1 = new Song("Fiction", "Kygo", 1.62f);
		float length = s1.getLength();
		
		assertEquals(1.62f, length, 0.05f);
	}

}
