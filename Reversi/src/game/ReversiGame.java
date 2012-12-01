package game;

import java.util.Scanner;

import player.HumanPlayer;
import player.Player;
import display.CommandLineDisplay;
import display.Display;

public class ReversiGame extends Game {

	private static final int MIN_DEFAULT = 0;
	private static final int MAX_DEFAULT = 9;

	public ReversiGame(int numberOfPlayers, int rows, int columns) {
		super(numberOfPlayers, rows, columns);
	}

	@Override
	public boolean isMoveValid(int r, int c) {
		boolean okN, okNW, okW, okSW, okS, okSE, okE, okNE;
		int i;
		// What about empty spaces?
		okN = r > 0
				&& players[currentPlayerId].getColour() != board.getPiece(
						r - 1, c).getColour();
		for (i = r - 1; okN && i >= 0; i--)
			if (board.isEmpty(i, c)) // No, it has to be an empty space
				return true;

		okNW = r > 0
				&& c > 0
				&& players[currentPlayerId].getColour() != board.getPiece(
						r - 1, c - 1).getColour();
		for (i = 1; okNW && i <= Math.min(r, c); i++)
			if (board.isEmpty(r - i, c - i))
				return true;

		okW = c > 0
				&& players[currentPlayerId].getColour() != board.getPiece(r,
						c - 1).getColour();
		return false;
	}

	@Override
	public void play() {
		Display display = new CommandLineDisplay();
		int numberOfPlayers = display.getNumberOfPlayers();
		Player[] playersNames = new HumanPlayer[numberOfPlayers];
		for (int i = 1; i <= numberOfPlayers; i++) {
			String playerName = display.getPlayerName();
			Colour playerColour = Colour.valueOf(display.getPlayerColour());
			playersNames[i - 1] = new HumanPlayer(playerName, playerColour);
		}

		while (!isOver()) { 
			display.displayBoard(board); 
			//if (players[currentPlayerId].canMove()) { 
				display.printCurrentPlayerTurn(getCurrentPlayer());
				int r = display.getMoveRow(MIN_DEFAULT, MAX_DEFAULT);
				int c = display.getMoveColumn(MIN_DEFAULT, MAX_DEFAULT);
				if (isMoveValid(r, c)) {
					move(r, c);
				} 
			//}
			nextPlayer();

		}
		// this.display(); //print board after move is made
		System.out.println("Game over");
	}

	private boolean isOver() {
		for (int i = MIN_DEFAULT; i < MAX_DEFAULT; i++) {
			for (int j = MIN_DEFAULT; j < MAX_DEFAULT; j++) {
				if (isMoveValid (i, j)) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public void move(int r, int c) {

	}

}
