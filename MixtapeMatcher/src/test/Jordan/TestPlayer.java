package test.Jordan;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;

/**
 * Test Player Object
 * @author Jordan
 *
 */
public class TestPlayer {

	@Test
	public void testPlayerCreated() {
		Player p = new Player("Jordan");
		
		assertSame("Jordan", p.getName());
	}
}
