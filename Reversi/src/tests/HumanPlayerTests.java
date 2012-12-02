package tests;

import static org.junit.Assert.assertEquals;
import game.Colour;

import org.junit.Test;

import player.HumanPlayer;
import player.Player;

public class HumanPlayerTests
{

	@Test
	public void testForNames()
	{
		Player player = new HumanPlayer("a", Colour.BLACK, null);
		assertEquals("a", player.getName());
		player = new HumanPlayer("humanPlayer", Colour.BLACK, null);
		assertEquals("humanPlayer", player.getName());
		player = new HumanPlayer("iAmHumanPlayer", Colour.BLACK, null);
		assertEquals("iAmHumanPlayer", player.getName());
	}
	
	@Test
	public void testForColour()
	{
		Player player = new HumanPlayer("humanPlayer", Colour.BLACK, null);
		
		assertEquals(Colour.BLACK, player.getColour());
		player = new HumanPlayer("humanPlayer", Colour.WHITE, null);
		assertEquals(Colour.WHITE, player.getColour());
	}
	
}
