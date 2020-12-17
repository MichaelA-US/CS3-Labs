import javax.swing.JOptionPane;

public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;
    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }
    
    /**
    * Calls the spread fire
    * method
    */
    public void solve()
    {
        // student code here
        myView.updateView(myGrid);
    	spreadFire();
    }
    /**
    * Checks if the index we are trying to check is in bounds 
    * @param a the xindex
    * @parwm b the y index
    */
    public boolean inBounds(int a, int b)
    {
    	int rl = myGrid[0].length;
    	int l = myGrid.length;
    	return a < 0 || b < 0 || a >= rl || b >= l;
    }
    /**
    * Spread fire method that loops through the grie and recursively calls the spread fire helper methid
    * then checksif each at the first row is burning and that dtermines if rhet are in trouble
    * 
    */
    public void spreadFire()
    {
    	int cl = myGrid[myGrid.length - 1].length;
    	int rl = myGrid[0].length;
    	int l2 = myGrid.length - 1;
    	for(int i = 0; i < cl; i++)
    	{
    		spreadFireHelp(i, l2);
    	}
    	 for (int j = 0; j < rl; j++) 
    	 {
    		 if (myGrid[0][j].getStatus() == FireCell.BURNING)
    		 {
                 System.out.println("Onett is in trouble!");
                 JOptionPane.showMessageDialog(null, "Onett is in trouble!");
                 return;
             }
    	 }
         System.out.println("The town of Onett is safe.");
         JOptionPane.showMessageDialog(null, "The town of Onett is safe.");
    }
    /**
    * Spread fire helper method that recursively checks each grid point to see if they aregreen and sets it to be  on fire
    * and makes sure to go through each possible index
    *@param a the x coord
    *@paeam b the y coord
    */
    public void spreadFireHelp(int a, int b)
    {
        if (inBounds(a, b)) 
        {
        	return;
        }
        if (myGrid[b][a].getStatus() == FireCell.GREEN)
        {
        	myGrid[b][a].setStatus(FireCell.BURNING);
        }
        else 
        {
        	return;
        }
        spreadFireHelp(a + 1, b);
        spreadFireHelp(a, b + 1);
        spreadFireHelp(a - 1, b);
        spreadFireHelp(a, b - 1);
    }
     /*
        recursive helper method here
     */

}
