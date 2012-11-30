package player;

import game.Colour;

public abstract class Player
{
	private final String name;
	private final Colour colour;

	public Player (String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}
	
	public abstract void getMove() ;
}
