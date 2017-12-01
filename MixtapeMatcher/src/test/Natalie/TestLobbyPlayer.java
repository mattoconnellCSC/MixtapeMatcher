package test.Natalie;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Lobby;
import application.Player;

public class TestLobbyPlayer {

	@Test
	public void testLobbyPlayerIntegration() {
		Lobby l = new Lobby();
		Player p = new Player("Tanacious");
		l.addPlayer(p);
		assertEquals(0, l.getNumPlayers());
	}
	
	@Test
	public void testLobbyPlayerIntegration2() {
		Lobby l = new Lobby();
		Player p = new Player("Tanacious");
		l.addPlayer(p);
		assertEquals(0, l.getPlayerList().get(0).getScore());
	}

}
