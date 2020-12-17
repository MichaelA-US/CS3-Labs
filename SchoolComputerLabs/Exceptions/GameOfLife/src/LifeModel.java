import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration() {
    for (int i = 0; i < SIZE; i++) 
    {
      for (int j = 0; j < SIZE; j++) 
      {
        int adjCells = getAdjacentCells(i, j);
        if ((!grid[i][j].isAliveNow() && (adjCells == 3)) || (grid[i][j].isAliveNow() && (adjCells == 2 || adjCells == 3))) //Updates the grid to have the adj cells with occupied cells having 2 to 3 adjacents
        {
          grid[i][j].setAliveNext(true); //Sets them alive
        }
        else
          grid[i][j].setAliveNext(false); //Makes them dead
      }
    }
    this.updateGenAlive(); //Updates the grid
  }
 /**
 * Checks if the cells are in bounds of the SIZE of the 2D array, and if it is not a neg value
 * @param The cell with its coordinates in the 2D array
 * @return The boolean value that determines whether the cell is in bounds or not
 **/
  private boolean isCellsInBounds(int cell1, int cell2) 
  {
    if (cell1 >= 0 && cell1 < SIZE) //Checks coordinate 1
    {
      if (cell2 >= 0 && cell2 < SIZE) //Checks coordinate 2
      {
        return true;
      }
    }
    return false;
  }
 /**
 * Updates the grid so that it can determine the next set of alive cells
 **/
  private void updateGenAlive()
  {
    for (int o = 0; o < SIZE; o++) //Goes through the 2D array
    { 
      for (int k = 0; k < SIZE; k++) 
      {
        grid[o][k].setAliveNow(grid[o][k].isAliveNext()); //Starts up the grid
        grid[o][k].setAliveNext(false); 
      }
    }
  }
 /**
 * Gets the total of adjacent cells around one cell
 * @param The coordinates of the cell to find its adjacents
 * @return the count of adjacent cells to the cell
 **/
  private int getAdjacentCells(int cell1, int cell2) 
  {
    int adjCells = 0;
    for (int i = -1; i < 2; i++) //Iterates through the neighbors
    {
      for (int j = -1; j < 2; j++) 
      {
        int c1 = cell1 + i;
        int c2 = cell2 + j;
        if ((i == 0 && j == 0) && isCellsInBounds(c1, c2)) //Makes sure the cells adj are in bounds
        {
        }else if (isCellsInBounds(c1, c2) && grid[c1][c2].isAliveNow()) //Makes sure the cells adj are in bounds and are alive
          {
            adjCells++;
          }
     }
    }
    return adjCells;
  }

}

