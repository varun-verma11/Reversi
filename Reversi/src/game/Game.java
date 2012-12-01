package game;

import player.Player;
import display.Display;

public abstract class Game {
	protected Board board;
	protected Player[] players;
	protected int currentPlayerId ;
	protected Display display;
	
	public Game(int numberOfPlayers, int rows, int columns)
	{
		this.board = new Board(rows, columns);
		this.players = new Player[numberOfPlayers];
	}
	
	public abstract boolean isMoveValid(int r, int c, boolean storeValidMoves);
	public abstract void move(int r, int c);
	
	public Player getCurrentPlayer() {
		return players[currentPlayerId];
	}
	
	public void nextPlayer() {
		currentPlayerId++;
		currentPlayerId%=players.length;
	}
	
	public abstract void play();
	
}
