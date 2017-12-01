package application;

import java.util.ArrayList;

/**
 * Logic class for the Guess part of the game 
 * @author Will
 *
 */

public class Guess {
	private Player player;
	private String answer;
	
	public Guess(Player currentPlayer, String answer) {
		player = currentPlayer;
		this.answer = answer;
	}
	
	public Player setScore() {
		if (player.getGuess().compareTo(answer) == 0)
			player.incrementScore();
		
		player.setGuess(null);
		
		return player;
	}
	
	public void setCurrentPlayer(Player player) {
		this.player = player;
	}
}
