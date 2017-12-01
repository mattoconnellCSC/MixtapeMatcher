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

public class PlaylistCreatorTester {
	
	@Test
	public void testSongsAdded() {
		CreatePlaylistCreator cpc = new CreatePlaylistCreator(null, null);
		Song s1 = new Song("Hello", "Adele");
		Song s2;
		
		
		cpc.songs.add(s1);
		cpc.addButton(cpc.songs, cpc.mySongs);
		
		s2 = cpc.mySongs.get(0);
		
		
		assertSame(s1.getTitle(), s2.getTitle());
	}
	
}
