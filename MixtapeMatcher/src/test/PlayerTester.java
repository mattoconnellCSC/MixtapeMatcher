package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;

/**
 * Test Player Object
 * @author Jordan
 *
 */
public class PlayerTester {

	@Test
	public void testPlayerCreated() {
		Player p = new Player("Jordan");
		
		assertSame(p.getName(), "Jordan");
	}
}
