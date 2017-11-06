package application;

public class Player {
	private String name;
	private Lobby lobby;

	// username is unique to this player, used to identify player within lobby
	private String username;
	private String password;

	private Playlist playlist;
	
	private int remaining; // remaining guesses
	private int score; // score for this game
	private int sumScores; // running total of scores 
	private int gamesPlayed; // number of games played
	private float average; // average score across games

	public Player() {}
	
	public Player(String name) {
		this.name = name;
		remaining = 3;
	}
	
	public void createPlaylist(String playlistName) {
		playlist = new Playlist(playlistName);
	}
	
	public String getName() { return name; }
	public Playlist getPlaylist() { return playlist; }
	
	public String getUsername() { return username; }
	public String getPassword() { return password; } // seems like a bad idea
	
	public int getRemaining() { return remaining; }
	public int getScore() { return score; }
	public int getGamesPlayed() { return gamesPlayed; }
	public float getAverage() { return average; }
	
	public void findSumScores() { sumScores += score; }
	public void findAverage() {
		average = (float) sumScores / gamesPlayed;
	}
	
	public void makeGuess() {
		remaining -= 1;
		lobby.updatePlayerStatus(name, remaining);
	}
}
