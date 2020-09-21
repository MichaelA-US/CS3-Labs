
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
public class Maze
{
	private Square[][] maze;
	private int size;
	private int start;
	private int exit;
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
				size = r*c;
				for(int i = 0; i < size; i++)
				{
					for(int j = 0; j < size; j++)
					{
						maze[i][j] = maze[newFile.nextInt()][newFile.nextInt()];
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
		int north = 0;
		int east = 0;
		int south = 0;
		int west = 0;
		ArrayList<Square> list = new ArrayList<Square>();
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				
			}
		}
		
	}
	
	public Square getStart()
	{
		
	}
	
	public Square getExit()
	{
		
	}
	
	public void reset()
	{
		
	}
	
	@Override
	public String toString()
	{
		
	}
}
