package test.Tanay;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Player;

public class TestPlayerInfo {

	@Test
	public void test1() {
		Player p = new Player("Tanacious");
		assertSame("Tanacious", p.getName());
	}
	
	@Test
	public void test2() {
		Player p = new Player("Tanacious");
		p.incrementScore();
		assertEquals(1, p.getScore());
	}

}
