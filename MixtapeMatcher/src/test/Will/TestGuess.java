package test.Will;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Guess;
import application.Player;
/**
 * 
 * @author Will
 *
 */
public class TestGuess {

	@Test
	public void testSetScore() {
		Player p1 = new Player("Will");
		p1.setGuess("abc");
		
		String ans = "ggg";
		Guess g = new Guess(p1, ans);
		
		Player p2 = g.getPlayer();
		Player p3 = g.setScore();
	
		assertEquals(p2, p3);
	}
	
	@Test
	public void testSetCurrentPlayer() {
		Player p1 = new Player("Will");
		Player p2 = new Player("Tanay");
		
		String ans = "bbb";
		Guess g = new Guess(p1, ans);
		
		g.setCurrentPlayer(p2);
		
		assertEquals(g.getPlayer().getName(), p2.getName());
	}

}
