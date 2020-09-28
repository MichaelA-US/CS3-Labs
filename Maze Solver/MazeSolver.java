import java.util.ArrayList;

/**
 * Abstract class that controls the main algorithm for
 * solving the maze
 */
public abstract class MazeSolver
{
	private MyStack workList;
	private Square start;
	private boolean solved;
	private boolean solveable;
	public Maze maze;

	/**
	 * Basic constructor that gets the start of the maze and
	 * sets all the variables to their correct values
	 * @param maze
	 */
	public MazeSolver(Maze maze)
	{
		workList = new MyStack();
		workList.push(maze.getStart());
		this.maze = maze;
		this.makeEmpty();
		if(maze != null) //Making sure that the maze exists
		{
			this.add(maze.getStart());
		}
		solved = false;
		solveable = true;
	}

	/**
	 * Abstract methods that
	 * controls the implementation
	 * of the MyStack class for the maze
	 */
	abstract void makeEmpty();
	abstract boolean isEmpty();
	abstract void add(Square s);
	abstract Square next();

	/**
	 * Returns whether the maze is solved
	 * @return true or false depending on if the maze is solved
	 */
	boolean isSolved()
	{
		return solved;
	}

	/**
	 * Implements the algorithm for solving the maze
	 * by gathering the neighbors and checking whether they have reached
	 * the exit or not
	 */
	public void step()
	{
		try
		{
			Square sqr = this.next();
			if(isSolved())
			{
				solved = true;
				solveable = false;
				System.out.println(getPath());
				return;
			}
			else if(sqr.equals(maze.getExit()))
			{
				solved = true;
				solveable = true;
				System.out.println(getPath());
				return;
			}
			else
			{
				ArrayList<Square> neighbs = maze.getNeighbors(sqr);
				for(int i = 0; i < neighbs.size(); i++) //Looping through the neighbors
				{
					if(neighbs.get(i).getType() == Square.EXIT) //If the neighbor is the exit; maze is solved
					{
						System.out.println("Maze is solved!");
						solved = true;
						solveable = false;
					}
					if(neighbs.get(i).getType() != Square.WALL && neighbs.get(i).getStatus() == Square.UNKNOWN) //If the neighbor is unknown set the status to working
					{
						neighbs.get(i).setStatus(Square.WORKING);
						this.add(neighbs.get(i));
					}
					sqr.setStatus(Square.EXPLORED); //Updates the square to be explored once it's already checked
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Maze can't be solved!");
			solved = false;
			solveable = false;
		}
	}

	/**
	 * Returns whether the maze is solved, not solvable, or not yet solved
	 * @return the current state of the maze
	 */
	public String getPath()
	{
		String str = "";
		if(solved)
		{
			str = "solved";
		}
		else if(!solveable)
		{
			str = "unsolvable";
		}
		else
		{
			str = "unsolved";
		}
		return str;
	}

	/**
	 * Recursively calls upon the step method in order
	 * to repeatedly solve the maze
	 */
	public void solve()
	{
		try
		{
			while(!solved)
			{
				step();
			}
			System.out.println(getPath());
		}
		catch(NullPointerException e)
		{
			System.out.println("End of maze");
		}
	}

}

