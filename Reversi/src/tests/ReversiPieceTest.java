package tests;

import static org.junit.Assert.assertEquals;
import game.Colour;

import org.junit.Test;

import piece.Piece;
import piece.ReversiPiece;

public class ReversiPieceTest
{

	@Test
	public void testGetColour()
	{
		assertEquals(Colour.BLACK, new ReversiPiece(Colour.BLACK).getColour() );
		assertEquals(Colour.WHITE, new ReversiPiece(Colour.WHITE).getColour() );
	}

	@Test
	public void testFlip()
	{
		Piece piece = new ReversiPiece(Colour.BLACK);
		assertEquals(Colour.BLACK, piece.getColour());
		piece.flip();
		assertEquals(Colour.WHITE, piece.getColour());
		piece.flip();
		assertEquals(Colour.BLACK, piece.getColour());
		piece.flip();
		assertEquals(Colour.WHITE, piece.getColour());
		piece.flip();
		assertEquals(Colour.BLACK, piece.getColour());
		piece.flip();
		assertEquals(Colour.WHITE, piece.getColour());
		piece.flip();
		assertEquals(Colour.BLACK, piece.getColour());
		piece.flip();
		assertEquals(Colour.WHITE, piece.getColour());
		piece.flip();
		assertEquals(Colour.BLACK, piece.getColour());
		
	}
}
