package player;

import game.Board;
import game.Colour;

public class RandomAIPlayer extends Player {

	public RandomAIPlayer(String name, Colour colour, Board board) {
		super(name, colour, board);
		
	}

	@Override
	public int[] getMove() {
		int move[] = new int[2];
		move[0] = (int) (Math.random()*8);
		move[1] = (int) (Math.random()*8);
		return move;
	}

}
