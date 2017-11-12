package application;

import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
	}
	
	public ArrayList<Song> getSongs() { return songs; }
	public String getName() { return name; }
	

	// change accordingly
	public void addSong(String title, String artist) {
		Song addition = new Song(title, artist);
		songs.add(addition);
	}

	public void deleteSong(String title, artist) {
		for (Song s : songs) {
			if (s.getTitle().equals(title) && s.getArtist().equals(artist))
				songs.remove(s);
		}
	}
	
}
