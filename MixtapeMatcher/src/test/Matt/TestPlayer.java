package test.Matt;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;
import application.Playlist;
/**
 * 
 * @author Matt
 *
 */
public class TestPlayer {

	@Test
	public void testGetName() {
		Player p = new Player("Will");
		assertEquals(p.getName(), "Will");
	}
	
	@Test
	public void testGetPlaylist() {
		Player p = new Player("Will");
		Playlist p1 = new Playlist("JIM");
		p.setPlaylist(p1);
		
		assertEquals(p.getPlaylist(), p1);
	}
	
	@Test
	public void testGetScore() {
		Player p = new Player("Tanay");
		p.incrementScore();
		p.incrementScore();
		p.decrementScore();
		
		assertEquals(p.getScore(), 1);
	}

	@Test
	public void testGetGuess() {
		Player p = new Player("Bridget");
		p.setGuess("diamonds");
		
		assertEquals(p.getGuess(), "diamonds");
	}

}
