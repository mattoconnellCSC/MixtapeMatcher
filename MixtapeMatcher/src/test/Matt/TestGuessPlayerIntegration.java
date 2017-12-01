package test.Matt;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Guess;
import application.Player;

/**
 * 
 * @author Matt
 *
 */

public class TestGuessPlayerIntegration {

	private Guess makeGuess;
	@Test
	public void testGuessPlayerIntegration() {
		Player p = new Player("Matt");
		p.setGuess("Tanay");
		makeGuess = new Guess(p, "Tanay");
		System.out.println(p.getScore());
		assertEquals(p.getScore(), 0);
	}
	
	@Test
	public void testGuessPlayerIntegration2() {
		Player p = new Player("Matt");
		p.incrementScore();
		p.incrementScore();
		assertEquals(p.getScore(), 2);
	}

}
