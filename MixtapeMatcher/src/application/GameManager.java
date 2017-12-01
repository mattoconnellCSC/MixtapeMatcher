package application;

import java.util.ArrayList;

public class GameManager {
	private ArrayList<Lobby> lobbies;
	private static GameManager singleInstance = null;
	
	private GameManager() {}
	
	public static GameManager getInstance() {
		if (singleInstance == null)
			singleInstance = new GameManager();
		
		return singleInstance;
	}
}
