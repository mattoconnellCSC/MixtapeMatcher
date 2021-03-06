package application;

public class Song {
	private String title;
	private String artist;
	private float length;
	private String link;
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public Song(String title, String artist, float length) {
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	
	public Song(String title, String artist, float length, String link) {
		this.title = title;
		this.artist = artist;
		this.length = length;
		this.link = link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String toString() {
		return ("Title: " + this.title + "\nArtist: " + this.artist);
	}
	
	public String getTitle() { return this.title; }
	public String getArtist() { return this.artist; }
	public float getLength() { return this.length; }
	public String getLink() { return this.link; }
}
