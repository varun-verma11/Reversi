package game;

import player.HumanPlayer;
import player.Player;
import display.CommandLineDisplay;
import display.Display;

public class ReversiGame extends Game {


	private static final int MIN_DEFAULT = 0;
	private static final int MAX_DEFAULT = 8;

	int[] validMoves = new int[16];
	public ReversiGame(int numberOfPlayers, int rows, int columns) {
		super(numberOfPlayers, rows, columns);
	}

	@Override
	public boolean isMoveValid(int r, int c, boolean storeValidMoves) {
		boolean okN, okNW, okW, okSW, okS, okSE, okE, okNE;
		boolean functionRet = false;
		int i;

		//Check for the north 
		validMoves[0] = -1;
		validMoves[1] = -1;
		okN = r>0 && players[currentPlayerId].getColour()!= board.getPiece(r-1, c).getColour() && !board.isEmpty(r-1, c);
		for(i=r-1;okN && i>=0 && !board.isEmpty(i, c); i--)
			if(board.getPiece(i, c).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[0] = i;
					validMoves[1] = c;
					functionRet = true;
				} else
				return true;
		
		validMoves[2] = -1;
		validMoves[3] = -1;
		//Check for the north-west
		okNW = r>0 && c>0 && players[currentPlayerId].getColour()!= board.getPiece(r-1, c-1).getColour()&& !board.isEmpty(r-1, c-1);
		for(i=1;okNW && !board.isEmpty(r-i, c-i); i++)
			if(board.getPiece(r-i, c-i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[2] = r-i;
					validMoves[3] = c-i;
					functionRet = true;
				} else
				return true;
			if(r-i<0 || c-i<0)
				okNW = false;
		
		validMoves[4] = -1;
		validMoves[5] = -1;			
		//Check for the west
		okW = c>0 && players[currentPlayerId].getColour()!= board.getPiece(r, c-1).getColour();
		for(i=c-1;okW && i>=0 && !board.isEmpty(r, i); i--)
			if(board.getPiece(r, i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[4] = r;
					validMoves[5] = i;
					functionRet = true;
				} else
				return true;

		validMoves[6] = -1;
		validMoves[7] = -1;
		//Check for the south-west
		okSW = c-1>0 && r+1<board.getRows() && players[currentPlayerId].getColour() != board.getPiece(r+1,c-1).getColour() && !board.isEmpty(r+1, c-1);
		for(i=1;okSW && !board.isEmpty(r+i, c-i); i++)
			if(board.getPiece(r+i, c-i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[6] = r+i;
					validMoves[7] = c-i;
					functionRet = true;
				} else
				return true;
			if(r+i+1<board.getRows() || c-i-1>0) 
				okSW = false;
		
		validMoves[8] = -1;
		validMoves[9] = -1;
		//Check for the south
		okS = r+1<board.getRows() && players[currentPlayerId].getColour() != board.getPiece(r+1, c).getColour() && !board.isEmpty(r+1, c);
		for(i=1;okS && i<r && !board.isEmpty(r+i, c); i++)
			if(board.getPiece(r+i, c).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[8] = r+i;
					validMoves[9] = c;
					functionRet = true;
				} else
				return true;
		
		validMoves[10] = -1;
		validMoves[11] = -1;
		//Check for the south-east
		okSE = r+1<board.getRows() && c+1<board.getColumns() && players[currentPlayerId].getColour() != board.getPiece(r+1, c+1).getColour() && !board.isEmpty(r+1, c+1);
		for(i=1;okSE && i<Math.min(r, c) && !board.isEmpty(r+i, c+i); i++)
			if(board.getPiece(r+i, c+i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[10] = r+i;
					validMoves[11] = c+i;
					functionRet = true;
				} else
				return true;
		
		validMoves[12] = -1;
		validMoves[13] = -1;
		//Check for the east
		okE = c+1<board.getColumns() && players[currentPlayerId].getColour() != board.getPiece(r, c+1).getColour() && !board.isEmpty(r, c+1);
		for(i=c+1;okE && i<board.getColumns() && !board.isEmpty(r, i); i++)
			if(board.getPiece(r, i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[12] = r;
					validMoves[13] = i;
					functionRet = true;
				} else
				return true;
		
		validMoves[14] = -1;
		validMoves[15] = -1;
		//Check for the north-east
		okNE = c+1<board.getColumns() && r-1>0 && players[currentPlayerId].getColour() != board.getPiece(r-1, c+1).getColour() && !board.isEmpty(r-1, c+1);
		for(i=1; okNE && !board.isEmpty(r-i, c+1); i++)
			if(board.getPiece(r-i, c+i).getColour() != players[currentPlayerId].getColour())
				if(storeValidMoves) {
					validMoves[14] = r-i;
					validMoves[15] = c+i;
					functionRet = true;
				} else
				return true;
			if(r-i-1>0 && c+i+1<board.getColumns())
				okNE = false;
		return functionRet;

	}

	@Override
	public void play() {
		Display display = new CommandLineDisplay();
		int numberOfPlayers = display.getNumberOfPlayers();
		Player[] playersNames = new HumanPlayer[numberOfPlayers];
		for (int i = 1; i <= numberOfPlayers; i++) {
			String playerName = display.getPlayerName();
			Colour playerColour = Colour.valueOf(display.getPlayerColour());
			playersNames[i - 1] = new HumanPlayer(playerName, playerColour,board);
		}

		while (!isOver()) { 
			display.displayBoard(board); 
			//if (players[currentPlayerId].canMove()) { 
				display.printCurrentPlayerTurn(getCurrentPlayer());
				int[] move = players[currentPlayerId].getMove();
				if (isMoveValid(move[0], move[1], false)) {
					move(move[0], move[1]);
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
				if (board.getBoard()[i][j]!=null && isMoveValid (i, j, false)) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public void move(int r, int c) {

		int ri, ci;
		//north
		ri = validMoves[0];
		ci = validMoves[1];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ri++;
		}
		//north-west
		ri = validMoves[2];
		ci = validMoves[3];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ri++;
			ci++;
		}
		//west
		ri = validMoves[4];
		ci = validMoves[5];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ci++;
		}
		
		//south-west
		ri = validMoves[6];
		ci = validMoves[7];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ri--;
			ci++;
		}
		
		//south
		ri = validMoves[8];
		ci = validMoves[9];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ri--;
		}
		
		//south-east
		ri = validMoves[10];
		ci = validMoves[11];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ri--;
			ci--;
		}
		
		//east
		ri = validMoves[12];
		ci = validMoves[13];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ci--;
		}
		
		//north-east
		ri = validMoves[14];
		ci = validMoves[15];
		while(ri!=-1 && (ri!= r || ci!=c)) {
			board.getPiece(ri, ci).flip();
			ci--;
			ri++;
		}
	}
	
	public static void main(String[] args)
	{
		Game game  = new ReversiGame(2, 8, 8);
		game.play();
	}

}
