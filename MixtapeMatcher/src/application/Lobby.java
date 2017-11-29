// Lobby is an instance of the game
// could act as an intermediary between main and player
//   get info from main, give it to player
//   handles guesses, determines who wins

package application;

import java.util.ArrayList;
import java.util.Hashtable;

public class Lobby {
	private ArrayList<Player> players;
	public int maxSongs;
	
	public Lobby() {
		players = new ArrayList<Player>();
	}
	
	public int getMaxSongs() {
		return maxSongs;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public ArrayList<Player> getPlayerList() {
		return players;
	}
	
}
