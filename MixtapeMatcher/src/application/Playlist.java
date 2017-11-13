// Bridget implementing as of Sunday Nov 12
// Methods commented out, waiting for Song methods

package application;

import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	private int current;
	
	public Playlist(String name) {
		this.name = name;
		current = -1;
	}
	
	public ArrayList<Song> getSongs() { return songs; }
	public String getName() { return name; }
	public boolean isEmpty() { return songs.isEmpty(); }
	
	public Song getCurrentSong() {
		if (!isEmpty())
			return songs.get(current);
		else
			return null;
	}
	
	// change accordingly
	public void addSong(String title, String artist) {
		Song addition = new Song(title, artist);
		songs.add(addition);
		
		// initialize current to first song
		if (current < 0)
			current = 0;
	}

	public void deleteSong(String title, String artist) {
		for (int i = 0; i < songs.size(); i ++) {
			Song s = songs.get(i);
			if (s.getTitle().equals(title) && s.getArtist().equals(artist)) {
				songs.remove(s);
			}
			
			// watch out when deleting the last item while playing
			if (current == songs.size())
				current = songs.size() - 1;
		}
	}
	
	public void play() {
		if (!isEmpty()) {
			String currSongLink = songs.get(current).getLink();
		}
	}
	public void pause() {
		//songs.get(current).pause();
	}
	
	public void skip() {
		//songs.get(current).pause();
		current++;
		//songs.get(current).reset();
		//songs.get(current).play();
	}
	
	public void rewind() {
		//songs.get(current).pause();
		//songs.get(current).reset();
		//songs.get(current).play();
	}
	
	// skip to previous song if this song has barely started
	public void back() {
		/*
		if (songs.getProgress() < 0.01) {
			songs.get(current).pause();
			current--;
		}
		*/
		rewind();
	}
}

