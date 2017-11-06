package application;

import java.util.ArrayList;

public class GameManager {
	private ArrayList<Lobby> lobbies;
	private static GameManager single_instance = null;
	
	private GameManager() {}
	
	public static GameManager getInstance() {
		if (single_instance == null)
			single_instance = new GameManager();
		
		return single_instance;
	}
}
