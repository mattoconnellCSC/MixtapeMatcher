package application;

import java.util.ArrayList;

public class Lobby {
	private String name;
	private ArrayList<String> playerNames;
	private String hostName;
	private String password;
	private boolean gameOver = false;
	
	public Lobby(String name, String hostName) {
		this.name = name;
		this.hostName = hostName;
	}

	public String getName() {
		return name;
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public void addPlayer(String uniqueName) {
		playerNames.add(uniqueName);
	}
	
	public Player getPlayer(String uniquePlayerName) {
		//query database of players for player will unique name
		//return player
		return null;
	}
	
	public String getWinner() {
		if (!gameOver)
			return null; //will write actuall error later
		
		for (Player p : )
	}
}
