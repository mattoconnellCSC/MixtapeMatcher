package application;

import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist() {}
	
	public Playlist(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}
	
	public String getName() {
		return name;
	}
}
