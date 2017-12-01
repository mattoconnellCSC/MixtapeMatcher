package test.Tanay;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Playlist;
import application.Song;

public class TestPlaylistSong {

	@Test
	public void testPlaylistSongInteraction() {
		Playlist p = new Playlist("Chill Playlist");
		Song s = new Song("Fiction", "Kygo");
		p.addSong(s);
		ArrayList<Song> songs = p.getSongs();
		assertSame("Fiction", songs.get(0).getTitle());
	}
	
	@Test
	public void testPlaylistSongInteraction2() {
		Playlist p = new Playlist("Chill Playlist");
		p.addSong("Fiction", "Kygo");
		ArrayList<Song> songs = p.getSongs();
		assertSame("Fiction", songs.get(0).getTitle());
	}

}
