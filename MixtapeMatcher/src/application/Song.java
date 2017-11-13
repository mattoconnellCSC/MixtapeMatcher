// @Bridget from PL requests Songs have play(), pause(), reset()
//   also getProgress() (etc) to get song progress
// TODO: w/ Bridget, play songs consecutively in Playlist

package application;

public class Song {
	private String title;
	private String artist;
	private float length;
	
	public Song() {}
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public Song(String title, String artist, float length) {
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	
	public String getTitle() { return this.title; }
	public String getArtist() { return this.artist; }
	public float getLength() { return this.length; }
}
