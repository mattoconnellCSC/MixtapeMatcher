package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Song;

public class SongTester {

	@Test
	public void testLinkGetter() {
		Song s1 = new Song("Fiction", "Kygo", 1.63f, "https://www.youtube.com/watch?v=kZx6amZDRSo");
		String link = s1.getLink();
		
		assertEquals("https://www.youtube.com/watch?v=kZx6amZDRSo", link);
	}

}
