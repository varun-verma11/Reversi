package game;

import player.HumanPlayer;
import player.Player;
import display.Display;

public abstract class Game {
	protected Board board;
	protected Player[] players;
	protected int currentPlayer ;
	protected Display display;
	
	public Game(int numberOfPlayers, int rows, int columns)
	{
		this.board = new Board(rows, columns);
		this.players = new Player[numberOfPlayers];
		for (@SuppressWarnings("unused") Player p: players)
		{
			//check for invalid colour
			p = new HumanPlayer(display.getPlayerName(), Colour.valueOf(display.getPlayerColour()));
		}
	}
	
	public abstract boolean isMoveValid(int r, int c);
	
	public Player getCurrentPlayer() {
		return players[currentPlayer];
	}
	
	public void nextPlayer() {
		currentPlayer++;
		currentPlayer%=players.length;
	}
	
	public abstract void play();
	
}
