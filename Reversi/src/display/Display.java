package display;

import game.Board;
import player.Player;

public interface Display
{

	public abstract void printCurrentPlayerTurn(Player player);

	public abstract String getPlayerName();

	public abstract String getPlayerColour();
	
	public abstract int getMoveRow(int min, int max);
	
	public abstract int getMoveColumn(int min, int max);
	
	public abstract void displayBoard(Board board);

}