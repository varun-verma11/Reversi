package game;

public abstract class Piece {
	protected Colour colour;
	public Piece(Colour colour) {
		this.colour = colour;
	}
	
	public Colour getColour() {
		return colour;
	}
	
	public void flip() {
		if(colour==Colour.WHITE)
			colour = Colour.BLACK;
		else
			colour = Colour.WHITE;
	}
	
}
