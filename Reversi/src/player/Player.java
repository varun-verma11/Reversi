package player;

import game.Board;
import game.Colour;

public abstract class Player
{
	protected final String name;
	protected final Colour colour;
	protected final Board board;
	public int score;
	public Player (String name, Colour colour, Board board) {
		this.name = name;
		this.colour = colour;
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}
	
	public void addToScore(int add) {
		score += add;
	}
	
	public int getScore() {
		return score;
	}
	public abstract int[] getMove() ;
}
