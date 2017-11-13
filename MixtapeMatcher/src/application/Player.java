package application;

public class Player {
	private String name;

	private Playlist playlist;
	
	private int score; // score for this game
	private int sumScores; // running total of scores 
	private int gamesPlayed; // number of games played
	private float average; // average score across games
	
	public Player(String name) {
		this.name = name;
	}
	
	public void createPlaylist(String playlistName) {
		playlist = new Playlist(playlistName);
	}
	
	public String getName() {
		return name;
	}
	
	public Playlist getPlaylist() {
		return playlist;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public float getAverage() {
		return average;
	}
	
	public void findSumScores() {
		sumScores += score;
	}
	
	public void findAverage() {
		average = (float) sumScores / gamesPlayed;
	}
}
