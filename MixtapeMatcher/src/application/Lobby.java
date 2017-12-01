// Lobby is an instance of the game
// could act as an intermediary between main and player
//   get info from main, give it to player
//   handles guesses, determines who wins

package application;

import java.util.ArrayList;

public class Lobby {
	private ArrayList<Player> players;
	private int maxSongs;
	private int numPlayers;
	private String theme;
	private int playlistsHeard = 0;
	private Playlist currentPlaylist;
	
	public Lobby() {
		players = new ArrayList<>();
	}
	
	public int getMaxSongs() {
		return maxSongs;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}


@java.lang.SuppressWarnings("squid:S1319")
	public ArrayList<Player> getPlayerList() {
		return players;
	}
	
	public void setNumPlayers(int num) {
		this.numPlayers = num;
	}
	
	public int getNumPlayers() {
		return this.numPlayers;
	}

	public void setMaxSongs(int n) {
		this.maxSongs = n;
	}

	public void setTheme(String t) {
		this.theme = t;
	}
	
	public String getTheme() {
		return theme;
	}
	
	public Playlist getNextPlaylist() {
		Player current = players.get(playlistsHeard);
		Playlist p = current.getPlaylist();
		playlistsHeard++;
		
		return p;
	}
	
	public Playlist getCurrentPlaylist( ) {
		return currentPlaylist;
	}
	
	public void setCurrentPlaylist(Playlist p) {
		currentPlaylist = p;
	}
	
}
