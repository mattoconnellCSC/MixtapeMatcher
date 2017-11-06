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
}
