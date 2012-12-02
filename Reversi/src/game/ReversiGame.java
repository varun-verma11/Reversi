package game;

import piece.ReversiPiece;
import player.HumanPlayer;
import display.CommandLineDisplay;

public class ReversiGame extends Game {

	private static final int MIN_DEFAULT = 0;
	private static final int MAX_DEFAULT = 8;

	int[] validMoves = new int[16];

	public ReversiGame(int numberOfPlayers, int rows, int columns) {
		super(numberOfPlayers, rows, columns);
		display = new CommandLineDisplay();

	}

	@Override
	public boolean isMoveValid(int r, int c, boolean storeValidMoves) {
		boolean okN, okNW, okW, okSW, okS, okSE, okE, okNE;
		boolean functionRet = false;
		int i;

		// Check for the north
		validMoves[0] = -1;
		validMoves[1] = -1;
		okN = r > 0
				&& !board.isEmpty(r - 1, c)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r - 1, c).getColour();
		for (i = r - 1; okN && i >= 0 && !board.isEmpty(i, c); i--) {
			if (board.getPiece(i, c).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[0] = i;
					validMoves[1] = c;
					functionRet = true;
					break;
				} else
					return true;
		}
		validMoves[2] = -1;
		validMoves[3] = -1;
		
		// Check for the north-west
		okNW = r > 0
				&& c > 0
				&& !board.isEmpty(r - 1, c - 1)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r - 1, c - 1).getColour();
		for (i = 1; okNW && !board.isEmpty(r - i, c - i); i++) {
			if (board.getPiece(r - i, c - i).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[2] = r - i;
					validMoves[3] = c - i;
					functionRet = true;
					break;
				} else
					return true;
			if (r - i - 1 < 0 || c - i - 1 < 0)
				okNW = false;

		}
		
		// Check for the west
		validMoves[4] = -1;
		validMoves[5] = -1;
		okW = c > 0
				
				&& !board.isEmpty(r , c - 1)
				&& players[currentPlayerId].getColour() != board.getPiece(r,
						c - 1).getColour();
		for (i = c - 1; okW && i >= 0 && !board.isEmpty(r, i); i--) {
			if (board.getPiece(r, i).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[4] = r;
					validMoves[5] = i;
					functionRet = true;
					break;
				} else
					return true;
		}
		validMoves[6] = -1;
		validMoves[7] = -1;
		
		// Check for the south-west
		okSW = c > 0
				&& r + 1 < board.getRows()
				&& !board.isEmpty(r + 1, c - 1)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r + 1, c - 1).getColour();
		for (i = 1; okSW && !board.isEmpty(r + i, c - i); i++) {
			if (board.getPiece(r + i, c - i).getColour() == players[currentPlayerId]
					.getColour()) {
				if (storeValidMoves) {
					validMoves[6] = r + i;
					validMoves[7] = c - i;
					functionRet = true;
					break;
				} else
					return true;
			}
			if (r + i + 1 >= board.getRows() || c - i - 1 < 0)
				okSW = false;
		}
		validMoves[8] = -1;
		validMoves[9] = -1;
		// Check for the south
		okS = r + 1 < board.getRows()
				&& !board.isEmpty(r + 1, c)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r + 1, c).getColour();
		for (i = 1; okS && !board.isEmpty(r + i, c); i++) {
			if (board.getPiece(r + i, c).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[8] = r + i;
					validMoves[9] = c;
					functionRet = true;
					break;
				} else
					return true;
			if(r+i+1>=board.getRows())
				okS = false;
		}
		validMoves[10] = -1;
		validMoves[11] = -1;
		// Check for the south-east
		okSE = r + 1 < board.getRows()
				&& c + 1 < board.getColumns()
				&& !board.isEmpty(r + 1, c + 1)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r + 1, c + 1).getColour();
		for (i = 1; okSE && !board.isEmpty(r + i, c + i); i++) {
			if (board.getPiece(r + i, c + i).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[10] = r + i;
					validMoves[11] = c + i;
					functionRet = true;
					break;
				} else
					return true;
			if(r + i + 1 >= board.getRows() || c + i + 1 >= board.getColumns())
				okSE = false;
		}
		validMoves[12] = -1;
		validMoves[13] = -1;
		
		// Check for the east
		okE = c + 1 < board.getColumns()
				&& !board.isEmpty(r, c + 1)
				&& players[currentPlayerId].getColour() != board.getPiece(r,
						c + 1).getColour();
		for (i = c + 1; okE && i < board.getColumns() && !board.isEmpty(r, i); i++) {
			if (board.getPiece(r, i).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[12] = r;
					validMoves[13] = i;
					functionRet = true;
					break;
				} else
					return true;
		}
		validMoves[14] = -1;
		validMoves[15] = -1;
		// Check for the north-east
		okNE = c + 1 < board.getColumns()
				&& r - 1 > 0
				&& !board.isEmpty(r - 1, c + 1)
				&& players[currentPlayerId].getColour() != board.getPiece(
						r - 1, c + 1).getColour();
		for (i = 1; okNE && !board.isEmpty(r - i, c + 1); i++) {
			if (board.getPiece(r - i, c + i).getColour() == players[currentPlayerId]
					.getColour())
				if (storeValidMoves) {
					validMoves[14] = r - i;
					validMoves[15] = c + i;
					functionRet = true;
					break;
				} else
					return true;
			if (r - i - 1 < 0 || c + i + 1 >= board.getColumns())
				okNE = false;
		}
		return functionRet;

	}

	@Override
	public void play() {
		currentPlayerId = 0;
		board.setPiece(3, 3, new ReversiPiece(Colour.WHITE));
		board.setPiece(3, 4, new ReversiPiece(Colour.BLACK));
		board.setPiece(4, 3, new ReversiPiece(Colour.BLACK));
		board.setPiece(4, 4, new ReversiPiece(Colour.WHITE));

		// Getting player1's name and setting its colour to black:
		System.out.println("Player 1 (black)");
		String player1Name = display.getPlayerName();
		Colour player1Colour = Colour.BLACK;
		players[0] = new HumanPlayer(player1Name, player1Colour, board);

		// Getting player2's name and setting its colour to white:
		System.out.println("Player 2 (white)");
		String player2Name = display.getPlayerName();
		Colour player2Colour = Colour.WHITE;
		players[1] = new HumanPlayer(player2Name, player2Colour, board);
		display.displayBoard(board);
		while (!isOver()) {

			// if (players[currentPlayerId].canMove()) {
			display.printCurrentPlayerTurn(getCurrentPlayer());
			int[] move;
			do {
				move = players[currentPlayerId].getMove();
			} while (!board.isEmpty(move[0], move[1])
					|| !isMoveValid(move[0], move[1], true));
			move(move[0], move[1]);
			// }
			display.displayBoard(board);
			nextPlayer();

		}
		// this.display(); //print board after move is made
		System.out.println("Game over");
		System.out.println("Scores:");
		System.out.println("Player1: " + players[0].getScore());
		System.out.println("Player2: " + players[1].getScore());
		if (players[0].getScore() > players[1].getScore()) {
			System.out.println("Player 1 won!");
		} else if (players[0].getScore() < players[1].getScore()) {
			System.out.println("Player 2 won!");
		} else {
			System.out.println("Draw!");
		}
	}

	private boolean isOver() {
		for (int i = MIN_DEFAULT; i < MAX_DEFAULT; i++) {
			for (int j = MIN_DEFAULT; j < MAX_DEFAULT; j++) {
				if (board.isEmpty(i, j) && isMoveValid(i, j, false)) {
					return false;
				}
			}
		}
		return true;

	}

	@Override
	public void move(int r, int c) {

		int ri, ci;
		board.setPiece(r, c,
				new ReversiPiece(players[currentPlayerId].getColour()));
		// north
		ri = validMoves[0];
		ci = validMoves[1];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ri++;
		}
		// north-west
		ri = validMoves[2];
		ci = validMoves[3];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ri++;
			ci++;
		}
		// west
		ri = validMoves[4];
		ci = validMoves[5];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ci++;
		}

		// south-west
		ri = validMoves[6];
		ci = validMoves[7];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ri--;
			ci++;
		}

		// south
		ri = validMoves[8];
		ci = validMoves[9];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ri--;
		}

		// south-east
		ri = validMoves[10];
		ci = validMoves[11];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ri--;
			ci--;
		}

		// east
		ri = validMoves[12];
		ci = validMoves[13];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ci--;
		}

		// north-east
		ri = validMoves[14];
		ci = validMoves[15];
		while (ri != -1 && (ri != r || ci != c)) {
			if (board.getPiece(ri, ci).getColour() != players[currentPlayerId]
					.getColour())
				board.getPiece(ri, ci).flip();
			players[currentPlayerId].addToScore(1);
			ci--;
			ri++;
		}
	}

	public static void main(String[] args) {
		Game game = new ReversiGame(2, 8, 8);
		game.play();
	}

	@Override
	public Board getBoard()
	{
		return board;
		
	}

}
