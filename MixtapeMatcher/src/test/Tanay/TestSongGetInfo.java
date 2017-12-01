package test.Tanay;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;

public class TestSongGetInfo {
	
	@Test
	public void testGetLength() {
		Song s1 = new Song("Fiction", "Kygo", 1.62f);
		float length = s1.getLength();
		
		assertEquals(1.62f, length, 0.05f);
	}
	
	@Test
	public void testGetLink() {
		String link = "xx8800";
		Song s1 = new Song("Fiction", "Kygo", 1.62f, link);
		String retrievedLink = s1.getLink();
	
	assertEquals(retrievedLink, link);
	}
}
