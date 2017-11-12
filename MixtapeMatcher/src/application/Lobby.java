// Lobby is an instance of the game
// could act as an intermediary between main and player
//   get info from main, give it to player
//   handles guesses, determines who wins

package application;

import java.util.ArrayList;
import java.util.Hashtable;

public class Lobby {
	private String name;
	private ArrayList<Player> players;
	private Hashtable<String, Integer> gameStatus; // 0 not done, 1 done
	private String hostName;
	private String password;
	private boolean gameOver = false;
	
	public Lobby(String name, String hostName) {
		this.name = name;
		this.hostName = hostName;
		players = new ArrayList<Player>();
		gameStatus = new Hashtable<String, Integer>();
	}

	public void updatePlayerStatus(String pname, Integer status) {
		gameStatus.put(pname, status);
	}
	
	public void setGameOver() {
		for (Player p : players) {
			String pname = p.getName();
			
			if (gameStatus.get(pname) == 0) {
				gameOver = false;
				break;
			}
		}
		
		gameOver = true;
	}
	
	public String getName() { return name; }
	public String getHostName() { return hostName; }
	
	public void addPlayer(String uniqueName) {
		// query the database?
	}
	
	public Player getPlayer(String uniquePlayerName) {
		//query database of players for player will unique name
		//return player
		return null;
	}
	
	/*public String getWinner() {
	} */
}
