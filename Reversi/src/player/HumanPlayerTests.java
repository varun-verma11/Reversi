package player;

import static org.junit.Assert.*;
import game.Colour;

import org.junit.Test;

public class HumanPlayerTests
{

	@Test
	public void testForNames()
	{
		assertEquals("a", new HumanPlayer("a", Colour.BLACK, null).getName());
		assertEquals("humanPlayer", new HumanPlayer("humanPlayer", Colour.BLACK, null).getName());
		assertEquals("iAmHumanPlayer", new HumanPlayer("iAmHumanPlayer", Colour.BLACK, null).getName());
	}
	
	@Test
	public void testForColour()
	{
		assertEquals(Colour.BLACK, new HumanPlayer("humanPlayer", Colour.BLACK, null).getColour());
		assertEquals(Colour.WHITE, new HumanPlayer("humanPlayer", Colour.BLACK, null).getColour());
	}
	
}
