
/**
 * This class implements a maze and represents its types
 * of it being empty, wall, start, or an exit.
 * @author Am10073106
 *
 */
public class Square
{
	final static int EMPTY = 0; //empty space
	final static int WALL = 1; ///wal
	final static int START = 2; //start
	final static int EXIT = 3; //exit
	
	final static char WORKING = 'o'; //currently on work list (stack)
	final static char EXPLORED = '.'; //already explored
	final static char ON_EXIT_PATH = 'x'; //on the exit path, used in a later lab
	final static char UNKNOWN = '_'; //not visited yet (empty cells only)
	
	private int row, col; //r, c location in the maze
	private int type; //type of the square (empty, wall, start, exit)
	private char status; //current status of the square (working, explored, exit path, unknown)
	
	/**
	 * Basic constructor that initalized a square object with a
	 * row col and type.
	 * @param row
	 * @param col
	 * @param type
	 */
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
	}
	/**
	 * 
	 * @return the row of the square
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * 
	 * @return the col of the square
	 */
	public int getCol()
	{
		return col;
	}
	/**
	 * 
	 * @return the type of the square
	 */
	public int getType()
	{
		return type;
	}
	/**
	 * 
	 * @return the status of the square
	 */
	public char getStatus()
	{
		return status;
	}
	@Override
	public String toString() //In Progress
	{
		String str = "";
		if(getType() == EMPTY)
		{
			//If empty add the status
			return status+"";
		}
		else if(getType() == WALL)
		{
			return "#";
		}
		else if(getType() == START)
		{
			return "S";
		}
		else if(getType() == EXIT)
		{
			return "E";
		}
		return "";
	}
	/**
	 * Squares are equal if they have the same ROW and COLUMN; type is not necessary.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return ((Square) obj).getRow() == this.getRow() && ((Square) obj).getCol() == this.getCol();
	}
}
