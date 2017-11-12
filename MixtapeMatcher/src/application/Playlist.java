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
}
