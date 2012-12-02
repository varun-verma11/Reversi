package tests;

import static org.junit.Assert.assertEquals;
import game.Board;
import game.Colour;
import game.Game;
import game.ReversiGame;

import org.junit.Test;

import piece.ReversiPiece;

public class ReversiGameTests
{

	@Test
	public void testGetCurrentPlayer()
	{
		Game game = new ReversiGame(2, 8, 8);
		assertEquals(null, game.getCurrentPlayer());
		game.nextPlayer();
		assertEquals(null, game.getCurrentPlayer());
		game.nextPlayer();
		assertEquals(null, game.getCurrentPlayer());
	}
	
	@Test
	public void isMoveValid()
	{
		ReversiGame game = new ReversiGame(2, 4, 4);
		/*
		 *  Current state is set to following display by following method.
		 *     	a  b  c  d
		 *    1 
		 *    2	   b  w
		 *    3	   w  b
		 *    4
		 */
		Board board = game.getBoard();
		board.setPiece(1, 1,new ReversiPiece(Colour.BLACK));
		board.setPiece(2, 2, new ReversiPiece(Colour.BLACK));
		board.setPiece(2, 1, new ReversiPiece(Colour.WHITE));
		board.setPiece(1, 2, new ReversiPiece(Colour.WHITE));
		
	}

}
