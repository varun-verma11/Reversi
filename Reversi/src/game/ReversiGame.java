package game;

public class ReversiGame extends Game {

	public ReversiGame(int numberOfPlayers, int rows, int columns) {
		super(numberOfPlayers, rows, columns);
	}

	@Override
	public boolean isMoveValid(int r, int c) {
		return false;
	}

	@Override
	public void play() {

	}

}
