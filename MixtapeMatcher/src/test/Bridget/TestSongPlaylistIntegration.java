package test.Bridget;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestSongPlaylistIntegration {

	@Test
	public void test() {
		Playlist playlist = new Playlist("title");
		Song song = new Song("title", "artist");
		
		playlist.addSong(song);
		
		assertSame(playlist.getSongs().get(0), song);
	}

}
