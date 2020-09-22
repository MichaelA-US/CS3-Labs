
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
public class Maze
{
	private Square[][] maze;
	private Square start;
	private Square exit;
	public Maze()
	{
	}
	
	public boolean loadMaze(String fileName) throws IOException //In progress
	{
		int r,c;
		Scanner newFile = new Scanner(new File("maze-1"));
		while(newFile.hasNextLine())
		{
			try
			{
				r = newFile.nextInt();
				c = newFile.nextInt();
				maze = new Square[r][c];
				for(int i = 0; i < maze.length; i++)
				{
					for(int j = 0; j < maze[i].length; j++)
					{
						maze[i][j] = new Square(i,j,newFile.nextInt());
						//Find Start, Exit
					}
				}
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return false;

	}
	
	public ArrayList<Square> getNeighbors(Square s)
	{
		int north = s.getRow()-1; //row-1 >= 0
		int east = s.getCol()+1; //col+1 < maze[0].length
		int south = s.getRow()+1; //row+1 < maze.length
		int west = s.getCol()-1; //col-1 >= 0
		ArrayList<Square> list = new ArrayList<Square>();
		//Add to list squares
		
		
	}
	
	public Square getStart()
	{
		//Iterate through 2DArray and find if the square's type is equal to that  of START
		return start;
	}
	
	public Square getExit()
	{
		//Iterate through 2DArray and find if the square's type is equal to that  of EXIT
		return exit;
	}
	
	public void reset()
	{
		
	}
	
	@Override
	public String toString()
	{
		//Loop through 2DArray and add squares to string
	}
}
