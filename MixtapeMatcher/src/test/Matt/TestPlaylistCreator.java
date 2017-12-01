package test.Matt;

import static org.junit.Assert.*;

import org.junit.Test;

import application.CreatePlaylistCreator;
import application.Song;

/**
 * Test Playlist Creator
 * @author Matt
 *
 */

public class TestPlaylistCreator {

	@Test
	public void testSongsAdded() {
		CreatePlaylistCreator cpc = new CreatePlaylistCreator(null, null);
		Song s1 = new Song("Hello", "Adele");
		Song s2;
		
		
		cpc.getSongs().add(s1);
		cpc.addButton(cpc.getSongs(), cpc.getMySongs());
		
		s2 = cpc.getMySongs().get(0);
		
		
		assertSame(s1.getTitle(), s2.getTitle());
	}
}
