package player;

import game.Board;
import game.Colour;
import display.CommandLineDisplay;
import display.Display;

public class HumanPlayer extends Player
{

	public HumanPlayer(String name, Colour colour, Board board) {
		super(name, colour, board);
	}

	@Override
	public int[] getMove() {
		Display display = new CommandLineDisplay();
		int[] move = {display.getMoveRow(0, board.getRows()) 
				, display.getMoveColumn(0, board.getColumns())};
		return move;
	}

}