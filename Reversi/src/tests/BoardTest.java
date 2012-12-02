package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import game.Board;
import game.Colour;

import org.junit.Test;

import piece.Piece;
import piece.ReversiPiece;

public class BoardTest
{

	@Test
	public void testForGettters()
	{
		Board board = new Board(1, 2);
		assertEquals(2, board.getColumns());
		assertEquals(1, board.getRows());
		board = new Board(8, 10);
		assertEquals(10, board.getColumns());
		assertEquals(8, board.getRows());
	}
	
	@Test
	public void testPieceManipulation()
	{
		Board board = new Board(4, 4);
		assertEquals(null, board.getPiece(0, 0));
		assertTrue(board.isEmpty(0, 0));
		
		Piece piece = new ReversiPiece(Colour.BLACK);
		board.setPiece(0, 0, piece);
		assertTrue(piece==board.getPiece(0, 0));
		
		piece = new ReversiPiece(Colour.WHITE);
		board.setPiece(1, 2, piece);
		assertTrue(piece==board.getPiece(1, 2));
		
		piece = new ReversiPiece(Colour.BLACK);
		board.setPiece(3, 3, piece);
		assertTrue(piece==board.getPiece(3, 3));
		
		assertEquals(null,board.getPiece(1, 1));
		assertEquals(null,board.getPiece(1, 3));
		assertEquals(null,board.getPiece(2, 1));
		assertEquals(null,board.getPiece(2, 2));
		assertEquals(null,board.getPiece(2, 3));
		assertEquals(null,board.getPiece(3, 1));
		assertEquals(null,board.getPiece(3, 2));
	}

}
