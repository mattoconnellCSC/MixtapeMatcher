package application;

/**
 * 
 * @author Natalie, Bridget?
 *
 */

public class Player {
	private String name;
	private String guess;

	private Playlist playlist;
	
	private int score; // score for this game
	private int sumScores; // running total of scores 
	private int gamesPlayed; // number of games played
	private float average; // average score across games
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
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
	
	public void incrementScore() {
		score++;
	}
	
	public void decrementScore() {
		score--;
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
	
	public String getGuess() {
		return guess;
	}
	
	public void setGuess(String g) {
		guess = g;
	}
	
}
