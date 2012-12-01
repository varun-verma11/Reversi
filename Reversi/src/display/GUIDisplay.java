package display;

import game.Board;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import player.Player;

public class GUIDisplay implements Display
{
	JFrame frame ;
	JPanel panel;
	
	public GUIDisplay(int rows, int columns) 
	{
		frame = new JFrame("Reversi Game!!!");
		GridLayout gridLayout = new GridLayout();
		JLabel heading = new JLabel("Welcome to game of Reversi!!!");
		panel = new JPanel(gridLayout);
		panel.add(heading);
		gridLayout.addLayoutComponent("heading", heading);
		frame.setLayout(gridLayout);
		frame.add(heading, 0);
	}

	@Override
	public void printCurrentPlayerTurn(Player player)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPlayerName()
	{
		String s = (String)JOptionPane.showInputDialog(
                frame,
                "Please enter your name.",
                "Enter Name",
                JOptionPane.PLAIN_MESSAGE);
		return s;
	}

	@Override
	public String getPlayerColour()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void displayBoard(Board board)
	{
		frame.show();
	}	
	
	public static void main(String[] args)
	{
		Display display = new GUIDisplay(3,4);
//		String name = display.getPlayerName();
		display.displayBoard(null);
//		System.out.println(name);
	}

	@Override
	public int getMoveRow(int min, int max)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMoveColumn(int min, int max)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfPlayers()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printInvalidMove()
	{
		// TODO Auto-generated method stub
		
	}

}
