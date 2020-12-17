/**
 * This class implement the logical layout of the maze and
 * stores the references to specific squares in the maze
 * @author am10073106
 */
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
public class Maze
{
	public Square[][] maze; //Creating maze of squares
	private Square start; //Start of maze (square)
	private Square exit; //End of maze (square)

	/**
	 * Basic constructor of the maze class that has no arguments
	 */
	public Maze()
	{

	}
	/**
	 * Loads the file given into a maze of squares
	 * using 2D arrays
	 * @param fileName file that is given
	 * @return a true or false to whether the file was able to be loaded
	 */
	public boolean loadMaze(String fileName)
	{
			try
			{
				int r,c;
				Scanner newFile = new Scanner(new File(fileName)); //Load the new file
				r = newFile.nextInt(); //Take first int (row) given of the maze
				c = newFile.nextInt(); //Take second int (col) given of the maze
				maze = new Square[r][c]; //Create a 2DArray with the two rows and cols
				for(int i = 0; i < maze.length; i++) //Looping through 2DArrays
				{
					for(int j = 0; j < maze[i].length; j++)
					{
						maze[i][j] = new Square(i,j,newFile.nextInt()); //Populating 2DArray with squares
						//Find Start, Exit
						if(maze[i][j].getType() == Square.EXIT)
						{
							exit = maze[i][j];
						}
						if(maze[i][j].getType() == Square.START)
						{
							start = maze[i][j];
						}
					}
				}
				return true; //The file loaded properly
			}
			catch(IOException e)
			{
				return false; //The file did not load
			}

	}
	/**
	 * Checks the surrounding neighbors of the square
	 * given N,S,W,E
	 * @param s square to check for
	 * @return a list of all the neighbors around the square given
	 */
	public ArrayList<Square> getNeighbors(Square s)
	{
		int north = s.getRow()-1; //row-1 >= 0
		int east = s.getCol()+1; //col+1 < maze[0].length
		int south = s.getRow()+1; //row+1 < maze.length
		int west = s.getCol()-1; //col-1 >= 0
		ArrayList<Square> list = new ArrayList<Square>();
		//Add to list squares
		if(north >= 0) //Checking north
		{
			list.add(maze[north][s.getCol()]);
		}
		if(east < maze[0].length) //Checking east
		{
			list.add(maze[s.getRow()][east]);
		}
		if(south < maze.length) //Checking south
		{
			list.add(maze[south][s.getCol()]);
		}
		if(west >= 0) //Checking west
		{
			list.add(maze[s.getRow()][west]);
		}
		return list;


	}
	/**
	 * Finds the starting position of the maze with
	 * the square of the start type
	 * @return the start square
	 */
	public Square getStart()
	{
		//Iterate through 2DArray and find if the square's type is equal to that  of START
		try
		{
			for(int i = 0; i < maze.length; i++)
			{
				for(int j = 0; j < maze[i].length; j++)
				{
					if(maze[i][j].getType() ==  Square.START) //2 is the start type
					{
						start = maze[i][j];
					}
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No loaded Maze");
		}

		return start;
	}
	/**
	 * Finds the ending position of the maze with
	 * the square of the end type
	 * @return the end square
	 */
	public Square getExit()
	{
		//Iterate through 2DArray and find if the square's type is equal to that  of EXIT
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze[i].length; j++)
			{
				if(maze[i][j].getType() == Square.EXIT) //3 is the exit type
				{
					exit = maze[i][j];
				}
			}
		}
		return exit;
	}
	/**
	 * Returns the maze back to the initial state
	 */
	public void reset()
	{
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze[i].length; j++)
			{
				maze[i][j].reset();
			}
		}
	}
	/**
	 * Print the toString of the maze
	 * @return the maze in a string format
	 */
	@Override
	public String toString()
	{
		//Loop through 2DArray and add squares to string
		String str = "";
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze[i].length; j++)
			{
				str += maze[i][j].toString() + " "; //Adding squares to str
			}
			str +="\n";
		}
		return str;
	}
}