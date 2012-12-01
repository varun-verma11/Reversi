package display;

import game.Board;
import game.Colour;
import game.Piece;
import game.ReversiPiece;

import java.util.Scanner;

import player.Player;

public class CommandLineDisplay implements Display
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see display.Display#printCurrentPlayerTurn(player.Player)
	 */
	@Override
	public void printCurrentPlayerTurn(Player player)
	{
		System.out.println(player.getName() + ": turn now.");
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see display.Display#getPlayerName()
	 */
	@SuppressWarnings("resource")
	@Override
	public String getPlayerName()
	{
		System.out.println("Please enter your name.");
		return (new Scanner(System.in)).nextLine();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see display.Display#getPlayerColour()
	 */
	@Override
	public String getPlayerColour()
	{
		System.out.println("Please enter your colour.");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while (!(input.contentEquals("b") || input.contentEquals("w")))
		{
			System.out.println("Invalid Input. Please enter b for Black "
					+ "and w for White.");
			input = in.nextLine();
		}
		return getColour(input);
	}

	private String getColour(String input)
	{
		if (input.contentEquals("b"))
		{
			return "BLACK";
		} else
		{
			return "WHITE";
		}
	}

	@Override
	@SuppressWarnings("resource")
	public int getMoveRow(int min, int max)
	{
		System.out.println("Please enter the row you want to move from.");

		String input = "";
		while (true)
		{
			input = new Scanner(System.in).nextLine();
			if (validateInput(input))
				return Integer.parseInt(input.charAt(0) + "");
			System.out.println("Please enter a move. Eg. a to move piece in "
					+ "row 1 , enter 1.");
		}
	}

	@SuppressWarnings("resource")
	@Override
	public int getMoveColumn(int min, int max)
	{
		System.out.println("Please enter the column you want to move from.");

		String input = "";
		while (true)
		{
			input = new Scanner(System.in).nextLine();
			if (validateInput(input))
				return Integer.parseInt((input.charAt(0) - 'a') + "");
			System.out.println("Please enter valid a move. Eg. a to move "
					+ "piece in column a , enter a.");
		}

	}

	private boolean validateInput(String input)
	{
		if (input.length() > 1)
			return false;
		try
		{
			if (input.charAt(input.length() - 1) >= 'a'
					&& input.charAt(input.length() - 1) <= 'z'
					|| Integer.parseInt(input.substring(0, input.length() )) > 0)
			{
				return true;
			}
		} catch (NumberFormatException e)
		{
			System.out.println("FALSE valid");
			return false;
		}
		System.out.println("FALSE");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see display.Display#displayBoard(game.Board)
	 */
	@Override
	public void displayBoard(Board board)
	{
		String header = "";
		String bottomAndTop = " ";
		for (int i = 0; i < board.getRows(); i++)
		{
			bottomAndTop += "____";
			header += "   " + (char) (i + (int) 'a');
		}
		System.out.println(header);

		System.out.println(bottomAndTop + "_");
		int start = 0;
		for (Piece[] row : board.getBoard())
		{
			System.out.print(start++);
			for (Piece p : row)
			{
				if (p == null)
				{
					System.out.print("|   ");
				} else if (p.getColour() == Colour.BLACK)
				{
					System.out.print("| b ");
				} else if (p.getColour() == Colour.WHITE)
				{
					System.out.print("| w ");
				}
			}
			System.out.println("|");
		}
		System.out.println(bottomAndTop + "_");
	}

	public static void main(String[] args)
	{
		Display display = new CommandLineDisplay();
		// String name = display.getPlayerName();
		// System.out.println(name);
		// Colour colour = display.getPlayerColour();
		// System.out.println(colour);
		Board board = new Board(10, 10);
		Colour curr = Colour.BLACK;

//		display.getNumberOfPlayers();
		display.displayBoard(board);
	}

	@Override
	public int getNumberOfPlayers()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("Please enter the number of Players.");
		
		while(true) {
			input = in.nextLine();
			try {
				int num = Integer.parseInt(input);
				System.out.println("Are you sure you want " + num + 
						" of players? (Please enter y for yes and n for no)");
				while(true)
				{
					String ans = in.nextLine();
					if (ans.length()>1) break;
					if (ans.charAt(0)=='y') return num;
					if (ans.charAt(0)=='n') break;
					System.out.println("Please enter valid input." +
							"(y for yes and n for no)");
				}
			} catch (NumberFormatException e) {	}
			System.out.println("Please enter a valid number of players.");
		}
	}


	@Override
	public void printInvalidMove()
	{
		System.out.println("The move you entered was not valid.");
	}
}
