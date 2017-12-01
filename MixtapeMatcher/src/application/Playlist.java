package application;

import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
		songs = new ArrayList<>();
	}

@java.lang.SuppressWarnings("squid:S1319")
	public ArrayList<Song> getSongs() { return songs; }
	public String getName() { return name; }
	public boolean isEmpty() { return songs.isEmpty(); }
	
	public void addSong(String title, String artist) {
		Song addition = new Song(title, artist);
		songs.add(addition);
	}
	
	public void addSong(Song s) {
		songs.add(s);
	}
}

